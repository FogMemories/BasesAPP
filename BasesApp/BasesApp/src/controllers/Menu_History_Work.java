package controllers;

public enum Menu_History_Work {

	ADD_HISTORY_WORK("agregar un History Work"),SHOW_HISTORY_WORK("mostrar History Work"),
	DELETE_HISTORY_WORK("eliminar History Work"),MODIFY_HISTORY_WORK("modificar History Work");

	private String txt;

	private Menu_History_Work(String txt) {
		this.txt = txt;
	}

	public String toString() {
		return txt;
	}
}
