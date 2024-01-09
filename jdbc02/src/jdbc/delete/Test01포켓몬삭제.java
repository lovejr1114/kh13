package jdbc.delete;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.jdbcHelper;

public class Test01포켓몬삭제 {
	public static void main(String[] args) {
		//자바는 자동커밋
		//포켓몬스터 삭제하려면 "번호"만 알면된다 (번호가 기본키PK이니까)
		
		//데이터 준비
		int pocketmonNo = 1;
		
		//처리
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		
		String sql = "delete pocketmon where pocketmon_no=?";
		Object[] data = {pocketmonNo}; //데이터가 1개여도 배열로 만들어줘야한다. (한 세트다)
		
		int result = jdbcTemplate.update(sql, data);
		
		//출력
		if(result > 0) {
			System.out.println("포켓몬스터 삭제 완료!");
		}
		else {
			System.out.println("존재하지 않는 포켓몬스터 번호");
		}
	}
}
