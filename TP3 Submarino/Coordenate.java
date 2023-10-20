package submarino;

public class Coordenate{
	public int x;
	public int y;

	public String direccionActual;

	public Coordenate( int x, int y) {
//        this.points = new Points(x, y);
//	}
		this.x = x;
		this.y = y;


	}
	
	public static Coordenate initialPosition = new Coordenate( 0,0 );
	
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

	public Coordenate getCoordinates() {
		return new Coordenate( x, y);
	}
}