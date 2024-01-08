package jdbc.connect;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test04Emp등록 {
	public static void main(String[] args) {
		
		//입력
//		int empNo = 1;
//		String empName = "김정은";
//		String empDept = "C강의실";
//		String empDate = "2023-12-04";
//		int empSal = 110000;
		Scanner sc = new Scanner(System.in);
		System.out.print("사원명 : ");
		String empName = sc.nextLine();
		System.out.print("소속 부서 : ");
		String empDept = sc.nextLine();
		System.out.print("입사일 : ");
		String empDate = sc.nextLine();
		System.out.print("급여 : ");
		int empSal = sc.nextInt();
		
		//처리
		String sql = "insert into emp(emp_no, emp_name, emp_dept, emp_date, emp_sal)"
				+ "values (emp_seq.nextval, ?, ?, ?, ?)";
		
		Object[] data = {empName, empDept, empDate, empSal};
		
		//[1] 연결 생성
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh13"); //사용자 아이디
		dataSource.setPassword("kh13"); //사용자 비밀번호
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); //DB 종류 지정
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB연결유형+위치
				
		//[3] 명령 처리 도구 생성
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		//도구에 바로 넣지말고 셋해줘서 넣어줘야함.
						
		//[4] 실행 시 홀더가 있는 구문과 그 데이터를 같이 주면서 실행 요청한다
		jdbcTemplate.update(sql, data);
		System.out.println("사원 등록 완료!");
				
	}
}
