package it.objectmethod.continente.dao.impl;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethod.continente.config.ConnectionFactory;
import it.objectmethod.continente.dao.ICercaDao;
import it.objectmethod.continente.domain.CityBean;


public class CercaDaoImpl implements ICercaDao {
	public List<CityBean> cercaCitta(String cercaCitta) {
		List<CityBean> v= new ArrayList();
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql;
			sql = "select * from city where name like '"+cercaCitta+"%'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CityBean ccb = new CityBean();
				int id = rs.getInt("ID");
				String citta  = rs.getString("name");
				String countryCode= rs.getString("countrycode");
				String district=rs.getString("district");
				int population=rs.getInt("population");
				ccb.setId(id);
				ccb.setName(citta);
				ccb.setCountryCode(countryCode);
				ccb.setDistrict(district);
				ccb.setPopulation(population);
				v.add(ccb);
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