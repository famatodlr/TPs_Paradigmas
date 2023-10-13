package instructions;

public class Instructions {

	public static int goDown(int profundidad) {
		return profundidad += 1;
	}

	public static int goUp(int profundidad) {
		if (profundidad > 0) {
			return profundidad -=1;
		}
		return profundidad;
	}
}
