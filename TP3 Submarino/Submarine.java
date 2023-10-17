package submarino;

import java.util.ArrayList;

public class Submarine {

	private Directions direction;
	private Coordenate coordenada;
	private Height nivel;
	public static Instructions[] instructions = {new GoDown(), new GoUp(), new TurnRight(), new TurnLeft(), new GoForward(), new UseCapsule(), new DoNothing()};


	public Submarine(){

		this.direction = new North();
		this.coordenada = Coordenate.initialPosition;
		this.nivel = new Height();
	}


	public boolean isAtSurface(){
        return nivel.isSurface();
	}
	
	public void instructions(Character instruction) {
		new Instructions().followComand(instruction);

	}

	public void multipleInstructions(String instructions) {
		for (int i = 0; i < instructions.length(); i++) {
			instructions(instructions.charAt(i));
		}
	}

	public Points getCoordinte(){
		return coordenada.getCoordinates();
	}

//	public Height getNivel() {
//		return nivel.;
//	}
}
