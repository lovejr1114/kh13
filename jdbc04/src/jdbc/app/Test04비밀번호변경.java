package jdbc.app;

import java.util.List;
import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test04비밀번호변경 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberDto dto = new MemberDto();
		
		System.out.print("ID 입력 : ");
		dto.setMemberId(sc.nextLine());
		System.out.print("비밀번호 입력 : ");
		dto.setMemberPw(sc.nextLine());
		
		System.out.print("변경 할 비밀번호 : ");
		String pw = sc.nextLine();
		
		MemberDao dao = new MemberDao();
		boolean login = dao.update(dto, pw);
		

		if(login) {
			System.out.println("비밀번호 변경 완료!");
		}
		else {
			System.out.println("잘못된 정보입니다.");
		}
	}
}
