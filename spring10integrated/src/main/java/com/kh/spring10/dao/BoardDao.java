package com.kh.spring10.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.BoardDto;

@Repository
public class BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//CRUD 메소드 생략
	
	public void insert(BoardDto dto) {
	String sql = "insert into board(board_no, board_title, board_content) "
				+ "values(board_seq.nextval, ?, ?)";
	Object[] param = {dto.getBoardTitle(), dto.getBoardContent()};
	jdbcTemplate.update(sql, param);
	}
}
