package it.objectmethod.continente.dao;

import java.util.ArrayList;
import java.util.List;

import it.objectmethod.continente.domain.CountryBean;

public interface INationDao {
	public List<String> getContinent();
	public List<CountryBean> getNationsByContinent(String continent);
	
	/*
	 * TODO ritornare una List (interfaccia) e non arraylist e soprattutto
	 *  immagazzinare le informazioni relative alla country in un opportuno bean
	 *  (nel caso della country code, nome, continent e popolazione)
	 *  Inoltre il nome del metodo dev'essere parlante, ovvero deve far capire esattamente cosa 
	 *  fa. getNation è sbagliato perchè ritorni una lista di nazioni filtrate per continente.
	 */
}
