package vitualDT.equipo;

import java.util.List;
import java.util.Vector;

public class Equipo {
	private String nombreDelEquipo;
	private List<Jugador> jugadores = new Vector<Jugador>();
	private List<Formacion> formaciones = new Vector<Formacion>();
	
	public Equipo() {// Hibernate ...
	}
	
	public Equipo(String nombreDelEquipo, List<Jugador> jugadores){
		this.nombreDelEquipo = nombreDelEquipo;
		this.jugadores.addAll(jugadores);
	}

	public void agregarFormacion(Formacion formacion){
		this.formaciones.add(formacion);
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public String getNombreDelEquipo() {
		return nombreDelEquipo;
	}

	public void setNombreDelEquipo(String nombreDelEquipo) {
		this.nombreDelEquipo = nombreDelEquipo;
	}

	public List<Formacion> getFormaciones() {
		return formaciones;
	}

	public void setFormaciones(List<Formacion> formaciones) {
		this.formaciones = formaciones;
	}

	public int puntajeSegunFormacion() {
		// TODO Auto-generated method stub
		return 0;
	}
}
