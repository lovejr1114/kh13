package com.kh.spring16;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EncryptTest05 {

	@Test
	public void test() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String input = "hello world";
		String db = "$2a$10$RsqPrzRz7kQa3xVM9MM1s.JwFaV6tWMxwI30uwLNk94SIZxerph0i";

		//비교할 때도 반드시 encoder를 사용해야 한다
		//순서를 잘 지켜야한다. 맞아도 순서가 틀리면 false로 나옴
		boolean isValid = encoder.matches(input, db);
		log.debug("isValid = {}", isValid);
	}
}
