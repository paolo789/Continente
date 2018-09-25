package it.objectmethod.continente.domain;

public class CityBean {
	private int id;
	private String Name;
	private String CountryCode;
	private String District;
	private int Population;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		this.CountryCode = countryCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		this.District = district;
	}
	public int getPopulation() {
		return Population;
	}
	public void setPopulation(int population) {
		this.Population = population;
	}
}
