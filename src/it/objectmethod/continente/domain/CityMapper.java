package it.objectmethod.continente.domain;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class CityMapper implements RowMapper<CityBean> {
	public CityBean mapRow(ResultSet resultSet, int i) throws SQLException {

		CityBean city = new CityBean();
		city.setId(resultSet.getInt("id"));
		city.setName(resultSet.getString("name"));
		city.setCountryCode(resultSet.getString("countrycode"));
		city.setDistrict(resultSet.getString("district"));
		city.setPopulation(resultSet.getInt("population"));
		
		return city;
	}
}
