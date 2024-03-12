package semiProject.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import semiProject.dao.MemberDao;
import semiProject.dto.MemberDto;
import semiProject.service.AttachService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	private AttachService attachService;
	
	//회원가입페이지
	@GetMapping("/signup")
	public String signup() {
		return "/WEB-INF/views/member/signup.jsp";
	}
	@PostMapping("/signup")
	public String signup(@ModelAttribute MemberDto memberDto,
						@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		if(!attach.isEmpty()) {
			int attachNo = attachService.save(attach);
			memberDao.connect(memberDto.getMemberId(), attachNo);
		}
		
		return "redirect:signupFinish";
	}
	//프사 반환
	
	@RequestMapping("/profilePhoto")
	public String image(HttpSession session) {
		try {
			String loginId = (String)session.getAttribute("loginId");
			int attachNo = memberDao.findAttachNo(loginId);
			return "redirect:/download?attachNo="+attachNo;
		}
		catch(Exception e) {
			return "redirect:/image/user.png";
		}
	}
	
	 
	
	//내정보페이지11
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
	//회원탍퇴페이지
	@GetMapping("/delete_account")
	public String delete_account() {
		
		return "/WEB-INF/views/member/delete_account.jsp";
	}
	
	
	/*
	 * @PostMapping("/delete_account") public String delete_account() {
	 * 
	 * return ""; }
	 */
	
	
	@RequestMapping("/delete_account_success")
	public String delete_account_finish() {
		
		return "/WEB-INF/views/member/delete_account_success.jsp";
	}
	
	//개인정보변경페이지
	@GetMapping("/profileEdit")
	public String profileEdit() {
		
		return "/WEB-INF/views/member/profileEdit.jsp";
	}
	
	/*
	 * @PostMapping("/profileEdit") public String profileEdit()
	 *  { return ""; }
	 */
	
	//비밀번호변경페이지
	@GetMapping("/pwUpdate")
	public String pwUpdate() {
		
		return "/WEB-INF/views/member/pwUpdate.jsp";
	}
	
	/*
	 * @PostMapping("/pwUpdate") public String pwUpdate() {
	 * 
	 * return ""; }
	 */
	//asd
	@RequestMapping("/pwUpdateSuccess")
	public String pwUpdateSuccess() {
		
		return "/WEB-INF/views/member/pwUpdateSuccess.jsp";
	}
	
	
	
	
	
	
	
	
}
