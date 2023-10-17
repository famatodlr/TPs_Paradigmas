package directions;

import gps.Coordenate;

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
    
    public String str() {
    	return "South";
    }

}
