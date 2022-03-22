package models;

public class Departament {

	public int idDepartament;
	public int idSupervisor;
	public int idLocalitation;
	public String nameDepartament;
	
	public Departament(int idDepartament, int idSupervisor, int idLocalitation, String nameDepartament) {
		this.idDepartament = idDepartament;
		this.idSupervisor = idSupervisor;
		this.idLocalitation = idLocalitation;
		this.nameDepartament = nameDepartament;
	}

	public Object[] toObjectVector(){
		return new Object[] {idDepartament, idSupervisor,idLocalitation,nameDepartament};
	}
	
	public int getIdDepartament() {
		return idDepartament;
	}

	public int getIdLocalitation() {
		return idLocalitation;
	}

	public int getIdSupervisor() {
		return idSupervisor;
	}

	public String getNameDepartament() {
		return nameDepartament;
	}
}
