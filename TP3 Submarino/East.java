package submarino;

public class East extends Directions {

    public Directions turnRight() {
        return new South();
    }

    public Directions turnLeft() {
        return new North();
    }

    public void moveSomewhere(Submarine submarine) {
        submarine.updatePosition( new Points( 1, 0));

    }
    
    public String str() {
    	return "East";
    }
}