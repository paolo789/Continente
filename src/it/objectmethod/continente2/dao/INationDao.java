package it.objectmethod.continente2.dao;

import java.util.ArrayList;
import java.util.List;

public interface INationDao {
	public List<String> getContinent();
	public ArrayList<String> getNation(String continent);
}
