package controllers;

public enum Menu_Departament {

	SHOW_DEPARTAMENT("mostrar departamentos"), ADD_DEPARTMENT("añadir departamento"), DROP_DEPARTMENT(
			"Borrar departamento");

	private String txt;

	private Menu_Departament(String txt) {
		this.txt = txt;
	}

	public String toString() {
		return txt;
	}
}
