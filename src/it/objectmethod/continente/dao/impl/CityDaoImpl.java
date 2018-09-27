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
	
	public CityBean selezionaCitta(int ident) {
		//List<CityBean> v = new ArrayList();
		CityBean cb = null;
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "select * from city where ID =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ident);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//Retrieve by column name
				cb=new CityBean();
				int id = rs.getInt("ID");
				String citta  = rs.getString("name");
				String countryCode = rs.getString("CountryCode");
				String district = rs.getString("District");
				int population = rs.getInt("Population");
				cb.setId(id);
				cb.setName(citta);
				cb.setCountryCode(countryCode);
				cb.setDistrict(district);
				cb.setPopulation(population);
				//v.add(cb);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cb;
	}
	
	public void modificaCitta(String citta,String countryCode,String district,int population,int id) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "update city set name=?, countrycode=?, district=?, population=? where ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, citta);
			stmt.setString(2, countryCode);
			stmt.setString(3, district);
			stmt.setInt(4, population);
			stmt.setInt(5, id);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertCity(String citta, String countryCode, String district, int population) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			String sql="insert into city (Name, CountryCode, District, Population) values (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, citta);
			stmt.setString(2, countryCode);
			stmt.setString(3, district);
			stmt.setInt(4, population);
			stmt.executeUpdate();
				/*
				 * TODO Non settare l'id e usare i prapared statements, non comporre la stringa altrimenti si creano
				 * problemi di SQLInjection
				 */
				
			stmt.close();
			conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	
	
	public void cancellaCitta(int ident) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql;
			sql = "delete from city where id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ident);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
		  e.printStackTrace();
		}
	}
	
	
	public List<CityBean> cercaCitta(String cercaCitta) {
		List<CityBean> v= new ArrayList();
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql;
			sql = "select * from city where name like ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cercaCitta+'%');
			ResultSet rs = stmt.executeQuery();
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
