package grupo3;

import grupo3.exception.InvalidPassword;
import grupo3.exception.NuevaPasswordInvalida;
import grupo3.exception.UsuarioNoExiste;
import grupo3.exception.ValidaciónException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
				return null;
			}
		};
		this.execute(task);
	}

	public void validarCuenta(String codigoValidación)
			throws ValidaciónException {
		// TODO Auto-generated method stub

	}
	
	public Usuario getUsuario(final String userName){
		Executor<Usuario> task = new Executor<Usuario>() {
			public Usuario execute(Connection connection) throws SQLException {
				PreparedStatement statement = connection.prepareStatement("SELECT * from usuarios WHERE nombreUsuario = ? ");
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
	}
	
	protected <T> T execute(Executor<T> executor){
		try {
			return executor.execute(conDB.getConnection());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
