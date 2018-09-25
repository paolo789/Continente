package it.objectmethod.continente.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.objectmethod.continente.config.ConnectionFactory;
import it.objectmethod.continente.dao.ICancellaDao;

public class CancellaDaoImpl implements ICancellaDao {
	public void cancellaCitta(int ident) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql;
			sql = "delete from city where id="+ident+"";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
		  e.printStackTrace();
		}
	}
 
}
