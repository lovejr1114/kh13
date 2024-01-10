package jdbc.select2;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.select.MenuDto;
import jdbc.select.MenuMapper;
import jdbc.util.jdbcHelper;

public class Test03항목검색 {
	public static void main(String[] args) {
		//메뉴를 검색하는데..
		//원하는 항목만 지정해서 검색하고 싶다면?
		
		String column = "menu_name_kor"; //검색할 항목 이름
		String  keyword = "탕"; //검색할 항목에 대한 키워드
		
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		MenuMapper mapper = new MenuMapper(); //조회 결과 처리 객체
		
		//구문 - like 검색으로 column, keyword를 이용한 구문 생성
		//- 위치 홀더는 데이터 자리에 사용하는 것(자료형에 맞게 따옴표 등 처리)
		//- 항목은 홀더가 될 수 없다
//		String sql = "select * from menu where "+column+" like ? || '%'"; //like
		String sql = "select * from menu where instr("+column+", ?) > 0"; //instr
		Object[] data = {keyword};
		
		List<MenuDto> list = jdbcTemplate.query(sql, mapper, data);
		if(list.isEmpty()) {
			System.out.println("검색 결과 없음");
		}
		else {
			for(MenuDto dto:list) {
				System.out.println(dto.getMenuNameKor()+" ("+dto.getMenuNameEng()+") | "+
											dto.getMenuPrice()+"원 | "+dto.getMenuType());
			}
		}
	}
}
