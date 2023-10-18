package submarino;

public class GoForward extends Instructions {

    public Submarine doInstruction(Submarine submarine) {
        submarine.coordenadas =  submarine.direccion.goForward( submarine.coordenadas );
        return  submarine;
    }
}
