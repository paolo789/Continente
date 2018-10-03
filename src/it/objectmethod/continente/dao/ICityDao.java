package it.objectmethod.continente.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import it.objectmethod.continente.domain.CityBean;

public interface ICityDao {
	public List<CityBean> getCitiesByNations(String countryCode); 
	public void insertCity(CityBean cb);
	public void cancellaCitta(int id);
	public List<CityBean> cercaCitta(String cercaCitta);
	public CityBean selezionaCitta(int ident);
	public void modificaCitta(CityBean cb);
	/*
	 * TODO ritornare una List (interfaccia) e non arraylist e soprattutto
	 *  immagazzinare le informazioni relative alla city in un opportuno bean
	 *  (nel caso della city TUTTO quel che c'è a db)
	 *  Inoltre il nome del metodo dev'essere parlante, ovvero deve far capire esattamente cosa 
	 *  fa. getCity è sbagliato perchè ritorni una lista di città filtrate per nazione.
	 */
}
