package jdbc.delete;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.jdbcHelper;

public class Test02사원정보삭제 {
	public static void main(String[] args) {
		
		//
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 사원 번호 : ");
		int empNo = sc.nextInt();
		sc.close();
		
		//
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		
		String sql = "delete emp where emp_no=?";
		Object[] data = {empNo};
		
		int result = jdbcTemplate.update(sql, data);
		
		if(result>0) {
			System.out.println("사원 정보 삭제 완료!");
		}
		else {
			System.out.println("존재하지 않는 사원번호");
		}
	}
}
