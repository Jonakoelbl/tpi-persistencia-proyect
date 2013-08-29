package virtualDT.home;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


import virtualDT.exception.*;

public class HomeMemoria implements Home{

	private List<Usuario> usuariosRegistrados = new Vector<Usuario>();
	private Map<String, Usuario> validaciones = new HashMap();
	
	public void registrarUsuario(Usuario usuarioNuevo)
			throws UsuarioYaExisteException {
		for (Usuario usuario : this.usuariosRegistrados) {
			if(usuario.getUsername() == usuarioNuevo.getUsername())
				throw new UsuarioYaExisteException();
		}
		this.usuariosRegistrados.add(usuarioNuevo);
		
		String codigo = "";
		this.validaciones.put(codigo, usuarioNuevo);
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
			if(usuario.getUsername().equals(userName) && usuario.getPassword().equals(password))
				return usuario;
		}
		throw new UsuarioNoExiste(userName);
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
		} else {
			throw new NuevaPasswordInvalida();
		}
	}

	public void validarCuenta(String codigoValidación)
			throws ValidaciónException {
		Usuario usuario = this.validaciones.get(codigoValidación);
		if(usuario != null){
			usuario.validarCuenta();
			this.validaciones.remove(codigoValidación);
		}
		else
			throw new ValidaciónException();
	}
}
