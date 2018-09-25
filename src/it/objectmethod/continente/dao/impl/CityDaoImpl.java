package it.objectmethod.continente.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.continente.config.ConnectionFactory;
import it.objectmethod.continente.dao.ICityDao;
import it.objectmethod.continente.domain.CityBean;

public class CityDaoImpl implements ICityDao {
	public List<CityBean> getCitiesByNations(String nation){
		List<CityBean> v = new ArrayList();
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "SELECT * from world.city where countrycode=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nation);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//Retrieve by column name
				CityBean city = new CityBean();
				city.setId(rs.getInt("ID"));
				city.setName(rs.getString("Name"));
				city.setDistrict(rs.getString("District"));
				city.setCountryCode(rs.getString("CountryCode"));
				city.setPopulation(rs.getInt("Population"));
				v.add(city);
				
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}
}
