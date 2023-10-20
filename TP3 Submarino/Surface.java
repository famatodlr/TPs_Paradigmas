package submarino;

public class Surface extends Profundidades {

    public boolean isSurface(){
        return true;
    }

    public Profundidades Emerge(){
        return this;
    }

    public Profundidades Submerge(){
        return new OneBelowSurface();
    }

    public String str() {
        return "Surface";
    }


}
