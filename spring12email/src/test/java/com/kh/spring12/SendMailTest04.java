package com.kh.spring12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.service.EmailService;

@SpringBootTest
public class SendMailTest04 {

	@Autowired
	private EmailService emailService;
	
	@Test
	public void test( ) {
		emailService.sendTempPassword("lovejr1114@naver.com");
	}
}
