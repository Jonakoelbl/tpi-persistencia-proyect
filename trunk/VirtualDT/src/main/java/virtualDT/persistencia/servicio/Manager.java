package virtualDT.persistencia.servicio;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import virtualDT.persistencia.daos.ManagerDAO;
import virtualDT.persistencia.daos.SessionManager;

public class Manager<T> implements ManagerDAO<T>{
	
	private String criterio;
	private Class<T> clazz;
	
	public Manager(Class<T> clazz, String criterio) {
		this.clazz = clazz;
		this.criterio = criterio;
	}
	
	public T consultar(final String consulta){
		return SessionManager.runInSession(new Operation<T>() {

			public T execute() {
				Criteria criteria = SessionManager.getSession().createCriteria(clazz);
				criteria.add(Restrictions.eq(criterio, consulta));
				return (T) criteria.uniqueResult();
			}
		});
	}
	
	public void crear(final T obj){
		SessionManager.runInSession(new Operation<Void>(){

			public Void execute() {
				SessionManager.getSession().saveOrUpdate(obj);
				return null;
			}
			
		});
	}
	
	public void eliminar(final T obj){
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				SessionManager.getSession().delete(obj);
				return null;
			}
		});
	}
	
}
