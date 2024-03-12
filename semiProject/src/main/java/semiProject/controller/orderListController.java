package semiProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import semiProject.dao.MemberDao;
import semiProject.dao.OrderListDao;

@Controller
@RequestMapping("/orderList")
public class orderListController {

	@Autowired
	private OrderListDao orderListDao;
//	@Autowired
//	private MenuDao menuDao;
	@Autowired
	private MemberDao memberDao;
}
