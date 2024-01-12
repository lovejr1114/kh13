package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MemberDto;
import jdbc.mapper.MemberMapper;
import jdbc.util.jdbcHelper;

//member 테이블 데이터 처리 담당 클래스
public class MemberDao {
	//메소드에서 공용으로 사용하는 도구들을 생성
//	private JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
//	private MemberMapper mapper = new MemberMapper();
	//이렇게 만들어주면 메소드 하나하나에 넣을 필요가 없음
	
	//가입 - 등록 (Create)
	public void insert(MemberDto dto) {
		JdbcTemplate jdbcTemplate =  jdbcHelper.getJdbcTemplate();
		String sql = "insert into member("
						+ "member_id, member_pw, member_nick, member_birth, member_contact, "
						+ "member_email, member_post, member_address1, member_address2) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {dto.getMemberId(), dto.getMemberPw(), dto.getMemberNick(),
						dto.getMemberBirth(), dto.getMemberContact(), dto.getMemberEmail(),
						dto.getMemberPost(), dto.getMemberAddress1(), dto.getMemberAddress2()};
		
		jdbcTemplate.update(sql, data);
	}
	
	
	//수정 (Update)
	public boolean update(MemberDto dto, String pw) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "update member set member_pw=? where member_id=? and member_pw=?";
		Object[] data = {pw, dto.getMemberId(), dto.getMemberPw()};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	
	//삭제 (Delete)
	public boolean delete(MemberDto dto) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "delete member where member_id=? and member_pw=?";
		Object[] data = {dto.getMemberId(), dto.getMemberPw()};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//목록 - 조회 (Read)
	public List<MemberDto> selectList(){
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "select * from member order by member_id asc";
		//잘 모르면 기본키로 정렬하라
		//Object[] data = {};
		MemberMapper mapper = new MemberMapper();
		return jdbcTemplate.query(sql, mapper);
	}
	
	//상세 조회 (Read)
	public MemberDto selectOne(String memberId) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "select * from member where member_id = ?";
		Object[] data = {memberId};
		MemberMapper mapper = new MemberMapper();
		List<MemberDto> list = jdbcTemplate.query(sql, mapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	
	//검색(항목, 키워드)
	public List<MemberDto> selectList(String column, String keyword) {
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		String sql = "select * from member where instr("+column+", ?) > 0 "
				+ "order by member_nick asc";
		Object[] data = {keyword};
		MemberMapper mapper = new MemberMapper();
		return jdbcTemplate.query(sql, mapper, data);
	}
	
}
