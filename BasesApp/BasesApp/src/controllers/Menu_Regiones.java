package controllers;

public enum Menu_Regiones {

	SHOW_REGION("mostrar regiones"), ADD_REGION("a�adir_regiones"), DELETE_REGION("Borrar regi�n");

	private String txt;

	private Menu_Regiones(String txt) {
		this.txt = txt;
	}

	public String toString() {
		return txt;
	}
}
