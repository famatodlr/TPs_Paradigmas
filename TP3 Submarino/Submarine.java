package submarino;

import java.util.ArrayList;

public class Submarine {
<<<<<<< HEAD

	private Directions direction;
	private Coordenate coordenada;
	private Height nivel;
	public static Points initialPosition = new Points(0,0);

	public static Directions initialDirection = new North();


=======
	public ArrayList<Profundidades> profundidad;
	public Coordenate coordenadas;
	public Directions direccion;
>>>>>>> 02993c47ede8d8b0680d8068bc41c48194a9031f
	public static Instructions[] instructions = {new GoDown(), new GoUp(), new TurnRight(), new TurnLeft(), new GoForward(), new UseCapsule(), new DoNothing()};
	

	public static String excessOfChocolate = "El submarino exploto por exceso de chocolate";
	public static String noMoreCapsules = "No hay mas capsulas";

//	public static Profundidades[] profundidades = {new Surface(), new OneBelowSurface(), new ManyBelowSurface()};



<<<<<<< HEAD
		this.direction = new North();
		this.coordenada = Points.initialPosition;
		this.nivel = new Height();
	}
=======

    public Submarine() {
    	coordenadas = Coordenate.initialPosition;
    	direccion = Directions.initialDirection;
    	profundidad = new ArrayList<>();
    	profundidad.add( new Surface());
    }

>>>>>>> 02993c47ede8d8b0680d8068bc41c48194a9031f


	public boolean isAtSurface(){
        return profundidad.get( profundidad.size() -1 ).isSurface();
	}
	
	public void instructions(Character instruction) {
		new Instructions().followComand(instruction);

	}

	public void multipleInstructions(String instructions) {
		for (int i = 0; i < instructions.length(); i++) {
			instructions(instructions.charAt(i));
		}
	}
<<<<<<< HEAD

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
=======
}
>>>>>>> 02993c47ede8d8b0680d8068bc41c48194a9031f
