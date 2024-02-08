package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.ItemDto2;

@Repository
public class ItemDao2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ItemDto2 itemDto2;
	
	//등록
	public void insert(ItemDto2 itemDto2) {}
	//목록
	public List<ItemDto2> selectList() {}
	//상세
	public ItemDto2 selectOne(int itemNo) {}
	//수정
	public boolean update(ItemDto2 itemDto2) {}
	//삭제
	public boolean delete(int itemNo) {}
}
