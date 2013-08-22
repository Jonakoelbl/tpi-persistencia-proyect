package grupo3;

import java.sql.Date;

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
}
