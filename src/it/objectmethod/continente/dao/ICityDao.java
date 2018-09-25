package it.objectmethod.continente.dao;

import java.util.ArrayList;
import java.util.List;

import it.objectmethod.continente.domain.CityBean;

public interface ICityDao {
	public List<CityBean> getCitiesByNations(String nation); 
	
	/*
	 * TODO ritornare una List (interfaccia) e non arraylist e soprattutto
	 *  immagazzinare le informazioni relative alla city in un opportuno bean
	 *  (nel caso della city TUTTO quel che c'� a db)
	 *  Inoltre il nome del metodo dev'essere parlante, ovvero deve far capire esattamente cosa 
	 *  fa. getCity � sbagliato perch� ritorni una lista di citt� filtrate per nazione.
	 */
}
