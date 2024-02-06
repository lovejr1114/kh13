package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.BuyDao;
import com.kh.spring10.dao.ItemDao;
import com.kh.spring10.dto.BuyDto;
import com.kh.spring10.dto.ItemDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/point")
public class PointController {
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private BuyDao buyDao;
	
	@GetMapping("/charge")
	public String charge(Model model) {
		model.addAttribute("list",itemDao.selectList());
		return "/WEB-INF/views/point/charge.jsp";
	}
	@PostMapping("/charge")
	public String charge(@ModelAttribute BuyDto buyDto, HttpSession session) {
		//buyDto에 itemNo와 buyQty가 들어온다
		String loginId = (String)session.getAttribute("loginId");// 아이디 추출
		ItemDto itemDto = itemDao.selectOne(buyDto.getItemNo()); //상품정보 조회
		
		buyDto.setMemberId(loginId);//아이디설정
		buyDto.setItemName(itemDto.getItemName()); //상품명 복사
		buyDto.setBuyTotal(itemDto.getItemPrice() * buyDto.getBuyQty()); //금액 * 수량
		
		buyDao.insert(buyDto);
		
		return "redirect:chargeFinish";
	}
	@RequestMapping("/chargeFinish")
	public String chargeFinish() {
		return "/WEB-INF/views/point/chargeFinish.jsp";
	}
	
	//상품번호를 전달하면 파일번호를 찾아서 리다이렉트하는 페이지
	@RequestMapping("/image")
	public String image(@RequestParam int itemNo) {
		try {
			int attachNo = itemDao.findAttcahNo(itemNo);
			return "redirect:/download?attachNo="+attachNo;
		}
		catch(Exception e) {
			//return "기본 이미지 주소";
			return "redirect:http://via.placeholder.com/200x100";
		}
	}
}
