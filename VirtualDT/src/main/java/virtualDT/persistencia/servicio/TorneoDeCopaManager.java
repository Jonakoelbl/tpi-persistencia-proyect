package virtualDT.persistencia.servicio;

import java.util.List;

import virtualDT.equipo.Equipo;
import virtualDT.persistencia.daos.SessionManager;
import virtualDT.torneo.PartidoSimple;
import virtualDT.torneo.TorneoDeCopa;

public class TorneoDeCopaManager extends TorneoManager<TorneoDeCopa> {

	public TorneoDeCopaManager() {
		super(TorneoDeCopa.class);
	}

	@Override
	public void armarPartidos(final List<Equipo> equipos,final int id) {
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {

				TorneoDeCopa tdc = TorneoDeCopaManager.this.consultar(id);
				tdc.armarPartidos(equipos);
				
				return null;
			}
		});
	}

	@Override
	public void jugarTorneo(final int idTorneo) {
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				TorneoDeCopa tdc = TorneoDeCopaManager.this.consultar(idTorneo);
				tdc.jugarTorneo();
				
				return null;
			}
			
		});
	}
	
	
}
