package org.caucotafederico.prode;
import com.opencsv.bean.*;

public class Pronostico {

	@CsvBindByPosition (position = 0)
	private String equipo1;

	@CsvBindByPosition (position = 1)
	private String ganaLocal;

	@CsvBindByPosition (position = 2)
	private String empate;

	@CsvBindByPosition (position = 3)
	private String ganaVisitante;

	@CsvBindByPosition (position = 4)
	private String equipo2;
	
	
	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public String getGanaLocal() {
		return ganaLocal;
	}

	public void setGanaLocal(String ganaLocal) {
		this.ganaLocal = ganaLocal;
	}

	public String getEmpate() {
		return empate;
	}

	public void setEmpate(String empate) {
		this.empate = empate;
	}

	public String getGanaVisitante() {
		return ganaVisitante;
	}

	public void setGanaVisitante(String ganaVisitante) {
		this.ganaVisitante = ganaVisitante;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}

}
