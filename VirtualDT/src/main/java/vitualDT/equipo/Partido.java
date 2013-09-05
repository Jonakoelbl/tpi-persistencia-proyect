package vitualDT.equipo;

import virtualDT.torneo.ResultadoPartido;


public class Partido {
	Formacion equipoLocal;
	Formacion equipoVisitante;
	
	public Partido(){
		//hibernate
	}
	
	public Partido(Formacion elEquipo1, Formacion elEquipo2){
		this.equipoLocal = elEquipo1;
		this.equipoVisitante = elEquipo2;
	}
	
	
	private int puntajeDeEquipoMasXPorCiento(Formacion f,int n){
		return (f.puntajeFormacion() + (f.puntajeFormacion() * n)/100);
	}
	
	private double multiplicarConRandom(int n){
		return n * ((Math.random()* 0.2) + 0.9);
	}
	
	private boolean leGano(Formacion e1, Formacion e2,int porcentaje){
		return multiplicarConRandom(e1.puntajeFormacion()) - multiplicarConRandom(puntajeDeEquipoMasXPorCiento(e2,porcentaje)) > 0;
	}
		
	public ResultadoPartido jugarYDevolverGanador(){
		if(this.leGano(this.equipoLocal, this.equipoVisitante,15)){
			return ResultadoPartido.LOCAL;
		} else if (this.leGano(this.equipoVisitante,this.equipoLocal,20)){
			return ResultadoPartido.VISITANTE;
		} else {
			return ResultadoPartido.EMPATE;
		}
	}

	protected Formacion getEquipoLocal() {
		return equipoLocal;
	}

	protected void setEquipoLocal(Formacion equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	protected Formacion getEquipoVisitante() {
		return equipoVisitante;
	}

	protected void setEquipoVisitante(Formacion equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
}
