package submarino;

public class OneBelowSurface extends Profundidades {


	public boolean isSurface(){
		return false;
	}

	public Profundidades Emerge(){
		return new Surface();
	}

	public Profundidades Submerge(){
		return new ManyBelowSurface(this);
	}
//	protected Profundidades goDown() {
//		return new ManyBelowSurface();
//	}
//
//	protected Submarine goUp(Submarine submarine) {
//		submarine.profundidad.remove( submarine.profundidad.size() -1 );
//		return submarine;
//	}

	public String str() {
		return "OneBelowSurface";
	}


}
