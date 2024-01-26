package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.EmpDao;
import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dao.MenuDao;
import com.kh.spring10.dao.PocketmonDao;
import com.kh.spring10.dto.MemberDto;
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
//		List<StatVO> list = empDao.countByEmpDept();
//		model.addAttribute("list", list);
		//위 주석처리된 두 코드를 줄여서 쓰기
		model.addAttribute("list", empDao.countByEmpDept());
		return "/WEB-INF/views/admin/stat/emp.jsp";
	}
	
	@Autowired
	private MenuDao menuDao;
	//메뉴 통계
	@RequestMapping("/stat/menu")
	public String statMenu(Model model) {
//		List<StatVO> list = menuDao.countByMenuType();
//		model.addAttribute("list", list);
		model.addAttribute("list", menuDao.countByMenuType());
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
	
	
	//멤버(회원) 검색
	@RequestMapping("/member/search")
	public String memberSearch(@RequestParam(required = false) String column,
											@RequestParam(required = false) String keyword,
											Model model) {
		boolean isSearch = column != null && keyword != null;
		List<MemberDto> list = isSearch ? 
				memberDao.selectList(column, keyword) : memberDao.selectList();
		
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/member/search.jsp";
	}
}
