package vitualDT.equipo;

import java.util.HashMap;
import java.util.Map;

public class Jugador {
	Map<Posicion,Integer> puntajeSegunPosicion = new HashMap<Posicion, Integer>();
	
	public Jugador(){
		//hibernate
	}
	
	public Jugador(int puntajeArquero, int puntajeDefensorCentral, int puntajeLateral, int puntajeMediocampista, int puntajeVolante, int puntajeCentrodelantero, int puntajeDelantero){
		this.puntajeSegunPosicion.put(Posicion.ARQUERO,puntajeArquero);
		this.puntajeSegunPosicion.put(Posicion.DEFENSORCENTRAL,puntajeDefensorCentral);
		this.puntajeSegunPosicion.put(Posicion.LATERAL,puntajeLateral);
		this.puntajeSegunPosicion.put(Posicion.MEDIOCAMPISTA,puntajeMediocampista);
		this.puntajeSegunPosicion.put(Posicion.VOLANTE,puntajeVolante);
		this.puntajeSegunPosicion.put(Posicion.CENTRODELANTERO,puntajeCentrodelantero);
		this.puntajeSegunPosicion.put(Posicion.DELANTERO,puntajeDelantero);
	}

	public Map<Posicion, Integer> getPuntajeSegunPosicion() {
		return puntajeSegunPosicion;
	}

	public void setPuntajeSegunPosicion(Map<Posicion, Integer> puntajeSegunPosicion) {
		this.puntajeSegunPosicion = puntajeSegunPosicion;
	}
	
	public int puntajeDeJugadorEnPosicion(Posicion p){
		return (this.getPuntajeSegunPosicion().get(p));
	}
}