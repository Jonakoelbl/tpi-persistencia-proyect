package virtualDT.torneo;

import java.util.List;
import java.util.Vector;

import virtualDT.equipo.Equipo;
import virtualDT.equipo.Partido;

public abstract class Torneo<R extends TipoResultado, T extends Partido<R>> {
	protected  List<T> partidos = new Vector<T>();
	protected List<R> resultados = new Vector<R>();
	protected int id;
	
	public void jugarTorneo() {
		for (T partido : this.partidos) {
			this.resultados.add(partido.jugarPartido());
		}
	}
	
	public abstract void armarPartidos(List<Equipo> equipos);

	public List<T> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<T> partidos) {
		this.partidos = partidos;
	}

	public List<R> getResultados() {
		return resultados;
	}

	public void setResultados(List<R> resultados) {
		this.resultados = resultados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
