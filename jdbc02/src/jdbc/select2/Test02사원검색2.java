package jdbc.select2;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.select.EmpDto;
import jdbc.select.EmpMapper;
import jdbc.util.jdbcHelper;

public class Test02사원검색2 {
	public static void main(String[] args) {
		
				//사원 검색을 like 연산자 instr 함수로 각각 구현
				//- 시작 검색은 like연산자, 포함검색은 instr함수
				
				
				Scanner sc = new Scanner(System.in);
				System.out.print("사원 이름 또는 소속 부서 입력 : ");
				String keyword = sc.nextLine();

				
				JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
				String sql = "select * from emp where (instr(emp_name, ?) > 0 "
						+ "or instr(emp_dept, ?) > 0) "
						+ "order by emp_name asc, emp_no asc"; //이름 가나다순, 같은 이름일 땐 번호 순대로
				Object[] data = {keyword, keyword}; //홀더에 배치 될 데이터
				
				EmpMapper mapper = new EmpMapper(); // 조회 결과 처리 방법 객체
				
				List<EmpDto> list = jdbcTemplate.query(sql, mapper, data); //구문을 먼저넣고 데이터를 제일 마지막에
				//List<EmpDto> => "사원 여러명"이라는 뜻
				
//				if(list.size() == 0) { //저급 명령
				if(list.isEmpty()) { //고급 명령
					System.out.println("검색 결과가 존재하지 않습니다.");
				}
				else {			
					System.out.println("조회 결과 : "+list.size() + "개");
					for(EmpDto dto:list) {
						System.out.println("사원명 : "+dto.getEmpName()+"\n소속부서 : "+dto.getEmpDept());
					}
				}
	}
}
