package submarino;


public class South extends Directions {
    public Directions turnRight() {
        return new West();
    }
    public Directions turnLeft() {
        return new East();
    }
    public void moveSomewhere(Submarine submarine) {
        submarine.updatePosition( new Points( 0, -1));
    }
}
