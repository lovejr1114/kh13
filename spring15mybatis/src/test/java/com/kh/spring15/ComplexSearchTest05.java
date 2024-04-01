package com.kh.spring15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ComplexSearchTest05 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		Map<String, Object> data = new HashMap<>();
//		data.put("memberId", "test");
//		data.put("memberNick", "테스트");
//		data.put("memberContact", "01012345678");
//		data.put("minPoint", 50000);
//		data.put("maxPoint", 100000);
//		data.put("memberJoin", "2024-01-26");
//		data.put("minLoginDate", "2024-03-01");
//		data.put("maxLoginDate", "2024-03-15");
//		data.put("memberLevelList", List.of("일반회원"));
//		data.put("memberLevelList", List.of("일반회원","우수회원"));
//		data.put("memberLevelList", List.of("일반회원","우수회원","관리자"));
//		data.put("orderList",List.of("member_nick asc","member_point desc"));
		
		data.put("beginRow", 1);
		data.put("endRow", 10);
		
		List<MemberDto> list = sqlSession.selectList("member.complex", data);
		for(MemberDto memberDto : list) {
			log.debug("member = {}", memberDto);
		}
	}
	
}
