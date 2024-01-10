package jdbc.app;

import java.util.Scanner;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test02사원등록 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		EmpDto dto = new EmpDto();
		
		System.out.print("이름 입력 : ");
		dto.setEmpName(sc.nextLine());
		System.out.print("부서명 입력 : ");
		dto.setEmpDept(sc.nextLine());
		System.out.print("입사일자 입력 : ");
		dto.setEmpDate(sc.nextLine());
		System.out.print("급여 입력 : ");
		dto.setEmpSal(sc.nextInt());
		
		EmpDao dao = new EmpDao();
		dao.insert(dto);
		
		System.out.println("사원 등록 완료!");
	}
}
