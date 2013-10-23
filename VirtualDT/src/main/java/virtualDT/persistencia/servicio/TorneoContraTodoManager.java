package virtualDT.persistencia.servicio;

import java.util.List;

import virtualDT.equipo.Equipo;
import virtualDT.persistencia.daos.SessionManager;
import virtualDT.torneo.TorneoContraTodo;

public class TorneoContraTodoManager extends TorneoManager<TorneoContraTodo>{

	
	public TorneoContraTodoManager() {
		super(TorneoContraTodo.class);
	}

	@Override
	public void armarPartidos(final List<Equipo> equipos,final int id) {
		SessionManager.runInSession(new Operation<Void>() {
			
			public Void execute() {
				TorneoContraTodo tct = TorneoContraTodoManager.this.consultar(id);
				tct.armarPartidos(equipos);
				
				return null;
			}
		});
		
	}

	@Override
	public void jugarTorneo(final int idTorneo) {
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				TorneoContraTodo tct = TorneoContraTodoManager.this.consultar(idTorneo);
				tct.jugarTorneo();
				
				return null;
			}
		});
	}
}
