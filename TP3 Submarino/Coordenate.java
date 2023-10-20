package submarino;

public class Coordenate{
	private int x;
	private int y;

	public String direccionActual;

	public Coordenate( int x, int y) {
//        this.points = new Points(x, y);
//	}
		this.x = x;
		this.y = y;
	}
	
	public static Coordenate initialPosition = new Coordenate( 0,0 );
	
	public Coordenate left() {
//        return new Coordenate( this.x - 1, this.y);
		return this.sum( new Coordenate( -1, 0));
	}

	public Coordenate right() {
//		return new Coordenate( this.x + 1, this.y);
		return this.sum( new Coordenate( 1, 0));
	}

	public Coordenate up() {
//		return new Coordenate( this.x, this.y + 1);
		return this.sum( new Coordenate( 0, 1));
	}

	public Coordenate down() {
//		return new Coordenate( this.x, this.y - 1);
		return this.sum( new Coordenate( 0, -1));
	}

	public Coordenate getCoordinates() {
		return this;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public Coordenate sum( Coordenate coordenate){
		return new Coordenate( this.getX() + coordenate.getX(), this.getY() + coordenate.getY());
	}
}