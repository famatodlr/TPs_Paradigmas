package submarino;

public class GoForward extends Instructions {

    public void doInstruction(Submarine submarine) {
        submarine.getDirection().moveSomewhere(submarine);
    }
}
