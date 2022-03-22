package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import persistencia.MySql;

public class Manager {

	public ArrayList<Employee> employeeList;
	public ArrayList<Work> workList;
	public ArrayList<Region> regionList;
	public ArrayList<Localitation> localitationList;
	public ArrayList<HistoryWork> historyWorkList;
	public ArrayList<Departament> departamentList;
	public ArrayList<Country> countryList;
	private MySql cc = new MySql();
	public Connection con = cc.conexion;

	public Manager() throws SQLException {
		employeeList = new ArrayList<Employee>();
		workList = new ArrayList<Work>();
		regionList = new ArrayList<Region>();
		localitationList = new ArrayList<Localitation>();
		historyWorkList = new ArrayList<HistoryWork>();
		departamentList = new ArrayList<Departament>();
		countryList = new ArrayList<Country>();
		showRegiones();
		// showPaises();
		// showDepartament();
		// showEmploye();
		// showTrabajos();
		// showHistoryWork();
		// showTrabajos();
		// showPlWork();
	}

	public void insertionRegion(String nameRegion) throws SQLException {
		String sql = "INSERT INTO ctregiones(nombre_region) VALUES (?);";
		java.sql.PreparedStatement pat = con.prepareStatement(sql);
		pat.setString(1, nameRegion);
		pat.execute();
	}

	// public void deleteRegion(String nameRegion) throws SQLException {
	// String sql = "DELETE id_region FROM ctregones WHERE id_regione?;";
	// java.sql.PreparedStatement pat = con.prepareStatement(sql);
	// pat.setString(1, nameRegion);
	// pat.execute();
	// }

	public void insertionCountry(int idPais, int idRegion, String nameCounntry) throws SQLException {
		String sql = "INSERT INTO ctpaises(id_pais,id_region,nombre_pais) VALUES (?,?,?);";
		java.sql.PreparedStatement pat = con.prepareStatement(sql);
		pat.setInt(1, idPais);
		pat.setInt(2, idRegion);
		pat.setString(3, nameCounntry);
		pat.execute();
	}

	public void insertTrabajos(int idTrabajo, String tituloTrabajo, double salarioMinimo, double salarioMaximo)
			throws SQLException {
		String sql = "INSERT INTO cttrabajos(id_trabajo,titulo_trabajo,salario_minimo,salario_maximo) VALUES (?,?,?,?);";
		java.sql.PreparedStatement pat = con.prepareStatement(sql);
		pat.setInt(1, idTrabajo);
		pat.setString(2, tituloTrabajo);
		pat.setDouble(3, salarioMinimo);
		pat.setDouble(4, salarioMaximo);
		pat.execute();
	}

	public void insertDepartamentos(int idDepartamento, int idSupervisor, int idUbicacion, String nombreDepartamento)
			throws SQLException {
		String sql = "INSERT INTO ctdepartamentos(id_departamento,id_supervisor,id_ubicacion,nombre_departamento) VALUES (?,?,?,?);";
		java.sql.PreparedStatement pat = con.prepareStatement(sql);
		pat.setInt(1, idDepartamento);
		pat.setInt(2, idSupervisor);
		pat.setInt(3, idUbicacion);
		pat.setString(4, nombreDepartamento);
		pat.execute();
	}

	public void insertUbicacion(int idUbicacion, int idPais, String direccion, int codePostal, String ciudad,
			String estadoProvincia) throws SQLException {
		String sql = "INSERT INTO ctubicaciones(id_ubicacion,id_pais,direccion,codigo_postal,ciudad,estado_provincia) VALUES (?,?,?,?,?,?);";
		java.sql.PreparedStatement pat = con.prepareStatement(sql);
		pat.setInt(1, idUbicacion);
		pat.setInt(2, idPais);
		pat.setString(3, direccion);
		pat.setInt(4, codePostal);
		pat.setString(5, ciudad);
		pat.setString(6, estadoProvincia);
		pat.execute();
	}

	public void insertEmployee(int idEmpleado, int idDepartamento, int idSupervisor, String nombreEmpleado,
			String apellidoEmpleado, String email, int telefono, Date date, double salario, double comision,
			int idTrabajo) throws SQLException {
		java.sql.Date insertDate = new java.sql.Date(date.getTime());
		String sql = "INSERT INTO ctempleados(id_empleado,id_departamento,id_supervisor,nombre_empleado,apellido_empleado,email,telefono,fecha_contrato,salario,comision,idtrab) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		java.sql.PreparedStatement pat = con.prepareStatement(sql);
		pat.setInt(1, idEmpleado);
		pat.setInt(2, idDepartamento);
		pat.setInt(3, idSupervisor);
		pat.setString(4, nombreEmpleado);
		pat.setString(5, apellidoEmpleado);
		pat.setString(6, email);
		pat.setInt(7, telefono);
		pat.setDate(8, insertDate);
		pat.setDouble(9, salario);
		pat.setDouble(10, comision);
		pat.setInt(11, idTrabajo);
		pat.execute();
	}

	public void insertHistoryTrabj(int idEmpleado, int idTrabajo, int idDepartamento, Date date, Date date2)
			throws SQLException {
		String sql = "INSERT INTO cthistorias_trabajos(id_empleado,id_trabajo,id_departamento,fecha_inicio,fecha_fin) VALUES (?,?,?,?,?);";
		java.sql.PreparedStatement pat = con.prepareStatement(sql);
		pat.setInt(1, idEmpleado);
		pat.setInt(2, idTrabajo);
		pat.setInt(3, idDepartamento);
		pat.setDate(4, (java.sql.Date) date);
		pat.setDate(5, (java.sql.Date) date2);
		pat.execute();
	}

	public void showPaises() throws SQLException {
		String sql = "SELECT * FROM ctpaises;";
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			addCountry(new Country(rs.getInt("id_pais"), rs.getInt("id_region"), rs.getString("nombre_pais")));
		}
	}

	public void showTrabajos() throws SQLException {
		String sql = "SELECT * FROM cttrabajos;";
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			addWork(new Work(rs.getInt("id_trabajo"), rs.getString("titulo_trabajo"), rs.getDouble("salario_minimo"),
					rs.getDouble("salario_maximo")));

		}
	}

	public void showDepartament() throws SQLException {
		String sql = "SELECT * FROM ctdepartamentos;";
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			addDepartament(new Departament(rs.getInt("id_departamento"), rs.getInt("id_supervisor"),
					rs.getInt("id_ubicacion"), rs.getString("nombre_departamento")));
		}
	}

	public void showRegiones() throws SQLException {
		String sql = "SELECT * FROM ctregiones;";
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			addRegion(new Region(rs.getInt("id_region"), rs.getString("nombre_region")));
		}
	}

	public void showEmploye() throws SQLException {
		String sql = "SELECT * FROM ctempleados;";
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			addEmploye(new Employee(rs.getInt("id_empleado"), rs.getInt("id_departamento"), rs.getInt("idtrab"),
					rs.getInt("id_supervisor"), rs.getString("nombre_empleado"), rs.getString("apellido_empleado"),
					rs.getString("email"), rs.getInt("telefono"), rs.getDate("fecha_contrato"), rs.getDouble("salario"),
					rs.getDouble("comision")));
		}
	}

	public void showPlWork(double valor) throws SQLException {
		// call bases1.pl_trabajos(200);
		String sql = "call bases1.pl_trabajos(" + valor + ");";
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			addWork(new Work(rs.getInt("id_trabajo"), rs.getString("titulo_trabajo"), rs.getDouble("salario_minimo"),
					rs.getDouble("salario_maximo")));

		}
		for (Work work : workList) {
			System.err.println(work.toString());
		}

	}

	public void showLocalitation() throws SQLException {
		String sql = "SELECT * FROM ctubicaciones;";
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			addLocalitation(new Localitation(rs.getInt("id_ubicacion"), rs.getInt("id_pais"), rs.getString("direccion"),
					rs.getInt("codigo_postal"), rs.getString("estado_provincia")));

		}
	}

	public void showHistoryWork() throws SQLException {
		String sql = "SELECT * FROM cthistorias_trabajos;";
		java.sql.Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			addHistoyWork(new HistoryWork(rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getInt("id_empleado"),
					rs.getInt("id_trabajo"), rs.getInt("id_departamento")));
		}
	}

	public void dropEMployee(int idEmployee) throws SQLException {
		String sql = "DELETE FROM ctempleados WHERE id_empleado =" + idEmployee;
		java.sql.Statement st = con.createStatement();
		st.executeUpdate(sql);

	}

	public void dropWork(int idWOrk) throws SQLException {
		String sql = "DELETE FROM cttrabajos WHERE id_trabajo =" + idWOrk;
		java.sql.Statement st = con.createStatement();
		st.executeUpdate(sql);

	}

	public void dropRegion(int idRegion) throws SQLException {
		String sql = "DELETE FROM ctregiones WHERE id_region =" + idRegion;
		java.sql.Statement st = con.createStatement();
		st.executeUpdate(sql);

	}

	public void dropLocalitation(int idLocalitation) throws SQLException {
		String sql = "DELETE FROM ctubicaciones WHERE id_ubicacion =" + idLocalitation;
		java.sql.Statement st = con.createStatement();
		st.executeUpdate(sql);

	}

	public void dropHistoryWork(int idHW) throws SQLException {
		String sql = "DELETE FROM cthistorias_trabajos WHERE id_empleado =" + idHW;
		java.sql.Statement st = con.createStatement();
		st.executeUpdate(sql);

	}

	public void dropDepartment(int idDepartment) throws SQLException {
		String sql = "DELETE FROM ctdepartamentos WHERE id_departamento =" + idDepartment;
		java.sql.Statement st = con.createStatement();
		st.executeUpdate(sql);

	}

	public void dropCountry(int idCountry) throws SQLException {
		String sql = "DELETE FROM ctregiones WHERE id_pais =" + idCountry;
		java.sql.Statement st = con.createStatement();
		st.executeUpdate(sql);

	}

	private void modifyEmployee(int idEmployee) {
		String sql = "UPDATE ctempleados  SET telefono='662142223' , email='albesanch@mimail.com'  WHERE id_empleado=idEmployee";
	}

	public void addEmploye(Employee employe) {
		employeeList.add(employe);
	}

	public void addWork(Work work) {
		workList.add(work);
	}

	public void addRegion(Region region) {
		regionList.add(region);
	}

	public void addLocalitation(Localitation localitation) {
		localitationList.add(localitation);
	}

	public void addHistoyWork(HistoryWork historyWork) {
		historyWorkList.add(historyWork);
	}

	public void addDepartament(Departament departament) {
		departamentList.add(departament);
	}

	public void addCountry(Country country) {
		countryList.add(country);
	}

	public void deleteEmployee(int idEmploye) {
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getIdEmployee() == idEmploye) {
				countryList.remove(i);
			}
		}
	}

	public void deleteWork(int idWork) {
		for (int i = 0; i < workList.size(); i++) {
			if (workList.get(i).getIdTrabajo() == idWork) {
				workList.remove(i);
			}
		}
	}

	public void deleteRegion(int idRegion) {
		for (int i = 0; i < regionList.size(); i++) {
			if (regionList.get(i).getIdRegion() == idRegion) {
				regionList.remove(i);
			}
		}
	}

	public void deleteLocalitation(int idLocalitation) {
		for (int i = 0; i < localitationList.size(); i++) {
			if (localitationList.get(i).getIdLocalitation() == idLocalitation) {
				localitationList.remove(i);
			}
		}
	}

	public void deleteDepartament(int idDepartament) {
		for (int i = 0; i < departamentList.size(); i++) {
			if (departamentList.get(i).getIdDepartament() == idDepartament) {
				departamentList.remove(i);
			}
		}
	}

	public void deleteCountrt(int idCountry) {
		for (int i = 0; i < countryList.size(); i++) {
			if (countryList.get(i).getIdPais() == idCountry) {
				countryList.remove(i);
			}
		}
	}

	public Employee searchEmploye(int idEmploye) {
		for (Employee employe : employeeList) {
			if (employe.getIdEmployee() == idEmploye) {
				return employe;
			}
		}
		return null;
	}

	public Work searchWork(int idWork) {
		for (Work work : workList) {
			if (work.getIdTrabajo() == idWork) {
				return work;
			}
		}
		return null;
	}

	public Region searchRegion(int idRegion) {
		for (Region region : regionList) {
			if (region.getIdRegion() == idRegion) {
				return region;
			}
		}
		return null;
	}

	public Localitation searchLocalitation(int idlocalitation) {
		for (Localitation localitation : localitationList) {
			if (localitation.getIdLocalitation() == idlocalitation) {
				return localitation;

			}
		}
		return null;
	}

	public Departament searchDepartament(int idDepartament) {
		for (Departament departament : departamentList) {
			if (departament.getIdDepartament() == idDepartament) {
				return departament;
			}
		}
		return null;
	}

	public Country searchCountry(int idCountry) {
		for (Country country : countryList) {
			if (country.getIdPais() == idCountry) {
				return country;
			}
		}
		return null;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public ArrayList<Work> getWorkList() {
		return workList;
	}

	public ArrayList<Region> getRegionList() {
		return regionList;
	}

	public ArrayList<Localitation> getLocalitationList() {
		return localitationList;
	}

	public ArrayList<HistoryWork> getHistoryWorkList() {
		return historyWorkList;
	}

	public ArrayList<Departament> getDepartamentList() {
		return departamentList;
	}

	public ArrayList<Country> getCountryList() {
		return countryList;
	}
}