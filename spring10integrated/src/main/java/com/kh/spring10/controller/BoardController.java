package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.BoardDao;
import com.kh.spring10.dto.BoardDto;

@RestController
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;

	//이하 생략
	@RequestMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto) {
		boardDao.insert(dto);
		return "성공";
	}
}
