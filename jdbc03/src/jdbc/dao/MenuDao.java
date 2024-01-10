package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MenuDto;
import jdbc.util.jdbcHelper;

//menu 테이블에 대한 DB처리 (CRUD)를 담당하는 클래스 
public class MenuDao {

	//등록 메소드
	public void insert(MenuDto dto) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "insert into menu(menu_no, menu_name_kor, menu_name_eng, "
						+ "menu_type, menu_price) "
						+ "values (menu_seq.nextval, ?, ?, ?, ?) "
						+ "order by menu_no asc";
		Object[] data = {
				dto.getMenuNameKor(), dto.getMenuNameEng(),
				dto.getMenuType(), dto.getMenuPrice()
		};
		
		jdbcTemplate.update(sql, data);
	}
	
	//수정
	public boolean update(MenuDto dto) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "update menu "
				+ "set menu_name_kor=?, menu_name_eng=?, menu_type=?, menu_price=? "
				+ "where menu_no=?";
		Object[] data = {dto.getMenuNameKor(), dto.getMenuNameEng(), 
				dto.getMenuType(), dto.getMenuPrice(), dto.getMenuNo()};
		
		return jdbcTemplate.update(sql, data) > 0;
	}
	//삭제
	//목록
	//검색
	//상세
	//...
}
