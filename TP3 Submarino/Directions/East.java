package directions;
import submarino.Coordenate;

public class East extends Directions {

    public Directions turnRight() {
        return new South();
    }

    public Directions turnLeft() {
        return new North();
    }

    public Coordenate goForward(Coordenate coordenada) {
        return coordenada.right();
    }
}