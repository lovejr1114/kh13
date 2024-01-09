package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jdbc.util.jdbcHelper;

public class Test01포켓몬수정 {
	public static void main(String[] args) {
		//목표: 1개의 포켓몬스터 정보 중 이름과 유형을 변경하도록 구현
		
		//데이터 준비
		int pocketmonNo = 1;
		String pocketmonName = "야도란";
		String pocketmonType = "물";
		
		
		//도구를 한 번에 생성
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		//RunTime.getRunTime(); / LocalDate.now(); => 이것과 같은 명령
		
		String sql = "update pocketmon set pocketmon_name=?, pocketmon_type=? "
				+ "where pocketmon_no=?";
		Object[] data = {pocketmonName, pocketmonType, pocketmonNo}; //구문 순서에 맞게 넣어줘야 함
		
		jdbcTemplate.update(sql, data);
		
		//출력
		System.out.println("정보 변경 완료!");
	}
}
