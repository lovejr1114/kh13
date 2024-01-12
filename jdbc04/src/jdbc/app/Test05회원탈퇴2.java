package jdbc.app;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test05회원탈퇴2 {
	public static void main(String[] args) {
		//비밀번호 검사 추가 
		//밑에 변수만 스캐너 추가해서 입력 받으면 됨.
		String memberId = "testuser1";
		String memberPw = "Testuser1!";
			
		MemberDao dao = new MemberDao();
		
		//memberId에 해당하는 회원정보를 불러와서 비밀번호 검사를 수행
		MemberDto find = dao.selectOne(memberId);
		boolean isValid = find != null && find.getMemberPw().equals(memberPw);
		// = 아이디에 대한 회원정보가 있으면서 비밀번호가 일치해야한다.
		
		if(isValid) {
			dao.delete(memberId);
			System.out.println("회원 탈퇴 완료\n그동안 이용해 주셔서 고맙습니다.");
		}
		else {
			System.out.println("입력하신 정보가 일치하지 않습니다.");
		}
	}
}
