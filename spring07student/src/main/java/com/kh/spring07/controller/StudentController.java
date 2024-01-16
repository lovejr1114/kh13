package com.kh.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.StudentDao;
import com.kh.spring07.dto.StudentDto;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentDao dao;
	
	//등록
	@RequestMapping("/add")
	public String add(@ModelAttribute StudentDto dto) {
		dao.insert(dto);
		return "학생 정보 등록 완료";
	}
	
	//수정
	@RequestMapping("/edit")
	public String edit(StudentDto dto) {
		boolean result = dao.update(dto);
		if(result) {
			return "학생 정보 수정 완료";
		}
		else {
			return "잘못된 학생 정보";
		}
	}
	
	//삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int studentId) {
		boolean result = dao.delete(studentId);
		if(result) {
			return "학생 정보 삭제 완료";
		}
		else {
			return "잘못된 학생 정보";
		}
	}
	
	//목록 및 검색
	@RequestMapping("/list")
	public String list(
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		List<StudentDto> list;
		if(isSearch) {
			list = dao.selectList(column, keyword);
		}
		else {
			list = dao.selectList();
		}
		
		StringBuffer buffer = new StringBuffer();
		for(StudentDto dto : list) {
			buffer.append("학생 이름 : " + dto.getStudentName()+"<br>");
			buffer.append("국어 점수 : "+dto.getStudentKoreanScore()+"점<br>");
			buffer.append("수학 점수 : "+dto.getStudentMathScore()+"점<br>");
			buffer.append("영어 점수 : "+dto.getStudentEnglishScore()+"점<br>");
			buffer.append("합계 : ?? 점<br>");
			buffer.append("평균 : ?? 점<br>");
			buffer.append("--------------------------<br>");
		}
		return buffer.toString();
	}
	
	//상세
	@RequestMapping("/detail")
	public String detail(@RequestParam int studentId) {
		StudentDto dto = dao.selectOne(studentId);
		if(dto != null) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("이름 : "+dto.getStudentName()+"<br>");
			buffer.append("국어점수 : " +dto.getStudentKoreanScore()+"점 <br>");
			buffer.append("수학점수 : "+dto.getStudentMathScore()+"점 <br>");
			buffer.append("영어점수 : "+dto.getStudentEnglishScore()+"점 <br>");
			buffer.append("합계 : ?? 점<br>");
			buffer.append("평균 : ?? 점<br>");
			
			return buffer.toString();
		}
		else {
			return "잘못된 학생 정보";
		}
			
	}
}
