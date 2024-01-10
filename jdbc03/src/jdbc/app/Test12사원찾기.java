package jdbc.app;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test12사원찾기 {
	public static void main(String[] args) {
		
		//selectOne()
		
		int empNo = 1;
		
		EmpDao dao = new EmpDao();
		EmpDto dto = dao.selectOne(empNo);
		
		System.out.println(dto);
		
	}
}
