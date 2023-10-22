package submarino;
public class UseCapsule extends Instructions {

    public void doInstruction(Submarine submarine) {
        submarine.getHeight().getProfundidad().useCapsule();

//        submarine.getProfundidad().getProfundidad().useCapsule();
//        submarine.updateHeight( submarine.getProfundidad());
//        submarine.nivel.useCapsule();
    }
}
