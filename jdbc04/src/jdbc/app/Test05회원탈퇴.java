package jdbc.app;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test05회원탈퇴 {
	public static void main(String[] args) {
		
		String memberId = "testuser1";
			
		MemberDao dao = new MemberDao();
		boolean result = dao.delete(memberId);
		
		if(result) {
			System.err.println("회원 탈퇴 완료");
			System.out.println("이용해주셔서 고맙습니다.");
		}
		else {
			System.out.println("존재하지 않는 회원 정보");
		}
	}
}
