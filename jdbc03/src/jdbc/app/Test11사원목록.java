package jdbc.app;

import java.util.List;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test11사원목록 {
	public static void main(String[] args) {
		
		//selectList()
		
		EmpDao dao = new EmpDao();
		List<EmpDto> list = dao.selectList();
		
		for(EmpDto dto:list) {			
			System.out.println("이름 : "+dto.getEmpName()+", 부서 : "+dto.getEmpDept());
		}
	}
}
