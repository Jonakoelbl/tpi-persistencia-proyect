package virtualDT.persistencia.daos;

public interface ManagerDAO<T> {
	public T consultar(final String consulta);
	public void crear(final T t);
	public void eliminar(final T t);
}
