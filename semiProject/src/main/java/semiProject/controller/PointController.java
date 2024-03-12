package semiProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import semiProject.dao.MemberDao;
import semiProject.dao.PointDao;
import semiProject.dto.PointDto;

@Controller
@RequestMapping("/point")
public class PointController {
	@Autowired
	private PointDao pointDao;
	@Autowired
	private MemberDao memberDao;
	
	//포인트 등록 페이지 -> 있어야 하나?
//	@GetMapping("/regist")
//	public String regist() {
//		return "/WEB-INF/views/point/regist.jsp";
//	}
//	@PostMapping("/regist")
	
	
	//충전 페이지
	@GetMapping("/charge")
	public String charge(Model model) {
		model.addAttribute("list",pointDao.selectList());
		return "/WEB-INF/views/point/charge.jsp";
	}
//	@PostMapping("/charge")
//	public String charge(HttpSession session, int point) {
//	    String loginId = (String)session.getAttribute("loginId");// 아이디 추출
//
//	    PointDto pointDto = new PointDto();
//	    pointDto.setPointCharge(point); // 충전할 포인트 설정
//	    
//	    memberDao.plusMemberPoint(loginId, point); // 포인트 증가
//	    
//	    return "redirect:pointComplete";
//	}
	@PostMapping("/charge")
    public String chargePoints(HttpSession session, @RequestParam String memberId, @RequestParam int point) {
        boolean success = pointDao.chargePoints(memberId, point);
        if (success) {
            return "redirect:pointComplete";
        } else {
            return "redirect:errorPage";
        }
    }
	
	//포인트 충전 완료페이지
	@RequestMapping("/chargeComplete")
	public String chargeComplete() {
		return "/WEB-INF/views/point/chargeComplete.jsp";
	}
	
	
	//상품 이미지
	@RequestMapping("/image")
	public String image(@RequestParam int pointNo) {
		try {
			int attachNo = pointDao.findAttcahNo(pointNo);
			return "redirect:/download?attachNo="+attachNo;
		}
		catch(Exception e) {
			//return "기본 이미지 주소";
			return "redirect:http://via.placeholder.com/200x100";
		}
	}
	
}
