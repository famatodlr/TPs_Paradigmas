package submarino;

public class Coordenate{

	private Points points;
	public Coordenate( int x, int y) {
        this.points = new Points(x, y);
	}


	public Points getCoordinates() {
		return points;
	}
	
	public Coordenate left() {
        return new Coordenate( Points.x - 1, Points.y);
	}

	public Coordenate right() {
		return new Coordenate( Points.x + 1, Points.y);
	}

	public Coordenate up() {
		return new Coordenate( Points.x, Points.y + 1);
	}

	public Coordenate down() {
		return new Coordenate( Points.x, Points.y - 1);
	}
}