package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.EmpDto;
import jdbc.util.jdbcHelper;

//emp 테이블에 대한 CRUD 작업을 수행하는 클래스
public class EmpDao {
	//등록 메소드
	public void insert(EmpDto dto) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "insert into emp(emp_no, emp_name, emp_dept, emp_date, emp_sal) "
				+ "values (emp_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {dto.getEmpName(), dto.getEmpDept(), dto.getEmpDate(), dto.getEmpSal()};
		
		jdbcTemplate.update(sql, data);
	}
	
	//수정
	public boolean update(EmpDto dto) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "update emp "
				+ "set emp_name=?, emp_dept=?, emp_date=?, emp_sal=? "
				+ "where emp_no=?";
		Object[] data = {dto.getEmpName(), dto.getEmpDept(), 
				dto.getEmpDate(), dto.getEmpSal(), dto.getEmpNo()};
		
		return jdbcTemplate.update(sql, data) > 0;		
	}
	
	//삭제
	public boolean delete(int empNo) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "delete emp where emp_no=?";
		Object[] data = {empNo};
		return  jdbcTemplate.update(sql, data) > 0;
	}
	
	//목록
	//검색
	//상세
	//...
}
