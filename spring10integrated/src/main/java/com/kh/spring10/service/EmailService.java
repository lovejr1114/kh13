package com.kh.spring10.service;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.kh.spring10.dao.CertDao;
import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dto.CertDto;
import com.kh.spring10.dto.MemberDto;

@Service
public class EmailService {

	@Autowired
	private JavaMailSenderImpl sender;
	
	@Autowired
	private MemberDao memberDao;
	
	//가입 환영 이메일 발송
	public void sendWelcomeMail(String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[Welcome] 축하드립니다.");
		message.setText("가입을 축하드립니다. 환영합니다!");
		
		sender.send(message);
	}
	
	//아이디 발송
	public boolean sendMemberId(String memberNick) {
		//닉네임으로 회원정보 조회
		MemberDto memberDto = memberDao.selectOneByMemberNick(memberNick);
		
		if(memberDto != null) { //존재하는 닉네임이라면
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(memberDto.getMemberEmail());
			message.setSubject("[KH정보교육원] 아이디 찾기 결과 안내");
			message.setText("당신의 아이디는" + memberDto.getMemberId() + " 입니다 ^^.");
			sender.send(message);
			return true;
		}
		else { //존재하지 않는 닉네임이라면
			return false;
		}
	}
	
	//임시 비밀번호 발송
	public void sendTempPassword(MemberDto memberDto) {
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
		
		//생성한 비밀번호로 DB를 변경
		memberDto.setMemberPw(buffer.toString()); //비밀번호 설정 후
		memberDao.updateMemberPw(memberDto); //변경 처리	
		
		//이메일 발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(memberDto.getMemberEmail());
		message.setSubject("[KH정보교육원] 임시 비밀번호 안내");
		message.setText("임시 비밀번호는 ' "+ memberDto.getMemberPw() +" ' 입니다.");
		
		sender.send(message);
	}
	
	@Autowired
	private CertDao certDao;
	
	//인증번호 발송 - 주어진 이메일에 무작위 6자리 숫자를 전송
	public void sendCert(String memberEmail) {
		Random r = new Random();
		int number = r.nextInt(1000000); // 000000부터 999999까지
		DecimalFormat fmt = new DecimalFormat("00000");
		
		//인증번호 저장
		certDao.delete(memberEmail);
		//메소드에 멤버이메일과 랜덤의 넘버를 합쳐서.
		CertDto certDto = new CertDto();
		certDto.setCertEmail(memberEmail);
		certDto.setCertNumber(fmt.format(number));
		certDao.insert(certDto);
		
		//메일 발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(memberEmail);
		message.setSubject("[KH정보교육원] 발급한 인증번호");
		message.setText("인증번호는 ["+ fmt.format(number)+"]입니다.");
		
		sender.send(message);
	}
	
}
