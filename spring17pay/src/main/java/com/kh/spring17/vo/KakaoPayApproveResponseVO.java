package com.kh.spring17.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true) //혹시 없는 항목이 있다면 넘어가줘.. 라는 뜻
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) //카멜케이스로 바꿔줘 (내가 만든게 아니기때문에)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaoPayApproveResponseVO {
	private String aid; //요청 고유 번호 (승인/취소가 구분된 결제번호)
	private String tid; //결제 고유 번호 (승인/취소가 동일한 결제번호)
	private String cid; //가맹점 코드
	private String sid; //정기 결제용 ID
	private String partnerOrderId; //가맹점 주문번호
	private String partnerUserId; //가맹점 회원ID
	private String paymentMethodType; //결제수단(CARD/MONEY)
	
	private KakaoPayAmountVO amount; //결제금액정보
	private KakaoPayCardInfoVO cardInfo; //결제상세정보(카드일경우)
	
	private String itemName; //상품이름 (최대100글자)
	private String itemCode; //상품코드(최대 100자)
	private int quantity; //상품 수량
	private String createAt; //결제 준비요청시각
	private String approvedAt; //결제 승인 시각
	private String payload; //결제 승인 요청에 대한 추가 파라미터 정보
}
