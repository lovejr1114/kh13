package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test01회원가입2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberDto dto = new MemberDto();
		
		System.out.print("ID : ");
		dto.setMemberId(sc.nextLine());
		
		//상세 조회로 아이디 중복검사
		MemberDao dao = new MemberDao();
		MemberDto find = dao.selectOne(dto.getMemberId());
		if(find != null) { //find가 null이 아니냐
			System.out.println("이미 사용중인 ID입니다.");
			System.exit(0); //프로그램 나가기
		}
		
		System.out.print("PW : ");
		dto.setMemberPw(sc.nextLine());
		
		//비밀번호 확인
		System.out.print("PW 확인 : ");
		String memberPwCheck = sc.nextLine();
		if(!dto.getMemberPw().equals(memberPwCheck)) { //비밀번호가 일치하지 않으면 
			System.out.println("비밀번호가 일치하지 않습니다.");
			System.exit(0); //프로그램 나가기
		}
		
		System.out.print("닉네임 : ");
		dto.setMemberNick(sc.nextLine());
		System.out.print("생년월일 : ");
		dto.setMemberBirth(sc.nextLine());
		System.out.print("연락처 : ");
		dto.setMemberContact(sc.nextLine());
		System.out.print("이메일 : ");
		dto.setMemberEmail(sc.nextLine());
		System.out.print("우편번호 : ");
		dto.setMemberPost(sc.nextLine());
		System.out.print("기본주소 : ");
		dto.setMemberAddress1(sc.nextLine());
		System.out.print("상세주소 : ");
		dto.setMemberAddress2(sc.nextLine());
		sc.close();
		
//		MemberDao dao = new MemberDao();
		dao.insert(dto);
		
		System.out.println("회원가입 완료!");
	}
}
