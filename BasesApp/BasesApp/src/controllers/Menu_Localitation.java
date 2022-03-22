package controllers;

public enum Menu_Localitation {

	ADD_LOCALITATION("agregar un ubicacion"),SHOW_LOCALITATION("mostrar ubicacion"),
	DELETE_LOCALITATION("eliminar ubicacion"),MODIFY_LOCALITATION("modificar ubicacion");

	private String txt;

	private Menu_Localitation(String txt) {
		this.txt = txt;
	}

	public String toString() {
		return txt;
	}
}
