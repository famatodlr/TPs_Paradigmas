package submarino;

public class GoUp extends Instructions {

//    public Submarine doInstruction( Submarine submarine ){
//        return submarine.profundidad.get( submarine.profundidad.size() -1 ).goUp( submarine);
//    }
//    public Profundidades doInstruction(Profundidades nivel) {
//        return nivel.Emerge();
//    }
    public Submarine doInstruction(Submarine submarine){

        submarine.nivel.Emerger();
        return submarine;
    }
}
