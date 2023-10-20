package submarino;

import java.util.ArrayList;

public abstract class Profundidades {

    public abstract boolean isSurface();
    public abstract Profundidades Emerge();
    public abstract Profundidades Submerge();
    public void useCapsule(){}
}
