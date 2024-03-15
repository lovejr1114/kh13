package semiProject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import semiProject.dto.CartDto;

@Service
public class CartMapper implements RowMapper<CartDto> {

	@Override
	public CartDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartDto cartDto = new CartDto();
		cartDto.setCartNo(rs.getInt("cart_no"));
		cartDto.setCartCount(rs.getInt("cart_count"));
		cartDto.setMemberId(rs.getString("member_id"));
		cartDto.setStoreNo(rs.getInt("store_no"));
		cartDto.setStoreName(rs.getString("store_name"));
		cartDto.setMenuName(rs.getString("menu_name"));
		cartDto.setCartPrice(rs.getInt("cart_price"));
		return cartDto;
	}

}
