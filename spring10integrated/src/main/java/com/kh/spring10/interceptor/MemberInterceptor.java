package com.kh.spring10.interceptor;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//회원 페이지에 대한 접근 허용 및 차단을 판정하여 처리하는 도구
@Service
public class MemberInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//인터셉터는 주어진 메소드 내에서 원하는 도구를 꺼내서 사용한다.
		//- request는 사용자의 요청 정보가 담긴 객체 (여기에 HttpSession이 들어있음)
		//- respinse는 사용자에게 내보낼 정보가 담긴 객체
		//- handler는 실행될 예정인 컨트롤러 매핑정보가 담긴 객체
		
		HttpSession session = request.getSession(); //세션 객체를 꺼내고
		String loginId = (String) session.getAttribute("loginId"); //사용자 ID 추출
		
		
		if(loginId != null) { //회원이면
			return true;
		}
		else { //회원이 아니면 
			return false;
		}
	}
}
