package submarino;

public class Submarine {

	public Coordenate coordenadas;
	public Directions direccion;
	public Height nivel;

	public static Instructions[] instructions = {new GoDown(), new GoUp(), new TurnRight(), new TurnLeft(), new GoForward(), new UseCapsule(), new DoNothing()};


	//PONER PARAMETROS
	public Submarine() {
		coordenadas = Coordenate.initialPosition;
		direccion = Directions.initialDirection;
		nivel = new Height();
	}

	public boolean isAtSurface() {
		return nivel.isSurface();
	}

	public void instructions(Character instruction) {
		new Instructions().followComand(instruction, this);
	}

	public void multipleInstructions(String instructions) {
		instructions.chars().forEach( instruction -> this.instructions( (char) instruction ));
	}

	public Coordenate getCoordinate() {
		return coordenadas.getCoordinates();
	}

	public Directions getDirection() {
		return direccion;
	}


	public Profundidades getProfundidad() {
		return nivel.getProfundidad();
	}
}

