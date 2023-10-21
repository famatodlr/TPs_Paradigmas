package submarino;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;


public class SubmarinoTest {
	
	@Test public void nemoIsCreatedInTheInitialPositionAndDirection01() {
		// Esta en la superficie?
		// En que poosicion esta?
		// Para donde esta mirando? (direccion)

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		assertTrue(nemo.isAtSurface());
		assertEquals(Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());
		assertEquals( Directions.initialDirection, nemo.getDirection());
	}

	@Test public void nemoDontReactToEmptyInstructions02() {
		// Le paso "" y permanece en el lugar

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());
		
		assertTrue(nemo.isAtSurface());
		assertEquals(Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());

		nemo.multipleInstructions(" ");
		
		assertTrue(nemo.isAtSurface());
		assertEquals(Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());
	}
	
	@Test public void nemoCanGoDown03() {
		//Testear pasarle 'd'

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());
		
		assertTrue(nemo.isAtSurface());
		
		nemo.multipleInstructions("d");
		
		assertFalse(nemo.isAtSurface());
		assertEquals( OneBelowSurface.class, nemo.getProfundidad().getClass());
	}
	
	@Test public void nemoDontReactIfGoesUpInSurface04() {
		// Testear pasarle 'u' en la superficie y que se quede ahi

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());
		
		assertTrue(nemo.isAtSurface());
		
		nemo.multipleInstructions("u");
		
		assertTrue(nemo.isAtSurface());
	}
	
	@Test public void nemoCanGoUp05(){
		// Testear pasarle 'u' bajo la superficie y que suba (u es opuesto a d)

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());
		
		nemo.multipleInstructions("d");
		
		assertFalse(nemo.isAtSurface());
		assertEquals( OneBelowSurface.class, nemo.getProfundidad().getClass());

		nemo.multipleInstructions("u");
		
		assertTrue(nemo.isAtSurface());
	}
	
	
	@Test public void canRotateToLeft06() {
		// TEastar pasarle 'l' y que gire a la izquierda

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.multipleInstructions("l");

		assertEquals( West.class, nemo.getDirection().getClass());
	}
	
	@Test public void canDoACompleteTurnAnticlockwise07() {
		// 4 veces 'l' equivale a una vuelta completa y te deja mirando al mismo lugar

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.multipleInstructions("llll");

		assertEquals( North.class, nemo.getDirection().getClass());
	}

	@Test public void canRotateToRight08() {
		// TEastar pasarle 'r' y que gire a la derecha

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		assertEquals( Directions.initialDirection, nemo.getDirection());

		nemo.multipleInstructions("r");

		assertEquals( East.class, nemo.getDirection().getClass());
	}
	
	@Test public void canDoACompleteTurnClockwise09() {
		// 4 veces 'r' equivale a una vuelta completa y te deja mirando al mismo lugar

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.multipleInstructions("rrrr");

		assertEquals( North.class, nemo.getDirection().getClass());
	}
	
	@Test public void rightOppositeToLeft10() {
		// 'r' es opuesto a 'l'

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.multipleInstructions("r");
		nemo.multipleInstructions("l");

		assertEquals( North.class, nemo.getDirection().getClass());
	}

	@Test public void nemoCanGoFoward11() {
		// Testear pasarle 'f' y que avance una unidad en la direccion adecuada

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		assertEquals(Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());

		nemo.multipleInstructions("f");

		assertEquals( 0 , nemo.getCoordinate().getX());
		assertEquals( 1 , nemo.getCoordinate().getY());
	}

	@Test public void canGoFowardManyTimes12(){
		// Teastar pasarle multiples instrucciones de movimiento

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		assertEquals( Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());

		nemo.multipleInstructions("fff");

		assertEquals( 0 , nemo.getCoordinate().getX());
		assertEquals( 3, nemo.getCoordinate().getY());
		assertEquals( North.class, nemo.getDirection().getClass());
	}

	@Test public void CanGOFowardAndRotate13(){
		// TEastar pasarle una instruccion de direccion y de movimiento

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		assertEquals(Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());

		nemo.multipleInstructions("ffrff");

		assertEquals(2, nemo.getCoordinate().getX());
		assertEquals(2, nemo.getCoordinate().getY());
		assertEquals( East.class, nemo.getDirection().getClass());
	}

	@Test public void canRecieveComplexInstructions14(){
		// TEastar mezcla de instrucciones de direccion, movimiento y profundidad

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		assertEquals( Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());

		nemo.multipleInstructions("ufdfurffdlffd");

		assertEquals(2, nemo.getCoordinate().getX());
		assertEquals(4, nemo.getCoordinate().getY());
		assertEquals( North.class, nemo.getDirection().getClass());

	}



	@Test public void nemoCanThrowCapsule15() {
		// TEastar pasarle 'm' y que lance una capsula

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		assertTrue(nemo.isAtSurface());
		assertEquals( Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());
		assertEquals( Directions.initialDirection, nemo.getDirection());

		nemo.multipleInstructions("m");

		assertTrue(nemo.isAtSurface());
		assertEquals( Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());
		assertEquals( Directions.initialDirection, nemo.getDirection());

	}

	@Test public void nemoCanThrowCapsuleInOneLevelBelowSurface16(){
		// Testear pasarle 'd' y 'm' y que lance una capsula a 1 de profundidad

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		nemo.multipleInstructions("d");

		assertFalse(nemo.isAtSurface());
		assertEquals( OneBelowSurface.class, nemo.getProfundidad().getClass());

		nemo.multipleInstructions("m");

		assertFalse(nemo.isAtSurface());
		assertEquals( OneBelowSurface.class, nemo.getProfundidad().getClass());
	}

	@Test public void nemoCanMoveAndThrowCapsule17(){
		//Testear que puede bajar y subir a una altura valida y tirar una capsula
		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		nemo.multipleInstructions("d");
		nemo.multipleInstructions("d");
		nemo.multipleInstructions("u");
		nemo.multipleInstructions("m");

		assertFalse(nemo.isAtSurface());
		assertEquals( Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());
		assertEquals( Directions.initialDirection, nemo.getDirection());
	}

	@Test public void cantThrowCapsuleTooDeep18(){
		// TEastar el error si se intenta tirar una capsula a mas de 1 de profundidad

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		nemo.multipleInstructions("dd");
		assertEquals( ManyBelowSurface.class, nemo.getProfundidad().getClass());

		assertEquals( ManyBelowSurface.excessOfChocolate,
				assertThrows( RuntimeException.class, () -> nemo.multipleInstructions("m")).getMessage());
	}

	@Test public void nemoCanDropMultipleCapsules19(){
		// TEastar que puede tirar multiples capsulas

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		nemo.multipleInstructions("m");
		nemo.multipleInstructions("m");
		nemo.multipleInstructions("m");

		assertTrue(nemo.isAtSurface());
		assertEquals( Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());
		assertEquals( Directions.initialDirection, nemo.getDirection());
	}

	@Test public void nemoCanDropMultipleCapsulesAtDifferentLevels20(){
		// TEastar que puede tirar multiples capsulas a diferentes profundidades

		Submarine nemo = new Submarine(Coordenate.initialPosition, new Height());

		nemo.multipleInstructions("mdmum");

		assertTrue(nemo.isAtSurface());
		assertEquals( Coordenate.initialPosition.getCoordinates(), nemo.getCoordinate());
		assertEquals( Directions.initialDirection, nemo.getDirection());
	}
}