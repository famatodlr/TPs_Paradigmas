package submarino;
import submarino.Directions.*;
public class Submarine {

	public static Coordenate initialPosition = new Coordenate( 0,0 );
	public static Directions initialDirection = new North();

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
//			if (direccion == "Norte") {
//				direccion = "Este";
//			}
//
//			else if (direccion == "Este") {
//				direccion = "Sur";
//			}
//
//			else if (direccion == "Sur") {
//				direccion = "Oeste";
//			}
//
//			else if (direccion == "Oeste") {
//				direccion = "Norte";
//			}
		}
		if (instruction == 'l') {
			direccion = direccion.turnLeft();
//			if (direccion == "Norte") {
//				direccion = "Oeste";
//			}
//
//			else if (direccion == "Oeste") {
//				direccion = "Sur";
//			}
//
//			else if (direccion == "Sur") {
//				direccion = "Este";
//			}
//
//			else if (direccion == "Este") {
//				direccion = "Norte";
//			}
		}
		if (instruction == 'f') {
			coordenada = direccion.goForward(coordenada);
			//			if (direccion == "Norte") {
//				coordenada = new Coordenate(coordenada.x, coordenada.y + 1);
//			}
//
//			else if (direccion == "Este") {
//				coordenada = new Coordenate(coordenada.x + 1, coordenada.y);
//			}
//
//			else if (direccion == "Sur") {
//				coordenada = new Coordenate(coordenada.x, coordenada.y - 1);
//			}
//
//			else if (direccion == "Oeste") {
//				coordenada = new Coordenate(coordenada.x - 1, coordenada.y);
//			}
		}
		if (instruction == 'm') {
			capsuleDrop(instruction);
		}
	}

	public void multipleInstructions(String instructions) {
		for (int i = 0; i < instructions.length(); i++) {
			instructions(instructions.charAt(i));
		}
	}

	public void capsuleDrop( Character instruction ) {
		if (isAtSurface() || profundidad == 1) {
			if (capsulas == 0) {
				throw new IllegalArgumentException("No hay mas capsulas");
			}
			capsulas -= 1;
		}

		else {
			throw new IllegalArgumentException("El submarino exploto por causa del chocolate");
		}
	}
}
