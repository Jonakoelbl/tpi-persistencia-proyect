package virtualDT.torneo;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import virtualDT.equipo.Equipo;

public class TorneoContraTodo extends Torneo<ResultadoDelPartido, PartidoSimple>{
	
	public TorneoContraTodo() {}
	
	public TorneoContraTodo(List<PartidoSimple> partidos){
		this.partidos = partidos;
	}
	
	public void armarPartidos(List<Equipo> equipos){
		List<PartidoSimple> partidos = new Vector<PartidoSimple>();
		
		Iterator<Equipo> equiposParaRecorrer = equipos.iterator() ;
		while (equiposParaRecorrer.hasNext()) {
			Equipo equipoA = (Equipo) equiposParaRecorrer.next();
			Iterator<Equipo> equiposAJugar = equiposParaRecorrer;
			
			while(equiposAJugar.hasNext()){
				Equipo equipoB = (Equipo) equiposAJugar.next();
				partidos.add(new PartidoSimple(equipoA, equipoB));
			}
		}
		this.partidos = partidos;
	}
}
