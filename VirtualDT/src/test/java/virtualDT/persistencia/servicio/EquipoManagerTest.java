package virtualDT.persistencia.servicio;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import virtualDT.equipo.Equipo;
import virtualDT.equipo.Jugador;

public class EquipoManagerTest {

	EquipoManager equipoManager = new EquipoManager();
	Equipo equipo;
	List<Jugador> jugadores = new Vector<Jugador>();
	
	@Before
	public void setup() {
		jugadores.add(new Jugador(2,3,4,5,6,2,4));
		jugadores.add(new Jugador(3,4,5,1,2,2,3));
		jugadores.add(new Jugador(1,2,1,5,6,7,9));
	}
	
	@Test
	public void guardarYConsultarEquipo() {
		
		equipo = new Equipo();
		equipo.setNombreDelEquipo("Complemento a dos");
		equipoManager.crear(equipo);
		
		Equipo testConsultaEquipo = equipoManager.consultar("Complemento a dos");
		
		assertEquals(testConsultaEquipo.getNombreDelEquipo(), "Complemento a dos");
		//assertEquals(testConsultaEquipo.getJugadores().size(), 3);
	}

}
