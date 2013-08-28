package grupo3.tests;

import grupo3.*;
import grupo3.exception.NuevaPasswordInvalida;
import grupo3.exception.UsuarioYaExisteException;

import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHomeMemoria {
	
	HomeMemoria homeMem;
	Usuario usuario;
	Usuario usuarioYaValidado;

	
	@Before
	public void miSetUp(){
		homeMem = new HomeMemoria();
		Date fechaNac = new GregorianCalendar(2000,02,01).getTime();
		usuario = new Usuario("username", "password", "nombre", "apellido", "email",fechaNac);
		usuarioYaValidado = new Usuario("username1", "password1", "nombre1", "apellido1", "email1",fechaNac);
		homeMem.getUsuariosRegistrados().add(usuario);
		homeMem.registrarUsuario(usuarioYaValidado);
	}
	
	@Test
	public void testRegistrarUsuarioNoExistente(){
		Assert.assertTrue(homeMem.getUsuariosRegistrados().contains(usuario));
	}
	
	@Test(expected = UsuarioYaExisteException.class)
	public void testRegistrarUsuarioExistente(){
		homeMem.registrarUsuario(usuarioYaValidado);
	}
	
	///////////////////////////////////////////////////////////////////////////
	@Test
	public void testIngresarUsuario(){
		Assert.assertEquals(usuario,homeMem.ingresarUsuario("username","password"));
	}
	//common codex
	//////////////////////////////////////////////////////////////////////////////
	@Test
	public void testCambiarPasswordCorrecto(){
		homeMem.cambiarPassword(usuario.getUsername(),"password","nuevaPassword");
		Assert.assertEquals(usuario.getPassword(),"nuevaPassword");
	}
	
	@Test(expected=NuevaPasswordInvalida.class)
	public void testcambiarPasswordViejaIncorrecta(){
		homeMem.cambiarPassword(usuario.getUsername(),"viejaPassword","nuevaPassword");
	}
	
	@Test(expected=NuevaPasswordInvalida.class)
	public void testcambiarPasswordNuevaVacia(){
		homeMem.cambiarPassword(usuario.getUsername(),"viejaPassword","");
	}
}