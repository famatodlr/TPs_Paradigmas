package submarino;

import java.util.ArrayList;

public class Submarine {

	public static String excessOfChocolate = "El submarino exploto por exceso de chocolate";
	public static String noMoreCapsules = "No hay mas capsulas";


	public static Instructions[] instructions = {new GoDown(), new GoUp(), new TurnRight(), new TurnLeft(), new GoForward(), new UseCapsule(), new DoNothing()};

//	public static Profundidades[] profundidades = {new Surface(), new OneBelowSurface(), new ManyBelowSurface()};

	public Coordenate coordenada = Coordenate.initialPosition;

//	public static ArrayList<Profundidades> profundidades = new ArrayList<>().add(new Surface());








	public Directions direccion = Directions.initialDirection;
//	public int capsulas = 1;


	public boolean isAtSurface(){
        return Profundidades.isSurface();
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


//		if (instruction == 'd') {
//			profundidad = Instructions.goDown( profundidad );
//		}
//
//		if (instruction == 'u') {
//			profundidad = Instructions.goUp( profundidad );
//		}
//
//		if (instruction == 'r') {
//			direccion = direccion.turnRight();
//		}
//
//		if (instruction == 'l') {
//			direccion = direccion.turnLeft();
//		}
//
//		if (instruction == 'f') {
//			coordenada = direccion.goForward(coordenada);
//		}
//
//		if (instruction == 'm') {
//			if (isAtSurface() || profundidad == 1) {
//				if (capsulas == 0) {
//					throw new RuntimeException(noMoreCapsules);
//				}
//				capsulas --;
//			}
//
//			else {
//				throw new RuntimeException(excessOfChocolate);
//			}
//		}
