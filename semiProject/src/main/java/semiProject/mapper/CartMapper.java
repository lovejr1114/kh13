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
		cartDto.setMemberNo(rs.getInt("member_no"));
		cartDto.setMenuNo(rs.getInt("menu_no"));
		cartDto.setItemName(rs.getString("item_name"));
		cartDto.setItemQuantify(rs.getInt("item_quantify"));
		cartDto.setItemPrice(rs.getInt("item_price"));

		return cartDto;
	}

}
