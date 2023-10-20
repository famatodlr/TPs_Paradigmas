package submarino;

public class TurnLeft extends Instructions {

    public void doInstruction(Submarine submarine) {
        submarine.direccion = submarine.direccion.turnLeft();
    }
}
