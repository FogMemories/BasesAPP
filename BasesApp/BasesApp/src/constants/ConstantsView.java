package constants;

public class ConstantsView {
	
	public static String[] headers_regiones = {"id region", "nombre_region"};
	public static String[] headers_paises = {"idCountry","idRegion", "namePais"};
	public static String[] headers_trabajos = {"idTrabajo", "tituloTrabajo","salarioMinimo","salarioM"};
	public static String[] headers_ubicaciones = {"idLocalitation", "idPais","direccion","codigoPostal","estadoProvincia"};
	public static String[] headers_departamentos = {"idDepartament", "idSupervisor","idLocalitation","nameDepartament"};
	public static String[] headers_empleados = {"idEmployee", "idDepartament","idWork","idSupervisor","nameEmploye","lastName","email","phone","dateContract","salario","comision"};
	public static String[] headers_historias_trabajos = {"dateStart", "dateFinish","idEmploye","idWork","idDepartament"};
}
