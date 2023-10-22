package submarino;

public class Points {
    private int Xcoord;
    private int Ycoord;

    public Points(int x, int y){
        Xcoord = x;
        Ycoord = y;
    }

    public int getX() {
        return Xcoord;
    }
    public int getY() {
        return Ycoord;
    }

    public Points sum( Points punto){
        this.Xcoord += punto.getX();
        this.Ycoord += punto.getY();
        return new Points(this.Xcoord, this.Ycoord);
    }
}
