package it.objectmethod.continente.domain;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class NationMapper implements RowMapper<CountryBean> {
	public CountryBean mapRow(ResultSet resultSet, int i) throws SQLException {

		CountryBean country = new CountryBean();
		country.setCode(resultSet.getString("code"));
		country.setName(resultSet.getString("name"));
		country.setContinent(resultSet.getString("continent"));
		country.setPopulation(resultSet.getInt("population"));
		
		return country;
	}
}
