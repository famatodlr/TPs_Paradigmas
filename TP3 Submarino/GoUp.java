package submarino;

public class GoUp extends Instructions {

    public int doInstruction(int profundidad) {
        return profundidad -= 1;
    }
}
