package gps;

public class Coordenate{
	public int x;
	public int y;

	public String direccionActual;

	public Coordenate( int x, int y) {
		this.x = x;
		this.y = y;

	}
	
	public static Coordenate initialPosition = new Coordenate( 0,0 );
	
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