package virtualDT.home;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import org.junit.Test;

import database.connector.DBConnector;

public class HomeDataBaseTest {
	HomeDataBase home = new HomeDataBase();
	DBConnector connection;
	
	@Test
	public void registrarUsuario() throws Exception{
		Usuario usuarioARegistrar = new Usuario("UserName", "1234", "Pepito", "Sapo", "email@email.com", new Date(1989, 06, 23));
		home.registrarUsuario(usuarioARegistrar);
		
		connection = new DBConnector(); 
		
		PreparedStatement statementRegister = connection.getConnection().prepareStatement("SELECT * FROM usuarios WHERE nombreUsuario = ? ");
		statementRegister.setString(1, "UserName");
		ResultSet resultRegister = statementRegister.executeQuery();
		
		assertEquals(resultRegister.getString("nombre"), "Pepito");
		assertEquals(resultRegister.getString("apellido"), "Sapo");
		assertEquals(resultRegister.getString("email"), "email@email.com");
		assertEquals(resultRegister.getString("password"), "1234");
		
		PreparedStatement statementValidation = connection.getConnection().prepareStatement("SELECT * FROM validaciones WHERE nombreUsuario = ?");
		statementValidation.setString(1, "UserName");
		ResultSet resultValidation = statementValidation.executeQuery();
		
		assertEquals(resultValidation.getConcurrency(), 1);
	}

	@Test
	public void validarCuenta() throws Exception{
		Usuario usuarioARegistrar = new Usuario("CosmeFu", "1234", "Cosme", "Fulanito", "email@email.com", new Date(1989, 06, 23));
		home.registrarUsuario(usuarioARegistrar);
		
		PreparedStatement statementValidation = connection.getConnection().prepareStatement("SELECT * FROM validaciones WHERE nombreUsuario = ?");
		statementValidation.setString(1, "CosmeFu");
		ResultSet resultValidation = statementValidation.executeQuery();
		
		String validation = resultValidation.getString("codigo");
		home.validarCuenta(validation);
		
		ResultSet resultValidationDelete = statementValidation.executeQuery();
		assertFalse(resultValidationDelete.next());
	}
	
	@Test
	public void ingresarUsuario() throws Exception{
		Usuario usuario = home.ingresarUsuario("CosmeFu", "1234");
		
		assertEquals(usuario.getNombre(), "Cosme");
		assertEquals(usuario.getApellido(), "Fulanito");
		assertEquals(usuario.getEmail(), "email@email.com");
		//deberia estar la fecha, por vago no lo hice aun ...
	}
	
	@Test
	public void cambiarPassword() throws Exception{
		Usuario usuario = new Usuario("Inconforme", "nolose", "Juan", "Lopez", "jl@email.com", new Date(1986, 05, 14));
		home.registrarUsuario(usuario);
		
		home.cambiarPassword("Inconforme", "nolose", "lanuevapass");
		
		Usuario usuarioConNuevaPass = home.ingresarUsuario("Inconforme", "lanuevapass");
		assertNotNull(usuarioConNuevaPass); // check it!
		assertEquals(usuarioConNuevaPass.getNombre(), usuario.getNombre());
		assertEquals(usuario.getApellido(), usuarioConNuevaPass.getApellido());
		assertEquals(usuario.getUsername(), usuarioConNuevaPass.getUsername());
		assertEquals(usuario.getFechaDeNac(), usuarioConNuevaPass.getFechaDeNac());
	}
}
