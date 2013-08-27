package virtualDT.home;

import virtualDT.exception.NuevaPasswordInvalida;
import virtualDT.exception.UsuarioNoExiste;
import virtualDT.exception.UsuarioYaExisteException;
import virtualDT.exception.ValidaciónException;

public interface Home {
	public void registrarUsuario (Usuario usuarioNuevo) throws UsuarioYaExisteException;
	public void validarCuenta (String codigoValidación) throws ValidaciónException;
    public Usuario ingresarUsuario (String userName, String password) throws UsuarioNoExiste;
    public void cambiarPassword(String userName, String password, String nuevaPassword) throws NuevaPasswordInvalida;
}
