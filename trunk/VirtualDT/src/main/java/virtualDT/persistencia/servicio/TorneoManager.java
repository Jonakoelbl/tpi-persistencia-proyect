package virtualDT.persistencia.servicio;

import java.util.List;

import virtualDT.equipo.Equipo;

public abstract class TorneoManager<T> extends Manager<T> {

	public TorneoManager(Class<T> clazz) {
		super(clazz, "id");
	}

	public abstract void jugarTorneo(final int idTorneo);

	public abstract void armarPartidos(final List<Equipo> equipos, final int id);	
}
