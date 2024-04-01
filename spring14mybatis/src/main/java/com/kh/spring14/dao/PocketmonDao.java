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
	
	//상세 조회를 구현하는 방법은 2가지
	//1. selectList를 사용해서 목록으로 처리 - 여러개 나와도 에러가 안남 (X)
	//2. selectOne을 사용해서 상세조회 처리 - 여러개 나오면 에러가 발생 (O)
	public PocketmonDto selectOne(int pocketmonNo) {
		//1번
//		List<PocketmonDto> list = 
//				sqlSession.selectList("pocketmon.find",pocketmonNo);
//		return list.isEmpty() ? null : list.get(0);
//		
		//2번
		return sqlSession.selectOne("pocketmon.find",pocketmonNo);
	}
	
	//검색,키워드
//	public List<PocketmonDto> selectSearch(String type, String keyword){
//		return sqlSession.selectSearch("pocketmon.search",);
//		https://velog.io/@jeeweon/TIL-Day72-MyBatis-%EC%A1%B0%EA%B1%B4%EB%B6%80-select-%EB%B3%B5%ED%95%A9-%EA%B2%80%EC%83%89
//		위 주소 들어가서 참고하기
//}
}
