package virtualDT.equipo;

import virtualDT.torneo.TipoResultado;

public interface Partido<E extends TipoResultado> {
	
	public E jugarPartido();

}
