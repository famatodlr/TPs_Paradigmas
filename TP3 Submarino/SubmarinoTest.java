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
//		assertEquals( Coordenate.initialPosition ,nemo.getCoordinate());
//		CHEQUEAR PORQUE NO ANDA CON GETCOORDINATE
		assertEquals(Coordenate.initialPosition, nemo.coordenadas);
		assertEquals( Directions.initialDirection, nemo.getDirection());
//		assertEquals( Coordenate.initialPosition, nemo.coordenadas);
//		assertEquals( Directions.initialDirection, nemo.direccion);

	}
	
	@Test public void nemoDontReactToEmptyInstructions() {
		// Le paso "" y permanece en el lugar
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		assertEquals( Coordenate.initialPosition, nemo.coordenadas);
		
		nemo.instructions(' ');
		
		assertTrue(nemo.isAtSurface());
		assertEquals( Coordenate.initialPosition, nemo.coordenadas);
//		assertEquals( 1 , nemo.capsulas);
	}
	
	@Test public void nemoCanGoDown() {
		//TEastar pasarle 'd'
		
		Submarine nemo = new Submarine();
		
		assertTrue(nemo.isAtSurface());
		
		nemo.instructions('d');
		
		assertFalse(nemo.isAtSurface());
//		assertEquals( 1 , nemo.getProfundidad());
//		assertEquals( new OneBelowSurface().str()  , nemo.profundidad.get( nemo.profundidad.size() -1 ).str() );
		assertEquals( new OneBelowSurface().str()  , nemo.getProfundidad().str() );
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
//		assertEquals( 1 , nemo.getProfundidad());
//		assertEquals( new OneBelowSurface().str() , nemo.profundidad.get( nemo.profundidad.size() -1 ).str() );
		assertEquals( new OneBelowSurface().str() , nemo.getProfundidad().str() );


		nemo.instructions('u');
		
		assertTrue(nemo.isAtSurface());
	}
	
	
	@Test public void canRotateToLeft() {
		// TEastar pasarle 'l' y que gire a la izquierda
		
		Submarine nemo = new Submarine();
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.instructions('l');
		
		assertEquals( "West", nemo.getDirection().str());
	}
	
	@Test public void canDoACompleteTurnAnticlockwise() {
		// 4 veces 'l' equivale a una vuelta completa y te deja mirando al mismo lugar
		
		Submarine nemo = new Submarine();
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.multipleInstructions("llll");
		
		assertEquals( "North", nemo.getDirection().str());
	}

	@Test public void canRotateToRight() {
		// TEastar pasarle 'r' y que gire a la derecha

		Submarine nemo = new Submarine();

		assertEquals( Directions.initialDirection, nemo.getDirection());

		nemo.instructions('r');

		assertEquals( "East", nemo.getDirection().str());
	}
	
	@Test public void canDoACompleteTurnClockwise() {
		// 4 veces 'r' equivale a una vuelta completa y te deja mirando al mismo lugar
		
		Submarine nemo = new Submarine();
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.multipleInstructions("rrrr");
		
		assertEquals( "North", nemo.getDirection().str());
	}
	
	@Test public void rightOppositeToLeft() {
		// 'r' es opuesto a 'l'
		
		Submarine nemo = new Submarine();
		
		assertEquals( Directions.initialDirection, nemo.getDirection());
		
		nemo.instructions('r');
		nemo.instructions('l');
		
		assertEquals( "North", nemo.getDirection().str());
	}

	@Test public void nemoCanGoFoward() {
		// TEastar pasarle 'f' y que avance una unidad en la direccion adecuada

		Submarine nemo = new Submarine();

//		assertEquals( Points.initialPosition.getCoordinates(), nemo.getCoordinate());
//
//		nemo.instructions('f');
//
//		assertEquals(new Points(0, 1), nemo.getCoordinate());

		assertEquals( Coordenate.initialPosition, nemo.coordenadas);

		nemo.instructions('f');

		assertEquals(0, nemo.coordenadas.x);
		assertEquals(1, nemo.coordenadas.y);
	}

	@Test public void canGoFowardManyTimes(){
		// Teastar pasarle multiples instrucciones de movimiento

		Submarine nemo = new Submarine();

//		assertEquals( Points.initialPosition.getCoordinates(), nemo.getCoordinate());
//
//		nemo.multipleInstructions("fff");
//
//		assertEquals(new Points(0, 3), nemo.getCoordinate());
		assertEquals( Coordenate.initialPosition, nemo.coordenadas);

		nemo.multipleInstructions("fff");

		assertEquals(0, nemo.coordenadas.x);
		assertEquals(3, nemo.coordenadas.y);
	}

	@Test public void CanGOFowardAndRotate(){
		// TEastar pasarle una instruccion de direccion y de movimiento

		Submarine nemo = new Submarine();

//		assertEquals( Points.initialPosition.getCoordinates(), nemo.getCoordinate());
//
//		nemo.multipleInstructions("ffrff");
//
//		assertEquals(new Points(2,2), nemo.getCoordinate());
//
//		assertEquals( "East", nemo.getDirection().str());
		assertEquals( Coordenate.initialPosition, nemo.coordenadas);

		nemo.multipleInstructions("ffrff");

		assertEquals(2, nemo.coordenadas.x);
		assertEquals(2, nemo.coordenadas.y);
		assertEquals( "East", nemo.direccion.str());
	}

	@Test public void canRecieveComplexInstructions(){
		// TEastar mezcla de instrucciones de direccion, movimiento y profundidad

		Submarine nemo = new Submarine();

//		assertEquals( Points.initialPosition.getCoordinates(), nemo.getCoordinate());
//
//		nemo.multipleInstructions("ufdfurffdlffd");
//
//		assertEquals(new Points(2,4), nemo.getCoordinate());
//		assertEquals( "North", nemo.getDirection().str());
//		assertEquals( 2, nemo.getProfundidad());
		assertEquals( Coordenate.initialPosition, nemo.coordenadas);

		nemo.multipleInstructions("ufdfurffdlffd");

		assertEquals(2, nemo.coordenadas.x);
		assertEquals(4, nemo.coordenadas.y);
		assertEquals( "North", nemo.direccion.str());
//		assertEquals( new ManyBelowSurface(this).str(), nemo.profundidad.get( nemo.profundidad.size() -1 ).str());

	}

	@Test public void nemoCanThrowCapsule() {
		// TEastar pasarle 'm' y que lance una capsula

		Submarine nemo = new Submarine();

		assertTrue(nemo.isAtSurface());
		assertEquals( Coordenate.initialPosition, nemo.coordenadas);
		assertEquals( Directions.initialDirection, nemo.direccion);

		nemo.instructions('m');

		assertTrue(nemo.isAtSurface());
		assertEquals( Coordenate.initialPosition, nemo.coordenadas);
		assertEquals( Directions.initialDirection, nemo.direccion);

	}

	@Test public void cantThrowCapsuleTooDeep(){
		// TEastar el error si se intenta tirar una capsula a mas de 1 de profundidad

		Submarine nemo = new Submarine();

		nemo.multipleInstructions("dd");
//		assertEquals(  new ManyBelowSurface().str(), nemo.profundidad.get( nemo.profundidad.size() -1 ).str());

		assertEquals( ManyBelowSurface.excessOfChocolate,
				assertThrows( RuntimeException.class, () -> nemo.instructions('m')).getMessage());
	}
}
