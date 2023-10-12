package submarino;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;


public class SubmarinoTest {
	
	@Test public void nemoIsCreatedInTheInitialPositionAndDirection() {
		// Esta en la superficie?
		// En que poosicion esta?
		// Para donde esta mirando? (direccion)
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		assertEquals( Submarine.initialPosition, nemo.coordenada);
		assertEquals( Submarine.initialDirection, nemo.direccion);
	}
	
	@Test public void nemoDontReactToEmptyInstructions() {
		// Le paso "" y permanece en el lugar
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		assertEquals( Submarine.initialPosition, nemo.coordenada);
		assertEquals( 1 , nemo.capsulas);
		
		nemo.instructions(' ');
		
		assertTrue(nemo.isAtSurface());
		assertEquals( Submarine.initialPosition, nemo.coordenada);
		assertEquals( 1 , nemo.capsulas);
	}
	
	@Test public void nemoCanGoDown() {
		//Testear pasarle 'd'
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		
		nemo.instructions('d');
		
		assertFalse(nemo.isAtSurface());
		assertEquals( 1 , nemo.profundidad);
	}
	
	@Test public void nemoDontReactIfGoesUpInSurface() {
		// Testear pasarle 'u' en la superficie y que se quede ahi
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		
		nemo.instructions('u');
		
		assertTrue(nemo.isAtSurface());
	}
	
	@Test public void nemoCanGoUp(){
		// Testear pasarle 'u' bajo la superficie y que suba (u es opuesto a d)
		
		Submarine nemo = new Submarine();
		
		nemo.instructions('d');
		
		assertFalse(nemo.isAtSurface());
		assertEquals( 1 , nemo.profundidad);
		
		nemo.instructions('u');
		
		assertTrue(nemo.isAtSurface());
	}
	
	
	@Test public void canRotateToLeft() {
		// Testear pasarle 'l' y que gire a la izquierda
		
		Submarine nemo = new Submarine();
		
		assertEquals( Submarine.initialDirection, nemo.direccion);
		
		nemo.instructions('l');
		
		assertEquals( "Oeste", nemo.direccion);
	}
	
	@Test public void canDoACompleteTurnAnticlockwise() {
		// 4 veces 'l' equivale a una vuelta completa y te deja mirando al mismo lugar
		
		Submarine nemo = new Submarine();
		
		assertEquals( Submarine.initialDirection, nemo.direccion);
		
		nemo.multipleInstructions("llll");
		
		assertEquals( "Norte", nemo.direccion);
	}

	@Test public void canRotateToRight() {
		// Testear pasarle 'r' y que gire a la derecha

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialDirection, nemo.direccion);

		nemo.instructions('r');

		assertEquals( "Este", nemo.direccion);
	}
	
	@Test public void canDoACompleteTurnClockwise() {
		// 4 veces 'r' equivale a una vuelta completa y te deja mirando al mismo lugar
		
		Submarine nemo = new Submarine();
		
		assertEquals( Submarine.initialDirection, nemo.direccion);
		
		nemo.multipleInstructions("rrrr");
		
		assertEquals( "Norte", nemo.direccion);
	}
	
	@Test public void rightOppositeToLeft() {
		// 'r' es opuesto a 'l'
		
		Submarine nemo = new Submarine();
		
		assertEquals( Submarine.initialDirection, nemo.direccion);
		
		nemo.instructions('r');
		nemo.instructions('l');
		
		assertEquals( "Norte", nemo.direccion);
	}

	@Test public void nemoCanGoFoward() {
		// Testear pasarle 'f' y que avance una unidad en la direccion adecuada

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialPosition, nemo.coordenada);

		nemo.instructions('f');

		assertEquals(0, nemo.coordenada.x);
		assertEquals(1, nemo.coordenada.y);
	}

	@Test public void canGoFowardManyTimes(){
		// Testear pasarle multiples instrucciones de movimiento

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialPosition, nemo.coordenada);

		nemo.multipleInstructions("fff");

		assertEquals(0, nemo.coordenada.x);
		assertEquals(3, nemo.coordenada.y);
	}

	@Test public void CanGOFowardAndRotate(){
		// Testear pasarle una instruccion de direccion y de movimiento

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialPosition, nemo.coordenada);

		nemo.multipleInstructions("ffrff");

		assertEquals(2, nemo.coordenada.x);
		assertEquals(2, nemo.coordenada.y);
		assertEquals( "Este", nemo.direccion);
	}

	@Test public void canRecieveComplexInstructions(){
		// Testear mezcla de instrucciones de direccion, movimiento y profundidad

		Submarine nemo = new Submarine();

		assertEquals( Submarine.initialPosition, nemo.coordenada);

		nemo.multipleInstructions("ufdfurffdlffd");

		assertEquals(2, nemo.coordenada.x);
		assertEquals(4, nemo.coordenada.y);
		assertEquals( "Norte", nemo.direccion);
		assertEquals( 2, nemo.profundidad);

	}

	@Test public void nemoCanThrowCapsule() {
		// Testear pasarle 'm' y que lance una capsula

		Submarine nemo = new Submarine();

		assertEquals( 1, nemo.capsulas);
		nemo.instructions('m');
		assertEquals( 0, nemo.capsulas);
	}

	@Test public void cantThrowCapsuleTooDeep(){
		// Testear el error si se intenta tirar una capsula a mas de 1 de profundidad

		Submarine nemo = new Submarine();

		assertEquals( 1, nemo.capsulas);
		nemo.multipleInstructions("dd");
		assertEquals( 2, nemo.profundidad);
		
		assertEquals( Submarine.excessOfChocolate,
				assertThrows( RuntimeException.class, () -> nemo.instructions('m')).getMessage());
	}

	@Test public void cantThrowManyCapsules(){
		// Testear que no se puede lanzar una capsula si no hay

		Submarine nemo = new Submarine();

		assertEquals( 1, nemo.capsulas);
		nemo.instructions('m');
		assertEquals( 0, nemo.capsulas);
		
		assertEquals( Submarine.noMoreCapsules,
				assertThrows( RuntimeException.class, () -> nemo.instructions('m')).getMessage());
	}

	

}
