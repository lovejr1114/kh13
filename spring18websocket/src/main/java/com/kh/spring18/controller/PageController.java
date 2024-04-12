package com.kh.spring18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring18.dao.MemberDao;
import com.kh.spring18.dto.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/page")
public class PageController {
	
	@Autowired
	private MemberDao memberDao;
	
	//로그인
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, 
																HttpSession session) {
		MemberDto findDto = memberDao.selectOneByMemberPw(memberDto); //조회
		if(findDto != null) { //null이 아니면 로그인 성공
			session.setAttribute("loginId", findDto.getMemberId()); //로그인아이디는 findDto안에 Id
			session.setAttribute("loginLevel", findDto.getMemberLevel());
		}
		return "redirect:/page/";
	}
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		session.removeAttribute("loginLevel");
		return "redirect:/page/";
	}
	
	
	//메인
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	
	@RequestMapping("/basic")
	public String basic() {
		return "basic";
	}

	@RequestMapping("/simple")
	public String simple() {
		return "simple";
	}
	
	@RequestMapping("/chatbot")
	public String chatbot() {
		return "chatbot";
	}
	
	@RequestMapping("/group")
	public String group() {
		return "group";
	}
	
	@RequestMapping("/json")
	public String json() {
		return "json";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member";
	}
}
