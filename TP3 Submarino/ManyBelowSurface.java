package submarino;

public class ManyBelowSurface extends Profundidades {

	public static String excessOfChocolate = "El submarino exploto por exceso de chocolate";
	private Profundidades previousLevel;

	public ManyBelowSurface (Profundidades previousLevel) {
		this.previousLevel = previousLevel;
	}

	public boolean isSurface(){
		return false;
	}

	public Profundidades Emerge(){
		return previousLevel;
	}

	public Profundidades Submerge(){
		return new ManyBelowSurface(this);
	}

	public String str() {
		return "ManyBelowSurface";
	}

	public void useCapsule() {
		throw new RuntimeException( excessOfChocolate );
	}

}
