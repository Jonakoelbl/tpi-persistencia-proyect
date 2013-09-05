package vitualDT.equipo;


public class Partido {
	Formacion equipoA;
	Formacion equipoB;
	
	
	public Formacion getEquipoA() {
		return equipoA;
	}

	public void setEquipoA(Formacion e1) {
		this.equipoA = e1;
	}

	public Formacion getEquipoB() {
		return equipoB;
	}

	public void setEquipoB(Formacion e2) {
		this.equipoB = e2;
	}

	public Partido(){
		//hibernate
	}
	
	public Partido(Formacion elEquipo1, Formacion elEquipo2){
		this.equipoA = elEquipo1;
		this.equipoB = elEquipo2;
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
	
	public String jugarYDevolverGanador(){
		String ganador;
		if(this.leGano(this.equipoA, this.equipoB,15)){
			ganador = "Local";
		} else if (this.leGano(this.equipoB,this.equipoA,20)){
			ganador = "Visitante";
		} else {
			ganador = "Empate";
		}
		return ganador;
	}
}
