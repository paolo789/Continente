package it.objectmethod.continente2.dao;

import java.util.ArrayList;
import java.util.List;

public interface INationDao {
	public List<String> getContinent();
	public ArrayList<String> getNation(String continent);
	
	/*
	 * TODO ritornare una List (interfaccia) e non arraylist e soprattutto
	 *  immagazzinare le informazioni relative alla country in un opportuno bean
	 *  (nel caso della country code, nome, continent e popolazione)
	 *  Inoltre il nome del metodo dev'essere parlante, ovvero deve far capire esattamente cosa 
	 *  fa. getNation è sbagliato perchè ritorni una lista di nazioni filtrate per continente.
	 */
}
