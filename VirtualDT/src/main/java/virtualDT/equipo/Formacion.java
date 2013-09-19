package virtualDT.equipo;
import java.util.HashMap;
import java.util.Map;

public class Formacion {
	private Map<Jugador,Posicion> jugadoresConPosiciones= new HashMap<Jugador, Posicion>();
	private int id; 

	public Formacion() { // Hibernate ...
	}
	
	public Formacion(Map<Jugador,Posicion> jcp){
		this.jugadoresConPosiciones = jcp;
	}
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
