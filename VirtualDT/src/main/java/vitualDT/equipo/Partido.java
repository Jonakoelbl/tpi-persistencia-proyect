package vitualDT.equipo;

import java.util.Random;

public class Partido {
	Formacion e1;
	Formacion e2;
	
	
	public Formacion getE1() {
		return e1;
	}

	public void setE1(Formacion e1) {
		this.e1 = e1;
	}

	public Formacion getE2() {
		return e2;
	}

	public void setE2(Formacion e2) {
		this.e2 = e2;
	}

	public Partido(){
		//hibernate
	}
	
	public Partido(Formacion elEquipo1, Formacion elEquipo2){
		this.e1 = elEquipo1;
		this.e2 = elEquipo2;
	}
	
	
	private int puntajeDeEquipoMasXPorCiento(Formacion f,int n){
		return (f.puntajeFormacion() + (f.puntajeFormacion() * n)/100);
	}
	
	private double multiplicarConRandom(int n){
		return n * Math.random()*(0.9-1.3)+1.3;
	}
	
	private boolean leGano(Formacion e1, Formacion e2,int porcentaje){
		return multiplicarConRandom(e1.puntajeFormacion()) - multiplicarConRandom(puntajeDeEquipoMasXPorCiento(e2,porcentaje)) > 0;
	}
	
	public String jugarYDevolverGanador(){
		String ganador;
		if(leGano(this.getE1(), this.getE2(),15)){
			ganador = "Local";
		} else if (leGano(this.getE2(),this.getE1(),20)){
			ganador = "Visitante";
		} else {
			ganador = "Empate";
		}
		return ganador;
	}
}
