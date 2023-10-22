package submarino;

import submarino.Points;
public class Coordenate{

	private Points position;

	public Coordenate(Points point) {
		this.position = point;
	}

	public static Coordenate initialPosition = new Coordenate(new Points(0, 0));

	public Points getCoordinates() {
		return position;
	}

	public void updateCoordinates(Points point) {
		position = point.sum(position);
	}
}