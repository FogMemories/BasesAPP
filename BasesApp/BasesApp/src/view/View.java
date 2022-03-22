package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import controllers.MenuPrinc;
import controllers.Menu_Country;
import controllers.Menu_Departament;
import controllers.Menu_Employee;
import controllers.Menu_History_Work;
import controllers.Menu_Localitation;
import controllers.Menu_Regiones;
import controllers.Menu_Work;

public class View {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	public Menu_Country getMenuCountry() {
		return (Menu_Country) JOptionPane.showInputDialog(null, "Ingrese la opcion:", "Menu", JOptionPane.QUESTION_MESSAGE,null, Menu_Country.values(), Menu_Country.values()[0]);
	}
	
	public Menu_Departament getMenuDepartament() {
		return (Menu_Departament) JOptionPane.showInputDialog(null, "Ingrese la opcion:", "Menu", JOptionPane.QUESTION_MESSAGE,null, Menu_Departament.values(), Menu_Departament.values()[0]);
	}
	
	public MenuPrinc getMenu() {
		return (MenuPrinc) JOptionPane.showInputDialog(null, "Ingrese la opcion:", "Menu", JOptionPane.QUESTION_MESSAGE,null, MenuPrinc.values(), MenuPrinc.values()[0]);
	}
	
	public Menu_Employee getMenuEmploye() {
		return (Menu_Employee) JOptionPane.showInputDialog(null, "Ingrese la opcion:", "Menu", JOptionPane.QUESTION_MESSAGE,null, Menu_Employee.values(), Menu_Employee.values()[0]);
	}
	
	public Menu_History_Work getMenuHistoryWork() {
		return (Menu_History_Work) JOptionPane.showInputDialog(null, "Ingrese la opcion:", "Menu", JOptionPane.QUESTION_MESSAGE,null, Menu_History_Work.values(), Menu_History_Work.values()[0]);
	}

	public Menu_Localitation getMenuLocalitation() {
		return (Menu_Localitation) JOptionPane.showInputDialog(null, "Ingrese la opcion:", "Menu", JOptionPane.QUESTION_MESSAGE,null, Menu_Localitation.values(), Menu_History_Work.values()[0]);
	}
	
	public Menu_Regiones getMenuRegiones() {
		return (Menu_Regiones) JOptionPane.showInputDialog(null, "Ingrese la opcion:", "Menu", JOptionPane.QUESTION_MESSAGE,null, Menu_Regiones.values(), Menu_Regiones.values()[0]);
	}
	
	public Menu_Work getMenuWork() {
		return (Menu_Work) JOptionPane.showInputDialog(null, "Ingrese la opcion:", "Menu", JOptionPane.QUESTION_MESSAGE,null, Menu_Work.values(), Menu_Work.values()[0]);
	}
	
	public int getIdRegion() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de la region"));
	}
	
	public int getIdLocalitation() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de la ubicacion"));
	}
	
	public int getIdCountry() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el id del pais"));
	}
	
	public int getIdDepartament() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el id del departamento"));
	}
	
	public int getIdHistoryWork() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de history-work"));
	}
	
	public int getIdWork() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el id del trabajo"));
	}
	
	public int getIdEmploye() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el id del empleado"));
	}
	
	public int getCodePostal() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el codigo postal"));
	}
	
	public int getSalarioMinimo() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el salario minimo"));
	}
	
	public int getSalarioMaximo() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el salario maximo"));
	}
	
	public int getTelefono() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el salario maximo"));
	}
	
	public String getNameRegion() {
		return JOptionPane.showInputDialog("ingrese el nombre de la region");
	}
	
	public String getNameEmpleado() {
		return JOptionPane.showInputDialog("ingrese el nombre del empleado");
	}
	
	public String getLastNameEmpleado() {
		return JOptionPane.showInputDialog("ingrese el nombre del empleado");
	}
	
	public String getEmail() {
		return JOptionPane.showInputDialog("ingrese su email");
	}
	
	public String getNameDepartament() {
		return JOptionPane.showInputDialog("ingrese el nombre del departamento");
	}
	
	public Calendar getFechaIncio() throws ParseException {
		String textDate = JOptionPane.showInputDialog(null, "Por favor ingrese la fecha de inicio formato dd/mm/yyyy:",
				"Fecha", JOptionPane.QUESTION_MESSAGE);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(DATE_FORMAT.parse(textDate));
		return calendar;
	}
	
	public double getSalario() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese el salario"));
	}
	
	public double getComision() {
		return Integer.parseInt(JOptionPane.showInputDialog("ingrese la comision"));
	}
	
	public Calendar getFechaContrato() throws ParseException {
		String textDate = JOptionPane.showInputDialog(null, "Por favor ingrese la fecha de contrato formato dd/mm/yyyy:",
				"Fecha", JOptionPane.QUESTION_MESSAGE);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(DATE_FORMAT.parse(textDate));
		return calendar;
	}
	
	public Calendar getFechaFin() throws ParseException {
		String textDate = JOptionPane.showInputDialog(null, "Por favor ingrese la fecha de fin formato dd/mm/yyyy:",
				"Fecha", JOptionPane.QUESTION_MESSAGE);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(DATE_FORMAT.parse(textDate));
		return calendar;
	}
	
	public String getCiudad() {
		return JOptionPane.showInputDialog("ingrese la ciudad");
	}
	
	public String getProvince() {
		return JOptionPane.showInputDialog("ingrese la provincia");
	}
	
	public String getTituloTrabajo() {
		return JOptionPane.showInputDialog("ingrese el titulo del trabajo");
	}
	
	public String getDireccion() {
		return JOptionPane.showInputDialog("direccion");
	}
	
	public String getNamePais() {
		return JOptionPane.showInputDialog("ingrese el nombre del pais");
	}
}
