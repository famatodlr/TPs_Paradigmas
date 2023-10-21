package submarino;


public class North extends Directions {

	public Directions turnRight() {
        return new East();
    }

    public Directions turnLeft() {
        return new West();
    }

    public void moveSomewhere(Submarine submarine) {
        submarine.updatePosition( new Points(0, 1));

    }
    
    public String str() {
    	return "North";
    }

}
