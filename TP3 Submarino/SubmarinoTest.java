package submarino;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

public class SubmarinoTest {
	@Test public void nemoIsCreatedInTheinitialPositionAndDirection01() {
		Submarine nemo = new Submarine( initialCoordinate() );
		assertInitialVariables(nemo);
	}

	@Test public void nemoDontReactToEmptyInstructions02() {
		Submarine nemo = new Submarine(initialCoordinate());
		assertInitialVariables(nemo);

		nemo.instructions(" ");

		assertInitialVariables(nemo);
	}

	@Test public void nemoCanGoDown03() {
		Submarine nemo = new Submarine(initialCoordinate());
		assertTrue(nemo.isAtSurface());

		nemo.instructions("d");

		assertFalse(nemo.isAtSurface());
		assertProfundidad(nemo, new OneBelowSurface());
	}

	@Test public void nemoDontReactIfGoesUpInSurface04() {
		Submarine nemo = new Submarine(initialCoordinate());
		assertTrue(nemo.isAtSurface());

		nemo.instructions("u");

		assertTrue(nemo.isAtSurface());
	}

	@Test public void nemoCanGoUp05(){
		Submarine nemo = new Submarine(initialCoordinate());

		nemo.instructions("d");

		assertFalse(nemo.isAtSurface());
		assertProfundidad(nemo, new OneBelowSurface());

		nemo.instructions("u");

		assertTrue(nemo.isAtSurface());
	}


	@Test public void canRotateToLeft06() {
		Submarine nemo = new Submarine(initialCoordinate());
		assertDirections(nemo, initialDirection());

		nemo.instructions("l");

		assertDirections(nemo, new West());
	}

	@Test public void canDoACompleteTurnAnticlockwise07() {
		Submarine nemo = new Submarine(initialCoordinate());
		assertDirections(nemo, initialDirection());

		nemo.instructions("llll");

		assertDirections(nemo, initialDirection());
	}

	@Test public void canRotateToRight08() {
		Submarine nemo = new Submarine(initialCoordinate());
		assertDirections(nemo, initialDirection());

		nemo.instructions("r");

		assertDirections(nemo, new East());
	}

	@Test public void canDoACompleteTurnClockwise09() {
		Submarine nemo = new Submarine(initialCoordinate());
		assertDirections(nemo, initialDirection());

		nemo.instructions("rrrr");

		assertDirections(nemo, initialDirection());
	}

	@Test public void rightOppositeToLeft10() {
		Submarine nemo = new Submarine(initialCoordinate());
		assertDirections(nemo, initialDirection());

		nemo.instructions("rl");

		assertDirections(nemo, initialDirection());
	}

	@Test public void nemoCanGoFoward11() {
		Submarine nemo = new Submarine(initialCoordinate());
		assertInitialVariables(nemo);

		nemo.instructions("f");

		assertCoordinatesAndDirections(nemo, 0, 1, initialDirection());
	}

	@Test public void canGoFowardManyTimes12(){
		Submarine nemo = new Submarine(initialCoordinate());
		assertInitialVariables(nemo);

		nemo.instructions("fff");

		assertCoordinatesAndDirections(nemo, 0, 3, initialDirection());
	}
	@Test public void CanGOFowardAndRotate13(){
		Submarine nemo = new Submarine(initialCoordinate());
		assertInitialVariables(nemo);

		nemo.instructions("ffrff");

		assertCoordinatesAndDirections(nemo, 2, 2, new East());
	}
	@Test public void canRecieveComplexInstructions14(){
		Submarine nemo = new Submarine(initialCoordinate());
		assertInitialVariables(nemo);

		nemo.instructions("ufdfurffdlffd");

		assertProfundidad(nemo, new ManyBelowSurface( new OneBelowSurface()));
		assertCoordinatesAndDirections(nemo, 2, 4, new North());

	}
	@Test public void nemoCanThrowCapsule15() {
		Submarine nemo = new Submarine(initialCoordinate());
		assertInitialVariables(nemo);

		nemo.instructions("m");

		assertInitialVariables(nemo);

	}
	@Test public void nemoCanThrowCapsuleInOneLevelBelowSurface16(){
		Submarine nemo = new Submarine(initialCoordinate());


		nemo.instructions("d");

		assertProfundidad(nemo, new OneBelowSurface());

		nemo.instructions("m");

		assertCoordinatesAndDirections(nemo, 0, 0, initialDirection());
		assertProfundidad(nemo, new OneBelowSurface());

	}
	@Test public void nemoCanMoveAndThrowCapsule17(){
		Submarine nemo = new Submarine(initialCoordinate());

		nemo.instructions("ddum");

		assertProfundidad(nemo, new OneBelowSurface());

		nemo.instructions("u");

		assertTrue(nemo.isAtSurface());

		nemo.instructions("m");

		assertTrue(nemo.isAtSurface());
		assertCoordinatesAndDirections(nemo, 0, 0, initialDirection());
	}
	@Test public void cantThrowCapsuleTooDeep18(){
		Submarine nemo = new Submarine(initialCoordinate());

		nemo.instructions("dd");
		assertProfundidad(nemo, new ManyBelowSurface( new OneBelowSurface()));

		assertEquals( ManyBelowSurface.excessOfChocolate,
				assertThrows( RuntimeException.class, () -> nemo.instructions("m")).getMessage());
	}
	@Test public void nemoCanDropMultipleCapsules19(){
		Submarine nemo = new Submarine(initialCoordinate());
		assertInitialVariables(nemo);

		nemo.instructions("mmm");

		assertInitialVariables(nemo);
	}
	@Test public void nemoCanDropMultipleCapsulesAtDifferentLevels20(){
		Submarine nemo = new Submarine(initialCoordinate());
		assertInitialVariables(nemo);

		nemo.instructions("mdmum");

		assertCoordinatesAndDirections(nemo, 0, 0, initialDirection());
	}
	@Test public void nemoCanInitializeInDifferentCoordinates21(){
		Submarine nemo = new Submarine(new Coordenate(new Points(1,2)));
		assertCoordinatesAndDirections(nemo, 1, 2, initialDirection());
	}




	private void assertCoordinates(Submarine nemo, int x, int y) {
		assertEquals(x, nemo.getCoordinate().getX());
		assertEquals(y, nemo.getCoordinate().getY());
	}

	private void assertDirections( Submarine nemo, Directions direction){
		assertEquals(direction.getClass(), nemo.getDirection().getClass());
	}

	public void assertCoordinatesAndDirections(Submarine nemo, int x, int y, Directions direction){
		assertCoordinates(nemo, x, y);
		assertDirections(nemo, direction);
	}

	private void assertProfundidad(Submarine nemo, Profundidades profundidad){
		assertEquals(profundidad.getClass(), nemo.getProfundidad().getClass());
	}

	private void assertInitialVariables(Submarine nemo) {
		assertTrue(nemo.isAtSurface());
		assertCoordinates(nemo, 0, 0);
		assertDirections(nemo, initialDirection());
	}

	private Coordenate initialCoordinate(){
		return new Coordenate( new Points(0,0) );
	}

	private Directions initialDirection(){
		return new North();
	}
}