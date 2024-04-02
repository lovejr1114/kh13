package com.kh.spring16;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.dao.SecretMemberDao;
import com.kh.spring16.dto.SecretMemberDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SecretMemberTest01 {

	@Autowired
	private SecretMemberDao secretMemberDao;
	
	@Test
	public void test() {
		//회원가입 테스트
//		SecretMemberDto memberDto = new SecretMemberDto();
//		memberDto.setMemberId("testuser1");
//		memberDto.setMemberPw("Testuser1!");
//		memberDto.setMemberNick("테스트유저1");
		
		//lombok에서는 builder를 이용해서 이렇게 만드는건 어때? 라고한다
		//범용성이 좋아진다. 위에 있는 코드하고 똑같지만 한 번에 쓰는건 밑에 코드
		SecretMemberDto secretMemberDto = SecretMemberDto.builder()
				.memberId("testuser1")
				.memberPw("Testuser1!")
				.memberNick("테스트유저1")
				.build();
		
		//DAO를 이용한 가입처리
		secretMemberDao.insert(secretMemberDto);
	}
}
