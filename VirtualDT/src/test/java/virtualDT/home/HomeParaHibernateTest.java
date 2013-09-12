package virtualDT.home;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import virtualDT.equipo.Equipo;

import junit.framework.TestCase;

public class HomeParaHibernateTest{

	SessionFactory sf;
	Equipo e;
	Session s;
	Transaction t;

	@Before
	public void miSetUp() {
		sf = new Configuration().configure().buildSessionFactory();
		s = sf.openSession();
		e = new Equipo("Melones");
	}

	@Test
	public void AlmacenarEquipoMelones() {
		s.save(e);
	}
	
	@After
	public void cerrarSession(){
		s.close();
	}
}
