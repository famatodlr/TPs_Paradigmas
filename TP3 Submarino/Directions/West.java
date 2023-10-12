package directions;

import submarino.Coordenate;

public class West extends Directions {

	public Directions turnRight() {
        return new North();
    }

    public Directions turnLeft() {
        return new South();
    }

    public Coordenate goForward(Coordenate coordenada) {
        return coordenada.left();
    }

}
