package virtualDT.home;

import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import virtualDT.exception.NuevaPasswordInvalida;
import virtualDT.exception.UsuarioYaExisteException;
import virtualDT.exception.ValidaciónException;

public class TestHomeMemoria {
	
	HomeMemoria homeMem;
	Usuario usuario;
	Usuario usuarioYaValidado;
    Usuario usuarioYaValidado1;
	
	@Before
	public void miSetUp(){
		homeMem = new HomeMemoria();
		Date fechaNac = new GregorianCalendar(2000,02,01).getTime();
		usuario = new Usuario("username", "password", "nombre", "apellido", "email",fechaNac);
		usuarioYaValidado = new Usuario("username1", "password1", "nombre1", "apellido1", "email1",fechaNac);
		homeMem.getUsuariosRegistrados().add(usuario);
		homeMem.registrarUsuario(usuarioYaValidado);
		usuarioYaValidado1 = new Usuario("username1", "password1", "nombre1", "apellido1", "email1",fechaNac);
		homeMem.getValidaciones().put("b12357",usuarioYaValidado1);
		homeMem.validarCuenta("b12357");
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
	
	////////////////////////////////////////////////////////////////////////////////
	
	@Test(expected=ValidaciónException.class)
	public void testUsuarioYaValidado(){
		homeMem.validarCuenta("b12357");
		homeMem.validarCuenta("b123579");
	}
	
	public void testUsuarioRegistradoEnHashmap(){
		Assert.assertTrue(homeMem.getValidaciones().containsValue(usuarioYaValidado));
	}
}