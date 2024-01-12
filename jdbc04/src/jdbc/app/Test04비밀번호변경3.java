package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test04비밀번호변경3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//현재 비밀번호 입력 추가
		MemberDto dto = new MemberDto();
		System.out.print("ID 입력 : ");
		dto.setMemberId(sc.nextLine());
		System.out.print("현재 비밀번호 입력 : ");
		String currentPw = sc.nextLine();
		System.out.print("변경 할 비밀번호 입력 : ");
		dto.setMemberPw(sc.nextLine());
		sc.close();
		
		//현재 비밀번호 판정 추가
		MemberDao dao = new MemberDao();
		MemberDto find = dao.selectOne(dto.getMemberId());
		if(find != null && find.getMemberPw().equals(currentPw)) {
				//업데이트
				dao.updateMemberPw(dto);
				System.out.println("비밀번호 변경 완료");
			}
			else {
				System.out.println("정보가 일치하지 않습니다.");
			}
		}

		
//		boolean result = dao.update(dto);
//		
//
//		if(result) {
//			System.out.println("비밀번호 변경 완료!");
//		}
//		else {
//			System.out.println("잘못된 정보입니다.");
//		}
}
