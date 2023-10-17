package submarino;

public class GoDown extends Instructions {

    public int doInstruction(int profundidad) {
        return profundidad += 1;
    }
}
