package virtualDT.torneo;

import java.util.List;
import java.util.Vector;


public class TorneoDeCopa extends Torneo{
	private List<PartidoDeCopa> partidosDeCopa = new Vector<PartidoDeCopa>();
	private List<ResultadoPartido> resultadosDelPartido = new Vector<ResultadoPartido>();
	
	@Override
	public void jugarTorneo() {
		for (PartidoDeCopa partido : this.partidosDeCopa) {
			resultadosDelPartido.add(partido.jugarPartido());
		}
	}

	protected List<PartidoDeCopa> getPartidosDeCopa() {
		return partidosDeCopa;
	}

	protected void setPartidosDeCopa(List<PartidoDeCopa> partidosDeCopa) {
		this.partidosDeCopa = partidosDeCopa;
	}

	protected List<ResultadoPartido> getResultadosDelPartido() {
		return resultadosDelPartido;
	}

	protected void setResultadosDelPartido(
			List<ResultadoPartido> resultadosDelPartido) {
		this.resultadosDelPartido = resultadosDelPartido;
	}
}
