package virtualDT.persistencia.daos;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import virtualDT.persistencia.servicio.Operation;

public class SessionManager {
	
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> tlSession;
	
	public synchronized static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure();

			sessionFactory = cfg.buildSessionFactory();
			tlSession = new ThreadLocal<Session>();
		}

		return sessionFactory;
	}
	
	public static <T> T runInSession(Operation<T> cmd){
		SessionFactory sessionFactory = SessionManager.getSessionFactory();
		Transaction transaction = null;
		T result = null;
		Session session = null;
		
		try {
			boolean alreadyHave = tlSession.get() != null;
			
			if(!alreadyHave){
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				tlSession.set(session);
			}

			result = cmd.execute();

			if(alreadyHave){
				session = null;
				return result;
			}
			
			session.flush();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw new RuntimeException(e);
		} finally {
			if (session != null)
				session.close();
			tlSession.set(null);
		}
		
		return result;
	}

	public static Session getSession() {
		return tlSession.get();
	}

}
