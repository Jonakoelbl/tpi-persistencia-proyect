package grupo3;

import grupo3.exception.NuevaPasswordInvalida;
import grupo3.exception.UsuarioNoExiste;
import grupo3.exception.UsuarioYaExisteException;
import grupo3.exception.ValidaciónException;

public class Sistema implements ISistema{

	public void registrarUsuario(Usuario usuarioNuevo)
			throws UsuarioYaExisteException {
		// TODO generar el codigo
		
	}

	public void validarCuenta(String codigoValidación)
			throws ValidaciónException {
		// TODO Auto-generated method stub
		
	}

	public void ingresarUsuario(String userName, String password)
			throws UsuarioNoExiste {
		// TODO Auto-generated method stub
		
	}

	public void cambiarPassword(String userName, String password,
			String nuevaPassword) throws NuevaPasswordInvalida {
		// TODO Auto-generated method stub
		
	}

}
