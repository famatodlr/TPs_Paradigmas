package submarino;

public class Submarine {
	private Coordenate coordenadas;
	private Directions direccion;
	private Height nivel;
	public static Instructions[] instructions = {new GoDown(), new GoUp(), new TurnRight(), new TurnLeft(), new GoForward(), new UseCapsule(), new DoNothing()};

	public Submarine(Coordenate coordenadas) {
		this.coordenadas = coordenadas;
		this.nivel = new Height();
		direccion = new North();
	}

	public void instructions(Character instruction) {
		new Instructions().followComand(instruction, this);
	}
	public void multipleInstructions(String instructions) {
		instructions.chars().forEach(instruction -> this.instructions((char) instruction));

	}

	public boolean isAtSurface() {
		return nivel.isSurface();
	}
	public Points getCoordinate() {
		return coordenadas.getCoordinates();
	}
	public Directions getDirection() {
		return direccion;
	}
	public Profundidades getProfundidad() {
		return this.nivel.getProfundidad();
	}

	public void updatePosition(Points points) {
		coordenadas.updateCoordinates(points);
	}
	public void updateDirection(Directions direction) {
		this.direccion = direction;
	}

	public void Emerge() {
		this.nivel.Emerger();
	}
	public void Submerger() {
		this.nivel.Submerger();
	}
	public void moveSomewhere() {
		this.direccion.moveSomewhere(this);
	}
	public void useCapsule() {
		this.nivel.getProfundidad().useCapsule();
	}
}

