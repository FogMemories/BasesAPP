package controllers;

public enum Menu_Regiones {

	SHOW_REGION("mostrar regiones"), ADD_REGION("añadir_regiones"), DELETE_REGION("Borrar región");

	private String txt;

	private Menu_Regiones(String txt) {
		this.txt = txt;
	}

	public String toString() {
		return txt;
	}
}
