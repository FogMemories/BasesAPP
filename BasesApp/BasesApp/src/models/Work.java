package models;

public class Work {

	public int idTrabajo;
	public String tituloTrabajo;
	public double salarioMinimo;
	public double salarioM;

	public Work(int idTrabajo, String tituloTrabajo, double salarioMinimo, double salarioMaxiomo) {
		this.idTrabajo = idTrabajo;
		this.tituloTrabajo = tituloTrabajo;
		this.salarioMinimo = salarioMinimo;
		this.salarioM = salarioMaxiomo;
	}	
	
	public Object[] toObjectVector(){
		return new Object[] {idTrabajo, tituloTrabajo,salarioMinimo,salarioM};
	}
	
	public int getIdTrabajo() {
		return idTrabajo;
	}

	public double getSalarioM() {
		return salarioM;

	}
	public double getSalarioMinimo() {
		return salarioMinimo;
	}

	public String getTituloTrabajo() {
		return tituloTrabajo;
	}

	@Override
	public String toString() {
		return "Work [idTrabajo=" + idTrabajo + ", tituloTrabajo=" + tituloTrabajo + ", salarioMinimo=" + salarioMinimo
				+ ", salarioM=" + salarioM + "]";
	}
	
}

