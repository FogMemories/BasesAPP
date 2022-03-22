package controllers;

public enum Menu_Country {

	ADD_COUNTRY("agregar un pais"),SHOW_COUNTRY("mostrar pais"),
	DELETE_COUNTRY("eliminar pais"),MODIFY_COUNTRY("modificar pais"),
	BACK_COUNTRY("atras");

	private String txt;

	private Menu_Country(String txt) {
		this.txt = txt;
	}

	public String toString() {
		return txt;
	}
}
