package it.objectmethod.continente2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.objectmethod.continente2.config.ConnectionFactory;
import it.objectmethod.continente2.dao.ICityDao;

public class CityDaoImpl implements ICityDao {
	public ArrayList<String> getCity(String nation){
		ArrayList<String> v = new ArrayList();
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "SELECT c.name, y.name FROM city c inner join country y on c.countrycode=y.code where y.name=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nation);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//Retrieve by column name
				String city  = rs.getString("c.name");
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
