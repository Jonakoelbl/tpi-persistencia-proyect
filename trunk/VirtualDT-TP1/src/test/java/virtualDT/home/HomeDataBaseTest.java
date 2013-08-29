package virtualDT.home;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import database.connector.DBConnector;

public class HomeDataBaseTest {
	HomeDataBase home = new HomeDataBase();
	DBConnector connection;
	Usuario usuarioDePrueba;
	
	@Before
	public void creacionDeUsuario() throws IOException, SQLException{
		usuarioDePrueba = new Usuario("CosmeFu", "1234", "Cosme", "Fulanito", "email@email.com", new Date(1989, 06, 23));
		
		connection = new DBConnector(); 
		connection.getConnection().prepareStatement("DELETE FROM usuarios where nombreUsuario != ''").executeUpdate();
		connection.getConnection().prepareStatement("DELETE FROM validaciones where nombreUsuario != ''").executeUpdate();
//		String command = "mysql virtualDT -u root --password=root < virtualDT.sql";
//		Runtime.getRuntime().exec(command);
	}
	
	@Test
	public void registrarUsuario() throws Exception{
		home.registrarUsuario(usuarioDePrueba);
		Usuario usuario = home.getUsuario("CosmeFu");
	
		assertEquals(usuario, usuarioDePrueba);
		
		connection = new DBConnector(); 
		PreparedStatement statementValidation = connection.getConnection().prepareStatement("SELECT * FROM validaciones WHERE nombreUsuario = ?");
		statementValidation.setString(1, usuario.getUsername());
		ResultSet resultValidation = statementValidation.executeQuery();
		
		assertFalse(!resultValidation.next());
	}

	@Test
	public void validarCuenta() throws Exception{
		home.registrarUsuario(usuarioDePrueba);
		PreparedStatement statementValidation = connection.getConnection().prepareStatement("SELECT * FROM validaciones WHERE nombreUsuario = ?");
		statementValidation.setString(1, usuarioDePrueba.getUsername());
		ResultSet resultValidation = statementValidation.executeQuery();

		resultValidation.next();
		String validation = resultValidation.getString("codigo");
		home.validarCuenta(validation);
		
		ResultSet resultValidationDelete = statementValidation.executeQuery();
		assertFalse(resultValidationDelete.next());
	}
	
	@Test
	public void ingresarUsuario() throws Exception{
		home.registrarUsuario(usuarioDePrueba);
		Usuario usuario = home.ingresarUsuario("CosmeFu", "1234");
		
		assertEquals(usuario.getNombre(), "Cosme");
		assertEquals(usuario.getApellido(), "Fulanito");
		assertEquals(usuario.getEmail(), "email@email.com");
		//deberia estar la fecha, por vago no lo hice aun ...
	}
	
	@Test
	public void cambiarPassword() throws Exception{
		home.registrarUsuario(usuarioDePrueba);
		
		home.cambiarPassword("CosmeFu", "1234", "lanuevapass");
		
		Usuario usuarioConNuevaPass = home.ingresarUsuario("CosmeFu", "lanuevapass");
		assertNotNull(usuarioConNuevaPass); // check it!
		assertEquals(usuarioDePrueba.getNombre(), usuarioConNuevaPass.getNombre());
		assertEquals(usuarioDePrueba.getApellido(), usuarioConNuevaPass.getApellido());
		assertEquals(usuarioDePrueba.getUsername(), usuarioConNuevaPass.getUsername());
		assertEquals(usuarioDePrueba.getFechaDeNac(), usuarioConNuevaPass.getFechaDeNac());
	}
}
