package jdbc.app;

import java.util.List;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test06회원검색2 {
	public static void main(String[] args) {
		
		//목록과 검색을 통합
		//-  언제를 목록으로 보고, 언제를 검색으로 볼 것인가? (를 정해야한다)
		
		String column = "";
		String keyword = "test";
		
//		boolean isSearch검색이면 = column도 있고 keyword도 있으면;
//		boolean isSearch = column != null && keyword != null; -> null값일 때만 판정됨.
		boolean isSearch = column != null && !column.isEmpty()
									&& keyword != null && !keyword.isEmpty();
		//.isEmpty() 대신에 .equals("")  또는 .length > 0 의 방법으로도 가능하다. 
		
		MemberDao dao = new MemberDao();
//		List<MemberDto> list = dao.selectList(); // 목록
//		List<MemberDto> list = dao.selectList(column, keyword); //검색
		List<MemberDto> list;
		if(isSearch) {//검색이면
			list = dao.selectList(column, keyword);
		}
		else {
			list = dao.selectList();
		}
		
		
		if(!list.isEmpty()) {
			System.out.println("회원 결과 수 : "+list.size());
			for(MemberDto dto:list)
				System.out.println(dto.getMemberId()+" ("+dto.getMemberNick()+")");
		}
		else {
			System.out.println("없는 닉네임");
		}
		
		
	}
}
