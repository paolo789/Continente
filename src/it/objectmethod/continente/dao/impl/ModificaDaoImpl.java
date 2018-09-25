package it.objectmethod.continente.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.continente.config.ConnectionFactory;
import it.objectmethod.continente.dao.IModificaDao;

import it.objectmethod.continente.domain.CityBean;

public class ModificaDaoImpl implements IModificaDao{

	public List<CityBean> selezionaCitta(int ident) {
		List<CityBean> v = new ArrayList();
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "select * from city where ID ="+ident+"";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				//Retrieve by column name
				CityBean cb = new CityBean();
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
				v.add(cb);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public void modificaCitta(String citta,String countrycode,String district,int population,int id) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "update city set Name='"+citta+"',population="+population+" where ID="+id+"";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

