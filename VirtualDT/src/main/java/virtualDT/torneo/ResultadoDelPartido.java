package virtualDT.torneo;

public class ResultadoDelPartido implements TipoResultado {
	private Resultado resultado;
	private String equipoGanador;
	
	public ResultadoDelPartido() {//Hibernate
	}
	
	public ResultadoDelPartido(String equipoGanador, Resultado resultado){
		this.equipoGanador = equipoGanador;
		this.resultado = resultado;
	}
	
	public String getEquipoGanador() {
		return equipoGanador;
	}

	public void setEquipoGanador(String equipoGanador) {
		this.equipoGanador = equipoGanador;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	
}
