package com.kh.spring17;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class KakaoPayTest03 {

	@Test
	public void test( ) throws URISyntaxException, JsonProcessingException {
		//카카오페이 서버에 결제 준비(ready) 요청을 보내보자!
		//신버전 코드(카카오페이 개발자센터가 따로 생김)
		
		//요청 전송 도구 생성
		RestTemplate template = new RestTemplate();
		
		//주소 생성 (승인주소)
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");
		
		//헤더 생성
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "SECRET_KEY DEVBD7CBDDCC79FBD5DDE03B426BDB5E4717054B");
		header.add("Content-Type", "application/json");
		
		//바디 생성
		//MultiValueMap<Stirng, String> body = new LinkdeMultiValueMap<>();
		Map<String, String> body = new HashMap<>();
		body.put("cid", "TC0ONETIME");
		body.put("tid", "T60e042a4510678bc534");
		body.put("pg_token", "734fd72394c7629149f5");
		body.put("partner_order_id", "907fa09f-c1d9-4716-8f22-34d7edd3aefa");
		body.put("partner_user_id", "testuser1");
		
		//통신 요청
		HttpEntity entity = new HttpEntity(body, header);//헤더+바디
		
		Map response = template.postForObject(uri, entity, Map.class);
		//log.debug("response = {}", response);
		log.debug("거래번호 = {}", response.get("tid"));
		log.debug("주소 = {}", response.get("next_redirect_pc_url"));
	}
	
}