package com.kh.spring10.interceptor;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//특정 주소(URL)에 대한 처리 과정을 간섭할 수 있는 객체
//(모니터링도 간섭, 보는것을 바꾸는 것도 간섭)
//인터셉트는 특별한 처리를 수행하기 때문에 만드는 방법이 정해져있다 
//[1] 상속을 통해 자격 요건을 획득한다 (HandlerInterceptor)
//[2] 스프링에 등록한다 (@Service)
//[3] 간섭메소드 재정의하여 내용 작성한다

@Service
public class TestInterceptor implements HandlerInterceptor {
	
	//- preHandle 메소드는 컨트롤러가 실행되기 전 시점을 간섭할 수 있다
	//		- true 반환하면 통과, false 반환하면 차단 
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		System.out.println("인터셉터 실행");
		return true; //통과
	}

	//- postHandler 메소드는 컨트롤러가 실행된 후 시점을 간섭할 수 있다
	//		- 화면은 아직 만들어지지 않은 상황
	//		- preHandler와 다르게 컨트롤러에서 추가한 Model과 화면 정보 확인 가능
	//		- 진행상황에 대한 모니터링을 수행할 수 있는 메소드
	//- 사용빈도가 낮음, 잘 진행되고 있는지 확인용.
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			ModelAndView modelAndView) throws Exception {
		System.out.println(modelAndView);
	}

	//- afterCompletion 메소드는 화면까지 모두 완성된 후 시점을 간섭할 수 있다
	//		- 진행과정에서 발생한 예외(Exception) 정보를 확인할 수 있다
	//		- 순수 자바에서 catch 블럭에 작성하던 코드를 이 곳에 작성해도 된다.
	//		- 단, 보여지는 페이지를 변경할 수는 없다.
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			Exception ex)
			throws Exception {
//		System.out.println("ex = " + ex);
		if(ex != null) { //catch(Exception ex){
			ex.printStackTrace(); //ex.printStackTrace(); }
		}
	}
	
}
