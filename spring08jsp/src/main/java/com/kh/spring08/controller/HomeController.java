package com.kh.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //결과를 화면으로 반환하는 컨트롤러
//@RestController //결과를 직접 생성하는 컨트롤러
public class HomeController {

	@RequestMapping("/welcome")
	public String welcome() {
//		return "<h1>Welcome</h1>"; //RestController를 썼을 때 사용한 코드
		return "/WEB-INF/views/welcom.jsp"; //화면 주소
	}
}
