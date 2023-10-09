package submarino;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
		
		assertEquals( "Este", nemo.direccion);
	}

	@Test public void test06() {
		// Testear pasarle 'r' y que gire a la derecha

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialDirection, nemo.direccion);

		nemo.instructions('r');

		assertEquals( "Oeste", nemo.direccion);
	}

	@Test public void test07() {
		// Testear pasarle 'f' y que avance una unidad

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialPosition, nemo.coordenada);

		nemo.instructions('f');

		assertEquals(0, nemo.coordenada.x);
		assertEquals(1, nemo.coordenada.y);
	}
//
//	@Test public void test08(){
//		// Testear pasarle "ffrff" y que avance dos unidades y gire a la derecha
//
//		Submarine nemo = new Submarine();
//
//		assertEquals( Submarine.initialPosition, nemo.coordenada);
//
//		nemo.instructions('f');
//		nemo.instructions('f');
//		nemo.instructions('r');
//		nemo.instructions('f');
//		nemo.instructions('f');
//
//		assertEquals(2, nemo.coordenada.x);
//		assertEquals(2, nemo.coordenada.y);
//		assertEquals( "Este", nemo.direccion);
//
//
//	}

//	@Test public void test09() {
//		// Testear pasarle 'm' y que lance una capsula
//
//		Submarine nemo = new Submarine();
//
//		assertEquals( 1, nemo.capsulas);
//		nemo.instructions('m');
//		assertEquals( 0, nemo.capsulas);
//	}
//
}
