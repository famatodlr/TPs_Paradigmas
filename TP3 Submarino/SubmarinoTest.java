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
		assertEquals(Coordenate.initialPosition, nemo.getCoordinate());
		assertEquals( Directions.initialDirection, nemo.getDirection());
	}

	@Test public void nemoDontReactToEmptyInstructions() {
		// Le paso "" y permanece en el lugar
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		assertEquals(Coordenate.initialPosition, nemo.getCoordinate());

		nemo.instructions(' ');
		
		assertTrue(nemo.isAtSurface());
		assertEquals(Coordenate.initialPosition, nemo.getCoordinate());
	}
	
	@Test public void nemoCanGoDown() {
		//TEastar pasarle 'd'
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		
		nemo.instructions('d');
		
		assertFalse(nemo.isAtSurface());
		assertEquals( OneBelowSurface.class, nemo.getProfundidad().getClass());
	}
	
	@Test public void nemoDontReactIfGoesUpInSurface() {
		// TEastar pasarle 'u' en la superficie y que se quede ahi
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		
		nemo.instructions('u');
		
		assertTrue(nemo.isAtSurface());
	}
	
	@Test public void nemoCanGoUp(){
		// TEastar pasarle 'u' bajo la superficie y que suba (u es opuesto a d)
		
		Submarine nemo = new Submarine();
		
		nemo.instructions('d');
		
		assertFalse(nemo.isAtSurface());
		assertEquals( OneBelowSurface.class, nemo.getProfundidad().getClass());

		nemo.instructions('u');
		
		assertTrue(nemo.isAtSurface());
	}
	
	
	@Test public void canRotateToLeft() {
		// TEastar pasarle 'l' y que gire a la izquierda
		
		Submarine nemo = new Submarine();
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.instructions('l');

		assertEquals( West.class, nemo.getDirection().getClass());
	}
	
	@Test public void canDoACompleteTurnAnticlockwise() {
		// 4 veces 'l' equivale a una vuelta completa y te deja mirando al mismo lugar
		
		Submarine nemo = new Submarine();
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.multipleInstructions("llll");

		assertEquals( North.class, nemo.getDirection().getClass());
	}

	@Test public void canRotateToRight() {
		// TEastar pasarle 'r' y que gire a la derecha

		Submarine nemo = new Submarine();

		assertEquals( Directions.initialDirection, nemo.getDirection());

		nemo.instructions('r');

		assertEquals( East.class, nemo.getDirection().getClass());
	}
	
	@Test public void canDoACompleteTurnClockwise() {
		// 4 veces 'r' equivale a una vuelta completa y te deja mirando al mismo lugar
		
		Submarine nemo = new Submarine();
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.multipleInstructions("rrrr");

		assertEquals( North.class, nemo.getDirection().getClass());
	}
	
	@Test public void rightOppositeToLeft() {
		// 'r' es opuesto a 'l'
		
		Submarine nemo = new Submarine();
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.instructions('r');
		nemo.instructions('l');

		assertEquals( North.class, nemo.getDirection().getClass());
	}

	@Test public void nemoCanGoFoward() {
		// TEastar pasarle 'f' y que avance una unidad en la direccion adecuada

		Submarine nemo = new Submarine();

		assertEquals(Coordenate.initialPosition, nemo.getCoordinate());

		nemo.instructions('f');

		assertEquals( 0 , nemo.getCoordinate().getX());
		assertEquals( 1 , nemo.getCoordinate().getY());
	}

	@Test public void canGoFowardManyTimes(){
		// Teastar pasarle multiples instrucciones de movimiento

		Submarine nemo = new Submarine();

		assertEquals( Coordenate.initialPosition, nemo.getCoordinate());

		nemo.multipleInstructions("fff");

		assertEquals( 0 , nemo.getCoordinate().getX());
		assertEquals( 3, nemo.getCoordinate().getY());
	}

	@Test public void CanGOFowardAndRotate(){
		// TEastar pasarle una instruccion de direccion y de movimiento

		Submarine nemo = new Submarine();

		assertEquals(Coordenate.initialPosition, nemo.getCoordinate());

		nemo.multipleInstructions("ffrff");

		assertEquals(2, nemo.getCoordinate().getX());
		assertEquals(2, nemo.getCoordinate().getY());
		assertEquals( East.class, nemo.getDirection().getClass());
	}

	@Test public void canRecieveComplexInstructions(){
		// TEastar mezcla de instrucciones de direccion, movimiento y profundidad

		Submarine nemo = new Submarine();

		assertEquals( Coordenate.initialPosition, nemo.getCoordinate());

		nemo.multipleInstructions("ufdfurffdlffd");

		assertEquals(2, nemo.getCoordinate().getX());
		assertEquals(4, nemo.getCoordinate().getY());
		assertEquals( North.class, nemo.getDirection().getClass());

	}

	@Test public void nemoCanThrowCapsule() {
		// TEastar pasarle 'm' y que lance una capsula

		Submarine nemo = new Submarine();

		assertTrue(nemo.isAtSurface());
		assertEquals( Coordenate.initialPosition, nemo.getCoordinate());
		assertEquals( Directions.initialDirection, nemo.getDirection());

		nemo.instructions('m');

		assertTrue(nemo.isAtSurface());
		assertEquals( Coordenate.initialPosition, nemo.getCoordinate());
		assertEquals( Directions.initialDirection, nemo.getDirection());

	}

	@Test public void cantThrowCapsuleTooDeep(){
		// TEastar el error si se intenta tirar una capsula a mas de 1 de profundidad

		Submarine nemo = new Submarine();

		nemo.multipleInstructions("dd");
		assertEquals( ManyBelowSurface.class, nemo.getProfundidad().getClass());

		assertEquals( ManyBelowSurface.excessOfChocolate,
				assertThrows( RuntimeException.class, () -> nemo.instructions('m')).getMessage());
	}
}