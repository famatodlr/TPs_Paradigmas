package submarino;

public class Submarine {

	public static Coordenate initialPosition = new Coordenate( 0,0 );
	public static String initialDirection = "Norte";
	
	public Coordenate coordenada = initialPosition;
	public int profundidad = 0;
	public String direccion = initialDirection;
	
	public boolean isAtSurface(){
		if (profundidad == 0) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public void instructions(String instruction) {
		if (instruction == "d") {
			profundidad += 1;
		}
		
		else if (instruction == "u") {
			if (profundidad > 0) {
				profundidad -=1;
			}
		}
		
		else if (instruction == "l") {
			if (direccion == "Norte") {
				direccion = "Este";
				return;
			}
			
			else if (direccion == "Este") {
				direccion = "Sur";
				return;
			}
			
			else if (direccion == "Sur") {
				direccion = "Oeste";
				return;
			}
			
			else if (direccion == "Oeste") {
				direccion = "Norte";
				return;
			}
		}
	}
}
