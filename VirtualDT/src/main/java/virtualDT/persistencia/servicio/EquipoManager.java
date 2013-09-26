package virtualDT.persistencia.servicio;

import java.util.Map;

import virtualDT.equipo.Equipo;
import virtualDT.equipo.Formacion;
import virtualDT.equipo.Jugador;
import virtualDT.equipo.Posicion;
import virtualDT.persistencia.daos.SessionManager;

public class EquipoManager extends Manager<Equipo>{

	
	public EquipoManager() {
		super(Equipo.class, "nombreDelEquipo");
	}

	public void guardarFormacion(final String nombreEquipo, final Formacion formacion){
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				//Guarda todos los jugadores
				for (Map.Entry<Jugador, Posicion> lugarDeCancha : formacion.getJugadoresConPosiciones().entrySet())
					SessionManager.getSession().saveOrUpdate(lugarDeCancha.getKey());

				//Guarda la formacion
				Equipo eq = EquipoManager.this.consultar(nombreEquipo);
				eq.agregarFormacion(formacion);				
				return null;
			}
		});
	}
	
	public void guardarFormacionActual(final String nombreEquipo, final Formacion formacion){
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				Equipo eq = EquipoManager.this.consultar(nombreEquipo);
				eq.setFormacionActual(formacion);
				return null;
			}
		});
	}
}
