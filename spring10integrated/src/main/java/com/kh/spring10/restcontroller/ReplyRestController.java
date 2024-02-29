package com.kh.spring10.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.ReplyDao;
import com.kh.spring10.dto.ReplyDto;

import jakarta.servlet.http.HttpSession;

//@CrossOrigin
@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {
	
	@Autowired
	private ReplyDao replyDao;
	
	// 비동기통신은 여태까지 알고있던 메소드가 다르다.. 혼동 조심
	
	//댓글 목록 읽기
	@PostMapping("/list")
	public List<ReplyDto> list(@RequestParam int replyOrigin) {
		return replyDao.selectList(replyOrigin);
	}
	//댓글 삭제
	@PostMapping("/delete")
	public void delete(@RequestParam int replyNo){
		replyDao.delete(replyNo);
	}
	//댓글 등록
	@PostMapping("/insert")
	public void insert(@ModelAttribute ReplyDto replyDto, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		int sequence = replyDao.sequence();
		
		replyDto.setReplyWriter(loginId);
		replyDto.setReplyNo(sequence);
		
		replyDao.insert(replyDto);
	}
}
