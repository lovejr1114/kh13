package jdbc.app;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test03회원찾기 {
	public static void main(String[] args) {
		
		String memberId = "khadmin13";
		
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.selectOne(memberId);
		
		if(dto == null) {
			System.out.println("존재하지 않는 ID 입니다.");
		}
		else {
			System.out.println("<회원 정보>");
			System.out.println("ID : "+dto.getMemberId());
			System.out.println("닉네임 : "+dto.getMemberNick());
			System.out.println("생년월일 : "+dto.getMemberBirth());
			System.out.println("연락처 : "+dto.getMemberContact());
			System.out.println("E-Mail : "+dto.getMemberEmail());
			System.out.println("우편번호 : "+dto.getMemberPost());
			System.out.println("주소 : "+dto.getMemberAddress1()+" "+dto.getMemberAddress2());
			System.out.println("회원 등급 : " + dto.getMemberLevel());
			System.out.println("포인트 : "+dto.getMemberPoint()+" point");
			System.out.println("가입일 : "+dto.getMemberJoin());
			System.out.println("최종로그인시각 : "+dto.getMemberLogin());
		}
	}
}
