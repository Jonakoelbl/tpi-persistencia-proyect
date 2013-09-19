package virtualDT.persistencia.servicio;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.hibernate.Criteria;
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
		jugadores.add(new Jugador(2,3,4,5,6,2,4));
		jugadores.add(new Jugador(3,4,5,1,2,2,3));
		jugadores.add(new Jugador(1,2,1,5,6,7,9));
	}
	
	@Test
	public void guardarYConsultarEquipo() {
		
		equipo = new Equipo();
		equipo.setNombreDelEquipo("Complemento a dos");
		equipoManager.crear(equipo);
		
		
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				Criteria criteria = SessionManager.getSession().createCriteria(Equipo.class);
				Equipo eq = (Equipo)criteria.add(Restrictions.eq("nombreDelEquipo", "Complemento a dos")).uniqueResult();
				assertEquals(eq.getNombreDelEquipo(), "Complemento a dos");
				return null;
			}
			
		});
	}
	
	@Test
	public void guardarListaDeJugadore(){
		equipo = new Equipo("Complemento");
		Map<Jugador, Posicion> jcp = new HashMap<Jugador, Posicion>();
		jcp.put(new Jugador(), Posicion.ARQUERO);
		jcp.put(new Jugador(), Posicion.CENTRODELANTERO);
		jcp.put(new Jugador(), Posicion.LATERAL);
		jcp.put(new Jugador(), Posicion.VOLANTE);
		jcp.put(new Jugador(), Posicion.MEDIOCAMPISTA);
		
		final Formacion formacion = new Formacion(jcp);
		
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				//equipoManager.crear(equipo);
				equipoManager.guardarFormacion("Complemento a dos", formacion);
				Criteria criteria = SessionManager.getSession().createCriteria(Equipo.class);
				Equipo eq = (Equipo)criteria.add(Restrictions.eq("nombreDelEquipo", "Complemento a dos")).uniqueResult();
				assertEquals(eq.getNombreDelEquipo(), "Complemento a dos");
				assertEquals(1,eq.getFormaciones().get(0).getJugadoresConPosiciones().size());
				return null;
			}
		});
		
	}

}
