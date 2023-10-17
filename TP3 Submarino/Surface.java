package submarino;

public class Surface extends Profundidades {


    public String doInstruction(Profundidades profundidad){
        return "Capsula lanzada correctamente";
    }

    public boolean isSurface() {
        return true;
    }

    public Profundidades Emerge() {
        return this;
    }

    public Profundidades Submerge() {
        return new OneBelowSurface();
    }
}
