package virtualDT.torneo;

import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;

import virtualDT.equipo.Equipo;

public class TorneoContraTodo extends Torneo<ResultadoDelPartido, PartidoSimple>{
	
	public TorneoContraTodo() {}
	
	public TorneoContraTodo(List<PartidoSimple> partidos){
		this.partidos = partidos;
	}
	
	public void armarPartidos(List<Equipo> equipos){
		List<PartidoSimple> partidos = new Vector<PartidoSimple>();
		
		Queue<Equipo> equiposParaArmar = new ArrayBlockingQueue<Equipo>(equipos.size());
		equiposParaArmar.addAll(equipos);
		while (!equiposParaArmar.isEmpty()) {
			Equipo unirEquipo = equiposParaArmar.poll();
			
			for (Equipo equipo : equiposParaArmar) {
				partidos.add(new PartidoSimple(unirEquipo, equipo));
			}
		}
		this.partidos = partidos;
	}
}
