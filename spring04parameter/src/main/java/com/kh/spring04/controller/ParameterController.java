package com.kh.spring04.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {
	
	//(Q) 숫자 두 개를 더해서 반환하는 페이지
	//- 필요한 값을 매개변수로 선언하면 된다
	//- 주소 뒤에 있는 해당 이름의 파라미터를 자동 수신
	//- 웹에서는 Scanner 대신에 파라미터를 사용 
	@RequestMapping("/plus")
	public String plus(int a, int b) {
		int result = a+b;
		return "덧셈결과 : "+ result;
	}

}
