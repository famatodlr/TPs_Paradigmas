package submarino;

public class Height {
    private Profundidades nivel;
    public Height() {
        nivel = new Surface();
    }

    public void Emerger() {
        nivel = nivel.Emerge();
    }

    public void Submerger() {
        nivel = nivel.Submerge();
    }

    public boolean isSurface() {
        return nivel.isSurface();
    }

    public Profundidades getProfundidad() {
        return nivel;
    }

}


