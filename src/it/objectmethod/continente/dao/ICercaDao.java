package it.objectmethod.continente.dao;

import java.util.List;

import it.objectmethod.continente.domain.CityBean;



public interface ICercaDao {
	public List<CityBean> cercaCitta(String cercaCitta);
}
