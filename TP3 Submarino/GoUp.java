package submarino;

public class GoUp extends Instructions {

    public Profundidades doInstruction(Profundidades profundidad) {
        return profundidad.Emerge();
    }
}
