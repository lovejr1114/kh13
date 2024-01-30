package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.BoardDao;
import com.kh.spring10.dto.BoardDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;

	//목록,검색
	@RequestMapping("/list")
	public String list(@RequestParam(required=false) String column,
							@RequestParam(required=false) String keyword,
							Model model) {
		boolean isSearch = column != null && keyword != null;
		List<BoardDto> list = isSearch ? 
				boardDao.selectList(column, keyword) : boardDao.selectList();
		
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("list", list);
		return "/WEB-INF/views/board/list.jsp";
	}
	
	
	//추가
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, Model model) {
		int boardNo = boardDao.boardSeqNo();
		boardDto.setBoardNo(boardNo);
		boardDao.insert(boardDto);
//		return "redirect:/board/detail";
		return "redirect:detail?boardNo="+boardDto.getBoardNo();
	}
	
	
	//상세
	@RequestMapping("/detail")
	public String detail(@RequestParam int  boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/detail.jsp";
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
