package com.kh.spring10.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSenderImpl sender;
	
	//가입 환영 이메일 발송
	public void sendWelcomeMail(String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[졸음방지] 졸음뚝껌");
		message.setText("먹고 물 마시면 어쩔줄 몰라..");
		
		sender.send(message);
	}
	
	
	//임시 비밀번호 발송
	public void sendTempPassword(String email) {
		String lower = "abcdefghijklmnopqrstuvwxyz"; //3글자
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //3글자
		String number = "0123456789"; //1글자
		String special = "!@#$"; //1글자
		
		Random r = new Random(); //랜덤 도구
		StringBuffer buffer = new StringBuffer(); //문자열 합성 도구
		
		for(int i=0; i<3; i++) {
			int pos = r.nextInt(lower.length()); //lower에서의 랜덤위치
			buffer.append(lower.charAt(pos)); //버퍼에 추가
		}
		for(int i=0; i<3; i++) {
			int pos = r.nextInt(upper.length()); // upper에서의 랜덤위치
			buffer.append(upper.charAt(pos)); //버퍼에 추가
		}
		for(int i=0; i<1; i++) {
			int pos = r.nextInt(number.length()); // number에서의 랜덤위치
			buffer.append(number.charAt(pos)); //버퍼에 추가
		}
		for(int i=0; i<1; i++) {
			int pos = r.nextInt(special.length()); // special에서의 랜덤위치
			buffer.append(special.charAt(pos)); //버퍼에 추가
		}
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[KH정보교육원] 임시 비밀번호 안내");
		message.setText("임시 비밀번호는 ' "+buffer+" ' 입니다.");
		
		sender.send(message);
	}
	
	//인증번호 발송
	
	
	
}
