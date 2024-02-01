package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.MenuDto;
import com.kh.spring10.mapper.MenuMapper;
import com.kh.spring10.mapper.StatMapper;
import com.kh.spring10.vo.PageVO;
import com.kh.spring10.vo.StatVO;

@Repository
public class MenuDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MenuMapper mapper;
	
	//등록
	public void insert(MenuDto dto) {
		String sql = "insert into menu(menu_no, menu_name_kor, menu_name_eng, menu_type, "
				+ "menu_price) "
				+ "values (menu_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {dto.getMenuNameKor(), dto.getMenuNameEng(), 
									dto.getMenuType(), dto.getMenuPrice()};
		jdbcTemplate.update(sql, data);
	}
	//수정
	public boolean update(MenuDto dto) {
		String sql = "update menu set menu_name_kor=?, menu_name_eng=?, menu_type=?, menu_price=? where menu_no=?";
		Object[] data = {dto.getMenuNameKor(), dto.getMenuNameEng(), dto.getMenuType(), dto.getMenuPrice(), dto.getMenuNo()};
		return jdbcTemplate.update(sql, data) > 0;
	}
	//삭제
	public boolean delete(int menuNo) {
		String sql = "delete menu where menu_no=?";
		Object[] data = {menuNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//목록
	public List<MenuDto> selectList(){
		String sql = "select * from menu order by menu_no asc";
		return jdbcTemplate.query(sql, mapper);
	}
	
	//항목, 키워드
	public List<MenuDto> selectList(String column, String keyword){
		String sql = "select * from menu where instr("+column+", ?) > 0 " //대소문자 구별
				//String sql = "select * from menu where instr(upper("+column+"), upper(?)) > 0 " //대소문자 무시
						+ "order by "+column+" asc, menu_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, mapper, data);
	}
	
	//목록+페이징
	public List<MenuDto> selectListByPaging(int page, int size){
		int endRow = page * size;
		int beginRow = endRow - (size-1);
		
		String sql = "select * from ("
				+ "select rownum rn, TMP.*from ("
					+ "select "
					+ "menu_no, menu_name_kor, menu_name_eng, "
					+ "menu_type, menu_price "
					+ "from menu order menu_no asc"
				+ ")TMP"
				+ ") where rn between ? and ?";
		Object[] data = {beginRow, endRow};
		return jdbcTemplate.query(sql, mapper, data);
	}
	//검색+페이징
	public List<MenuDto> selectListByPaging(String column, String keyword, int page, int size){
		int endRow = page * size;
		int beginRow = endRow - (size-1);
		
		String sql = "select * from ("
				+ "select rownum rn, TMP.*from ("
					+ "select "
						+ "menu_no, menu_name_kor, menu_name_eng, "
						+ "menu_type, menu_price "
						+ "from menu where menu("+column+", ? ) > 0 "
						+ "order menu_no asc"
					+ ")TMP"
			+ ") where rn between ? and ?";
		Object[] data = {keyword, beginRow, endRow};
		return jdbcTemplate.query(sql, mapper, data);
	}
	
	//통합+페이징 (페이징을 위한 목록/검색/카운트 구현)
	public List<MenuDto> selectListByPaging(PageVO pageVO){
		if(pageVO.isSearch()) {//검색
			String sql = "select * from ("
					+ "select rownum rn, TMP.*from ("
						+ "select "
							+ "menu_no, menu_name_kor, menu_name_eng, "
								+ "menu_type, menu_price "
								+ "from menu "
								+ "where instr("+pageVO.getColumn()+", ?) > 0 "
								+ "order by "+pageVO.getColumn()+" asc"
							+ ")TMP"
					+ ") where rn between ? and ?";
			Object[] data = {pageVO.getKeyword(),
					pageVO.getBeginRow(), pageVO.getEndRow()};
			return jdbcTemplate.query(sql, mapper, data);
		}
		else { //목록
			String sql = "select * from ("
					+ "select rownum rn, TMP.* from ("
					+ "select "
						+ "menu_no, menu_name_kor, menu_name_eng,"
						+ "menu_type, menu_price "
						+ "from menu order by menu_no asc"
				+ ")TMP"
			+ ") where rn between ? and ?";
		Object[] data = {pageVO.getBeginRow(), pageVO.getEndRow()};
		return jdbcTemplate.query(sql, mapper, data);
		}
	}
	
	//카운트
	//목록
	public int count() {
		String sql = "select count(*) from menu";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	//검색
	public int count(String column, String keyword) {
		String sql = "select count(*) from menu "
				+ "where instr("+column+", ?) > 0";
		Object[] data = {keyword};
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}
	//검색+목록
	public int count(PageVO pageVO) {
		if(pageVO.isSearch()) { //검색
			String sql = "select count(*) from menu "
					+ "where instr("+pageVO.getColumn()+", ?) > 0";
			Object[] data = {pageVO.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, data);
		}
		else {//목록
			String sql = "select count(*) from menu";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
	}
	
	
	//상세
	public MenuDto selectOne(int menuNo) {
		String sql = "select * from menu where menu_no=?";
		Object[] data = {menuNo};
		List<MenuDto> list = jdbcTemplate.query(sql, mapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Autowired
	private StatMapper statMapper;
	//변종메소드
	public List<StatVO> countByMenuType(){
		String sql = "select menu_type 항목, count(*) 개수 "
				+ "from menu group by menu_type "
				+ "order by 개수 desc, 항목 asc";
		return jdbcTemplate.query(sql, statMapper);
	}
}