package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PocketmonDto;
import jdbc.util.jdbcHelper;

//DAO(Data Access Object)
//- 해당 테이블에 대한 CRUD 코드를 가진 클래스
public class PocketmonDao {

	//등록 메소드
	//매개 변수에 하나하나 적는 거보다 하나로 묶어줘서 적는다. 하나하나적을거면 dto 왜 만드냐.
	public void insert(PocketmonDto dto) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "insert into pocketmon(pocketmon_no, pocketmon_name, "
				+ "pocketmon_type) values (?, ?, ?)";
		Object[] data = {
				dto.getPocketmonNo(), dto.getPocketmonName(), dto.getPocketmonType()
				};
		jdbcTemplate.update(sql, data);
	}
	
	//수정 메소드
	public boolean update(PocketmonDto dto) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "update pocketmon "
				+ "set pocketmon_name=?, pocketmon_type=? "
				+ "where pocketmon_no=?";
		Object[] data = {
				dto.getPocketmonName(), 
				dto.getPocketmonType(), 
				dto.getPocketmonNo()
				};
//		int result = jdbcTemplate.update(sql, data);
//		if(result > 0) {
//			return true;
//		}
//		else {
//		return false;
//		}
		//식이 길어서 밑에처럼 줄여 쓴다.
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//삭제 메소드
	//- 수정 메소드와 같은 조건을 사용 (where pocketmon_no=?)
	//- 데이터가 하나이기 때문에 Dto를 사용하지 않아도 된다.
	public boolean delete(int pocketmonNo) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "delete pocketmon where pocketmon_no=?";
		Object[] data = {pocketmonNo};
		return jdbcTemplate.update(sql, data) > 0;
//		int result = jdbcTemplate.update(sql, data);
//		if(result>0) return true;
//		else return false;
	}
	
	//목록 메소드
	//검색 메소드
	
}
