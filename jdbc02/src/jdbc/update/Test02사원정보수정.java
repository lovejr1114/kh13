package jdbc.update;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.jdbcHelper;

public class Test02사원정보수정 {
	public static void main(String[] args) {
		//사번을 이용해서 사원명,부서,입사일,급여를 변경하도록 구현
		//- 수정은 실패할 수도 있다. (에러가 아니라, 대상이 없는 경우)
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("사원 이름: ");
		String empName = sc.nextLine();
		System.out.print("사원 소속 부서 : ");
		String empDept = sc.nextLine();
		System.out.print("사원 입사일 : ");
		String empDate = sc.nextLine();
		System.out.print("사원 월급 : ");
		int empSal = sc.nextInt();
		int empNo = 10;
		
		//도구 생성
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		
		String sql = "update emp set emp_name=?, emp_dept=?, emp_date=?, emp_sal=? "
				+ "where emp_no=?";
		Object[] data = {empName, empDept, empDate, empSal, empNo};
		
		//update 메소드는 반환형이 int이며, 적용된 행(row)의 개수가 반환된다
		int count = jdbcTemplate.update(sql, data);
//		System.out.println("count = "+count);
		
		
		if(count > 0) { //count가 0보다 크면
			System.out.println("사원 정보 변경 완료!");
		}
		else {
			System.out.println("존재하지 않는 사원번호입니다.");
		}
		}
}
