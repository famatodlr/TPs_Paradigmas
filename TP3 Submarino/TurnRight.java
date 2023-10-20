package submarino;

public class TurnRight extends Instructions {

    public void doInstruction(Submarine submarine) {
        submarine.direccion = submarine.direccion.turnRight();
    }
}
