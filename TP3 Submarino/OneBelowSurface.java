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

}
