package semiProject.controller;

import java.io.IOException;
import java.util.List;

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
import semiProject.dao.AttachDao;
import semiProject.dao.MemberDao;
import semiProject.dao.PointDao;
import semiProject.dto.PointDto;
import semiProject.service.AttachService;

@Controller
@RequestMapping("/point")
public class PointController {
	@Autowired
	private PointDao pointDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private AttachDao attachDao;
	@Autowired
	private AttachService attachService;

	// 포인트 등록 페이지 -> 있어야 하나? (관리자 전용)
	@GetMapping("/regist")
	public String regist() {
		return "/WEB-INF/views/point/regist.jsp";
	}
	@PostMapping("/regist")
	public String regist(@ModelAttribute PointDto pointDto,
								@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		int pointNo = pointDao.getPointSequence();
		pointDto.setPointNo(pointNo);
		pointDao.insert(pointDto);
		
		if(!attach.isEmpty()) {//파일이 있으면
			System.out.println("파일명="+attach.getOriginalFilename());
			System.out.println("파일유형="+attach.getContentType());
			System.out.println("파일크기="+attach.getSize());
			int attachNo = attachService.save(attach);
			pointDao.connect(pointNo, attachNo);
		}		
		return "redirect:registComplete";
	}

	
	//포인트 상품 목록
	@RequestMapping("/list")
	public String list(Model model) {
		List<PointDto> list = pointDao.selectList();
		model.addAttribute("list",list);
		return "/WEB-INF/views/point/list.jsp";
	}
	
	//상품번호를 전달하면 파일번호를 찾아서 리다이렉트하는 페이지
	@RequestMapping("/image")
	public String image(@RequestParam int pointNo) {
		try {
			int attachNo = pointDao.findAttcahNo(pointNo);
			return "redirect:/download?attachNo=" + attachNo;
		} catch (Exception e) {
			// return "기본 이미지 주소";
			return "redirect:http://via.placeholder.com/200x100";
		}
	}
	
	@RequestMapping("/registComplete")
	public String registComplete() {
		return "/WEB-INF/views/point/registComplete.jsp";
	}
	//여기까지 관리자

	
	
	//아직 안됨...ㅠㅠ
	// 충전 페이지
	@GetMapping("/charge")
	public String charge(Model model) {
		model.addAttribute("list", pointDao.selectList());
		return "/WEB-INF/views/point/charge.jsp";
	}

	@PostMapping("/charge")
	public String charge(HttpSession session, int point) {
	    String loginId = (String)session.getAttribute("loginId");// 아이디 추출

	    PointDto pointDto = new PointDto();
	    pointDto.setPointCharge(point); // 충전할 포인트 설정
	    
	    memberDao.plusMemberPoint(loginId, point); // 포인트 증가
	    
	    return "redirect:pointComplete";
	}
//	@PostMapping("/charge")
//	public String chargePoints(HttpSession session, @RequestParam String memberId, @RequestParam int point) {
//		boolean success = pointDao.chargePoints(memberId, point);
//		if (success) {
//			return "redirect:pointComplete";
//		} else {
//			return "redirect:errorPage";
//		}
//	}

	// 포인트 충전 완료페이지
	@RequestMapping("/chargeComplete")
	public String chargeComplete() {
		return "/WEB-INF/views/point/chargeComplete.jsp";
	}

}
