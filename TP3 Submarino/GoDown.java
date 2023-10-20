package submarino;

public class GoDown extends Instructions {

//    public Submarine doInstruction( Submarine submarine ){
//        submarine.profundidad.add( submarine.profundidad.get( submarine.profundidad.size() -1 ).goDown() );
//        return submarine;
//    }
//    public Submarine doInstruction (Submarine submarine) {
//        return submarine.Submerger();
//    }

    public Submarine doInstruction(Submarine submarine){

        submarine.nivel.Submerger();
        return submarine;
    }
}
