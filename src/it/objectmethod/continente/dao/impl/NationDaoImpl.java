package it.objectmethod.continente2.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import it.objectmethod.continente2.dao.INationDao;
import it.objectmethod.continente2.config.ConnectionFactory;


public class NationDaoImpl implements INationDao {
	
	public List<String> getContinent(){
		List<String> v = new ArrayList();
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql ="SELECT continent FROM world.country GROUP BY continent"; //TODO meglio SELECT distinct continent from world.country
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
	
	public ArrayList<String> getNation(String continent){
		ArrayList<String> v = new ArrayList();
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "SELECT Name FROM world.country where continent=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, continent);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//Retrieve by column name
				String nation  = rs.getString("name");
				v.add(nation);
				
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
