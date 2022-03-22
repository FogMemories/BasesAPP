package models;

public class Localitation {

	public int idLocalitation;
	public int idPais;
	public String direccion;
	public int codigoPostal;
	public String estadoProvincia;
	
	public Localitation(int idLocalitation, int idPais, String direccion, int codigoPostal, String estadoProvincia) {
		this.idLocalitation = idLocalitation;
		this.idPais = idPais;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.estadoProvincia = estadoProvincia;
	}
	
	public Object[] toObjectVector(){
		return new Object[] {idLocalitation, idPais,direccion,codigoPostal,estadoProvincia};
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getEstadoProvincia() {
		return estadoProvincia;
	}

	public int getIdLocalitation() {
		return idLocalitation;
	}

	public int getIdPais() {
		return idPais;
	}
}
