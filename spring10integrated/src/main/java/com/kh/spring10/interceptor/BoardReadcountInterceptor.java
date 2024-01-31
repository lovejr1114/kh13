package com.kh.spring10.interceptor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring10.dao.BoardDao;
import com.kh.spring10.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//게시글의 조회수와 관련된 사전 처리를 수행하는 인터셉터
@Service
public class BoardReadcountInterceptor implements HandlerInterceptor {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//인터셉터에서 파라미터를 받고싶다면
		//- request.getParameter("이름")을 사용
		//- 반환형이 String이므로 원하는 형태로 바꿔서 사용
		
//		int boardNo = request.getParameter("boardNo"); //수동으로 파라미터 불러오기
		int boardNo = Integer.parseInt(request.getParameter("boardNo")); //파라미터에서 글 번호 추출
	
		//1. 비회원은 조회수 증가 방지 처리
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		if(loginId == null) { //로그인아이디가 null이라면
			return true;
		}
		
		
		//2. 작성자 본인인 경우 조회수 증가 방지 처리
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(loginId.equals(boardDto.getBoardWriter())) { //로그인아이디와 작성자가 같으면
			return true; //통과
		}
		
		
		//3. 작성자가 탈퇴한 사용자면 조회수 증가 방지 처리
		if(boardDto.getBoardWriter() == null) {
			return true;
		}
		
		
		//4. 한 번이라도 본 적이 있는 글이라면 조회수 증가 방지 처리
		//- 여러 방법이 있지만, 방법 중에 HttpSession을 사용하는 방법으로 구현
		//- 세션에 history라는 이름으로 글 번호를 저장할 저장소를 저장
		//- history=[10,13,15] 와 같은 형태로 만들 예정
		//- history에 해당하는 저장소는 HashSet<Integer> 형태로 만든다 
		
		//session에 history라는 이름의 저장소를 꺼낸다 (없을 수도 있음)
//		Set<Integer> history = new HashSet<>();
//		Set<Integer> history = session.getAttribute("history");
		Set<Integer> history = (Set<Integer>) session.getAttribute("history");	 //경고 그냥 넘어가기, 프로그램에서 자신이없는것.
		
		//history가 없으면 null이므로 새로 만들어야한다.
		if(history == null) {
			history = new HashSet<>();
		}
		
		if(history.contains(boardNo)) { //이미 읽은 적이 있다면
			return true; //그냥 통과 시키고
		}
		else { //읽은 적이 없다면
			history.add(boardNo); //번호를 기록하고
			session.setAttribute("history", history);//저장소를 갱신시켜라
		}
		
		
		
		//조회수 증가 & 중복 방지 코드
//		System.out.println("조회수 중복 방지 인터셉터 실행");
		
//		boardDao.updateBoardReadcount(글번호);
		boardDao.updateBoardReadcount(boardNo); //조회수 증가
		
		return true; //통과시켜줌
	}
}