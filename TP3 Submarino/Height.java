package submarino;

public class Height {

    private Profundidades nivel;
    private int capsules = 0;
    public Height(){
        nivel = new Surface();
    }

    public void Emerger(){
        nivel = nivel.Emerge();
    }

    public void Submerger(){
        nivel = nivel.Submerge();
    }

    public boolean isSurface(){
        return nivel.isSurface();
    }

    public Profundidades getProfundidad() {
        return nivel;
    }

//    public int getPronfundidad(){
//        USAR EMPY QUEUE TP2;
//    }
}
