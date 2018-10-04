package it.objectmethod.continente.domain.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.continente.domain.CountryBean;
public class CountryMapper implements RowMapper<CountryBean> {
	public CountryBean mapRow(ResultSet resultSet, int i) throws SQLException {

		CountryBean country = new CountryBean();
		country.setCode(resultSet.getString("code"));
		country.setName(resultSet.getString("name"));
		country.setContinent(resultSet.getString("continent"));
		country.setPopulation(resultSet.getInt("population"));
		
		return country;
	}
}
