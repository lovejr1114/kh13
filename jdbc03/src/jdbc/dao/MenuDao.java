package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MenuDto;
import jdbc.mapper.MenuMapper;
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
	public boolean delete(int menuNo) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "delete menu where menu_no=?";
		Object[] data = {menuNo};
		return jdbcTemplate.update(sql, data) > 0; //실행 결과가 0보다 큰지
	}
	
	
	//목록
	public List<MenuDto> selectList(){
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "select * from menu order by menu_no asc";
		//Object[] data = {};
		MenuMapper mapper = new MenuMapper();
		return jdbcTemplate.query(sql, mapper);
	}

	//상세
	public MenuDto selectOne(int menuNo) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "select * from menu where menu_no=?";
		Object[] data = {menuNo};
		MenuMapper mapper = new MenuMapper();
		List<MenuDto> list = jdbcTemplate.query(sql, mapper, data);
//		if(list.isEmpty()) {
//			return null;
//		}
//		else {
//			return list.get(0);
//		}
		return list.isEmpty() ? null : list.get(0);
		//		list가 비어있으면 ? 없다고 하고 :(아니면) 위치가0인것부터 보여줘
	}
	
	
	//...
}
