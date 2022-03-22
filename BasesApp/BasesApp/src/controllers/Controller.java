package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Country;
import models.Employee;
import models.HistoryWork;
import models.Localitation;
import models.Manager;
import models.Region;
import models.Work;
import view.JPanelDepartamentos;
import view.JPanelEmpleados;
import view.JPanelHistoryWork;
import view.JPanelLugares;
import view.JPanelPaises;
import view.JPanelRegiones;
import view.JPanelTableDepartamentos;
import view.JPanelTableEmployee;
import view.JPanelTableHistoryWork;
import view.JPanelTablePaises;
import view.JPanelTableRegiones;
import view.JPanelTableUbicacion;
import view.JPanelTableWork;
import view.JPanelTableWorkPl;
import view.JPanelTrabajo;
import view.View;

public class Controller implements ActionListener {

	private Manager manager;
	private View view;

	private JPanelTableRegiones tableRegiones;
	private JPanelTablePaises tablePaises;
	private JPanelTableDepartamentos tableDepartamentos;
	private JPanelTableEmployee tableEmpleados;
	private JPanelTableHistoryWork tableHistoriasPaises;
	private JPanelTableUbicacion tableUbicaciones;
	private JPanelTableWork tableTrabajos;
	private JPanelTableWorkPl tableTrabajosPl;
	private JPanelRegiones jdRegiones;
	private JPanelTrabajo jdWork;
	private JPanelPaises jdPaises;
	private JPanelLugares jdLugares;
	private JPanelHistoryWork jdHistoryWork;
	private JPanelEmpleados jdEmpleados;
	private JPanelDepartamentos jdDepartamentos;

	public Controller() throws SQLException {
		manager = new Manager();
		view = new View();
		showMenu();
	}

	public ArrayList<Region> cargarRegiones() throws SQLException {
		System.err.println("regiones cargarRegiones");
		manager.showRegiones();
		return manager.regionList;
	}

	public void cargarPaises() {
		for (int i = 0; i < manager.getCountryList().size(); i++) {
			Country country = new Country(manager.getCountryList().get(i).getIdPais(),
					manager.getCountryList().get(i).getIdRegion(), manager.getCountryList().get(i).getNombrePais());
			System.out.println(country);
			tablePaises.addElementToTable(country.toObjectVector());

		}
	}

	public ArrayList<Employee> cargarEmpleados() throws SQLException {
		System.err.println("cargarEmpleados");
		manager.showEmploye();
		return manager.getEmployeeList();
	}

	public void cargarDepartamentos() {

	}

	public void cargarHistoryWork() {
		System.err.println("ingreso menu cargarHistoryWork");
		for (int i = 0; i < manager.getHistoryWorkList().size(); i++) {
			HistoryWork history = new HistoryWork(manager.getHistoryWorkList().get(i).getDateStart(),
					manager.getHistoryWorkList().get(i).dateFinish, manager.getHistoryWorkList().get(i).getIdEmploye(),
					manager.getHistoryWorkList().get(i).getIdWork(),
					manager.getHistoryWorkList().get(i).getIdDepartament());
			System.out.println(history);
			tableHistoriasPaises.addElementToTable(history.toObjectVector());
		}
	}

	public ArrayList<Work> cargarTrabajos() throws SQLException {
		this.manager.showTrabajos();
		ArrayList<Work> listArray = this.manager.getWorkList();

		return listArray;
	}

	public ArrayList<Work> cargarTrabajosPl(double value) throws SQLException {
		this.manager.showPlWork(value);
		ArrayList<Work> listArray = this.manager.getWorkList();

		return listArray;
	}

	public void cargarUbicaciones() {
		for (int i = 0; i < manager.getLocalitationList().size(); i++) {
			Localitation ubicacion = new Localitation(manager.getLocalitationList().get(i).getIdLocalitation(),
					manager.getLocalitationList().get(i).getIdPais(),
					manager.getLocalitationList().get(i).getDireccion(),
					manager.getLocalitationList().get(i).getCodigoPostal(),
					manager.getLocalitationList().get(i).getEstadoProvincia());
			System.out.println(ubicacion);
			tableUbicaciones.addElementToTable(ubicacion.toObjectVector());
		}
	}

	private void showMenu() throws SQLException {
		switch (view.getMenu()) {
		case DEPARTAMENT:
			showMenuDepartament();
			break;
		case REGION:
			showMenuRegion();
			break;
		case WORK:
			showMenuWork();
			break;
		case EMPLOYE:
			showMenuEmploye();
			break;
		case COUNTRY:
			showMenuCounty();
			break;
		case LOC:
			showMenuLocalitation();
			break;
		default:
			break;
		}
	}

	private void showMenuWork() throws SQLException {
		System.err.println("ingreso menu trabajo");
		switch (view.getMenuWork()) {

		case SHOW_WORK:
			tableTrabajos = new JPanelTableWork(this);
			break;
		case SHOW_WORK_PL:
			tableTrabajosPl = new JPanelTableWorkPl(this);
			break;
		case ADD_WORK:
			jdWork = new JPanelTrabajo(this);
			break;
		case DELETE_WORK:
			manager.dropWork(view.getIdWork());
			break;

		default:
			break;
		}

	}

	private void showMenuLocalitation() throws SQLException {
		switch (view.getMenuLocalitation()) {
		case ADD_LOCALITATION:
			jdLugares = new JPanelLugares(this);
			break;
		case DELETE_LOCALITATION:
			manager.dropLocalitation(view.getIdLocalitation());
			break;
		case MODIFY_LOCALITATION:

			break;
		case SHOW_LOCALITATION:
			tableUbicaciones = new JPanelTableUbicacion();
			cargarUbicaciones();
			showMenu();
			break;

		default:
			break;
		}

	}

	private void showMenuRegion() throws SQLException {
		switch (view.getMenuRegiones()) {
		case SHOW_REGION:
			tableRegiones = new JPanelTableRegiones(this);
			break;
		case ADD_REGION:
			jdRegiones = new JPanelRegiones(this);
			break;
		case DELETE_REGION:
			manager.dropRegion(view.getIdRegion());
			break;
		default:
			break;
		}
	}

	private void showMenuCounty() throws SQLException {
		switch (view.getMenuCountry()) {
		case ADD_COUNTRY:
			jdPaises = new JPanelPaises(this);
			break;
		case DELETE_COUNTRY:
			manager.dropCountry(view.getIdCountry());
			break;
		case MODIFY_COUNTRY:

			break;
		case SHOW_COUNTRY:
			tablePaises = new JPanelTablePaises();
			cargarPaises();
			break;
		default:
			break;
		}
	}

	public void showMenuHistoryWork() {
		switch (view.getMenuHistoryWork()) {
		case ADD_HISTORY_WORK:
			jdHistoryWork = new JPanelHistoryWork(this);
			break;
		case DELETE_HISTORY_WORK:

			break;
		case MODIFY_HISTORY_WORK:

			break;
		case SHOW_HISTORY_WORK:
			tableHistoriasPaises = new JPanelTableHistoryWork();
			cargarHistoryWork();
			break;
		default:
			break;
		}
	}

	private void showMenuEmploye() throws SQLException {
		switch (view.getMenuEmploye()) {

		case SHOW_EMPLOYEE:
			tableEmpleados = new JPanelTableEmployee(this);

			break;
		case ADD_EMPLOYEE:
			jdEmpleados = new JPanelEmpleados(this);
			break;
		case DELETE_EMPLOYEE:
			manager.dropEMployee(view.getIdEmploye());
			break;
		default:
			break;
		}
	}

	private void showMenuDepartament() throws SQLException {
		switch (view.getMenuDepartament()) {
		case SHOW_DEPARTAMENT:
			tableDepartamentos = new JPanelTableDepartamentos(this);

			break;
		case ADD_DEPARTMENT:
			jdDepartamentos = new JPanelDepartamentos(this);
		case DROP_DEPARTMENT:
			manager.dropDepartment(view.getIdDepartament());
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) throws SQLException {
		new Controller();
	}

	public void actionPerformed(ActionEvent e) {
		switch (ComandApp.valueOf(e.getActionCommand())) {
		case ADD_WORK:
			try {
				manager.insertTrabajos(jdWork.getidTrabajo(), jdWork.gettituloTrabajo(), jdWork.getSalarioMinimo(),
						jdWork.getSalarioMaximo());
				jdWork.setVisible(false);
				showMenu();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case ADD_REGION:
			try {
				manager.insertionRegion(jdRegiones.getNombreRegion());
				jdRegiones.setVisible(false);
				showMenu();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case ADD_PAIS:
			try {
				manager.insertionCountry(jdPaises.getIdPais(), jdPaises.getIdRegion(), jdPaises.getNombrePais());
				jdPaises.setVisible(false);
				showMenu();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case ADD_UBICACION:
			try {
				manager.insertUbicacion(jdLugares.getidUbicacion(), jdLugares.getidPais(), jdLugares.getdireccion(),
						jdLugares.getcodigoPostal(), jdLugares.getciudad(), jdLugares.getestadoProvincial());

				jdLugares.setVisible(false);
				showMenu();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
			break;
		case ADD_DEPARTAMENTO:
			try {
				manager.insertDepartamentos(jdDepartamentos.getIdDepartamento(), jdDepartamentos.getidSupervisor(),
						jdDepartamentos.getidUbicacion(), jdDepartamentos.getnombreDepartamento());
				jdDepartamentos.setVisible(false);
				showMenu();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case ADD_EMPLEADO:
			try {
				manager.insertEmployee(jdEmpleados.getIdEmpleado(), jdEmpleados.getIdDepartamento(),
						jdEmpleados.getidSupervisor(), jdEmpleados.getNombreEmpleado(),
						jdEmpleados.getApellidoEmpleado(), jdEmpleados.getEmail(), jdEmpleados.getTelefono(),
						jdEmpleados.getFechaContrato(), jdEmpleados.getSalario(), jdEmpleados.getComision(),
						jdEmpleados.getidtrabajo());
				jdEmpleados.setVisible(false);
				showMenu();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case ADD_HYSTORY_WORK:
			try {
				manager.insertHistoryTrabj(jdHistoryWork.getidEmpleado(), jdHistoryWork.getidTrabajo(),
						jdHistoryWork.getidDepartamento(), jdHistoryWork.getFechaInicio(), jdHistoryWork.getFechaFin());
				jdHistoryWork.setVisible(false);
				showMenu();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
