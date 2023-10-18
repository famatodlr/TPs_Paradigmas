package submarino;

public abstract class Profundidades {

    public boolean isSurface(){
        return false;
    }

	protected abstract Profundidades goDown();

    protected abstract Submarine goUp(Submarine submarine);

    public abstract String str();

    public void useCapsule(){}
}
