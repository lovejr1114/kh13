package com.kh.spring19.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring19.dto.BookDto;

@Repository
public class BookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BookDto> selectList(){
		return sqlSession.selectList("book.list");
	}

}
