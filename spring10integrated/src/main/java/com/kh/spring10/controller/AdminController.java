package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring10.dao.EmpDao;
import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dao.MenuDao;
import com.kh.spring10.dao.PocketmonDao;
import com.kh.spring10.vo.StatVO;

//관리자가 이용할 수 있는 기능을 제공하는 컨트롤러
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private PocketmonDao pocketmonDao;
	//포켓몬스터 통계
	@RequestMapping("/stat/pocketmon")
	public String statPocketmon(Model model) {
		List<StatVO> list = pocketmonDao.statByType();
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/stat/pocketmon.jsp";
	}
	
	@Autowired
	private EmpDao empDao;
	//사원 통계
	@RequestMapping("/stat/emp")
	public String statEmp(Model model) {
		List<StatVO> list = empDao.statByType();
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/stat/emp.jsp";
	}
	
	@Autowired
	private MenuDao menuDao;
	//메뉴 통계
	@RequestMapping("/stat/menu")
	public String statMenu(Model model) {
		List<StatVO> list = menuDao.statByType();
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/stat/menu.jsp";
	}
	
	@Autowired
	private MemberDao memberDao;
	//멤버 통계
	@RequestMapping("/stat/member")
	public String statMember(Model model) {
		List<StatVO> list = memberDao.statByType();
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/stat/member.jsp";
	}
}
