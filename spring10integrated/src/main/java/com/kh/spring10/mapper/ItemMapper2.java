package com.kh.spring10.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring10.dto.ItemDto2;

@Service
public class ItemMapper2 implements RowMapper<ItemDto2> {

	@Override
	public ItemDto2 mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemDto2 itemDto2 = new ItemDto2();
		itemDto2.setItemNo(rs.getInt("item_no"));
		itemDto2.setItemName(rs.getString("item_name"));
		itemDto2.setItemPrice(rs.getInt("item_price"));
		itemDto2.setItemRegist(rs.getDate("item_regist"));
		return itemDto2;
	}

}
