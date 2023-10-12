package directions;

import submarino.Coordenate;

public class South extends Directions {

    public Directions turnRight() {
        return new West();
    }

    public Directions turnLeft() {
        return new East();
    }

    public Coordenate goForward(Coordenate coordenada) {
        return coordenada.down();
    }

}
