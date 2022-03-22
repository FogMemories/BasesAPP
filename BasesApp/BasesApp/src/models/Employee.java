package models;

import java.util.Date;

public class Employee {

	public int idEmployee;
	public int idDepartament;
	public int idWork;
	public int idSupervisor;
	public String nameEmploye;
	public String lastName;
	public String email;
	public int phone;
	public Date dateContract;
	public double salario;
	public double comision;
	
	public Employee(int idEmployee, int idDepartament, int idWork, int idSupervisor, String nameEmploye,
			String lastName, String email, int phone, Date dateContract,double salario,double comision) {
		
		this.idEmployee = idEmployee;
		this.idDepartament = idDepartament;
		this.idWork = idWork;
		this.idSupervisor = idSupervisor;
		this.nameEmploye = nameEmploye;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.dateContract = dateContract;
		this.salario = salario;
		this.comision = comision;
	}
	
	public Object[] toObjectVector(){
		return new Object[] {idEmployee, idDepartament,idWork,idSupervisor,nameEmploye,lastName,email,phone,dateContract,salario,comision};
	}

	public Date getDateContract() {
		return dateContract;
	}

	public String getEmail() {
		return email;
	}

	public int getIdDepartament() {
		return idDepartament;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public int getIdSupervisor() {
		return idSupervisor;
	}

	public int getIdWork() {
		return idWork;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNameEmploye() {
		return nameEmploye;
	}

	public int getPhone() {
		return phone;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public double getComision() {
		return comision;
	}

	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + ", idDepartament=" + idDepartament + ", idWork=" + idWork
				+ ", idSupervisor=" + idSupervisor + ", nameEmploye=" + nameEmploye + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", dateContract=" + dateContract + ", salario=" + salario
				+ ", comision=" + comision + "]";
	}
	
}
