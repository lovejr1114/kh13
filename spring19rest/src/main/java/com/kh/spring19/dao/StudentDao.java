package com.kh.spring19.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring19.dto.StudentDto;

@Repository
public class StudentDao {
	@Autowired
	private SqlSession sqlSession;

	
	//조회
	public List<StudentDto> selectList() {
		return sqlSession.selectList("student.list");
	}
	
	//시퀀스
	public int sequence() {
		return sqlSession.selectOne("student.sequence");
	}

	//등록
	public void insert(StudentDto studentDto) {
		sqlSession.insert("student.save",studentDto);
	}
	
	//상세
	public StudentDto selectOne(int studentId) {
		return sqlSession.selectOne("student.find",studentId);
	}
	
}
