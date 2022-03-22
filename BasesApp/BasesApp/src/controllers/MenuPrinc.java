package controllers;

public enum MenuPrinc {

	REGION("usar tabla de regiones"),
	DEPARTAMENT("usar tabla de  departamentos"),
	EMPLOYE("usar tabla de  empleados"),
	WORK("usar tabla de trabajos "),
	LOC("usar tabla de localicación"),
	COUNTRY("usar tabla paises");

	private String text;

	private MenuPrinc(String txt) {
		this.text = txt;
	}
	public String toString() {
		return text;
	}
}
