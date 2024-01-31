package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.BoardDao;
import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dto.BoardDto;
import com.kh.spring10.dto.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberDao memberDao;

	//목록,검색
	@RequestMapping("/list")
	public String list(
			@RequestParam(required = false) String column, 
			@RequestParam(required = false) String keyword, Model model) {
		boolean isSearch = column != null && keyword != null;
		if(isSearch) {
			model.addAttribute("list", boardDao.selectList(column, keyword));
		}
		else {
			model.addAttribute("list", boardDao.selectList());
		}
		return "/WEB-INF/views/board/list.jsp";
	}
	
	
	//상세
	@RequestMapping("/detail")
	public String detail(@RequestParam int  boardNo, Model model) {
		//boardDao.updateBoardReadcount(boardNo); //조회수 증가 메소드를 dao에 넣어준다
		
		BoardDto boardDto = boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		//조회한 게시글 정보에 있는 회원 아이디로 회원 정보를 불러와서 첨부(멤버 아이디는 게시판정보에 있는 작성자를 불러오기)
		if(boardDto.getBoardWriter() != null) { //작성자가 탈퇴하지 않았다면
			MemberDto memberDto = memberDao.selectOne(boardDto.getBoardWriter());
			model.addAttribute("memberDto", memberDto);
		}
		return "/WEB-INF/views/board/detail.jsp";
	}
	
	
	//추가
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto,
								HttpSession session) {
		//세션에서 로그인한 사용자의 ID를 추출
		String loginId = (String)session.getAttribute("loginId");
		
		//ID를 게시글 정보에 포함시킨다
		boardDto.setBoardWriter(loginId);
		
		int sequence = boardDao.getSequence(); //DB에서 시퀀스 번호를 추출
		boardDto.setBoardNo(sequence); //게시글 정보에 추출한 번호를 포함시킨다.
		boardDao.insert(boardDto); //등록
//		return "redirect:/board/detail";
		return "redirect:detail?boardNo="+boardDto.getBoardNo();
	}
	
	
	
	
//	//수정
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) {
			return "";
		}
		else {
			return "/WEB-INF/views/board/edit.jsp";
		}
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto, int boardSeqNo) {
		boardDao.update(boardDto);
		return "";
	}
	
	
	//삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boardDao.delete(boardNo);
		return "redirect:list";
	}
}
