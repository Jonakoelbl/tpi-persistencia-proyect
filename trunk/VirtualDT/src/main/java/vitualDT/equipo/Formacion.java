package vitualDT.equipo;

import java.util.List;
import java.util.Vector;

public class Formacion {
	private List<Jugador> jugadores = new Vector<Jugador>();
	
	public Formacion() { // Hibernate ...
	}
	
	public Formacion(List<Jugador> jugadores){
		this.jugadores.addAll(jugadores);
	}
	
	//TODO calcular el puntaje
}
