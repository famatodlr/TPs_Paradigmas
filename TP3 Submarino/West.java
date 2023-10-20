package submarino;

public class West extends Directions {

	public Directions turnRight() {
        return new North();
    }

    public Directions turnLeft() {
        return new South();
    }

    public Coordenate goForward(Coordenate coordenada) {
        return coordenada.left();
//        return coordenada.sum( new Coordenate( -1, 0));
    }
    
    public String str() {
    	return "West";
    }

}
