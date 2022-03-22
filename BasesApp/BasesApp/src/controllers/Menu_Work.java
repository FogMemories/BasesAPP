package controllers;

public enum Menu_Work {

	SHOW_WORK("mostrar trabajo"), SHOW_WORK_PL("mostrar trabajos dependiendo el salario"), ADD_WORK(
			"añadir trabajo"), DELETE_WORK("Eliminar trabajo");

	private String txt;

	private Menu_Work(String txt) {
		this.txt = txt;
	}

	public String toString() {
		return txt;
	}
}
