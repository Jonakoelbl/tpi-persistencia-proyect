package virtualDT.home;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import virtualDT.equipo.Formacion;
import virtualDT.equipo.Jugador;
import virtualDT.equipo.Posicion;

public class testFormacion {

	Formacion f;
	Map<Jugador, Posicion> laFormacion;
	Jugador j0;
	Jugador j1;
	Jugador j2;
	Jugador j3;
	Jugador j4;
	Jugador j5;
	Jugador j6;
	Jugador j7;
	Jugador j8;
	Jugador j9;
	Jugador j10;
	
	@Before
	public void miSetUp(){
		//Arquero,DefensorCentral, Lateral, Mediocampista, Volante, Centrodelantero, Delantero
		j0 = new Jugador("",30, 10, 10, 10, 20, 0, 0);
		j1 = new Jugador("",6, 9, 40, 10, 20, 0, 0);
		j2 = new Jugador("",1, 35, 35, 10, 20, 0, 0);
		j3 = new Jugador("",1, 20, 10, 10, 20, 0, 0);
		j4 = new Jugador("",1, 20, 10, 10, 20, 0, 0);
		j5 = new Jugador("",1, 10, 10, 60, 20, 0, 0);
		j6 = new Jugador("",1, 10, 10, 55, 20, 0, 0);
		j7 = new Jugador("",1, 10, 10, 10, 40, 0, 0);
		j8 = new Jugador("",1, 10, 10, 10, 40, 0, 0);
		j9 = new Jugador("",1, 10, 10, 10, 20, 70, 0);
		j10 = new Jugador("",1, 10, 10, 10, 20, 0, 100);
		/////////////////////////////////////////////
		laFormacion = new HashMap<Jugador, Posicion>();
		/////////////////////////////////////////////
		//30 + 40 + 35 + 20 + 20 + 60 + 55 + 40 + 40 + 70 + 100
		laFormacion.put(j0, Posicion.ARQUERO);
		laFormacion.put(j1, Posicion.LATERAL);
		laFormacion.put(j2, Posicion.LATERAL);
		laFormacion.put(j3, Posicion.DEFENSORCENTRAL);
		laFormacion.put(j4, Posicion.DEFENSORCENTRAL);
		laFormacion.put(j5, Posicion.MEDIOCAMPISTA);
		laFormacion.put(j6, Posicion.MEDIOCAMPISTA);
		laFormacion.put(j7, Posicion.VOLANTE);
		laFormacion.put(j8, Posicion.VOLANTE);
		laFormacion.put(j9, Posicion.CENTRODELANTERO);
		laFormacion.put(j10, Posicion.DELANTERO);
		f = new Formacion(laFormacion);
	}
	
	@Test
	public void puntajeFormacion100(){
		Assert.assertEquals(510, f.puntajeFormacion());
	}
	
}