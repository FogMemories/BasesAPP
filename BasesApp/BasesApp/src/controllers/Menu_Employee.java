package controllers;

public enum Menu_Employee {

	SHOW_EMPLOYEE("mostrar empleado"), 
	ADD_EMPLOYEE("añadir empleado"), DELETE_EMPLOYEE("Borrar empleado");

	private String txt;

	private Menu_Employee(String txt) {
		this.txt = txt;
	}

	public String toString() {
		return txt;
	}
}
