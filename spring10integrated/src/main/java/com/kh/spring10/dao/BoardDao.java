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
//		String sql = "select * from board where instr("+column+", ?) > 0 "
//						+ "order by board_no desc";
//		Object[] data = {keyword};
//		return jdbcTemplate.query(sql, boardMapper, data);
		
		//샘 코드
		String sql = "select "
				+ "board_no, board_title, board_writer, "
				+ "board_wtime, board_etime, board_readcount "
			+ "from board "
			+ "where instr("+column+", ?) > 0 "
			+ "order by board_no desc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
	
	//목록
	public List<BoardDto> selectList(){
//		String sql = "select * from board order by board_no desc";
//		String sql = "select * from board order by board_wtime desc"; //이것도 되지만 PK로 해주는게 제일 성능이 좋음
//		return jdbcTemplate.query(sql, boardMapper);
		//선생님 코드
		String sql = "select "
				+ "board_no, board_title, board_writer, "
				+ "board_wtime, board_etime, board_readcount "
			+ "from board order by board_no desc";
		return jdbcTemplate.query(sql, boardListMapper);
	}
	
	//목록+페이징
	//- page는 현재 조회할 페이지 번호
	//- size는 조회할 페이지의 출력개수
	//- 위 두개를 이용하여 시작행(beginRow)과 종료행(endRow)를 계산
	public List<BoardDto> selectListByPaging(int page, int size){
		int endRow = page * size;
		int beginRow = endRow - (size-1);
		
		String sql = "select * from ("
				+ "select rownum rn, TMP.* from ("
				+ "select "
					+ "board_no, board_title, board_writer, "
					+ "board_wtime, board_etime, board_readcount "
				+ "from board order by board_no desc"
			+ ")TMP"
		+ ") where rn between ? and ?";
		Object[] data = {beginRow, endRow};
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
	
	//검색+페이징
	public List<BoardDto> searchByPaging(String column, String keyword, int page, int size){
		int endRow = page * size;
		int beginRow = endRow - (size-1);
		
		String sql = "select * from ("
				+ "select rownum rn, TMP.* from ("
					+ "select "
					+ "board_no, board_title, board_writer, "
					+ "board_wtime, board_etime, board_readcount "
					+ "from board where instr("+column+", ?) > 0 "
					+ "order by board_no desc"
				+ ")TMP"
		+ ") where rn between ? and ?";
		Object[] data = {keyword, beginRow, endRow};
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
	
	
	//count, sequence, max, min, sum, avg처럼 결과가 하나만 나오는 경우
	//그 결과는 객체가 아니라 원시데이터 형태일 확률이 높다
	
	//게시글 등록 시퀀스
	public int getSequence(){ //이렇게하는 이유가 시퀀스라서 자동으로 DB가 번호 넣어줌
		String sql = "select board_seq.nextval from dual";
		//jdbcTemplate.queryForObject(구문, 결과자료형); .class = 자료형객체
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	// 등록할 때 시퀀스 번호를 생성하면 절대 안된다. (위에 만들어줬기 때문에)
	//등록
	public void insert(BoardDto boardDto) {
		String sql = "insert into board(board_no, board_title, "
						+ "board_content, board_writer) "
						+ "values (?, ?, ?, ?)";
		Object[] data = {boardDto.getBoardNo(), boardDto.getBoardTitle(),
				boardDto.getBoardContent(), boardDto.getBoardWriter()};
		jdbcTemplate.update(sql, data);
	}
	
	//상세 (단일조회)
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
	
	//조회수 증가
	public boolean updateBoardReadcount(int boardNo) {
		String sql = "update board "
						+ "set board_readcount = board_readcount +1 "
						+ "where board_no = ?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
}
