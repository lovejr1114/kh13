package jdbc.connect;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test03데이터변수화 {
	public static void main(String[] args) {
		//목표 : 변수에 저장된 정보를 구문과 합쳐서 실행
		
		//입력
		int pocketmonNo = 99;
		String pocketmonName = "테스트몬";
		String pocketmonType = "테스트";
		
		//처리 (구문)
		String sql = "insert into pocketmon(pocketmon_no, pocketmon_name,"
				+ "pocketmon_type) values("+pocketmonNo+",'"+pocketmonName+"', '"
				+pocketmonType+"')";

		
		//[1] 연결 생성
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh13"); //사용자 아이디
		dataSource.setPassword("kh13"); //사용자 비밀번호
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); //DB 종류 지정
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB연결유형+위치
		
		//[3] 명령 처리 도구 생성
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				
		//[4] 실행
		jdbcTemplate.update(sql);
		System.out.println("완료!");
	}
}
