package submarino;

public class TurnRight extends Instructions {

    public Submarine doInstruction(Submarine submarine) {
        submarine.direccion = submarine.direccion.turnRight();
        return submarine;
    }
}
