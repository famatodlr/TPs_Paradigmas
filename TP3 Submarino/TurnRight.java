package submarino;

public class TurnRight extends Instructions {

    public void doInstruction(Submarine submarine) {
        submarine.updateDirection( submarine.getDirection().turnRight());
//        submarine.direccion = submarine.direccion.turnRight();
    }
}
