package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.jdbcHelper;

public class Test02사원목록 {
	public static void main(String[] args) {
		
		
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		
		String sql = "select * from emp";
		//Object[] data = {};
		
		
		EmpMapper mapper = new EmpMapper();
		
		
		List<EmpDto> list = jdbcTemplate.query(sql, mapper);
		System.out.println("데이터 개수 = " + list.size());
		

		for(EmpDto dto:list) { //list에 있는거 다 꺼내서 dto로 사용하겠다
			System.out.println(dto.getEmpName()+" | "+dto.getEmpDept()+
					" | "+dto.getEmpDate()+" | "+dto.getEmpSal()+"원 ");
		}
	}
}
