package models;

import java.util.Date;

public class HistoryWork {

	public Date dateStart;
	public Date dateFinish;
	public int idEmploye;
	public int idWork;
	public int idDepartament;
	public HistoryWork(Date dateStart, Date dateFinish, int idEmploye, int idWork,int idDepartament) {

		this.dateStart = dateStart;
		this.dateFinish = dateFinish;
		this.idEmploye = idEmploye;
		this.idWork = idWork;
		this.idDepartament = idDepartament;
	}
	
	public Object[] toObjectVector(){
		return new Object[] {dateStart, dateFinish,idEmploye,idWork,idDepartament};
	}

	public Date getDateFinish() {
		return dateFinish;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public int getIdDepartament() {
		return idDepartament;
	}
	
	public int getIdEmploye() {
		return idEmploye;
	}

	public int getIdWork() {
		return idWork;
	}
}