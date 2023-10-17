package submarino;

public class GoForward extends Instructions {

    public Coordenate doInstruction(Directions direccion, Coordenate coordenada) {
        return direccion.goForward( coordenada);
    }
}
