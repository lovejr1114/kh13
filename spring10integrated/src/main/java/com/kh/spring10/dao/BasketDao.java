package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.BasketDto;

@Repository
public class BasketDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BasketDto basketDto;
	
	//등록
	public void insert(BasketDto basketDto) {}
	//목록
	public List<BasketDto> selectList(){}
	//상세
	public BasketDto selectOne(int basketNo) {}
	//수정
	public boolean update(BasketDto basketDto) {}
	//삭제
	public boolean delete(int basketNo) {}
}
