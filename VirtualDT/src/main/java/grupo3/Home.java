package grupo3;

import grupo3.exception.NuevaPasswordInvalida;
import grupo3.exception.UsuarioNoExiste;
import grupo3.exception.UsuarioYaExisteException;
import grupo3.exception.ValidaciónException;

public interface Home {
	public void registrarUsuario (Usuario usuarioNuevo) throws UsuarioYaExisteException;
	public void validarCuenta (String codigoValidación) throws ValidaciónException;
    public Usuario ingresarUsuario (String userName, String password) throws UsuarioNoExiste;
    public void cambiarPassword(String userName, String password, String nuevaPassword) throws NuevaPasswordInvalida;
}
