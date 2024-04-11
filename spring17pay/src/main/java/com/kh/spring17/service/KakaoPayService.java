package com.kh.spring17.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring17.configuration.KakaoPayProperties;
import com.kh.spring17.dao.PaymentDao;
import com.kh.spring17.dao.ProductDao;
import com.kh.spring17.dto.PaymentDetailDto;
import com.kh.spring17.dto.PaymentDto;
import com.kh.spring17.dto.ProductDto;
import com.kh.spring17.vo.KakaoPayApproveRequestVO;
import com.kh.spring17.vo.KakaoPayApproveResponseVO;
import com.kh.spring17.vo.KakaoPayCancelRequestVO;
import com.kh.spring17.vo.KakaoPayCancelResponseVO;
import com.kh.spring17.vo.KakaoPayOrderRequestVO;
import com.kh.spring17.vo.KakaoPayOrderResponseVO;
import com.kh.spring17.vo.KakaoPayReadyRequestVO;
import com.kh.spring17.vo.KakaoPayReadyResponseVO;
import com.kh.spring17.vo.PurchaseListVO;
import com.kh.spring17.vo.PurchaseVO;

@Service
public class KakaoPayService {
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	@Autowired
	private RestTemplate template;
	@Autowired
	private HttpHeaders header;
	
	//준비 요청 메소드
	public KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO requestVO) throws URISyntaxException {
		//주소 생성
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
		
		//바디 생성
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("partner_order_id", requestVO.getPartnerOrderId());
		body.put("partner_user_id", requestVO.getPartnerUserId());
		body.put("item_name", requestVO.getItemName());
		body.put("quantity", "1");
		body.put("total_amount", String.valueOf(requestVO.getTotalAmount())); // int를 String으로 바꿔서 출력
		body.put("tax_free_amount", "0");
		
		//구매페이지 주소의 뒤에 /success, /cancel, /fail을 붙여서 처리하도록 구현
		String page = ServletUriComponentsBuilder
							.fromCurrentRequestUri().build().toUriString();
		
		body.put("approval_url", page+"/success");
		body.put("cancel_url", page+"/cancel");
		body.put("fail_url", page+"/fail");
		
		//통신 요청
		HttpEntity entity = new HttpEntity(body, header);//헤더+바디
			
		return template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
	}

	
	//승인 요청 메소드
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO requestVO) throws URISyntaxException {
		//주소 생성 (요청 주소)
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");
		
		//바디 생성
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("tid", requestVO.getTid());
		body.put("pg_token", requestVO.getPgToken());
		body.put("partner_order_id", requestVO.getPartnerOrderId());
		body.put("partner_user_id", requestVO.getPartnerUserId());
		
		//통신 요청
		HttpEntity entity = new HttpEntity(body, header);//헤더+바디
		
		return template.postForObject(uri, entity, KakaoPayApproveResponseVO.class);
	}
	
	
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private ProductDao productDao;
	
	//여러번의 등록 과정이 모두 성공하거나 모두 실패해야한다 (모 아니면 도)
	//->즉, 하나의 트랜잭션(transaction)으로 관리되어야 한다
	@Transactional
	public void insertPayment(PurchaseListVO vo, KakaoPayApproveResponseVO responseVO) {
		//DB에 결제 완료된 내역을 저장
		//- 결제 대표 정보(payment) = 번호를 생성하고 등록을 한다.
		int paymentNo = paymentDao.paymentSequence(); //번호 생성
		PaymentDto paymentDto = PaymentDto.builder()
					.paymentNo(paymentNo) //시퀀스
					.paymentName(responseVO.getItemName()) //대표 결제명
					.paymentTotal(responseVO.getAmount().getTotal()) //결제 총 금액
					.paymentRemain(responseVO.getAmount().getTotal()) //잔여금액 (결제 총 금액과 동일)
					.memberId(responseVO.getPartnerUserId()) //구매자 ID
					.paymentTid(responseVO.getTid()) //거래번호
				.build();
		paymentDao.insertPayment(paymentDto);
		
		//- 결제 상세 내역(payment_detail) - 목록 개수만큼 반복적으로 등록
		for(PurchaseVO purchaseVO : vo.getPurchase()) {
			ProductDto productDto = productDao.selectOne(purchaseVO.getNo()); //상품 정보 조회
					
			int paymentDetailNo = paymentDao.paymentDetailSequence(); //시퀀스번호출력
			PaymentDetailDto paymentDetailDto = PaymentDetailDto.builder()
						.paymentDetailNo(paymentDetailNo) //시퀀스
						.paymentDetailProduct(productDto.getNo()) //상품번호 (purchaseVO에서 꺼내도 됨)
						.paymentDetailQty(purchaseVO.getQty()) //수량
						.paymentDetailName(productDto.getName()) //상품명
						.paymentDetailPrice(productDto.getPrice()) //상품가격
						.paymentDetailStatus("승인") //결제 상태 (이건 무조건 승인이라 안적어도 상관없지만 적음.)
						.paymentNo(paymentNo) //결제 대표번호
					.build();
			paymentDao.insertPaymentDetail(paymentDetailDto); //등록
		}
	}
	
	//상세 조회 메소드
	public KakaoPayOrderResponseVO order(KakaoPayOrderRequestVO requestVO) throws URISyntaxException {
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/order");
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("tid", requestVO.getTid());
		
		HttpEntity entity = new HttpEntity(body, header);
		
		return template.postForObject(uri, entity, KakaoPayOrderResponseVO.class);
	}
	

	//취소 메소드
	public KakaoPayCancelResponseVO cancel(KakaoPayCancelRequestVO requestVO) throws URISyntaxException {
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/cancel");
		
		Map<String, String> body = new HashMap<>();
		body.put("cid",kakaoPayProperties.getCid());
		body.put("tid",requestVO.getTid());
		body.put("cancel_amount",String.valueOf(requestVO.getCancelAmount()));
		body.put("cancel_tax_free_amount","0");
		
		HttpEntity entity = new HttpEntity<>(body, header);
		
		return template.postForObject(uri, entity, KakaoPayCancelResponseVO.class);
	}
}
