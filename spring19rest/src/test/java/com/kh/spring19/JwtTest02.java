package com.kh.spring19;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring19.dto.MemberDto;
import com.kh.spring19.service.JwtService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JwtTest02 {

	@Autowired
	private JwtService jwtService;
	
	@Test
	public void test() {
		String token = jwtService.createAccessToken(MemberDto.builder()
					.memberId("testuser1")
					.memberLevel("일반회원")
				.build());
		
		log.debug("token = {}", token);
	}
	
}