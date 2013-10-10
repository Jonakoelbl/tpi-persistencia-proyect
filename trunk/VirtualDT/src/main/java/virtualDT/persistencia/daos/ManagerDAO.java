package virtualDT.persistencia.daos;

public interface ManagerDAO<T> {
	public T consultar(final Object consulta);
	public void crear(final T t);
	public void eliminar(final T t);
}
