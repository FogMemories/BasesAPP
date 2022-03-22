package models;

public class Country {

	public int idCountry;
	public int idRegion;
	public String namePais;

	public Country(int idCountry, int idRegion, String namePais) {
		super();
		this.idCountry = idCountry;
		this.idRegion = idRegion;
		this.namePais = namePais;
	}

	public Object[] toObjectVector(){
		return new Object[] {idCountry,idRegion, namePais};
	}

	public int getIdPais() {
		return idCountry;
	}

	public String getNombrePais() {
		return namePais;
	}

	public int getIdRegion() {
		return idRegion;
	}

	public String toString() {
		return "id pais: " + idCountry + "/n" + 
				"id region: " + idRegion + "/n" +
				"nombre pais: " +namePais + "/n" ;
	}
}