package semiProject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import semiProject.dto.PointDto;
import semiProject.mapper.PointMapper;

@Repository
public class PointDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PointMapper pointMapper;
	
	//충전상품 시퀀스번호
	public int getPointSequence() {
		String sql = "select point_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	//충전상품 등록
	public void insert(PointDto pointDto) {
		String sql = "insert into point("
						+ "point_no, point_name, point_price, point_charge) "
					+ "values(?, ?, ?, ?)";
		Object[] data = {pointDto.getPointNo(), pointDto.getPointName(),
								pointDto.getPointPrice(), pointDto.getPointCharge()};
		jdbcTemplate.update(sql, data);
	}
	
	
	
	
	
	
	
	
	
	
	
}
