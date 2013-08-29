package virtualDT.home;

import virtualDT.exception.ValidaciónException;

import java.util.Date;

public class Usuario {
	private String username;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private Date fechaDeNac;
	private Boolean estaValidado;
	

	public Usuario(String username, String password, String nombre, String apellido, String email, Date fechaNac) {
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaDeNac = fechaNac;
		this.estaValidado = false;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getEmail() {
		return email;
	}
	public Date getFechaDeNac() {
		return fechaDeNac;
	}
	
	public Boolean getEstaValidado() {
		return estaValidado;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFechaDeNac(Date fechaDeNac) {
		this.fechaDeNac = fechaDeNac;
	}

	public void setEstaValidado(Boolean estaValidado) {
		this.estaValidado = estaValidado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	public void validarCuenta(String codigoValidación){
		if(!getEstaValidado()){
			setEstaValidado(true);
		} else {
			throw new ValidaciónException();
		}
	}
}
