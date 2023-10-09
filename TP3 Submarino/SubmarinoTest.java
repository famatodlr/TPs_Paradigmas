package submarino;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubmarinoTest {
	
	@Test public void test00() {
		// Esta en la superficie?
		// En que poosicion esta?
		// Para donde esta mirando? (direccion)
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		assertEquals( Submarine.initialPosition, nemo.coordenada);
		assertEquals( Submarine.initialDirection, nemo.direccion);
	}
	
	@Test public void test01() {
		// Le paso "" y permanece en el lugar
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		assertEquals( Submarine.initialPosition, nemo.coordenada);
		
		nemo.instructions(' ');
		
		assertTrue(nemo.isAtSurface());
		assertEquals( Submarine.initialPosition, nemo.coordenada);
	}
	
	@Test public void test02() {
		//Testear pasarle 'd'
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		
		nemo.instructions('d');
		
		assertFalse(nemo.isAtSurface());
		assertEquals( 1 , nemo.profundidad);
	}
	
	@Test public void test03() {
		// Testear pasarle 'u' en la superficie y que se quede ahi
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		
		nemo.instructions('u');
		
		assertTrue(nemo.isAtSurface());
	}
	
	@Test public void test04(){
		// Testear pasarle 'u' bajo la superficie y que suba
		
		Submarine nemo = new Submarine();
		
		nemo.instructions('d');
		
		assertFalse(nemo.isAtSurface());
		assertEquals( 1 , nemo.profundidad);
		
		nemo.instructions('u');
		
		assertTrue(nemo.isAtSurface());
	}
	
	@Test public void test05() {
		// Testear pasarle 'l' y que gire a la izquierda
		
		Submarine nemo = new Submarine();
		
		assertEquals( Submarine.initialDirection, nemo.direccion);
		
		nemo.instructions('l');
		
		assertEquals( "Oeste", nemo.direccion);
	}

	@Test public void test06() {
		// Testear pasarle 'r' y que gire a la derecha

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialDirection, nemo.direccion);

		nemo.instructions('r');

		assertEquals( "Este", nemo.direccion);
	}

	@Test public void test07() {
		// Testear pasarle 'f' y que avance una unidad

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialPosition, nemo.coordenada);

		nemo.instructions('f');

		assertEquals(0, nemo.coordenada.x);
		assertEquals(1, nemo.coordenada.y);
	}

	@Test public void test08(){
		// Testear pasarle una instruccion de direccion y de movimiento

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialPosition, nemo.coordenada);

		nemo.multipleInstructions("fff");

		assertEquals(0, nemo.coordenada.x);
		assertEquals(3, nemo.coordenada.y);
	}

	@Test public void test09(){
		// Testear pasarle una instruccion de direccion y de movimiento

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialPosition, nemo.coordenada);

		nemo.multipleInstructions("ffrff");

		assertEquals(2, nemo.coordenada.x);
		assertEquals(2, nemo.coordenada.y);
		assertEquals( "Este", nemo.direccion);
	}

	@Test public void test10(){
		// Testear pasarle una instruccion de direccion y de movimiento mas compleja

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialPosition, nemo.coordenada);

		nemo.multipleInstructions("ffrfflff");

		assertEquals(2, nemo.coordenada.x);
		assertEquals(4, nemo.coordenada.y);
		assertEquals( "Norte", nemo.direccion);

	}

	@Test public void test11(){
		// Testear mezcla de instrucciones de direccion, movimiento y profundidad

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialPosition, nemo.coordenada);

		nemo.multipleInstructions("ffrfflffdd");

		assertEquals(2, nemo.coordenada.x);
		assertEquals(4, nemo.coordenada.y);
		assertEquals( "Norte", nemo.direccion);
		assertEquals( 2, nemo.profundidad);

	}

	@Test public void test12() {
		// Testear pasarle 'm' y que lance una capsula

		Submarine nemo = new Submarine();

		assertEquals( 1, nemo.capsulas);
		nemo.instructions('m');
		assertEquals( 0, nemo.capsulas);
	}

//	@Test public void test13(){
//		// Testear el error si se intenta tirar una capsula a mas de 1 de profundidad
//
//		Submarine nemo = new Submarine();
//
//		assertEquals( 1, nemo.capsulas);
//		nemo.multipleInstructions("dd");
//		assertEquals( 2, nemo.profundidad);
//		nemo.instructions('m');
////		ESCRIBIR EL ASSERT DEL ERROR
//	}

//	@Test public void test14(){
//		CHEQUEAR
//		// Testear que no se puede lanzar una capsula si no hay
//
//		Submarine nemo = new Submarine();
//
//		assertEquals( 1, nemo.capsulas);
//		nemo.instructions('m');
//		assertEquals( 0, nemo.capsulas);
//
//	}


}
