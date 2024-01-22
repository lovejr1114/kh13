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

import com.kh.spring10.dao.MenuDao;
import com.kh.spring10.dto.MenuDto;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuDao dao;
	
	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/menu/insert.jsp";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MenuDto dto) {
		dao.insert(dto);
//		return "redirect:/menu/insertComplete"; //절대
		return "redirect:insertComplete"; //상대
	}
	
	@RequestMapping("/insertComplete")
	public String insertComplete() {
		return "/WEB-INF/views/menu/insertComplete.jsp";
	}
	
	
	//수정 페이지
	@GetMapping("/change")
	public String change(@RequestParam int menuNo, Model model) {
		MenuDto dto = dao.selectOne(menuNo); //번호에 대한 메뉴 조회
		if(dto == null) { //없는 메뉴면
			return "redirect:changeFail"; //실패 페이지 이동
		}
		else {			
			model.addAttribute("dto",dto); //JSP로 메뉴정보를 전달
			return "/WEB-INF/views/menu/change.jsp"; //수정화면을 연결
		}
	}
	
	@PostMapping("/change")
	public String change(@ModelAttribute MenuDto dto) {
//		if(dao.update(dto)) {
//			return "redirect:/menu/changeSuccess";
		dao.update(dto);
//			return "redirect:changeSuccess"; //수정 성공 페이지
			return "redirect:detail?menuNo="+dto.getMenuNo(); //수정 성공페이지
//		}
//		else {
//			return "redirect:/menu/changeFail";
//			return "redirect:changeFail";
//		}
	}
	
	@RequestMapping("/changeSuccess")
	public String changeSuccess() {
		return "/WEB-INF/views/menu/changeSuccess.jsp";
	}
	
	
	@RequestMapping("/changeFail")
	public String changeFail() {
		return "/WEB-INF/views/menu/changeFail.jsp";
	}
	
	@RequestMapping("/list")
	public String list(
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword,
			Model model) {
		boolean isSearch = column != null && keyword != null;
		//List<MenuDto> list = isSearch ? dao.selectList(column, keyword) : dao.selectList();
		List<MenuDto> list;
		if(isSearch) {
			list = dao.selectList(column, keyword);
		}
		else {
			list = dao.selectList();
		}
		
		model.addAttribute("list", list);
		return "/WEB-INF/views/menu/list.jsp";
	}
	
	//상세 페이지
	@RequestMapping("/detail")
	public String detail(@RequestParam int menuNo, Model model) {
		MenuDto dto = dao.selectOne(menuNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/menu/detail.jsp";
	}
	
	//삭제페이지
	@RequestMapping("/delete")
	public String delete(@RequestParam int menuNo) {
		dao.delete(menuNo);
		return "redirect:list";
		//return "redirect:/menu/list";
	}
}
