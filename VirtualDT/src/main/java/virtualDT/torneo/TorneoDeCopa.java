package virtualDT.torneo;

import java.util.List;
import java.util.Vector;

import virtualDT.equipo.Equipo;

public class TorneoDeCopa extends Torneo<Resultado, PartidoDeCopa> {

	public TorneoDeCopa() {	}

	public void armarPartidos(List<Equipo> equipos) {
		List<PartidoDeCopa> partidos = new Vector<PartidoDeCopa>();

		List<Equipo> equiposParaArmar = new Vector<Equipo>(equipos);
		for (Equipo equipo : equiposParaArmar) {
			for (Equipo equipoA : equiposParaArmar) {
				partidos.add(new PartidoDeCopa(new PartidoSimple(equipo,equipoA), 
								new PartidoSimple(equipoA, equipo)));
			}
		}//TODO ver bien la idea...
		
		this.partidos = partidos;
	}
}
