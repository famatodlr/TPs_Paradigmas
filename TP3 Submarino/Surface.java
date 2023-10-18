package submarino;

public class Surface extends Profundidades {

    public boolean isSurface(){
        return true;
    }

	protected Profundidades goDown() {
		return new OneBelowSurface();
	}

    protected Submarine goUp(Submarine submarine) {
        return submarine;
    }

    public String str() {
        return "Surface";
    }


}
