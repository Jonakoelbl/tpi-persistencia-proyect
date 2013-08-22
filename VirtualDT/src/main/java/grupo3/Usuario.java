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
}
