package grupo3;

import java.util.List;
import java.util.Vector;

import grupo3.exception.NuevaPasswordInvalida;
import grupo3.exception.UsuarioNoExiste;
import grupo3.exception.UsuarioYaExisteException;

public class HomeMemoria implements Home{

	private List<Usuario> usuariosRegistrados = new Vector<Usuario>();
	
	public void registrarUsuario(Usuario usuarioNuevo)
			throws UsuarioYaExisteException {
		for (Usuario usuario : this.usuariosRegistrados) {
			if(usuario.getUsername() == usuarioNuevo.getUsername())
				throw new UsuarioYaExisteException();
		}
		this.usuariosRegistrados.add(usuarioNuevo);
	}
	
	public void validarCuenta(String codigoValidación){
		
	}

	public List<Usuario> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}

	public void setUsuariosRegistrados(List<Usuario> usuariosRegistrados) {
		this.usuariosRegistrados = usuariosRegistrados;
	}

	public Usuario ingresarUsuario(String userName, String password)
			throws UsuarioNoExiste {
		for (Usuario usuario : this.usuariosRegistrados) {
			if(usuario.getNombre().equals(userName) && usuario.getPassword().equals(password))
				return usuario;
		}
		throw new UsuarioNoExiste();
	}

	private Usuario getUsuarioByUsername(String userName){
		Usuario usuarioActual = null;
		for (Usuario usuario : this.usuariosRegistrados) {
			if(usuario.getUsername().equals(userName)){
				usuarioActual = usuario;
			}
		}
		return usuarioActual;
	}
	
	public void cambiarPassword(String userName, String password, String nuevaPassword) throws NuevaPasswordInvalida {
		if(getUsuarioByUsername(userName).getPassword().equals(password) && (password != "")){
			getUsuarioByUsername(userName).setPassword(nuevaPassword);
		}
	}
}

