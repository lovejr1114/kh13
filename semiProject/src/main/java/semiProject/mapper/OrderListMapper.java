package semiProject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import semiProject.dto.OrderListDto;

@Service
public class OrderListMapper implements RowMapper<OrderListDto> {

	@Override
	public OrderListDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderListDto orderListDto = new OrderListDto();
		orderListDto.setOrderListNo(rs.getInt("orderList_no"));
		orderListDto.setOrderListPay(rs.getString("orderList_pay"));
		orderListDto.setOrderListTotalprice(rs.getInt("orderList_totalpay"));
		orderListDto.setOrderListRequest(rs.getString("orderList_request"));
		orderListDto.setOrderListTime(rs.getDate("orderList_time"));
		return orderListDto;
	}

}
