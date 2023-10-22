package submarino;

public class GoDown extends Instructions {
    public void doInstruction(Submarine submarine){
        submarine.getHeight().updateHeight(submarine.getHeight().getProfundidad().Submerge());
        submarine.updateHeight( submarine.getHeight().getProfundidad());

    }
}
