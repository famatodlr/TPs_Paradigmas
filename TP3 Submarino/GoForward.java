package submarino;

public class GoForward extends Instructions {

    public void doInstruction(Submarine submarine) {
        submarine.direccion.moveSomewhere( submarine );
//        submarine.direccion.moveSomewhere( submarine );
    }
}
