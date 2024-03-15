package semiProject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import semiProject.dto.OrdersDto;
import semiProject.mapper.OrdersMapper;

@Repository
public class OrdersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private OrdersMapper ordersMapper;
	
	//주문 내역 등록
	public void insert(OrdersDto ordersDto) {
		String sql = "insert into orders("
				+ "orders_no, member_no, store_no, store_name, menu_no, "
				+ "menu_name, orders_qty, orders_total) "
				+ "values(orders_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {
				ordersDto.getMemberNo(), ordersDto.getStoreNo(),
				ordersDto.getStoreName(), ordersDto.getMenuNo(),
				ordersDto.getMenuName(), ordersDto.getOrdersQty(),
				ordersDto.getOrdersTotal()
		};
		jdbcTemplate.update(sql, data);
	}
	
	//주문 내역 조회
	//[1] 자신(특정 회원)의 구매내역을 조회할 수 있는 기능
	public List<OrdersDto> selectListMemberNo(int memberNo){
		String sql = "select * from orders where member_no = ? "
						+ "order by orders_no desc";
		Object[] data = {memberNo};
		return jdbcTemplate.query(sql, ordersMapper, data);
	}
		
	//[2] 관리자가 모든 회원의 구매내역을 조회할 수 있는 기능
	public List<OrdersDto> selectListStoreNo(int storeNo){
		String sql = "select * from orders where store_no = ? "
				+ "order by orders_no desc";
		Object[] data = {storeNo};
		return jdbcTemplate.query(sql, ordersMapper, data);
	}
		
	//[3] 관리자가 모든 회원의 구매내역을 조회할 수 있는 기능
	public List<OrdersDto> selectList(){
		String sql = "select * from orders order by orders_no desc";
		return jdbcTemplate.query(sql, ordersMapper);
	}
}
