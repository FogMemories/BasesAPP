package models;

public class Region {

	public int idRegion;
	public String nombreRegion;

	public Region(int idRegion, String nombreRegion) {
		this.idRegion = idRegion;
		this.nombreRegion = nombreRegion;
	}
	
	public int getIdRegion() {
		return idRegion;
	}
	
	public String getNombreRegion() {
		return nombreRegion;
	}

	public Object[] toObjectVector(){
		return new Object[] {idRegion, nombreRegion};
	}

	@Override
	public String toString() {
		return "Region [idRegion=" + idRegion + ", nombreRegion=" + nombreRegion + "]";
	}
	
}

