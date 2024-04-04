package com.kh.spring17.controller;

import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring17.dao.ProductDao;
import com.kh.spring17.dto.ProductDto;
import com.kh.spring17.service.KakaoPayService;
import com.kh.spring17.vo.KakaoPayReadyRequestVO;
import com.kh.spring17.vo.KakaoPayReadyResponseVO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pay2")
public class pay2Controller {

	@Autowired
	private KakaoPayService kakaoPayService;

	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/purchase")
	public String purchase(Model model) {
		model.addAttribute("list",productDao.selectList());
		return "pay2/purchase";
	}
	
	@PostMapping("/purchase")
	public String purchase(@RequestParam int no, HttpSession session) throws URISyntaxException {
		//상품명과 가격을 알기 위해 DB 조회
		ProductDto productDto = productDao.selectOne(no);
		//만약 productDto가 null 이라면 예외 발생 혹은 중단
		
		KakaoPayReadyRequestVO requestVO = 
				KakaoPayReadyRequestVO.builder()
					.partnerOrderId(UUID.randomUUID().toString())
					.partnerUserId("testuser1")
					.itemName(productDto.getName())
					.totalAmount(productDto.getPrice())
				.build();
		
		KakaoPayReadyResponseVO responseVO = 
										kakaoPayService.ready(requestVO);
		
		//세션에 Flash Attribute를 추가
		session.setAttribute("partner_order_id", requestVO.getPartnerOrderId());
		session.setAttribute("partner_user_id", requestVO.getPartnerUserId());
		session.setAttribute("tid", responseVO.getTid());
		
		return "redirect:"+responseVO.getNextRedirectPcUrl();
	}
}
