package submarino;


public class South extends Directions {

    public Directions turnRight() {
        return new West();
    }

    public Directions turnLeft() {
        return new East();
    }

    public void moveSomewhere(Submarine submarine) {
//        return coordenada.down();
        submarine.updatePosition( new Points( 0, -1));

    }
    
    public String str() {
    	return "South";
    }

}
