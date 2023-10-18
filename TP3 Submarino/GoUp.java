package submarino;

public class GoUp extends Instructions {

    public Submarine doInstruction( Submarine submarine ){
        return submarine.profundidad.get( submarine.profundidad.size() -1 ).goUp( submarine);
    }
}
