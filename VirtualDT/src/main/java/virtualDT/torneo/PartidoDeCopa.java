package virtualDT.torneo;

import vitualDT.equipo.Partido;

public class PartidoDeCopa {
	private Partido PartidoA, PartidoB;
	
	public PartidoDeCopa(Partido partidoA, Partido partidoB) {
		this.PartidoA = partidoA;
		this.PartidoB = partidoB;
	}
	
	public ResultadoPartido jugarPartido(){
		ResultadoPartido resultadoPartidoA = this.PartidoA.jugarYDevolverGanador();
		ResultadoPartido resultadoPartidoB = this.PartidoB.jugarYDevolverGanador();
		
		return this.resultadoDelPartido(resultadoPartidoA, resultadoPartidoB);
	}
	
	protected ResultadoPartido resultadoDelPartido(ResultadoPartido resultadoA, ResultadoPartido resultadoB){
		
		if(resultadoA == resultadoB && resultadoA != ResultadoPartido.EMPATE && resultadoB != ResultadoPartido.EMPATE){
				return resultadoA;
		}else if(resultadoA != resultadoB){
			if(resultadoB != ResultadoPartido.EMPATE)
				return resultadoA;
			else
				return this.pasarAPenales();
		}else if(resultadoA == ResultadoPartido.EMPATE){
			return resultadoB;
		}else{
			return this.pasarAPenales();
		}
	}
	
	protected ResultadoPartido pasarAPenales(){
		int match = (int) Math.random();
		if(match > 1)
			return ResultadoPartido.LOCAL;
		else
			return ResultadoPartido.VISITANTE;
	}
}
