package submarino;

import directions.Directions;
import gps.Coordenate;
import instructions.Instructions;

public class Submarine {
	
	public static String excessOfChocolate = "El submarino exploto por exceso de chocolate";
	public static String noMoreCapsules = "No hay mas capsulas";

	public Coordenate coordenada = Coordenate.initialPosition;
	public int profundidad = 0;
	public Directions direccion = Directions.initialDirection;
	public int capsulas = 1;


	public boolean isAtSurface(){
        return profundidad == 0;
	}
	
	public void instructions(Character instruction) {
		if (instruction == 'd') {
			profundidad = Instructions.goDown( profundidad );
		}
		
		if (instruction == 'u') {
			profundidad = Instructions.goUp( profundidad );
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
