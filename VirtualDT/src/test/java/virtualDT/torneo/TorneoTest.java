package virtualDT.torneo;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import virtualDT.equipo.Equipo;
import virtualDT.equipo.Jugador;
import virtualDT.persistencia.servicio.EquipoManager;
import virtualDT.persistencia.servicio.TorneoContraTodoManager;
import virtualDT.persistencia.servicio.TorneoDeCopaManager;

public class TorneoTest {

	TorneoContraTodoManager tct = new TorneoContraTodoManager();
	TorneoDeCopaManager tdc = new TorneoDeCopaManager();
	List<Equipo> equiposA = new Vector<Equipo>();
	List<Jugador> jugadoresA = new Vector<Jugador>(),
			jugadoresB = new Vector<Jugador>(),
			jugadoresC = new Vector<Jugador>(),
			jugadoresE = new Vector<Jugador>();

	@Before
	public void setUp() {
		jugadoresA.add(new Jugador("Pepito", 2, 3, 4, 5, 6, 2, 4));
		jugadoresA.add(new Jugador("Sultano", 3, 4, 5, 1, 2, 2, 3));
		jugadoresA.add(new Jugador("Melgano", 1, 2, 1, 5, 6, 7, 9));
	}

	@Test
	public void armadoDeLosPartidos() {
		equiposA.add(new Equipo("Lambda", jugadoresA));
		equiposA.add(new Equipo("Complemento a 2", jugadoresB));
		equiposA.add(new Equipo("Monadas", jugadoresC));
		equiposA.add(new Equipo("Gnum8085", jugadoresE));

		TorneoContraTodo torneoCT = new TorneoContraTodo();

		TorneoDeCopa torneoDC = new TorneoDeCopa();

		EquipoManager equipoManager = new EquipoManager();

		equipoManager.crearTodo(equiposA);

		tct.crear(torneoCT);
		tdc.crear(torneoDC);

		tct.armarPartidos(equiposA, torneoCT.getId());
		tdc.armarPartidos(equiposA, torneoDC.getId());
		
	}

	@Test
	public void armarPartidosLogica() {
		equiposA.add(new Equipo("Lambda", jugadoresA));
		equiposA.add(new Equipo("Complemento a 2", jugadoresB));
		equiposA.add(new Equipo("Monadas", jugadoresC));
		equiposA.add(new Equipo("Gnum8085", jugadoresE));

		TorneoContraTodo torneoCT = new TorneoContraTodo();
		torneoCT.armarPartidos(equiposA);
		assertEquals(6, torneoCT.getPartidos().size());

		TorneoDeCopa torneoDeCopa = new TorneoDeCopa();
		torneoDeCopa.armarPartidos(equiposA);
		assertEquals(16, torneoDeCopa.getPartidos().size());
	}

}
