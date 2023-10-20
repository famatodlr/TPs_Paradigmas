package submarino;


public class North extends Directions {

	public Directions turnRight() {
        return new East();
    }

    public Directions turnLeft() {
        return new West();
    }

    public Coordenate goForward(Coordenate coordenada) {
        return coordenada.up();
    }
    
    public String str() {
    	return "North";
    }

}