package virtualDT.torneo;

import virtualDT.equipo.Equipo;
import virtualDT.equipo.Formacion;
import virtualDT.equipo.Partido;


public class PartidoSimple implements Partido<ResultadoDelPartido> {
	private Equipo equipoLocal, equipoVisitante;
	
	public PartidoSimple(){
		//hibernate
	}
	
	public PartidoSimple(Equipo elEquipo1, Equipo elEquipo2){
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
		
	public ResultadoDelPartido jugarPartido(){
		if(this.leGano(this.equipoLocal.getFormacionActual(), this.equipoVisitante.getFormacionActual(),15)){
			this.equipoLocal.sumarPuntuacion(3);
			return new ResultadoDelPartido(this.equipoLocal.getNombreDelEquipo(), Resultado.LOCAL);
		} else if (this.leGano(this.equipoVisitante.getFormacionActual(),this.equipoLocal.getFormacionActual(),20)){
			this.equipoVisitante.sumarPuntuacion(3);
			return new ResultadoDelPartido(this.equipoVisitante.getNombreDelEquipo(), Resultado.VISITANTE);
		} else {
			this.equipoLocal.sumarPuntuacion(1);
			this.equipoVisitante.sumarPuntuacion(1);
			return new ResultadoDelPartido("", Resultado.EMPATE);//No me gusta...
		}
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}	
}
