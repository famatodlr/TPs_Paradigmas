package submarino;

public class GoForward extends Instructions {

    public void doInstruction(Submarine submarine) {
        submarine.coordenadas =  submarine.direccion.goForward( submarine.coordenadas );
    }
}
