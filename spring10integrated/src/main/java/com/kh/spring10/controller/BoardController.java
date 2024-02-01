package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.BoardDao;
import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dto.BoardDto;
import com.kh.spring10.dto.MemberDto;
import com.kh.spring10.vo.PageVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

	//게시판에서는 empty String으로 전달되는 파라미터를 null로 간주하도록 설정
	//= @InitBinder 설정으로 구현
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberDao memberDao;

	//목록,검색
//	@RequestMapping("/list")
//	public String list(
//			@RequestParam(required = false) String column, 
//			@RequestParam(required = false) String keyword, 
//			@RequestParam(required = false, defaultValue = "1") int page,
//			@RequestParam(required = false, defaultValue = "10") int size,
//			Model model) {
//		boolean isSearch = column != null && keyword != null;

		/*
	 	화면에 네비게이터를 보여주는데 필요한 값들을 계산
	 	- blockSize : 화면에 표시할 네비게이터 개수 (10으로 설정)
	 	- beginBlock : 네비게이터의 처음 숫자 , (페이지 -1) / 10 * 10 + 1 (10은 blockSize)
	 	- endBlock : 네비게이터의 마지막 숫자 , (페이지 -1) / 10 * 10 + 10 (10은 blockSize)
	 	- count : 게시글 개수
	 	- totalPage : 전체 페이지 개수
		 */
//		//페이지 목록
//		int blockSize = 10;
//		int beginBlock = (page-1) / blockSize * blockSize +1; 
//		int endBlock = (page - 1) / blockSize * blockSize +10;
//		model.addAttribute("beginBlock", beginBlock); //네비게이터 시작번호
//		model.addAttribute("endBlock", endBlock); //네비게이터 종료번호
//		model.addAttribute("page", page); //현재 페이지 번호
//		
//		//게시글 개수에 따른 페이지목록
//		int count = isSearch ? 
//				boardDao.count(column, keyword) : boardDao.count();
//		int totalPage = (count -1) / size + 1;
//		model.addAttribute("count", count); //게시글 개수
//		model.addAttribute("totalPage", totalPage); //총 페이지 수
//		
//		model.addAttribute("size", size); //현재 게시글 표시 개수
//		model.addAttribute("page", page);
//		
//		if(isSearch) {
//			model.addAttribute("list", boardDao.selectList(column, keyword));
//			model.addAttribute("list", boardDao.searchByPaging(column, keyword, page, size));
//		}
//		else {
//			//model.addAttribute("list", boardDao.selectList());
//			model.addAttribute("list", boardDao.selectListByPaging(page, size));
//		}
//		return "/WEB-INF/views/board/list.jsp";
//	}
	
	//Paging 처리를 별도의 VO 클래스로 구현
	//(참고) @ModelAttribute에 옵션을 주면 자동으로 모델에 첨부된다
	@RequestMapping("/list")
	public String list(@ModelAttribute PageVO pageVO,
							Model model) {
		//세부 계산은 클래스에서 수행하도록 하고 count, list만 처리
		int count = boardDao.count(pageVO);
		pageVO.setCount(count);
		model.addAttribute("pageVO", pageVO);
		
		List<BoardDto> list = boardDao.selectListByPaging(pageVO);
		model.addAttribute("list", list);
//		vo.setList(list);
		
		return "/WEB-INF/views/board/list2.jsp";
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
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto) {
		boardDao.update(boardDto);
		return "redirect:detail?boardNo="+boardDto.getBoardNo();
	}
	
	
	//삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boardDao.delete(boardNo);
//		return "redirect:/board/list";	
		return "redirect:list";
	}
}
