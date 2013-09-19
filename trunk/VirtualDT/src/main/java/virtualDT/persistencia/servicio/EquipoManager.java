package virtualDT.persistencia.servicio;

import virtualDT.equipo.Equipo;
import virtualDT.equipo.Formacion;
import virtualDT.persistencia.daos.SessionManager;

public class EquipoManager extends Manager<Equipo>{

	
	public EquipoManager() {
		super(Equipo.class, "nombreDelEquipo");
	}

	public void guardarFormacion(final String criterio, final Formacion formacion){
		final Equipo eq = this.consultar(criterio);
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				eq.agregarFormacion(formacion);
				SessionManager.getSession().saveOrUpdate(eq);
				return null;
			}
		});
	}
}
