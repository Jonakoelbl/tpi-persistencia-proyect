package virtualDT.home;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import virtualDT.email.Mail;
import virtualDT.exception.InvalidPassword;
import virtualDT.exception.NuevaPasswordInvalida;
import virtualDT.exception.UsuarioNoExiste;
import virtualDT.exception.ValidaciónException;

import database.connector.DBConnector;

public class HomeDataBase implements Home {

	private DBConnector conDB = new DBConnector();
		
	public void registrarUsuario(final Usuario usuarioNuevo) {
		Executor<Void> task = new Executor<Void>() {
			public Void execute(Connection connection) throws SQLException {
				PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios(nombre, apellido, nombreUsuario, password, email, fechaNac) VALUES (?, ?, ?, ?, ?)");
				statement.setString(1, usuarioNuevo.getNombre());
				statement.setString(2, usuarioNuevo.getApellido());
				statement.setString(3, usuarioNuevo.getUsername());
				statement.setString(4, usuarioNuevo.getPassword());
				statement.setString(5, usuarioNuevo.getEmail());
				statement.setDate(6, new java.sql.Date(usuarioNuevo.getFechaDeNac().getTime()));
				statement.executeUpdate();
	
				//Guardo el codigo de validacion con el nombre de usuario
				statement = connection.prepareStatement("INSERT INTO validaciones(nombreUsuario, codigo) values (?, ?)");
				statement.setString(1, usuarioNuevo.getUsername());
				String codigo = ""; //TODO crear una formar de generar codigo aleatoreo!
				statement.setString(2, codigo);
				statement.executeUpdate();
				
				Mail generarMail = new Mail(usuarioNuevo.getEmail(), "email@admin.com", "[VirutalDT] Verificar su cuenta ", 
									"Hola "+usuarioNuevo.getNombre()+"."+"/n"+"Con tal de mantener la seguridad de su cuenta VirtualDT, " +
											"por favor verifiquelo con el siguiente codigo: "+codigo+"/n"+
											"Equipo de VirtualDT.");
				
				generarMail.enviarMail(generarMail); //HORRIBLE!!!!!
				
				return null;
			}
		};
		this.execute(task);
	}

	public void validarCuenta(final String codigoValidación)
			throws ValidaciónException {
		Executor<Void> task = new Executor<Void>() {
			
			public Void execute(Connection connection) throws SQLException {
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM validaciones WHERE codigo = ?");
				statement.setString(1, codigoValidación);
				
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()){
					statement = connection.prepareStatement("DELETE FROM validaciones WHERE codigo = ?");
					statement.setString(1, codigoValidación);
					statement.executeQuery();
				}
				return null;
			}
		};
		this.execute(task);
	}
	
	public Usuario getUsuario(final String userName){
		Executor<Usuario> task = new Executor<Usuario>() {
			public Usuario execute(Connection connection) throws SQLException {
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios WHERE nombreUsuario = ? ");
				statement.setString(1, userName);
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()){
					return new Usuario(resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getString("nomnbreUsuario"),
											resultSet.getString("password"), resultSet.getString("email"), resultSet.getDate("FechaNac"));
				}else{
					throw new UsuarioNoExiste(userName);
				}
			}
			
		};
		this.execute(task);
		return null;
	}
	

	public Usuario ingresarUsuario(final String userName, String password)throws UsuarioNoExiste {
		Usuario usuario = HomeDataBase.this.getUsuario(userName);
		if(usuario.getPassword().equals(password))
			return usuario;
		throw new InvalidPassword();
	}

	public void cambiarPassword(String userName, String password,
			String nuevaPassword) throws NuevaPasswordInvalida {
		Usuario usuario = this.ingresarUsuario(userName, password);
		usuario.setPassword(nuevaPassword);
		this.updateUsuario(usuario);
	}
	
	protected void updateUsuario(final Usuario usuario) {
		Executor<Void> task = new Executor<Void>() {			
			public Void execute(Connection connection) throws SQLException {
				PreparedStatement statement = connection.prepareStatement("UPDATE usuarios SET password = ? WHERE nombreUsuario = ?");
				statement.setString(1, usuario.getPassword());
				statement.setString(2, usuario.getUsername());
				
				return null;
			}
		};
		this.execute(task);
	}
	
	protected <T> T execute(Executor<T> executor){
		try {
			return executor.execute(conDB.getConnection());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
