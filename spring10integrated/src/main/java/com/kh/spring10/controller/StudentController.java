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

import com.kh.spring10.dao.StudentDao;
import com.kh.spring10.dto.StudentDto;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentDao studentDao;
	
	//등록 페이지
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/student/add.jsp";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute StudentDto studentDto) {
		studentDao.insert(studentDto);
		return "redirect:list";
	}
	
	
	//목록 및 검색
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column,
							@RequestParam(required = false) String keyword,
							Model model) {
		boolean isSearch = column != null && keyword != null;
		List<StudentDto> list = isSearch ? 
							studentDao.selectList(column, keyword) : studentDao.selectList();
		
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("list", list);
		return "/WEB-INF/views/student/list.jsp";
	}
}
