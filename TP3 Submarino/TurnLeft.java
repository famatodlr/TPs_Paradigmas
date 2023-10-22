package submarino;

public class TurnLeft extends Instructions {
    public void doInstruction(Submarine submarine) {
        submarine.updateDirection( submarine.getDirection().turnLeft());
    }

}
