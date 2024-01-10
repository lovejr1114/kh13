package jdbc.app;

import jdbc.dao.EmpDao;

public class Test08사원삭제 {
	public static void main(String[] args) {
		
		//EmpDao에 메소드를 구현하여 사원 정보를 삭제하는 프로그램을 완성하세요
		
		
		
		int empNo = 18;
		
		EmpDao dao = new EmpDao();
		boolean result = dao.delete(empNo);
		
		if(result) {
			System.out.println("사원 정보 삭제 완료!");
		}
		else {
			System.out.println("존재하지 않는 사원번호");
		}
	}
}
