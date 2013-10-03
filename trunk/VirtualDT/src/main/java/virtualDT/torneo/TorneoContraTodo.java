package virtualDT.torneo;

import java.util.List;

import virtualDT.equipo.Equipo;

public class TorneoContraTodo extends Torneo<ResultadoDelPartido, PartidoSimple>{
	
	public TorneoContraTodo() {//Hibernate....
	}
	
	public TorneoContraTodo(List<PartidoSimple> partidos){
		this.partidos = partidos;
	}
	
	public void armarPartidos(List<Equipo> equipos){
		//TODO armar partidos para los torneos de todos contra todos
	}
	
}
