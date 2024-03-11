package semiProject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import semiProject.dto.BasketDto;

@Service
public class BasketMapper implements RowMapper<BasketDto> {

	@Override
	public BasketDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BasketDto basketDto = new BasketDto();
		basketDto.setBasketNo(rs.getInt("basket_no"));
		basketDto.setBasketCount(rs.getInt("basket_count"));
		return basketDto;
	}

}
