package virtualDT.persistencia.servicio;

import virtualDT.equipo.Equipo;
import virtualDT.persistencia.daos.ManagerDAO;
import virtualDT.persistencia.daos.SessionManager;

public class EquipoManager implements ManagerDAO<Equipo>{

	public Equipo consultar(final int id){
		return SessionManager.runInSession(new Operation<Equipo>() {

			public Equipo execute() {
				return (Equipo)SessionManager.getSession().get(Equipo.class,id);
			}
		});
	}
	
	public void crear(final Equipo equipo){
		SessionManager.runInSession(new Operation<Void>(){

			public Void execute() {
				SessionManager.getSession().saveOrUpdate(equipo);
				return null;
			}
			
		});
	}
	
	public void eliminar(final Equipo equipo){
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				SessionManager.getSession().delete(equipo);
				return null;
			}
		});
	}
}
