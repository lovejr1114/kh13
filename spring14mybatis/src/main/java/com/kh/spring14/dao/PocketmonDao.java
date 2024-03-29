package com.kh.spring14.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring14.dto.PocketmonDto;

@Repository
public class PocketmonDao {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	//이제 이거 가져올 필요 없다. 이것은 Spring JDBC
	
	@Autowired
	private SqlSession sqlSession; //myBatis
	
	public List<PocketmonDto> selectList(){
//		return pocketmon 영역의 list라는 구문을 실행해서 나온 결과;
		return sqlSession.selectList("pocketmon.list");
	}
	
	//등록
	public void insert(PocketmonDto pocketmonDto) {
		sqlSession.insert("pocketmon.add", pocketmonDto);
	}
	
	//수정
	public boolean update(PocketmonDto pocketmonDto) {
		return sqlSession.update("pocketmon.edit", pocketmonDto) > 0;
	}
	
	//삭제
	public boolean delete(int pocketmonNo) {
		return sqlSession.delete("pocketmon.remove",pocketmonNo) > 0;
	}
}
