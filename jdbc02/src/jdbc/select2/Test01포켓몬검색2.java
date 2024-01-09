package jdbc.select2;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.select.PocketmonDto;
import jdbc.select.PocketmonMapper;
import jdbc.util.jdbcHelper;

public class Test01포켓몬검색2 {
	public static void main(String[] args) {
		//유사검색
		//- 시작 검색 or 포함검색
		//- 상황에 맞게 like 연산자 또는 instr 함수를 사용
		
		//데이터 준비
		String keyword = "피카";
		
//		keyword += "%"; // Java에서 처리하는 경우
		
		//처리
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "select * from pocketmon where instr(pocketmon_name, ?) > 0";
		Object[] data = {keyword};
		PocketmonMapper mapper = new PocketmonMapper();
		
		List<PocketmonDto> list = jdbcTemplate.query(sql, mapper, data);
		
		System.out.println("조회 결과 : "+list.size()+"개");
		for(PocketmonDto dto:list) {
			System.out.println(dto.getPocketmonName());
		}
	}
}
