package com.kh.spring10.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring10.dto.MemberDto;

@Service
public class MemberMapper implements RowMapper<MemberDto> {


@Override
public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
	MemberDto memberdto = new MemberDto();
	memberdto.setMemberId(rs.getString("member_id"));
	memberdto.setMemberPw(rs.getString("member_pw"));
	memberdto.setMemberNick(rs.getString("member_nick"));
	memberdto.setMemberBirth(rs.getString("member_birth"));
	memberdto.setMemberContact(rs.getString("member_contact"));
	memberdto.setMemberEmail(rs.getString("member_email"));
	memberdto.setMemberPost(rs.getString("member_post"));
	memberdto.setMemberAddress1(rs.getString("member_address1"));
	memberdto.setMemberAddress2(rs.getString("member_address2"));
	memberdto.setMemberLevel(rs.getString("member_level"));
	memberdto.setMemberPoint(rs.getInt("member_point"));
	memberdto.setMemberJoin(rs.getDate("member_join"));
	memberdto.setMemberLogin(rs.getDate("member_login"));
	return memberdto;
}
}
