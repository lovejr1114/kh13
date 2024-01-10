package jdbc.app;

import java.util.List;

import jdbc.dao.PocketmonDao;
import jdbc.dto.PocketmonDto;

public class Test10포켓몬조회2 {
	public static void main(String[] args) {
		//조회 역시 DAO를 이용하여 진행
		//- 목록을 조회하는 경우
		//		- 데이터가 여러개 조회(0,1개도 포함)
		//		- 원하는 최종 형태는 List<PocketmonDto>
		//		- 검색은 목록을 조회하는 경우 (많이 나올 수 있으니까)
		
		//- 단일 항목을 조회하는 경우 (단일 항목은 조건이 PK)
		// 		- 기본키(PK) 조건을 통해 조회
		// 		- 데이터가 있거나 없거나 두 가지 상태.
		//		- 원하는 최종 형태는 PocketmonDto
		
		//selectOne()
		
		int pocketmonNo = 1;
		
		PocketmonDao dao = new PocketmonDao();
		PocketmonDto dto = dao.selectOne(pocketmonNo);
		
		System.out.println(dto);
		
	}
}
