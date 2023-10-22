package submarino;

public class West extends Directions {

	public Directions turnRight() {
        return new North();
    }

    public Directions turnLeft() {
        return new South();
    }

    public void moveSomewhere(Submarine submarine) {
        submarine.updatePosition( new Points( -1, 0));
    }

}
