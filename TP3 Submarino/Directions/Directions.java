package directions;
import submarino.Coordenate;

public abstract class Directions {

public abstract Directions turnRight();

public abstract Directions turnLeft();

public abstract Coordenate goForward( Coordenate coordenada);
}