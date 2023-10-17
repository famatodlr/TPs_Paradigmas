package submarino;

public class TurnRight extends Instructions {

    public Directions doInstruction(Directions direccion) {
        return direccion.turnRight();
    }
}
