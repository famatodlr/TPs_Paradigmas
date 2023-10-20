package submarino;

import java.util.ArrayList;

public abstract class Profundidades {
    public static ArrayList<Profundidades> initialProfundidad() {
        ArrayList<Profundidades> profundidad = new ArrayList<>();
        profundidad.add( new Surface());
        return profundidad;
    }

//    public boolean isSurface(){
//        return false;
//    }

    public abstract boolean isSurface();
    public abstract Profundidades Emerge();
    public abstract Profundidades Submerge();
//	protected abstract Profundidades goDown();
//    protected abstract Submarine goUp(Submarine submarine);

    public abstract String str();

    public void useCapsule(){}
}
