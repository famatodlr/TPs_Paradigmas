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

    public Height updateHeight(Profundidades profundidad){
        nivel = profundidad;
        return this;
    }

    public void useCapsule(){
        nivel.useCapsule();
    }

    public void setProfundidad(Profundidades profundidad){
        nivel = profundidad;
    }

}


