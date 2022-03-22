package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql {


	public static final String driver = "com.mysql.jdbc.Driver" ;
	public static final String user = "root";
	public static final String pasword = "root";
	public static final String url = "jdbc:mysql://localhost:3306/bases1";
	public Connection conexion = null; 
	

	public MySql() throws SQLException {
		Conexion();
	}

	public Connection Conexion() throws SQLException {

		try {
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url, user, pasword);
			if (conexion != null) {
				System.out.println("conexion establecida");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("error al conectar: "+ e);
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return conexion;
	}

	public void desconectar() {

	}
}
