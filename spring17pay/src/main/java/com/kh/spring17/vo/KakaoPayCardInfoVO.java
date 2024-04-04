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
public class KakaoPayCardInfoVO {
	private String kakaopayPurchaseCorp; //카카오페이 매입사명
	private String kakaopayPurchaseCorpCode; //카카오페이 매입사 코드
	private String kakaopayIssuerCorp; //카카오페이 발급사명
	private String kakaopayIssuerCorpCode; //카카오페이 발급사 코드
	private String bin; //카드 BIN
	private String cardType; //카드 유형
	private String installMonth; //할부 개월 수
	private String approvedId; //카드사 승인번호
	private String cardMid; //카드사 가맹점 번호
	private String interestFreeInstall; //무이자할부 여부 (Y/N)
	private String installmentType; //할부 유형 (2024/02/01~)
	private String cardItemCode; //카드 상품 코드
	
	
}
