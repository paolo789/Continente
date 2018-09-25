package it.objectmethod.continente.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.continente.config.ConnectionFactory;
import it.objectmethod.continente.dao.INationDao;
import it.objectmethod.continente.domain.CountryBean;


public class NationDaoImpl implements INationDao {
	
	public List<String> getContinent(){
		List<String> v = new ArrayList();
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql ="SELECT distinct continent FROM world.country"; //TODO meglio SELECT distinct continent from world.country
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//Retrieve by column name
				String continente  = rs.getString("continent");
				v.add(continente);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}
	
	public List<CountryBean> getNationsByContinent(String continent){
		List<CountryBean> v = new ArrayList();
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM world.country where continent=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, continent);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//Retrieve by column name
				CountryBean country=new CountryBean();
				country.setCode(rs.getString("code"));
				country.setName(rs.getString("Name"));
				country.setContinent(rs.getString("Continent"));
				country.setPopulation(rs.getInt("Population"));
				v.add(country);
				
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
