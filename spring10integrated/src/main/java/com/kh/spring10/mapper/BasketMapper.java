package com.kh.spring10.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring10.dto.BasketDto;

@Service
public class BasketMapper implements RowMapper<BasketDto> {

	@Override
	public BasketDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BasketDto basketDto = new BasketDto();
		basketDto.setBasketNo(rs.getInt("basket_no"));
		basketDto.setBasketUser(rs.getString("basket_user"));
		basketDto.setBasketItem(rs.getInt("basket_item"));
		basketDto.setBasketTime(rs.getDate("basket_time"));
		basketDto.setBasketQty(rs.getInt("basket_qty"));
		return basketDto;
	}
}
