package submarino;

public class GoDown extends Instructions {
    public void doInstruction(Submarine submarine){
        submarine.nivel.Submerger();
    }
}
