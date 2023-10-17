package submarino;

public class ManyBelowSurface extends Profundidades {

    public ManyBelowSurface(Profundidades previousLevel){
        this.previousLevel = previousLevel;
    }

    private Profundidades previousLevel;

    public String doInstruction(Profundidades profundidad){
        throw new RuntimeException(excessOfChocolate);
    }


    public boolean isSurface() {
        return false;
    }

    public Profundidades Emerge() {
        return previousLevel;
    }

    public Profundidades Submerge() {
        return new ManyBelowSurface(this);
    }
}
