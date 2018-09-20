package it.objectmethod.continente2.dao;

import java.util.ArrayList;

public interface ICityDao {
	public ArrayList<String> getCity(String nation); 
	
	/*
	 * TODO ritornare una List (interfaccia) e non arraylist e soprattutto
	 *  immagazzinare le informazioni relative alla city in un opportuno bean
	 *  (nel caso della city TUTTO quel che c'è a db)
	 *  Inoltre il nome del metodo dev'essere parlante, ovvero deve far capire esattamente cosa 
	 *  fa. getCity è sbagliato perchè ritorni una lista di città filtrate per nazione.
	 */
}
