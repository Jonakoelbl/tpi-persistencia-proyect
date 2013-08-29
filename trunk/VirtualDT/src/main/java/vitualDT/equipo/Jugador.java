package vitualDT.equipo;

import java.util.HashMap;
import java.util.Map;

public class Jugador {
	Map<String,Integer> puntajeSegunPosicion = new HashMap<String, Integer>();
	
	public Jugador(){
		//hibernate
	}
	
	public Jugador(int puntajeArquero, int puntajeDefensorCentral, int puntajeLateral, int puntajeMediocampista, int puntajeVolante, int puntajeCentrodelantero, int puntajeDelantero){
		this.puntajeSegunPosicion.put("arquero",puntajeArquero);
		this.puntajeSegunPosicion.put("defensorCentral",puntajeDefensorCentral);
		this.puntajeSegunPosicion.put("lateral",puntajeLateral);
		this.puntajeSegunPosicion.put("mediocampista",puntajeMediocampista);
		this.puntajeSegunPosicion.put("volante",puntajeVolante);
		this.puntajeSegunPosicion.put("centroDelantero",puntajeCentrodelantero);
		this.puntajeSegunPosicion.put("delantero",puntajeDelantero);
	}

	public Map<String, Integer> getPuntajeSegunPosicion() {
		return puntajeSegunPosicion;
	}

	public void setPuntajeSegunPosicion(Map<String, Integer> puntajeSegunPosicion) {
		this.puntajeSegunPosicion = puntajeSegunPosicion;
	}
}