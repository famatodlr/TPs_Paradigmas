package submarino;

public class Coordenate{
	private int x;
	private int y;

//	public String direccionActual;

	public Coordenate( int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Coordenate initialPosition = new Coordenate( 0,0 );


	//CAMBIAR PARA QUE CADA DIRECCION SEPA Y NO LA CLASE DIRECTIONS
	public Coordenate left() {
		return this.sum( new Coordenate( -1, 0));
	}

	public Coordenate right() {
		return this.sum( new Coordenate( 1, 0));
	}

	public Coordenate up() {
		return this.sum( new Coordenate( 0, 1));
	}

	public Coordenate down() {
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