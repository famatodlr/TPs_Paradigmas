package submarino;

public class ManyBelowSurface extends Profundidades {

	public static String excessOfChocolate = "El submarino exploto por exceso de chocolate";
	protected Profundidades goDown() {
		return new ManyBelowSurface();
	}

	protected Submarine goUp(Submarine submarine) {
		submarine.profundidad.remove( submarine.profundidad.size() -1 );
		return submarine;
	}

	public String str() {
		return "ManyBelowSurface";
	}

	public void useCapsule() {
		throw new RuntimeException( excessOfChocolate );
	}
}
