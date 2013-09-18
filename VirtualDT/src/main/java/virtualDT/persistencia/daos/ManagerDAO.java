package virtualDT.persistencia.daos;

public interface ManagerDAO<T> {
	public T consultar(final int id);
	public void crear(final T t);
	public void eliminar(final T t);
}
