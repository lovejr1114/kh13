package jdbc.app;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test03회원찾기 {
	public static void main(String[] args) {
		
		//데이터 준비 (정확하게 일치하는걸로 찾기)
		String memberId = "testuser1";
		
		//처리
		//DB를 이용해 찾으려면 dao 생성
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.selectOne(memberId);
		
		//출력
		//보통 조건을 걸 때, 내가 하고싶은걸 먼저 적는게 맞다.
		//if에 dto != null로 하고 정보를 넣고 else에 존재하지않는 ID라고 뜨게
		if(dto == null) {
			System.out.println("존재하지 않는 ID 입니다.");
		}
		else { //Dto에서 만들어준 Str getter메소드로 수정해주기.
			System.out.println("<"+dto.getMemberId()+"님의 회원 정보>");
			System.out.println("닉네임 : "+dto.getMemberNick());
			System.out.println("생년월일 : "+dto.getMemberBirthStr());//
			System.out.println("연락처 : "+dto.getMemberContactStr());//
			System.out.println("E-Mail : "+dto.getMemberEmail());
			System.out.println("우편번호 : "+dto.getMemberPostStr());//
			System.out.println("주소 : "+dto.getMemberAddress1Str()+" "+dto.getMemberAddress2Str());//
			System.out.println("회원 등급 : " + dto.getMemberLevel());
			System.out.println("포인트 : "+dto.getMemberPoint()+" point");
			System.out.println("가입일 : "+dto.getMemberJoin());
			System.out.println("최종로그인 : "+dto.getMemberLoginStr());//
		}
	}
}
