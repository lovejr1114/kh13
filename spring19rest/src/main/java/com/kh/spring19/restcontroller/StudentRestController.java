package com.kh.spring19.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring19.dao.StudentDao;
import com.kh.spring19.dto.StudentDto;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="학생 성적 정보", description="국어 수학 영어")

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private StudentDao studentDao;
	
	//조회
	@GetMapping("/")
	public List<StudentDto> list(){
		return studentDao.selectList();
	}
	
	//등록
	@PostMapping("/")
	public StudentDto insert(@RequestBody StudentDto studentDto) {
		int sequence = studentDao.sequence(); //번호 생성
		studentDto.setStudentId(sequence); //설정(세팅)
		studentDao.insert(studentDto); //등록
		
		return studentDao.selectOne(sequence);
	}
}
