package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test01회원가입 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberDto dto = new MemberDto();
		
		System.out.print("ID : ");
		dto.setMemberId(sc.nextLine());
		System.out.print("PW : ");
		dto.setMemberPw(sc.nextLine());
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
		
		MemberDao dao = new MemberDao();
		dao.insert(dto);
		
		System.out.println("회원가입 완료!");
	}
}
