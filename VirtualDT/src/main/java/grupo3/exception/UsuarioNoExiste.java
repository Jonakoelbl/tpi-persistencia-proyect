package grupo3.exception;

public class UsuarioNoExiste extends RuntimeException {

	public UsuarioNoExiste(String userName) {
		super("El usuario "+userName+" no existe");
	}

}
