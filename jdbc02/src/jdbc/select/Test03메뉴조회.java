package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.jdbcHelper;

public class Test03메뉴조회 {
	public static void main(String[] args) {
		
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		
		String sql = "select * from menu order by menu_no asc"; //정렬 써주는게 좋다
		//Object[] data = {};
		
		
		MenuMapper mapper = new MenuMapper();
		
		List<MenuDto> list = jdbcTemplate.query(sql, mapper);
		//명령은 update 아니면 query이다.
		//만약 홀더(=?) 가 있으면 List<MenuDto> list = jdbcTemplate.query(sql, mapper,data); 이다.
		
		System.out.println("데이터 개수 = "+ list.size());
		
		for(MenuDto dto:list) {
			//System.out.println(dto.toString()); //MenuDto에 toString을 만들어줘야 출력가능함.
			System.out.println(dto.getMenuNameKor()+" ("+dto.getMenuNameEng()+") | "+
					dto.getMenuType()+" | "+dto.getMenuPrice()+"원");
		}
	}
}
