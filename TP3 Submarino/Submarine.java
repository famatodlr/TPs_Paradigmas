package submarino;

import java.util.ArrayList;

public class Submarine {

	public ArrayList<Profundidades> profundidad;
	public Coordenate coordenadas;
	public Directions direccion;
//	private Height nivel;
	public static Instructions[] instructions = {new GoDown(), new GoUp(), new TurnRight(), new TurnLeft(), new GoForward(), new UseCapsule(), new DoNothing()};

    public Submarine() {
    	coordenadas = Coordenate.initialPosition;
    	direccion = Directions.initialDirection;
    	profundidad = new ArrayList<>();
    	profundidad.add( new Surface());
//		this.nivel = new Height();
    }

	public boolean isAtSurface(){
        return profundidad.get( profundidad.size() -1 ).isSurface();
	}
	
	public Submarine instructions(Character instruction) {
		return new Instructions().followComand(instruction, this);
	}

	public void multipleInstructions(String instructions) {
		for (int i = 0; i < instructions.length(); i++) {
			instructions(instructions.charAt(i));
		}
	}

//	public Points getCoordinate(){
//		return coordenada.getCoordinates();
//	}

	public Directions getDirection() {
		return direccion;
	}

//	public Profundidades getProfundidad() {
//		return nivel.getProfundidad();
	}

//	public Height getNivel() {
//		return nivel.;
//	}
//}
