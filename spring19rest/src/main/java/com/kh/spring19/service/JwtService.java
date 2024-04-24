package com.kh.spring19.service;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring19.configuration.JwtProperties;
import com.kh.spring19.dto.MemberDto;
import com.kh.spring19.vo.MemberLoginVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Autowired
	private JwtProperties jwtProperties;// keyStr, expireHour, issuer

	//6시간짜리 토큰 (처음 발행)
		public String createAccessToken(MemberDto memberDto) {
			//1. 서명을 위한 키(SecretKey) 생성
			// - HMAC : 메세지의 무결성과 인증을 동시에 처리하기 위해 사용하는 암호화 방식
			// - HMAC-SHA라는 이름으로 시작함
			String keyStr = jwtProperties.getKeyStr();
			SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
			//2. 토큰의 만료시간을 설정
			Calendar c = Calendar.getInstance();
			Date now = c.getTime();//현재 시간 추출
			c.add(Calendar.HOUR, jwtProperties.getExpireHour());//6시간 후로 이동
			Date expire = c.getTime();//만료시각 추출
			
			//3. 토큰 생성
			String token = Jwts.builder()
					.issuer(jwtProperties.getIssuer())//발행자
					.issuedAt(now)//발행시각
					.expiration(expire)//만료시각
					.signWith(key)//서명
					//.claim("제목", "내용")//사용자에게 보낼 내용(key=value)
					.claim("loginId", "testuser1")
					.claim("loginLevel", "일반회원")
				.compact();
			
			return token;
		}
		
		//1년(8760시간)짜리 토큰 (갱신)
		public String createRefreshToken(MemberDto memberDto) {
			//1. 서명을 위한 키(SecretKey) 생성
			// - HMAC : 메세지의 무결성과 인증을 동시에 처리하기 위해 사용하는 암호화 방식
			// - HMAC-SHA라는 이름으로 시작함
			String keyStr = jwtProperties.getKeyStr();
			SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
			//2. 토큰의 만료시간을 설정
			Calendar c = Calendar.getInstance();
			Date now = c.getTime();//현재 시간 추출
			c.add(Calendar.HOUR, jwtProperties.getExpireHourRefresh());//6시간 후로 이동
			Date expire = c.getTime();//만료시각 추출
			
			//3. 토큰 생성
			String token = Jwts.builder()
					.issuer(jwtProperties.getIssuer())//발행자
					.issuedAt(now)//발행시각
					.expiration(expire)//만료시각
					.signWith(key)//서명
					//.claim("제목", "내용")//사용자에게 보낼 내용(key=value)
					.claim("loginId", "testuser1")
					.claim("loginLevel", "일반회원")
				.compact();
			
			return token;
		}
	

	public MemberLoginVO parse(String token) {
		// 1. 해석을 위한 key 생성
		String keyStr = jwtProperties.getKeyStr();
		SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));

		// 2. 토큰 해석 - 목적은 Claim을 읽어내는 것
		Claims claims = (Claims) Jwts.parser() // 해석도구 (parser) 준비해서
				.verifyWith(key) // 열쇠 설정하고
				.requireIssuer(jwtProperties.getIssuer()) // 발행자 정보를 확인하도록
				.build() // 만든 다음에
				.parse(token) // 토큰 해석하고
				.getPayload(); // 내용 가져와!

		//3. 해석된 결과를 객체로 반환
		return MemberLoginVO.builder()
					.memberId((String)claims.get("loginId"))
					.memberLevel((String)claims.get("loginLevel"))
				.build();
	}
}