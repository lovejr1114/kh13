package com.kh.spring14;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring14.dao.PocketmonDao;
import com.kh.spring14.dto.PocketmonDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PocketmonUpdateTest01 {

	@Autowired
	private PocketmonDao pocketmonDao;
	
	@Test
	public void test() {
		PocketmonDto pocketmonDto = new PocketmonDto();
		pocketmonDto.setPocketmonNo(77);
		pocketmonDto.setPocketmonName("김정은");
		pocketmonDto.setPocketmonType("바람");
		
		if(pocketmonDao.update(pocketmonDto)) {
			log.debug("정보 변경 성공");
		}
		else {
			log.debug("존재하지 않는 대상");
		}
	}
}
