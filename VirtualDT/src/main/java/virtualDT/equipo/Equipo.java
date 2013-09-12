package virtualDT.equipo;

import java.util.List;
import java.util.Vector;

public class Equipo {
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String nombreDelEquipo;
	private Integer puntaje = 0;
	private List<Jugador> jugadores = new Vector<Jugador>();
	private List<Formacion> formaciones = new Vector<Formacion>();
	private Formacion formacionActual;
	private int puntosAdquiridos;
	
	public Equipo() {// Hibernate ...
	}
	
	public Equipo(String n) {
		this.nombreDelEquipo = n;
	}
	
	public Equipo(String nombreDelEquipo, List<Jugador> jugadores){
		this.nombreDelEquipo = nombreDelEquipo;
		this.jugadores.addAll(jugadores);
		this.puntosAdquiridos = 0;
	}
	
	public int getPuntosAdquiridos() {
		return puntosAdquiridos;
	}

	public void setPuntosAdquiridos(int puntosAdquiridos) {
		this.puntosAdquiridos = puntosAdquiridos;
	}

	public int puntajeDeLaFormacion() {
		return this.formacionActual.puntajeFormacion();
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

	public Formacion getFormacionActual() {
		return formacionActual;
	}

	public void setFormacionActual(Formacion formacionActual) {
		this.formacionActual = formacionActual;
	}

	public void sumarPuntuacion(int i) {
		this.puntaje += i;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
}
