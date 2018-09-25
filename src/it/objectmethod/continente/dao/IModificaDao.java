package it.objectmethod.continente.dao;

import java.util.List;


import it.objectmethod.continente.domain.CityBean;

public interface IModificaDao {
	public List<CityBean> selezionaCitta(int ident);
	public void modificaCitta(String citta,String countrycode,String district,int population,int id);
}
