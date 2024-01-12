package jdbc.app;

import java.util.List;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test02회원목록 {
	public static void main(String[] args) {
		//회원목록 = List<MemberDto>
		
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.selectList();
		
		System.out.println("전체 회원 수 : "+list.size());
		for(MemberDto dto:list) {
			System.out.println("ID : "+dto.getMemberId()+" ("+dto.getMemberNick()+")");
		}
	}
}
