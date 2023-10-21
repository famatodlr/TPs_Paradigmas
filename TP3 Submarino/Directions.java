package submarino;

public abstract class Directions {
    public static Directions initialDirection = new North();

    public abstract Directions turnRight();

    public abstract Directions turnLeft();

    public abstract void moveSomewhere(Submarine submarine);

    public abstract Object str();




}