package jdbc.select2;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.select.EmpDto;
import jdbc.select.EmpMapper;
import jdbc.util.jdbcHelper;

public class Test04사원항목검색 {
	public static void main(String[] args) {
//		사원(emp) 테이블을 이용하여 항목-키워드 검색을 진행하세요
//		사용자에게 다음과 같이 입력받아 진행하도록 구현합니다.
//		(검색은 instr 함수 사용하세요)
		
		Scanner sc = new Scanner(System.in);
//		int choice = 1;
		System.out.print("1.사원명 2.부서명 3.입사일 : ");
		int choice = sc.nextInt();
		sc.nextLine();
		String column;
		
		if(choice == 1) {
			column = "emp_name";
		}
		else if(choice == 2) {
			column = "emp_dept";
		}
		else {
			column = "emp_date";
		}
		System.out.print("검색 : ");
//		String keyword = "피카";
		String keyword = sc.nextLine();
		sc.close();
		
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
//		String sql = "select * from emp where "+column+" like ? || '%'";
		String sql = "select * from emp where instr("+column+", ?) > 0"
				+ "order by "+column+" asc, emp_no asc"; //정렬
		Object[] data = {keyword};
		
		EmpMapper mapper = new EmpMapper();
		
		List<EmpDto> list = jdbcTemplate.query(sql, mapper, data);
		
		if(list.isEmpty()) {
			System.out.println("존재하지 않은 항목");
		}
		else {
			System.out.println("검색 결과 수 : "+list.size()+"건");
			for(EmpDto dto:list) {
				System.out.print("이름 : " + dto.getEmpName());
				System.out.print(", 부서 : "+dto.getEmpDept());
				System.out.print(", 입사일 : "+dto.getEmpDate());
				System.out.println();
			}
		}
	}
}
