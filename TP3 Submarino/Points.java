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

    public Points sum( Points point1, Points point2){
        return new Points( point1.getX() + point2.getX() , point1.getY() + point2.getY());
    }
}
