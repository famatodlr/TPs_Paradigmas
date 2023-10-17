package submarino;

public class DoNothing extends Instructions {

    public Directions doInstruction(Directions direccion) {
        return direccion;
    }

    public Coordenate doInstruction(Directions direccion, Coordenate coordenada) {
        return coordenada;
    }
}
