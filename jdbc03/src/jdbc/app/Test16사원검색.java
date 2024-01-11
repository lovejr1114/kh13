package jdbc.app;

import java.util.List;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test16사원검색 {
	public static void main(String[] args) {
//		EmpDao에 selectList 메소드를 만들어 사원에 대한 항목+키워드 검색이 가능하도록 구현하세요
		
		int choice = 2;
		String keyword = "집";
		
		String column;
		if(choice == 1) 
			column = "emp_name";
		else
			column = "emp_dept";

		
		EmpDao dao = new EmpDao();
		List<EmpDto> list = dao.selectList(column, keyword);
		
		if(list.isEmpty()) {
			System.out.println("존재하지 않는 정보");
		}
		else {
			for(EmpDto dto:list) {				
				System.out.println("<사원 정보>");
				System.out.println(dto.getEmpName()+"("+dto.getEmpDept()+")");
			}
		}
	}
}
