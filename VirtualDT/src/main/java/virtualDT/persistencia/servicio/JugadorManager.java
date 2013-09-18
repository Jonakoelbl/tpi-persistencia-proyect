package virtualDT.persistencia.servicio;

import virtualDT.equipo.Jugador;
import virtualDT.persistencia.daos.ManagerDAO;
import virtualDT.persistencia.daos.SessionManager;

public class JugadorManager implements ManagerDAO<Jugador>{

	public Jugador consultar(final int id) {
		return SessionManager.runInSession(new Operation<Jugador>() {

			public Jugador execute() {
				return (Jugador)SessionManager.getSession().get(Jugador.class,id);
			}
		});
	}

	public void crear(final Jugador j) {
		SessionManager.runInSession(new Operation<Void>(){

			public Void execute() {
				SessionManager.getSession().saveOrUpdate(j);
				return null;
			}
			
		});
	}

	public void eliminar(final Jugador j) {
		SessionManager.runInSession(new Operation<Void>() {
			public Void execute() {
				SessionManager.getSession().delete(j);
				return null;
			}
		});
	}

}
