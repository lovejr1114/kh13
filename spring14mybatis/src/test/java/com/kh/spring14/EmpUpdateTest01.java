package com.kh.spring14;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring14.dao.EmpDao;
import com.kh.spring14.dto.EmpDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmpUpdateTest01 {

	@Autowired
	private EmpDao empDao;
	
	@Test
	public void test() {
		EmpDto empDto = new EmpDto();
		empDto.setEmpNo(8);
		empDto.setEmpName("김정은");
		empDto.setEmpDept("영업부");
		empDto.setEmpDate("2024-03-08");
		empDto.setEmpSal(2500000);
		
		if(empDao.update(empDto)) {
			log.debug("정보 변경 완료");
		}
		else {
			log.debug("없는 정보입니다");
		}
	}
}
