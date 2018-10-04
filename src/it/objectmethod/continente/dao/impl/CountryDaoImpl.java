package it.objectmethod.continente.dao.impl;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import it.objectmethod.continente.dao.ICountryDao;
import it.objectmethod.continente.domain.CountryBean;
import it.objectmethod.continente.domain.mapper.CountryMapper;


public class CountryDaoImpl implements ICountryDao {
	
	final static String SQL_GET_CONTINENT="SELECT distinct continent FROM world.country";
	final static String SQL_GET_NATION="SELECT * FROM world.country where continent=?";
	final static String SQL_GET_COUNTRY="select * from world.country";
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	   }
	   
	   public List<String> getContinent() {
			return jdbcTemplate.queryForList(SQL_GET_CONTINENT, String.class);
		}
	   
	   public List<CountryBean> getNationsByContinent(String continent){
		    return jdbcTemplate.query(SQL_GET_NATION, new Object[] { continent }, new CountryMapper());
	   }
	   
	   public List<CountryBean> listaCountry() {
		   	return jdbcTemplate.query(SQL_GET_COUNTRY, new CountryMapper());
	   }
}
