package com.kh.spring11.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.dao.MemberDao;
import com.kh.spring11.dao.PocketmonDao;
import com.kh.spring11.dto.MemberDto;
import com.kh.spring11.dto.PocketmonDto;

//@Controller // 사용자에게 화면을 전송하는 컨트롤러

@CrossOrigin //외부에서의 비동기통신을 허용하는 설정 (현관문 열어놓기)
@RestController // 사용자에게 데이터를 전송하는 컨트롤러 (화면이 없음)
public class AjaxRestController {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private PocketmonDao pocketmonDao;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello Ajax!";
	}
	
	
	@RequestMapping("/checkId")
	public String checkId(@RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		
		if(memberDto == null) {	//memberDto 안에 null일 경우(없을 경우)		
			return "NNNNY"; // 사용 가능한 경우 (DB에 없는 경우)
		}
		else {
			return "NNNNN"; // 사용 불가능한 경우 (DB에 있는 경우)			
		}
	}

	
	@PostMapping("/checkPocketmonNo")
	public boolean checkPocketmonNo(@RequestParam int pocketmonNo) {
		PocketmonDto pocketmonDto = pocketmonDao.selectOne(pocketmonNo);
		return pocketmonDto == null;
//		if(pocketmonDto == null) {
//			return true;
//		}
//		else {
//			return false;
//		}
	}
	
	
	@PostMapping("/checkMemberNick")
	public boolean checkMemberNick(@RequestParam String memberNick) {
		MemberDto memberDto = memberDao.selectOneByMemberNick(memberNick);
		return memberDto == null;
	}

}
