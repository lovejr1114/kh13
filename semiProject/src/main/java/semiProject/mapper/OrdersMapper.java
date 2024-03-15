package semiProject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import semiProject.dto.OrdersDto;

@Service
public class OrdersMapper implements RowMapper<OrdersDto> {

	@Override
	public OrdersDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrdersDto ordersDto = new OrdersDto();
		ordersDto.setOrdersNo(rs.getInt("orders_no"));
		ordersDto.setMemberNo(rs.getInt("member_no"));
		ordersDto.setStoreNo(rs.getInt("store_no"));
		ordersDto.setStoreName(rs.getString("store_name"));
		ordersDto.setMenuNo(rs.getInt("menu_no"));
		ordersDto.setMenuName(rs.getString("menu_name"));
		ordersDto.setOrdersQty(rs.getInt("orders_qty"));
		ordersDto.setOrdersTotal(rs.getInt("orders_total"));
		ordersDto.setOrdersTime(rs.getDate("orders_time"));
		return ordersDto;
	}
}
