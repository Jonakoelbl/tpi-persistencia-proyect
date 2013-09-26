package virtualDT.persistencia.servicio;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import virtualDT.equipo.Equipo;
import virtualDT.equipo.Formacion;
import virtualDT.equipo.Jugador;
import virtualDT.equipo.Posicion;
import virtualDT.persistencia.daos.SessionManager;

public class EquipoManagerTest {

	EquipoManager equipoManager = new EquipoManager();
	Equipo equipo;
	List<Jugador> jugadores = new Vector<Jugador>();

	@Before
	public void setup() {
		jugadores.add(new Jugador("Pepito", 2, 3, 4, 5, 6, 2, 4));
		jugadores.add(new Jugador("Sultano", 3, 4, 5, 1, 2, 2, 3));
		jugadores.add(new Jugador("Melgano", 1, 2, 1, 5, 6, 7, 9));
	}

	@Test
	public void guardarYConsultarEquipo() {

		equipo = new Equipo();
		equipo.setNombreDelEquipo("Complemento a dos");
		equipoManager.crear(equipo);

		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				Criteria criteria = SessionManager.getSession().createCriteria(
						Equipo.class);
				Equipo eq = (Equipo) criteria
						.add(Restrictions.eq("nombreDelEquipo",
								"Complemento a dos")).uniqueResult();
				assertEquals(eq.getNombreDelEquipo(), "Complemento a dos");
				return null;
			}

		});
	}

	@Test
	public void eliminarDatosDeUnEquipo() {
		equipo = new Equipo();
		equipo.setNombreDelEquipo("Yupanqui");

		equipoManager.crear(equipo);

		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				Criteria criteria = SessionManager.getSession().createCriteria(
						Equipo.class);
				Equipo eq = (Equipo) criteria.add(
						Restrictions.eq("nombreDelEquipo", "Yupanqui"))
						.uniqueResult();
				assertEquals(eq.getNombreDelEquipo(), "Yupanqui");

				equipoManager.eliminar(eq);
				Equipo eqNull = (Equipo) criteria.add(
						Restrictions.eq("nombreDelEquipo", "Yupanqui"))
						.uniqueResult();
				assertEquals(eqNull, null);

				return null;
			}
		});

	}

	@Test
	public void guardarListaDeJugadores() {
		equipo = new Equipo("Complemento");
		Map<Jugador, Posicion> jcp = new HashMap<Jugador, Posicion>();
		jcp.put(new Jugador("Pepito", 2, 4, 5, 7, 8, 3, 2), Posicion.ARQUERO);
		jcp.put(new Jugador("Sultano", 4, 5, 3, 2, 7, 5, 8),
				Posicion.CENTRODELANTERO);
		jcp.put(new Jugador("Fulano", 3, 2, 2, 1, 6, 5, 9), Posicion.LATERAL);
		jcp.put(new Jugador("Mengano", 2, 2, 5, 6, 7, 4, 2), Posicion.VOLANTE);
		jcp.put(new Jugador("Cosme", 2, 3, 5, 3, 3, 1, 7),
				Posicion.MEDIOCAMPISTA);

		equipoManager.crear(equipo);

		Formacion formacion = new Formacion(jcp);
		equipoManager.guardarFormacion("Complemento", formacion);

		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				Criteria criteria = SessionManager.getSession().createCriteria(
						Equipo.class);
				Equipo eq = (Equipo) criteria.add(
						Restrictions.eq("nombreDelEquipo", "Complemento"))
						.uniqueResult();
				assertEquals(eq.getNombreDelEquipo(), "Complemento");
				assertEquals(1, eq.getFormaciones().size());
				assertEquals(eq.getFormaciones().get(0)
						.getJugadoresConPosiciones().size(), 5);
				return null;
			}
		});

	}

}
