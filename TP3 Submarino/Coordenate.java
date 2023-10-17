package submarino;

public class Coordenate{

	private Points points;
	public Coordenate( int x, int y) {
        this.points = new Points(0,0);
	}


	public Points getCoordinates() {
		return points;
	}
	
	public Coordenate left() {
		return new Coordenate( x - 1, y);
	}

	public Coordenate right() {
		return new Coordenate( x + 1, y);
	}

	public Coordenate up() {
		return new Coordenate( x, y + 1);
	}

	public Coordenate down() {
		return new Coordenate( x, y - 1);
	}
}