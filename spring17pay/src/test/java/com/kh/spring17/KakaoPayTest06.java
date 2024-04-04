package com.kh.spring17;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring17.service.KakaoPayService;
import com.kh.spring17.vo.KakaoPayApproveRequestVO;
import com.kh.spring17.vo.KakaoPayApproveResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class KakaoPayTest06 {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		//데이터 준비 - KakaoPayApproveRequestVO
		KakaoPayApproveRequestVO requestVO = 
				KakaoPayApproveRequestVO.builder()
					.tid("T60e324e4510678bc605")
					.partnerOrderId("bc8878d2-c620-4832-b9ce-00aabd17d43d")
					.partnerUserId("testuser1")
					.pgToken("18d45731915ff158e9f3")
				.build();
		
		//처리
		KakaoPayApproveResponseVO responseVO = 
								kakaoPayService.approve(requestVO);
		
		//결과 출력 - KakaoPayApproveResponseVO
		log.debug("responseVO = {}", responseVO);
	}
}