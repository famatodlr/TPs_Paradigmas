package submarino;

public class GoUp extends Instructions {
    public void doInstruction(Submarine submarine){
        submarine.getHeight().updateHeight(submarine.getHeight().getProfundidad().Emerge());
        submarine.updateHeight( submarine.getHeight().getProfundidad());
    }
}
