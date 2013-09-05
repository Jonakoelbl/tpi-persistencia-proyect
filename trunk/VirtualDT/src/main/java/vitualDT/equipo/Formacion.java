package vitualDT.equipo;

import java.util.HashMap;
import java.util.Map;

public class Formacion {
	Map<Jugador,Posicion> jugadoresConPosiciones= new HashMap<Jugador, Posicion>();


	public Formacion() { // Hibernate ...
	}
	
	
	/*public Formacion(List<Jugador> jugadores){
		this.jugadores.addAll(jugadores);
	}

	 */
	
	public int puntajeFormacion(){
		int puntajeTotal = 0;
		for(Jugador j : this.getJugadoresConPosiciones().keySet()){
			puntajeTotal = puntajeTotal + j.puntajeDeJugadorEnPosicion(this.getJugadoresConPosiciones().get(j));
		}
		return puntajeTotal;
	}
	
	public Map<Jugador, Posicion> getJugadoresConPosiciones() {
		return jugadoresConPosiciones;
	}
	
	public void setJugadoresConPosiciones(Map<Jugador, Posicion> jugadoresConPosiciones) {
		this.jugadoresConPosiciones = jugadoresConPosiciones;
	}
}
