package jdbc.app;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test12사원찾기 {
	public static void main(String[] args) {
		//1명의 사원을 찾고싶다면 .. 반드시 사원번호(기본키)를 알아야 한다
		//selectOne()
		
		int empNo = 3;
		
		EmpDao dao = new EmpDao();
		EmpDto dto = dao.selectOne(empNo);
		//반복문은 배열이나 List처럼 여러개가 저장되어있는 것을 풀어쓸 때만 작성한다.
		
		if(dto != null) {
			System.out.println("<사원 정보>");
			System.out.println("사번 : " +dto.getEmpNo());
			System.out.println("이름 : " + dto.getEmpName());
			System.out.println("부서 : "+dto.getEmpDept());
			System.out.println("입사일 : "+dto.getEmpDate());
			System.out.println("급여액 : "+dto.getEmpSal());
		}
		else {
			System.out.println("존재하지 않는 사번");
		}
		
	}
}
