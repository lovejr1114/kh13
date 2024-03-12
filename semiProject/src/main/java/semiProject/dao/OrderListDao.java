package semiProject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import semiProject.dto.OrderListDto;
import semiProject.mapper.OrderListMapper;

@Repository
public class OrderListDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private OrderListMapper orderListMapper;
	
	//주문 내역 등록
	public void insert(OrderListDto orderListDto) {
		String sql = "insert into orderList("
					+ "orderList_no, orderList_store, orderList_id, "
					+ "orderList_pay, orderList_totalprice, orderList_request) "
					+ "values(orderList_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] data = {orderListDto.getOrderListStore() ,orderListDto.getOrderListId(),
					orderListDto.getOrderListPay(), orderListDto.getOrderListTotalprice(),
					orderListDto.getOrderListRequest()};
		jdbcTemplate.update(sql, data);
	}
	
	//주문 내역 조회
	//[1] 자신(특정 회원)의 구매내역을 조회할 수 있는 기능
	public List<OrderListDto> selectList(String orderListId){
		String sql = "select * from orderList where orderList_id = ? "
						+ "order by orderList_no desc";
		Object[] data = {orderListId};
		return jdbcTemplate.query(sql, orderListMapper, data);
	}
		
	//[2] 관리자가 모든 회원의 구매내역을 조회할 수 있는 기능
	public List<OrderListDto> selectList(int orderListStore){
		String sql = "select * from orderList where orderList_store = ? "
				+ "order by orderList_no desc";
		Object[] data = {orderListStore};
		return jdbcTemplate.query(sql, orderListMapper, data);
	}
		
	//[3] 관리자가 모든 회원의 구매내역을 조회할 수 있는 기능
	public List<OrderListDto> selectList(){
		String sql = "select * from orderList order by orderList_no desc";
		return jdbcTemplate.query(sql, orderListMapper);
	}
}
