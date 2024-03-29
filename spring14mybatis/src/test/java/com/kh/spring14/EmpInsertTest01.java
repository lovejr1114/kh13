package com.kh.spring14;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring14.dao.EmpDao;
import com.kh.spring14.dto.EmpDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmpInsertTest01 {

	@Autowired
	private EmpDao empDao;
	
	@Test
	public void test() {
		EmpDto empDto = new EmpDto();
		empDto.setEmpNo(8);
		empDto.setEmpName("김정은");
		empDto.setEmpDept("강의부");
		empDto.setEmpDate("2024-03-29");
		empDto.setEmpSal(1234000);
		
		empDao.insert(empDto);
		log.debug("등록 성공!");
	}
}
