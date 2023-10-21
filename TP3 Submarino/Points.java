package submarino;

public class Points {

    private static int Xcoord;
    private static int Ycoord;

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

//    public Points sum( Points punto){
//        return new Points( this.getX() + punto.getX(), this.getY() + punto.getY());
//    }

}
