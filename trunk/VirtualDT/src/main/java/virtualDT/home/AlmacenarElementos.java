package virtualDT.home;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AlmacenarElementos {
	private SessionFactory sessionFactory;
	
	protected SessionFactory obtenerSessionFactory(){
		if(sessionFactory == null){
			Configuration cfg = new Configuration();
			cfg.configure();
			sessionFactory = cfg.buildSessionFactory();
		}
		return sessionFactory;
	}
	
}
