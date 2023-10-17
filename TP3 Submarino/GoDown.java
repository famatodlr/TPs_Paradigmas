package submarino;

public class GoDown extends Instructions {

    public Profundidades doInstruction(Profundidades nivel) {
        return nivel.Submerge();
    }
}
