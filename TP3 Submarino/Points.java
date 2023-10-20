package submarino;

public class Points {

    private static int x;
    private static int y;

    public Points(int x, int y){
        Points.x = x;
        Points.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    //UN SOLO PARAMETRO
//    public Points sum( Points punto){
//        return new Points( this.getX() + punto.getX(), this.getY() + punto.getY());
//    }
}
