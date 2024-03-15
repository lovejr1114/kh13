package semiProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import semiProject.dao.CartDao;
import semiProject.dao.MenuDao;
import semiProject.dao.StoreDao;
import semiProject.dto.CartDto;
import semiProject.dto.MenuDto;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private MenuDao menuDao;
	

	@RequestMapping("/list")
	public String list(@RequestParam int menuNo, Model model,
							@ModelAttribute CartDto cartDto, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId"); //아이디 추출
		//메뉴디비에 있는 정보를 불러옴 (selectOne(cartNo))
		MenuDto menuDto = (MenuDto) menuDao.selectList(); // 
		
		//cart 디비에 저장
		cartDto.setMemberId(loginId); //아이디 설정
		cartDto.setMenuName(menuDto.getMenuName()); //메뉴명 복사
		cartDto.setCartPrice(menuDto.getMenuPrice() * cartDto.getCartCount()); //메뉴 가격 * 장바구니 수량
		
		//cart 디비에 있는 정보를 jsp로 넘겨줌. 
		cartDao.add(cartDto);
		
		
		return "/WEB-INF/views/cart/list.jsp";
	}
	
//	@RequestMapping("/add")
//	public String add(@ModelAttribute CartDto cartDto, HttpSession session) {
//		String loginId = (String)session.getAttribute("loginId");
//		if(loginId == null) {
//			return "redirect:/member/signin";
//		}
//		
//		int memberNo = Integer.parseInt(loginId);
//		cartDto.setMemberNo(memberNo);
//		cartDto.setStoreName();
//	}
}
