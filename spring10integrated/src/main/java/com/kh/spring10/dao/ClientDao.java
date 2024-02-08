package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.ClientDto;

@Repository
public class ClientDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ClientDto clientDto;

	//등록
	public void insert(ClientDto clientDto) {}
	//목록
//	public List<ClientDto> selectList(){}
//	//상세
//	public ClientDto selectOne(String clientId) {}
//	//수정
//	public boolean update(ClientDto clientDto) {}
//	//삭제
//	public boolean delete(String clientId) {}
}
