package virtualDT.torneo;

import java.util.List;
import java.util.Vector;

import vitualDT.equipo.Partido;

public class TorneoContraTodo extends Torneo{
	
	private List<Partido> partidos = new Vector<Partido>();
	private List<ResultadoDelPartido> resultados= new Vector<ResultadoDelPartido>();
	
	public TorneoContraTodo() {//Hibernate....
	}
	
	public TorneoContraTodo(List<Partido> partidos){
		this.partidos = partidos;
	}
	
	@Override
	public void jugarTorneo() {
		for (Partido partido : this.partidos) {
			this.resultados.add(partido.jugarYDevolverGanador());
		}
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public List<ResultadoDelPartido> getResultados() {
		return resultados;
	}

	public void setResultados(List<ResultadoDelPartido> resultados) {
		this.resultados = resultados;
	}
	
	
}
