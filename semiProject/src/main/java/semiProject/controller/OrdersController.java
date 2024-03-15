package semiProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import semiProject.dao.MemberDao;
import semiProject.dao.OrdersDao;
import semiProject.dao.StoreDao;
import semiProject.dto.OrdersDto;
import semiProject.dto.StoreDto;

@Controller
@RequestMapping("/orderList")
public class OrdersController {

	@Autowired
	private OrdersDao ordersDao;
//	@Autowired
//	private MenuDao menuDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private StoreDao storeDao;
	
	//주문내역 등록
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("list", ordersDao.selectList());
		return "/WEB-INF/views/orderlist/add.jsp";
	}
//	@PostMapping("/add")
//	public String add(@ModelAttribute OrderListDto orderListDto, HttpSession session) {
//		//orderListDto에 storeNo가 들어온다
//		String loginId = (String)session.getAttribute("loginId"); //아이디 추출하고
//		StoreDto storeDto = StoreDao.selectOne(OrderListDto.getStoreNo()); //가게 정보 조회
//		
//		orderListDto.setOrderListId(loginId);
//		orderListDto.setOrderListStore(storeDto.get)
//	}
}
