package submarino;

public class OneBelowSurface extends Profundidades {

	protected Profundidades goDown() {
		return new ManyBelowSurface();
	}

	protected Submarine goUp(Submarine submarine) {
		submarine.profundidad.remove( submarine.profundidad.size() -1 );
		return submarine;
	}

	public String str() {
		return "OneBelowSurface";
	}


}
