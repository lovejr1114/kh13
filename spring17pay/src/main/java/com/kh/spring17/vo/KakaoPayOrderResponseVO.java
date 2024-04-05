package com.kh.spring17.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaoPayOrderResponseVO {
	private String tid; //결제 고유 번호
	private String cid; //가맹점 코드
	private String status; //결제 상태
	private String partnerOrderId; //가맹점 주문번호
	private String partnerUserid; //가맹점 회원 ID
	private String paymentMethodType; //결제수단 카드 또는 현금
	
	//만들어놨었던 VO와 문서를 비교해봐서 똑같다면 그대로 써도됨.
	private KakaoPayAmountVO amount; //결제 금액
	private KakaoPayAmountVO canceledAmount; //취소된 금액
	private KakaoPayAmountVO cancelAvailableAmount; //취소 가능 금액	
	
	private String itemName; //상품 이름
	private String itemCode; //상품 코드
	private int quantity; //상품 수량
	private String createdAt; //결제 준비 요청 시각
	private String approvedAt; //결제 승인 시각
	private String canceledAt; //결제 취소 시각
	
	private KakaoPaySelectedCardInfo selectedCardInfo; //결제 카드 정보
	private List<KakaoPayPaymentActionDetailVO> paymentActionDetails; //결제 취소 상세
}
