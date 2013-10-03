package virtualDT.torneo;

import virtualDT.equipo.Partido;

public class PartidoDeCopa implements Partido<Resultado> {
	private PartidoSimple partidoA, partidoB;
	private int id;

	public PartidoDeCopa(PartidoSimple partidoA, PartidoSimple partidoB) {
		this.partidoA = partidoA;
		this.partidoB = partidoB;
	}

	/**
	 * Devuelve el ganador del partido
	 */
	public Resultado jugarPartido() {
		ResultadoDelPartido resultadoPartidoA = this.partidoA.jugarPartido();
		ResultadoDelPartido resultadoPartidoB = this.partidoB.jugarPartido();

		return this.resultadoDelPartido(resultadoPartidoA.getResultado(),
				resultadoPartidoB.getResultado());
	}

	protected Resultado resultadoDelPartido(Resultado resultadoA,
			Resultado resultadoB) {

		if (resultadoA == resultadoB && resultadoA != Resultado.EMPATE
				&& resultadoB != Resultado.EMPATE) {
			return resultadoA;
		} else if (resultadoA != resultadoB) {
			if (resultadoB != Resultado.EMPATE)
				return resultadoA;
			else
				return this.pasarAPenales();
		} else if (resultadoA == Resultado.EMPATE) {
			return resultadoB;
		} else {
			return this.pasarAPenales();
		}
	}

	protected Resultado pasarAPenales() {
		int match = (int) Math.random();
		if (match > 1)
			return Resultado.LOCAL;
		else
			return Resultado.VISITANTE;
	}

	public PartidoSimple getPartidoA() {
		return partidoA;
	}

	public void setPartidoA(PartidoSimple partidoA) {
		this.partidoA = partidoA;
	}

	public PartidoSimple getPartidoB() {
		return partidoB;
	}

	public void setPartidoB(PartidoSimple partidoB) {
		this.partidoB = partidoB;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
