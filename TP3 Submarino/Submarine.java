package submarino;

import java.util.ArrayList;

public class Submarine {
	public ArrayList<Profundidades> profundidad;
	public Coordenate coordenadas;
	public Directions direccion;
	public static Instructions[] instructions = {new GoDown(), new GoUp(), new TurnRight(), new TurnLeft(), new GoForward(), new UseCapsule(), new DoNothing()};
	

	public static String excessOfChocolate = "El submarino exploto por exceso de chocolate";
	public static String noMoreCapsules = "No hay mas capsulas";

//	public static Profundidades[] profundidades = {new Surface(), new OneBelowSurface(), new ManyBelowSurface()};




    public Submarine() {
    	coordenadas = Coordenate.initialPosition;
    	direccion = Directions.initialDirection;
    	profundidad = new ArrayList<>();
    	profundidad.add( new Surface());
    }



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
}