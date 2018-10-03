package it.objectmethod.continente.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;  
import it.objectmethod.continente.config.ConnectionFactory;
import it.objectmethod.continente.dao.ICityDao;
import it.objectmethod.continente.domain.CityBean;
import it.objectmethod.continente.domain.CityMapper;

public class CityDaoImpl implements ICityDao {
	
	
	private final String SQL_FIND_CITIES="SELECT * from world.city where countrycode=?";
	private final String SQL_SELEZIONA_CITTA = "select * from city where ID =?";
	private final String SQL_MODIFICA_CITTA = "update city set name=?, countrycode=?, district=?, population=? where ID=?";
	private final String SQL_INSERT_CITTA="insert into city (Name, CountryCode, District, Population) values (?,?,?,?)";
	private final String SQL_CANCELLA_CITTA = "delete from city where id=?";
	private final String SQL_CERCA_CITTA = "select * from city where name like ?";
	
	
	//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("Beans.xml");
	//JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	   }
	
	
	public List<CityBean> getCitiesByNations(String countryCode) {
		return jdbcTemplate.query(SQL_FIND_CITIES,new Object[] { countryCode }, new CityMapper());
	}
	
	
	public CityBean selezionaCitta(int ident) {
		return jdbcTemplate.queryForObject(SQL_SELEZIONA_CITTA,new Object[] { ident }, new CityMapper());
	}
	
	public void modificaCitta(CityBean cb) {
		jdbcTemplate.update(SQL_MODIFICA_CITTA, cb.getName(), cb.getCountryCode(), cb.getDistrict(), cb.getPopulation(), cb.getId());
	}
	
	public void insertCity(CityBean cb) {
		jdbcTemplate.update(SQL_INSERT_CITTA, cb.getName(), cb.getCountryCode(), cb.getDistrict(), cb.getPopulation());
	}
	
	public void cancellaCitta(int ident) {
		jdbcTemplate.update(SQL_CANCELLA_CITTA, ident);
	}
	
	public List<CityBean> cercaCitta(String cercaCitta) {
		return jdbcTemplate.query(SQL_CERCA_CITTA, new Object[] {cercaCitta+'%'}, new CityMapper());
	}
	
	
	
	
	
	
	/*public List<CityBean> getCitiesByNations(String nation){
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
	} */
	
	
	
	
/*	public CityBean selezionaCitta(int ident) {
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
	} */ 
	
/*	public void modificaCitta(CityBean cb) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "update city set name=?, countrycode=?, district=?, population=? where ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cb.getName());
			stmt.setString(2, cb.getCountryCode());
			stmt.setString(3, cb.getDistrict());
			stmt.setInt(4, cb.getPopulation());
			stmt.setInt(5, cb.getId());
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} */
	
	/*public void insertCity(CityBean cb) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			String sql="insert into city (Name, CountryCode, District, Population) values (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cb.getName());
			stmt.setString(2, cb.getCountryCode());
			stmt.setString(3, cb.getDistrict());
			stmt.setInt(4, cb.getPopulation());
			stmt.executeUpdate();
				
				
			stmt.close();
			conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	} */
	
	
/*	public void cancellaCitta(int ident) {
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
	} */
	
	
/*	public List<CityBean> cercaCitta(String cercaCitta) {
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
	} */
	
	
	
}
