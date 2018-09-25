package it.objectmethod.continente.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethod.continente.config.ConnectionFactory;
import it.objectmethod.continente.dao.IAggiungiDao;

public class AggiungiDaoImpl implements IAggiungiDao {
	public void insertCity(String citta, String countrycode, String district, int population) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "select max(ID) from city";
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("max(ID)");
				System.out.println(id);
				id++;
				sql="insert into city values("+id+",'"+citta+"','"+countrycode+"','"+district+"',"+population+")";
				/*
				 * TODO Non settare l'id e usare i prapared statements, non comporre la stringa altrimenti si creano
				 * problemi di SQLInjection
				 */
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate(sql);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
}

