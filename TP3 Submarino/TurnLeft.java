package submarino;

public class TurnLeft extends Instructions {

    public Submarine doInstruction(Submarine submarine) {
        submarine.direccion = submarine.direccion.turnLeft();
        return submarine;
    }
}
