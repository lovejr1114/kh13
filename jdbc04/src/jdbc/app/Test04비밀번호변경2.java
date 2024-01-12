package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test04비밀번호변경2 {
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
		if(find != null) {// ID가 있으면
			//비밀번호 비교 (find의 memberPw와 crrentPw를 비교),(find = DB정보, crrentPw = 변수)
			if(find.getMemberPw().equals(currentPw)) {
				//업데이트
				dao.updateMemberPw(dto);
				System.out.println("비밀번호 변경 완료");
			}
			else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
		else {
			System.out.println("존재하지 않는 ID입니다.");
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
}
