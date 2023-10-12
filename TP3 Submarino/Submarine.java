package submarino;

import directions.Directions;
import directions.North;

public class Submarine {

	public static Coordenate initialPosition = new Coordenate( 0,0 );
	public static Directions initialDirection = new North();
	
	public static String excessOfChocolate = "El submarino exploto por exceso de chocolate";
	public static String noMoreCapsules = "No hay mas capsulas";

	public Coordenate coordenada = initialPosition;
	public int profundidad = 0;
	public Directions direccion = initialDirection;

	public static int capacityCapsulas = 1;
	public int capsulas = capacityCapsulas;


	public boolean isAtSurface(){
        return profundidad == 0;
	}
	
	public void instructions(Character instruction) {
		if (instruction == 'd') {
			profundidad += 1;
		}
		
		if (instruction == 'u') {
			if (profundidad > 0) {
				profundidad -=1;
			}
		}
		
		if (instruction == 'r') {
			direccion = direccion.turnRight();
		}
		
		if (instruction == 'l') {
			direccion = direccion.turnLeft();
		}
		
		if (instruction == 'f') {
			coordenada = direccion.goForward(coordenada);
		}

		if (instruction == 'm') {
			if (isAtSurface() || profundidad == 1) {
				if (capsulas == 0) {
					throw new RuntimeException(noMoreCapsules);
				}
				capsulas --;
			}
	
			else {
				throw new RuntimeException(excessOfChocolate);
			}
		}
	}

	public void multipleInstructions(String instructions) {
		for (int i = 0; i < instructions.length(); i++) {
			instructions(instructions.charAt(i));
		}
	}
}
