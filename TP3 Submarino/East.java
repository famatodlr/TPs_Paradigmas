package submarino;

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
    
    public String str() {
    	return "East";
    }
}