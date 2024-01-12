package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test04비밀번호변경 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//가장 중요한건 아이디와 바꿀 비밀번호를 알아야 한다
		MemberDto dto = new MemberDto();
		System.out.print("ID 입력 : ");
		dto.setMemberId(sc.nextLine());
		System.out.print("변경 할 비밀번호 입력 : ");
		dto.setMemberPw(sc.nextLine());
		sc.close();
		
		MemberDao dao = new MemberDao();
		boolean result = dao.updateMemberPw(dto);
		

		if(result) {
			System.out.println("비밀번호 변경 완료!");
		}
		else {
			System.out.println("잘못된 정보입니다.");
		}
	}
}
