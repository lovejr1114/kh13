package com.kh.spring10.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.EmpDao;
import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dao.MenuDao;
import com.kh.spring10.dao.PocketmonDao;
import com.kh.spring10.vo.StatVO;

// 통계 데이터를 클라이언트에게 전송하는 컨트롤러
@CrossOrigin // 비동기통신이 다 좋은데 남의집 거는 못 들어감. 그래서 허용해주는. (CORS 허용-교차출처 자원공유)
@RestController
@RequestMapping("/rest/stat")
public class StatRestController {
	@Autowired
	private PocketmonDao pocketmonDao;
	
	@Autowired
	private EmpDao empDao;
	
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/pocketmon")
	public List<StatVO> pocketmon() {
		return pocketmonDao.statByType();
	}

	@RequestMapping("/emp")
	public List<StatVO> emp() {
		return empDao.statByDept();
	}
	
	@RequestMapping("/menu")
	public List<StatVO> menu(){
		return menuDao.countByMenuType();
	}
	
	@RequestMapping("/member")
	public List<StatVO> member() {
		return memberDao.statByLevel();
	}
}
