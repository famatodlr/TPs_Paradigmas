package directions;
import gps.Coordenate;

public abstract class Directions {

public static Directions initialDirection = new North();
	
public abstract Directions turnRight();

public abstract Directions turnLeft();

public abstract Coordenate goForward( Coordenate coordenada);

public abstract Object str();
}