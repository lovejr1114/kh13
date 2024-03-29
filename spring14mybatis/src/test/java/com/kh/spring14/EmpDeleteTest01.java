package com.kh.spring14;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring14.dao.EmpDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmpDeleteTest01 {

	@Autowired
	private EmpDao empDao;
	
	@Test
	public void test() {
		int empNo = 8;
		if(empDao.delete(empNo)) {
			log.debug("삭제 성공");
		}
		else {
			log.debug("존재하지 않는 사원번호");
		}
	}
}
