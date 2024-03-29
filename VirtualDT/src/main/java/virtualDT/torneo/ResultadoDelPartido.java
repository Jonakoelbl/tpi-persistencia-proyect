package virtualDT.torneo;

import virtualDT.equipo.Equipo;

public class ResultadoDelPartido implements TipoResultado {
	private Resultado resultado;
	private Equipo equipoGanador;
	private int id;
	
	public ResultadoDelPartido() {//Hibernate
	}
	
	public ResultadoDelPartido(Equipo equipoGanador, Resultado resultado){
		this.equipoGanador = equipoGanador;
		this.resultado = resultado;
	}
	
	public Equipo getEquipoGanador() {
		return equipoGanador;
	}

	public void setEquipoGanador(Equipo equipoGanador) {
		this.equipoGanador = equipoGanador;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
