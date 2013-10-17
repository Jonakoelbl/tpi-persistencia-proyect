package virtualDT.torneo;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import virtualDT.equipo.Equipo;

public class TorneoDeCopa extends Torneo<Resultado, PartidoDeCopa> {

	public TorneoDeCopa() {	}

	public void armarPartidos(List<Equipo> equipos) {
		List<PartidoDeCopa> partidos = new Vector<PartidoDeCopa>();

		Iterator<Equipo> equiposParaArmar = equipos.iterator();
		while(equiposParaArmar.hasNext()) {
			Equipo unirEquipo = equiposParaArmar.next();
			Iterator<Equipo> equiposParaAsociar = equipos.iterator();
			while(equiposParaAsociar.hasNext()){
				Equipo equipo = equiposParaAsociar.next();
				partidos.add(new PartidoDeCopa(new PartidoSimple(equipo,unirEquipo), 
								new PartidoSimple(unirEquipo, equipo)));
			}
		}//TODO ver bien la idea...
		
		this.partidos = partidos;
	}
}
