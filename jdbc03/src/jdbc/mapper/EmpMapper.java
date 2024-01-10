package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.EmpDto;

public class EmpMapper implements RowMapper<EmpDto> {

	@Override
	public EmpDto mapRow(ResultSet rs, int idx) throws SQLException {
		EmpDto dto = new EmpDto();
		dto.setEmpNo(rs.getInt("emp_no")); //DB("emp_no) → DTO(empNo)로 옮겨라
		dto.setEmpName(rs.getString("emp_name")); //DB("emp_name) → DTO(empName)로 옮겨라
		dto.setEmpDept(rs.getString("emp_dept")); //DB("emp_dept) → DTO(empDept)로 옮겨라
		dto.setEmpDate(rs.getString("emp_date")); //DB("emp_date) → DTO(empDate)로 옮겨라
		dto.setEmpSal(rs.getInt("emp_sal")); //DB("emp_sal) → DTO(empSal)로 옮겨라
		return dto; //dto를 가져가라
	}

}
