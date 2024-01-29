package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.MemberDto;
import com.kh.spring10.mapper.MemberMapper;
import com.kh.spring10.mapper.StatMapper;
import com.kh.spring10.vo.StatVO;

@Repository
public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MemberMapper mapper;
	
	//등록
	public void insert(MemberDto dto) {
		String sql = "insert into member(member_id, member_pw, member_nick, member_birth, member_contact,"
							+ "member_email, member_post, member_address1, member_address2) "
						+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {dto.getMemberId(), dto.getMemberPw(), dto.getMemberNick(), dto.getMemberBirth(), dto.getMemberContact(),
								dto.getMemberEmail(), dto.getMemberPost(), dto.getMemberAddress1(), dto.getMemberAddress2()};
		jdbcTemplate.update(sql, data);
	}

	//비밀번호 변경 - 수정 (Update)
		public boolean updateMemberPw(MemberDto dto) {
			String sql = "update member set member_pw=? where member_id=?";
			Object[] data = {dto.getMemberPw(), dto.getMemberId()};
			return jdbcTemplate.update(sql, data) > 0;
		}
		
		
		//회원 탈퇴 - 삭제 (Delete)
		public boolean delete(String memberId) {
			String sql = "delete member where member_id=?";
			Object[] data = {memberId};
			return jdbcTemplate.update(sql, data) > 0;
		}
		
		//목록 - 조회 (Read)
		public List<MemberDto> selectList(){
			String sql = "select * from member order by member_id asc";
			//잘 모르면 기본키로 정렬하라
			//Object[] data = {};
			MemberMapper mapper = new MemberMapper();
			return jdbcTemplate.query(sql, mapper);
		}
		
		//상세 - 조회 (Read)
		public MemberDto selectOne(String memberId) { //하나만 찾으려면 Primary key(기본키)
			String sql = "select * from member where member_id = ?";
			Object[] data = {memberId};
			List<MemberDto> list = jdbcTemplate.query(sql, mapper, data);
			return list.isEmpty() ? null : list.get(0); //없으면 null 있으면 끄집어내라
		}
		
		
		//항목, 키워드 검색 - 조회 (Read)
		public List<MemberDto> selectList(String column, String keyword) {
			String sql = "select * from member where instr("+column+", ?) > 0 "
					+ "order by "+column+" asc";
			Object[] data = {keyword};
			return jdbcTemplate.query(sql, mapper, data); //구문을 제일 먼저, data를 제일 마지막에
		}
		
		//최종로그인시각 변경 (수정, Update)
		public boolean updateMemberLogin(String memberId) {
			String sql = "update member set member_login = sysdate where member_id = ?";
			Object[] data = {memberId};
			return jdbcTemplate.update(sql, data) > 0;
		}
		//회원이 자신의 정보를 변경(수정, Update)
		public boolean updateMember(MemberDto memberDto) {
			String sql = "update member set "
					+ "member_nick=?, member_email=?, member_birth=?, "
					+ "member_contact=?, member_post=?, "
					+ "member_address1=?, member_address2=? "
					+ "where member_id=?";
			Object[] data = {
					memberDto.getMemberNick(), memberDto.getMemberEmail(),
					memberDto.getMemberBirth(), memberDto.getMemberContact(),
					memberDto.getMemberPost(), memberDto.getMemberAddress1(),
					memberDto.getMemberAddress2(), memberDto.getMemberId()
			};
			return jdbcTemplate.update(sql, data) > 0;
		}
		
		@Autowired
		private StatMapper statMapper;
		//회원(멤버) 통계
		public List<StatVO> statByType(){
			String sql = "select member_level 항목, count(*) 개수 "
					+ "from member group by member_level "
					+ "order by 개수 desc, member_level asc";
			return jdbcTemplate.query(sql, statMapper);
		}
}