package virtualDT.persistencia.servicio;

import virtualDT.equipo.Equipo;
import virtualDT.equipo.Formacion;
import virtualDT.persistencia.daos.SessionManager;

public class EquipoManager extends Manager<Equipo>{

	
	public EquipoManager() {
		super(Equipo.class, "nombreDelEquipo");
	}

	public void guardarFormacion(final String nombreEquipo, final Formacion formacion){
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				Equipo eq = EquipoManager.this.consultar(nombreEquipo);
				eq.agregarFormacion(formacion);
				SessionManager.getSession().saveOrUpdate(eq);
				return null;
			}
		});
	}
}
