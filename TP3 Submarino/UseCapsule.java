package submarino;
public class UseCapsule extends Instructions {

    public Submarine doInstruction(Submarine submarine) {
//        submarine.profundidad.get( submarine.profundidad.size() -1 ).useCapsule();
        submarine.nivel.useCapsule();
        return submarine;

    }
}
