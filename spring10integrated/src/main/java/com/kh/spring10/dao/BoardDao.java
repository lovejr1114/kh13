package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.BoardDto;
import com.kh.spring10.mapper.BoardListMapper;
import com.kh.spring10.mapper.BoardMapper;

@Repository
public class BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private BoardListMapper boardListMapper;

	
	//항목, 검색
	public List<BoardDto> selectList(String column, String keyword){
		String sql = "select * from board where instr("+column+", ?) > 0 "
						+ "order by board_no desc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, boardMapper, data);
	}
	
	//목록
	public List<BoardDto> selectList(){
		String sql = "select * from board order by board_no desc";
//		String sql = "select * from board order by board_wtime desc"; //이것도 되지만 PK로 해주는게 제일 성능이 좋음
		return jdbcTemplate.query(sql, boardMapper);
		
		
	}
	
	//등록
	public void insert(BoardDto boardDto) {
		String sql = "insert into board(board_no, board_title, board_content, "
					+ "board_writer) "
					+ "values (board_seq.nextval, ?, ?, ?)";
		Object[] data = {boardDto.getBoardTitle(), boardDto.getBoardContent(),
								boardDto.getBoardWriter()};
		jdbcTemplate.update(sql, data);
	}
	
	//게시글 등록 시퀀스
	public int boardSeqNo(){ //이렇게하는 이유가 시퀀스라서 자동으로 DB가 번호 넣어줌
		String sql = "select board_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	
	//상세
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no=?";
		Object[] data = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	
	
	//수정
	public boolean update(BoardDto boardDto) {
		String sql = "update board set board_title=?, board_content=?, board_etime=sysdate where board_no=?";
		Object[] data = {boardDto.getBoardTitle(), boardDto.getBoardContent(),
								boardDto.getBoardNo()};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	
	//삭제
	public boolean delete(int boardNo) {
		String sql = "delete board where board_no=?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
}
