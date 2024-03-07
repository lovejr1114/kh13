package com.kh.spring10.controller;

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

import com.kh.spring10.dao.AttachDao;
import com.kh.spring10.dao.BuyDao;
import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dto.MemberDto;
import com.kh.spring10.service.AttachService;
import com.kh.spring10.service.EmailService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private AttachDao attachDao;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private AttachService attachService;
	
	@Autowired
	private BuyDao buyDao;
	
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto,
							@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		//회원가입
		memberDao.insert(memberDto);
		//첨부파일 등록
		if(!attach.isEmpty()) {
			int attachNo = attachService.save(attach); //파일저장+DB저장
			
			memberDao.connect(memberDto.getMemberId(), attachNo); //연결
		}
		
		//가입 환영 메일 발송
		emailService.sendWelcomeMail(memberDto.getMemberEmail());
		
		return "redirect:joinSuccess";
	}
	
	@RequestMapping("/joinSuccess")
	public String joinSuccess() {
		return "/WEB-INF/views/member/joinSuccess.jsp";
	}
	
	//테스트 로그인 & 로그아웃
	//- HttpSession을 사용하고 싶다면 매개변수에 선언만 하면 된다.
	//- 등록 : session.setAttribute("key",value)
	//- 확인 : session.getAttribute("key")
	//- 삭제 : session.removeAttribute("key")
	@RequestMapping("/testLogin")
	public String testLogin(HttpSession session) {
		session.setAttribute("loginId", "testuser1");
//		session.setAttribute(이름, PK값);
		return "redirect:/";
	}
	
	@RequestMapping("/testLogout")
	public String testLogout(HttpSession session) {
			session.removeAttribute("loginId");
			return "redirect:/";
	}
	
	
	//실제 로그인
	//- 아이디와 비밀번호 검사를 통과해야만 세션에 데이터를 추가한다 
	//- 사용자가 입력한 아이디를 추가한다 
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/member/login.jsp";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto inputDto, HttpSession session) {
		//사용자가 입력한 아이디로 회원정보를 조회한다
		MemberDto findDto = memberDao.selectOne(inputDto.getMemberId());
		//로그인 가능 여부를 판전
		boolean isValid = findDto != null && inputDto.getMemberPw().equals(findDto.getMemberPw());
		//아이디가 있다면 && 사용자가 입력한 비밀번호.equals(DB에 저장된 비밀번호)
		
		//결과에 따라 다른 처리
		if(isValid) {
			//세션에 데이터 추가
			session.setAttribute("loginId",findDto.getMemberId());
			session.setAttribute("loginLevel", findDto.getMemberLevel());
			
			//최종 로그인 시각 갱신
			memberDao.updateMemberLogin(findDto.getMemberId());
			
			return "redirect:/";
		}
		else { //로그인 실패
			return "redirect:login?error";
		}
	}
	
	//실제 로그아웃
	//- 로그인 때 검사를 했으므로 추가 검사는 불필요
	//- 로그인 때 저장한 세션의 데이터만 삭제 처리
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId"); //세션 값 삭제
		session.removeAttribute("loginLevel");
		//session.incalidate(); //세션 삭제 (사용자가 없어짐, 비추천)
		return "redirect:/";
	}
	
	//내 정보
	//- (중요) 내 아이디는 HttpSession에 있다
	//- 그리고 화면에 내 정보를 표시해야 한다
	@RequestMapping("/mypage")
	public String mypage(Model model, HttpSession session) {
		//1. 세션에 저장된 아이디를 꺼낸다
		String loginId = (String) session.getAttribute("loginId");
		//다운 캐스팅해준다.
		
		//2. 아이디에 맞는 정보를 조회한다.
		MemberDto memberDto = memberDao.selectOne(loginId);
		
		//3. 화면에 조회한 정보를 전달한다.
		model.addAttribute("memberDto", memberDto);
		
		//(추가) 현재 사용자의 구매내역을 첨부
		model.addAttribute("buyList",buyDao.selectList(loginId));
		
		//(추가) 현재 사용자의 작성 글 내역을 첨부
		
		
		//4. 연결이 될 화면을 반환
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
	//비밀번호 변경
	@GetMapping("/password")
	public String password() { //전달할 내용이있으면 Model을 만들고 없으면 냅두고.
		return "/WEB-INF/views/member/password.jsp";
	}
	
	//기존 비밀번호를 originPw, 변경할 비밀번호를 changePw로 처리
	//아이디는 HttpSession에 존재한다.
	@PostMapping("/password")
	public String password(@RequestParam String originPw,
										@RequestParam String changePw,
										HttpSession session) {
		//로그인된 사용자의 아이디를 추출
		String loginId = (String) session.getAttribute("loginId"); //다운캐스팅 (되돌린다)
		
//		memberDao.updateMemberPw(memberDto); //Dto가 없으면 만들어주면 된다
		//loginId , origin, changePw 중에 dto에 들어가야할 것은 로그인아이디, 바꿀 아이디. ->이걸로 Dto만들기
		
		//비밀번호 검사를 위해 DB에 저장된 정보를 불러온다
		MemberDto findDto = memberDao.selectOne(loginId); //findDto와 originPw를 비교
		boolean isValid = findDto != null && findDto.getMemberPw().equals(originPw);
		
		if(isValid) { //입력한 기존 비밀번호가 유효할 경우
			//아이디와 변경할 비밀번호로 DTO를 만들어 DAO의 기능을 호출
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(loginId);
			memberDto.setMemberPw(changePw);
			memberDao.updateMemberPw(memberDto);
			
			return "redirect:passwordFinish";
		}
		else {//입력한 기존 비밀번호가 유효하지 않을 경우
			return "redirect:password?error";
		}
	}

	@RequestMapping("/passwordFinish")
	public String passwordFinish() {
		return "/WEB-INF/views/member/passwordFinish.jsp";
	}
	
	//개인정보 변경
	@GetMapping("/change")
	public String change(Model model, HttpSession session) { //기존 나의 정보 출력
		//사용자 아이디를 세션에 추출
		String loginId = (String) session.getAttribute("loginId");
		//위 코드를 JSP에서 표현하면 ${sessionScope.loginId}
		
		//아이디로 정보 조회 (단일 조회)
		MemberDto memberDto = memberDao.selectOne(loginId); 
		
		//모델에 정보 추가
		model.addAttribute("memberDto", memberDto);
		
		return "/WEB-INF/views/member/change.jsp";
	}
	@PostMapping("/change")
	public String change(@ModelAttribute MemberDto memberDto, HttpSession session) {
		//세션에서 아이디 추출
		String loginId = (String)session.getAttribute("loginId");
		
		//memberDto에 아이디 설정
		memberDto.setMemberId(loginId);
		
		//DB정보 조회
		MemberDto findDto = memberDao.selectOne(loginId);
		//memberDto와 findDto의 비밀번호를 비교해야한다. 같으면 성공, 다르면 에러
		
		//판정
		boolean isValid = memberDto.getMemberPw().equals(findDto.getMemberPw());
		
		//변경 요청
		if(isValid) {
			memberDao.updateMember(memberDto);
			return "redirect:mypage";	
		}
		else {
			//이전 페이지로 리다이렉트
			return "redirect:change?error";		
		}
	}
	//회원 탈퇴
	@GetMapping("/exit")
	public String exit() {
		return "/WEB-INF/views/member/exit.jsp";
	}
	
	@PostMapping("/exit")
	public String exit(@RequestParam String memberPw, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		
		MemberDto findDto = memberDao.selectOne(loginId);
		boolean isValid = findDto.getMemberPw().equals(memberPw);
		
		if(isValid) {
			//회원 탈퇴 전에 프로필 번호를 찾아서 삭제 처리
			try {
				int attachNo = memberDao.findAttachNo(loginId);
				attachService.remove(attachNo); //파일삭제+DB삭제
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			memberDao.delete(loginId); //회원 탈퇴
			session.removeAttribute("loginId"); //로그아웃
			return "redirect:exitFinish";
		}
		else {
			return "redirect:exit?error";
		}
	}
	
	@RequestMapping("/exitFinish")
	public String exitFinish() {
		return "/WEB-INF/views/member/exitFinish.jsp";
	}
	
	//프로필 다운로드 페이지
	@RequestMapping("/image")
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
}
