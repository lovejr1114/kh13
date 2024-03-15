package semiProject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import semiProject.dto.CartDto;
import semiProject.mapper.CartMapper;

@Repository
public class CartDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CartMapper cartMapper;
	
	//장바구니 추가
	public void add(CartDto cartDto) {
		String sql = "insert into cart("
				+ "cart_no, cart_count, member_id, menu_no, "
				+ "store_no, store_name, menu_name, cart_price) "
				+ "values(cart_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {
				cartDto.getCartNo(), cartDto.getMemberId(),
				cartDto.getMenuNo(), cartDto.getStoreNo(),
				cartDto.getStoreName(), cartDto.getMenuName(),
				cartDto.getCartPrice()
		};
		jdbcTemplate.update(sql, data);
	}
}
