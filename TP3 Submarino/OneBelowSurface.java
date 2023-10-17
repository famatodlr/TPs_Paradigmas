package submarino;

public class OneBelowSurface extends Profundidades {

    public String doInstruction(Profundidades profundidad){
        return "Capsula lanzada correctamente";
    }


    public boolean isSurface() {
        return false;
    }

    public Profundidades Emerge() {
        return new Surface();
    }

    public Profundidades Submerge() {
        return new ManyBelowSurface(this);
    }
}
