package jdbc.app;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test05사원정보변경 {
	public static void main(String[] args) {
		//EmpDao에 메소드를 구현하여 사원 정보를 변경하는 프로그램을 완성하세요
		
		//데이터 준비 (홈페이지로 치면 프론트엔드)
		EmpDto dto = new EmpDto();
		dto.setEmpName("스펀지밥");
		dto.setEmpDept("집게리아");
		dto.setEmpDate("2000-10-10");
		dto.setEmpSal(15000);
		dto.setEmpNo(15);
		
		//데이터 처리 (홈페이지로 치면 백엔드)
		EmpDao dao = new EmpDao();
		boolean result = dao.update(dto);
		
		//출력 (홈페이지로 치면 프론트엔드)
		if(result) {
			System.out.println("사원 정보 변경 완료!");
		}
		else {
			System.out.println("존재하지 않는 사원 번호");
		}
	}
}
