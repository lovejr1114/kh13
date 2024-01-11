package jdbc.app;

import java.util.List;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test02회원목록 {
	public static void main(String[] args) {
		
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.selectList();
		
		System.out.println("<회원 목록>");
		for(MemberDto dto:list) {
			System.out.println("ID : "+dto.getMemberId());
		}
	}
}
