package submarino;

public class TurnLeft extends Instructions {

    public Directions doInstruction(Directions direccion) {
        return direccion.turnLeft();
    }
}
