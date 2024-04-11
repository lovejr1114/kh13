package com.kh.spring17.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring17.dao.PaymentDao;
import com.kh.spring17.dao.ProductDao;
import com.kh.spring17.dto.PaymentDetailDto;
import com.kh.spring17.dto.PaymentDto;
import com.kh.spring17.dto.ProductDto;
import com.kh.spring17.service.KakaoPayService;
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

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pay3")
public class pay3Controller {

	@Autowired
	private KakaoPayService kakaoPayService;

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@GetMapping("/purchase")
	public String purchase(Model model) {
		model.addAttribute("list",productDao.selectList());
		return "pay3/purchase";
	}
	
	@PostMapping("/purchase")
	public String purchase(@ModelAttribute PurchaseListVO vo, HttpSession session) throws URISyntaxException {
		log.debug("size={}",vo.getPurchase().size());
		log.debug("vo={}",vo);
		
		//vo의  purchase 목록을 이용하여 결제 정보를 생성하는 코드
		StringBuffer name = new StringBuffer(); //문자열을 더해야해서 만들어준다.
		int total = 0;
		
		//이름 구하기 - OOO외 N건, 가격 구하기
//		for(PurchaseVO purchaseVO : vo.getPurchase()) { //구매이력을 반복 조회하며
		for(int i=0; i<vo.getPurchase().size(); i++) { //위 주석코드와 똑같은뜻. 하지만 상품이름을 알기위해 반복문을 이렇게.
			PurchaseVO purchaseVO = vo.getPurchase().get(i);
			ProductDto productDto = productDao.selectOne(purchaseVO.getNo()); //상품 정보를 조회
			if(i == 0) {				
				name.append(productDto.getName()); //이름은 한 번만 구한다. i == 0
			}
			total += productDto.getPrice() * purchaseVO.getQty();//이 상품에 대한 구매금액.. 가격 * 수량
		}
		
		//구매목록이 2개 이상이라면 "외 N건" 이라는 글자를 추가
		if(vo.getPurchase().size() >= 2) { //구매목록의 사이즈가 2이상이라면
			name.append(" 외 ");
			name.append(vo.getPurchase().size()-1);
			name.append("건");
		}
		
		log.debug("결제이름 = {} ", name);
		log.debug("결제금액 = {} ", total);
		
		//결제 준비 요청 - KakaoPayReadyRequestVO, KakaoPayReadyResponseVO
		KakaoPayReadyRequestVO requestVO = 
				KakaoPayReadyRequestVO.builder()
					.partnerOrderId(UUID.randomUUID().toString())
					.partnerUserId("testuser1")
					.itemName(name.toString()) // OOO 외 ? 건
					.totalAmount(total) //총 결제 금액
				.build();
		
		KakaoPayReadyResponseVO responseVO = 
												kakaoPayService.ready(requestVO);
		
		//세션에 Flash Attribute를 추가
		session.setAttribute("partner_order_id", requestVO.getPartnerOrderId());
		session.setAttribute("partner_user_id", requestVO.getPartnerUserId());
		session.setAttribute("tid", responseVO.getTid());
		//(+추가) 사용자가 구매한 상품번호와 수량 목록을 결제 성공 페이지로 전송
		session.setAttribute("vo", vo); //"list", vo.getPurchase()
		
		return "redirect:"+responseVO.getNextRedirectPcUrl(); //결제 페이지 안내
	}
	
	@GetMapping("/purchase/success")
	public String success(HttpSession session, 
						@RequestParam String pg_token) throws URISyntaxException {
		
		KakaoPayApproveRequestVO requestVO = 
				KakaoPayApproveRequestVO.builder()
					.partnerOrderId((String)session.getAttribute("partner_order_id"))
					.partnerUserId((String)session.getAttribute("partner_user_id"))
					.tid((String)session.getAttribute("tid"))
					.pgToken(pg_token)
				.build();
		
		//세션의 Flash Attribute를 제거 
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("tid");
		
		KakaoPayApproveResponseVO responseVO =
								kakaoPayService.approve(requestVO);
		
		//세션에 전송된 vo(구매목록)을 꺼내서 DB에 저장할 때 활용
		PurchaseListVO vo = (PurchaseListVO) session.getAttribute("vo"); //다운캐스팅
		session.removeAttribute("vo");
		
		//카카오페이서비스에 모듈화 해놓은 걸 불러오기!(컨트롤러가 길어지면 안되서 모듈화 해서 저장해놨잖아)
        kakaoPayService.insertPayment(vo, responseVO);
		
//		
//		//DB에 결제 완료된 내역을 저장
//		//- 결제 대표 정보(payment) = 번호를 생성하고 등록을 한다.
//		int paymentNo = paymentDao.paymentSequence(); //번호 생성
//		PaymentDto paymentDto = PaymentDto.builder()
//					.paymentNo(paymentNo) //시퀀스
//					.paymentName(responseVO.getItemName()) //대표 결제명
//					.paymentTotal(responseVO.getAmount().getTotal()) //결제 총 금액
//					.paymentRemain(responseVO.getAmount().getTotal()) //잔여금액 (결제 총 금액과 동일)
//					.memberId(responseVO.getPartnerUserId()) //구매자 ID
//					.paymentTid(responseVO.getTid()) //거래번호
//				.build();
//		paymentDao.insertPayment(paymentDto);
//		
//		
//		//- 결제 상세 내역(payment_detail) - 목록 개수만큼 반복적으로 등록
//		for(PurchaseVO purchaseVO : vo.getPurchase()) {
//			ProductDto productDto = productDao.selectOne(purchaseVO.getNo()); //상품 정보 조회
//			
//			int paymentDetailNo = paymentDao.paymentDetailSequence(); //시퀀스번호출력
//			PaymentDetailDto paymentDetailDto = PaymentDetailDto.builder()
//						.paymentDetailNo(paymentDetailNo) //시퀀스
//						.paymentDetailProduct(productDto.getNo()) //상품번호 (purchaseVO에서 꺼내도 됨)
//						.paymentDetailQty(purchaseVO.getQty()) //수량
//						.paymentDetailName(productDto.getName()) //상품명
//						.paymentDetailPrice(productDto.getPrice()) //상품가격
//						.paymentDetailStatus("승인") //결제 상태 (이건 무조건 승인이라 안적어도 상관없지만 적음.)
//						.paymentNo(paymentNo) //결제 대표번호
//					.build();
//			paymentDao.insertPaymentDetail(paymentDetailDto); //등록
//		}
		
		return "redirect:successComplete";
	}
	
	@GetMapping("/purchase/successComplete")
	public String successComplete() {
		return "pay3/successComplete";
	}
	
	//결제 취소와 실패에서는 결제 준비 시 세션에 담았던 Flash Attribute를 반드시 제거해야한다.
	@GetMapping("/purchase/cancel")
	public String cancel(HttpSession session) {
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("tid");
		session.removeAttribute("vo");
		return "pay3/cancel";
	}
	@GetMapping("/purchase/fail")
	public String fail(HttpSession session) {
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("tid");
		session.removeAttribute("vo");
		return "pay3/fail";
	}
	
	//결제 목록 - 카카오페이 아니고 payment의 목록을 보겠다는 뜻
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", paymentDao.paymentList());
		return "pay3/list";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int paymentNo, Model model) throws URISyntaxException {
		//무슨 상품을 얼마에 몇 개 샀는지
		//DB의 상세내역 첨부
		List<PaymentDetailDto> detailList = paymentDao.paymentDetailList(paymentNo);
		model.addAttribute("detailList", detailList);
		
		//카카오페이의 상세조회 내역 첨부 
		PaymentDto paymentDto = paymentDao.selectOne(paymentNo);
		model.addAttribute("paymentDto", paymentDto);
		KakaoPayOrderRequestVO requestVO = 
							KakaoPayOrderRequestVO.builder()
								.tid(paymentDto.getPaymentTid())
							.build();
				
		KakaoPayOrderResponseVO responseVO = kakaoPayService.order(requestVO);
		model.addAttribute("responseVO", responseVO);
		return "pay3/detail";
	}
	
	
	//부분취소(항목취소)
	//- 데이터베이스 변경 + KakaoAPI 취소요청
	//- 데이터베이스는 payment_detail과 payment 조회 및 변경이 필요
	//- payment에서는 잔여금액을 차감하고 TID를 조회해야함
	//- payment_detail에서는 상품 상태를 취소로 변경하고 금액을 조회해야함
	@GetMapping("/cancelItem")
	public String cancelItem(@RequestParam int paymentDetailNo) throws URISyntaxException {
		//[1] 결제 상세 정보를 모두 불러온다 (취소시킬 금액을 알 수 있다)
		PaymentDetailDto paymentDetailDto = paymentDao.paymentDetailFind(paymentDetailNo);
		int amount = paymentDetailDto.getTotalPrice(); //소계를 불러온다. (이게 취소시킬 금액)
		
		//(+추가) 상품이 취소 상태라면 예외를 발생시켜 실행을 막는다
		if(paymentDetailDto.getPaymentDetailStatus().equals("취소")) {
			throw new RuntimeException("이미 취소된 상품");
		}
		
		//[2] 거래번호를 알 수 있게 결제 대표 정보를 모두 불러온다. (거래번호와 잔여금액 알 수 있다)
		PaymentDto paymentDto = paymentDao.selectOne(paymentDetailDto.getPaymentNo());
		int paymentNo = paymentDto.getPaymentNo(); //번호 꺼내놓기.
		int paymentRemain = paymentDto.getPaymentRemain();
		
//		if(paymentRemain < amount) { //잔여금액이 더 작은 경우 (지금은 안해도 에러가 남 제약조건에 막혀있기 때문에)
//			return "redirect:에러페이지";
//		}
//		
		
		//[3] 불러온 정보들을 이용하여 카카오페이 취소 요청을 한다 (Test07에서 했던거)
		KakaoPayCancelRequestVO requestVO = 
												KakaoPayCancelRequestVO.builder()
													.tid(paymentDto.getPaymentTid())
													.cancelAmount(amount)
												.build();
		
		KakaoPayCancelResponseVO responseVO = 
											kakaoPayService.cancel(requestVO);
		
		//[4] 취소가 성공한 경우 데이터베이스 값을 변화시킨다
		paymentDao.paymentRemainDecrease(paymentNo, amount);
		paymentDao.paymentDetailCancel(paymentDetailNo);
		
		return "redirect:detail?paymentNo="+paymentNo;
	}
	
	//전체취소
	//@GetMapping("/cancelAll")
}
