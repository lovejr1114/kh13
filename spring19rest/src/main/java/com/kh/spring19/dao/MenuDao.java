package com.kh.spring19.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring19.dto.MenuDto;

@Repository
public class MenuDao {

	@Autowired
	private SqlSession sqlSession;
	
	//시퀀스
	public int sequence() {
		return sqlSession.selectOne("menu.sequence");
	}
	
	//등록
	public void insert(MenuDto menuDto) {
		sqlSession.insert("menu.insert",menuDto);
	}
	
	//목록
	public List<MenuDto> selectList(){
		return sqlSession.selectList("menu.list");
	}
	
	//상세
	public MenuDto selectOne(int menuNo) {
		return sqlSession.selectOne("menu.find",menuNo);
	}
	
	//전체 수정
	public boolean editAll(MenuDto menuDto) {
		return sqlSession.update("menu.editAll",menuDto) > 0;
	}
	//일부 수정
	public boolean editUnit(MenuDto menuDto) {
		return sqlSession.update("menu.editUnit",menuDto) > 0;
	}
	
	//삭제
	public boolean delete(int menuNo) {
		return sqlSession.delete("menu.delete",menuNo) > 0;
	}
}
