package submarino;

public class Coordenate{
	private Points position;
	public Coordenate(Points point) {
		this.position = point;
	}
	public Points getCoordinates() {
		return position;
	}
	public void updateCoordinates(Points point) {
		position = point.sum(position);
	}
}