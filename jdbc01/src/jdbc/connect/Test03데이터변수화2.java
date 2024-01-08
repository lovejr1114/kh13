package jdbc.connect;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test03데이터변수화2 {
	public static void main(String[] args) {
		//목표 : 변수에 저장된 정보를 구문과 합쳐서 실행
		
		//입력
		int pocketmonNo = 99;
		String pocketmonName = "테스트몬"; //구문에 영향을 주는 글자
		String pocketmonType = "테스트";
		
		//처리 (구문)
		//- 동적 SQL 방식에서는 위치 홀더(?)를 사용한다
		//- 위치 홀더를 준비하고 그에 맞는 데이터를 배치하면 자동으로 구문 완성
		//- 단, 완성된 구문은 볼 수 없음(상상만 해야함. 보안상에 이슈가 있기 때문에)
		String sql = "insert into pocketmon("
				+ "pocketmon_no, pocketmon_name,pocketmon_type"
				+ ")"
				+ "values(?, ?, ?)";
		Object[] data = new Object[] {pocketmonNo, pocketmonName, pocketmonType};
		//int와 String 뭐가 들어갈지 모르니까 오브젝트로 만든다.
		
		//[1] 연결 생성
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh13"); //사용자 아이디
		dataSource.setPassword("kh13"); //사용자 비밀번호
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); //DB 종류 지정
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB연결유형+위치
		
		//[3] 명령 처리 도구 생성
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				
		//[4] 실행 시 홀더가 있는 구문과 그 데이터를 같이 주면서 실행 요청한다
		jdbcTemplate.update(sql, data);
		System.out.println("완료!");
	}
}
