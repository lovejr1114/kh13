package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.PocketmonDto;

//Mapper 파일
//- 데이터베이스의 조회 결과 (ResultSet)를 변환객체(PocketmonDto)로 바꿔주는 역할
//- 상속을 받아서 특정 메소드를 구현해야함
public class PocketmonMapper implements RowMapper<PocketmonDto>{

	@Override
	public PocketmonDto mapRow(ResultSet rs, int idx) throws SQLException {
		//rs에 담긴 정보를 PocketmonDto로 옮겨서 반환하는 코드 작성
		PocketmonDto dto = new PocketmonDto(); //비어있는 객체 생성
		dto.setPocketmonNo(rs.getInt("pocketmon_no"));//rs에 들어있는 pocketmon_no 항목
		dto.setPocketmonName(rs.getString("pocketmon_name")); //rs에 들어있는 pocketmon_name 항목
		dto.setPocketmonType(rs.getString("pocketmon_type")); //rs에 들어있는 pocketmon_type 항목
		return dto;
	}

}
