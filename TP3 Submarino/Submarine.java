package submarino;

import java.util.ArrayList;

public class Submarine {

	private Directions direction;
	private Coordenate coordenada;
	private Height nivel;
	public static Points initialPosition = new Points(0,0);

	public static Directions initialDirection = new North();


	public static Instructions[] instructions = {new GoDown(), new GoUp(), new TurnRight(), new TurnLeft(), new GoForward(), new UseCapsule(), new DoNothing()};


	public Submarine(){

		this.direction = new North();
		this.coordenada = Points.initialPosition;
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

	public Points getCoordinate(){
		return coordenada.getCoordinates();
	}

	public Directions getDirection() {
		return direction;
	}

	public Profundidades getProfundidad() {
		return nivel.getProfundidad();
	}

//	public Height getNivel() {
//		return nivel.;
//	}
}
