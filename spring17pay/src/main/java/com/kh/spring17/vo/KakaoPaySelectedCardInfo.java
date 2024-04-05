package com.kh.spring17.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data @NoArgsConstructor @AllArgsConstructor @ Builder
public class KakaoPaySelectedCardInfo {
	private String cardBin; //카드 BIN
	private int installMonth; //할부 개월 수
	private String installmentType; //할부 유형 (업종무이자/분담무이자)
	private String cardCorpName; //카드사 정보
	private String interestFreeInstall; //무이자 할부 여부 (Y/N)
	
	//만들 때 의미부여 ㄴㄴ 있는 그대로 만들기
}
