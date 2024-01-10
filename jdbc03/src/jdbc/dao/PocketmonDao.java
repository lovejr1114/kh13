package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PocketmonDto;
import jdbc.mapper.PocketmonMapper;
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
	//여러개 : selectList()  한개 : selectOne()
	public List<PocketmonDto> selectList(){
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "select * from pocketmon order by pocketmon_no asc";
		//Object[] data = {};
		PocketmonMapper mapper = new PocketmonMapper();
//		List<PocketmonDto> list = jdbcTemplate.query(sql, mapper);
//		return list; //list를 가져가라. 밑에가 줄인 코드
		return jdbcTemplate.query(sql, mapper);
	}
	
	//상세 메소드 - 기본키를 조건으로 설정하여 결과가 하나만 나오도록 구현
	public PocketmonDto selectOne(int pocketmonNo) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "select * from pocketmon where pocketmon_no=?";
		//홀더키가 있기 때문에 매개변수가 int로 하나 있어야한다. 그래서 매개변수에 int로 넣어줌(75번줄)
		Object[] data = {pocketmonNo};
		PocketmonMapper mapper = new PocketmonMapper(); //메소드끼리 공유하지않음. 새로 만들기.
		List<PocketmonDto> list = jdbcTemplate.query(sql, mapper, data);
		// list에는 데이터가 없거나 1개 있거나 둘 중 하나의 상태
//		if(list.isEmpty()) {
//			return null;
//		}
//		else {
//			return list.get(0); //list 안 위치가 0인  데이터를 가져와라
//		} //줄여서 밑에 코드처럼.
		return list.isEmpty() ? null : list.get(0); //if문이 1개밖에 없을 때 이렇게 쓸 수 있음
		
	}
	
}
