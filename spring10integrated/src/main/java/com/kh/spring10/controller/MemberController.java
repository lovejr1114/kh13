package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.DtoInstantiatingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dto.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:joinSuccess";
	}
	
	@RequestMapping("/joinSuccess")
	public String joinSuccess() {
		return "/WEB-INF/views/member/joinSuccess.jsp";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam(required = false) String memberId,
								@RequestParam(required = false) String memberPw,
								Model model) {
		return "/WEB-INF/views/member/login.jsp";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto) {
			Object memberId = null;
			if(memberDto.equals(memberId)) {
				return "redirect:/";
			}
			else {
				return "redirect:login";
			}
		}
	
}
