package virtualDT.home;

import java.util.Date;
import java.util.GregorianCalendar;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import virtualDT.exception.ValidaciónException;

public class TestUsuario {
	Usuario usuario;
	Usuario usuarioYaValidado;
	final String CodigoDeValidacion = "3e4r5t";
	
	@Before
	public void miSetUp(){
		Date fechaNac = new GregorianCalendar(2000,02,01).getTime();
		usuario = new Usuario("username", "password", "nombre", "apellido", "email",fechaNac);
		usuarioYaValidado = new Usuario("username1", "password1", "nombre1", "apellido1", "email1",fechaNac);
		usuarioYaValidado.validarCuenta();
	}
	
	@Test
	public void testValidarCuentaNoExistente(){
		usuario.validarCuenta();
		Assert.assertTrue(usuario.getEstaValidado());
	}
	
	@Test(expected=ValidaciónException.class)
	public void testValidarCuentaExistente(){
		usuarioYaValidado.validarCuenta();
	}
}