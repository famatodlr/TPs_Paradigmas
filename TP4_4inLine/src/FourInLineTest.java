import org.junit.Test;
import static org.junit.Assert.*;


public class FourInLineTest {

    @Test public void iniciarJuego01(){
        Game juego = new Game(6, 7);
        assertEquals(6, juego.getBase());
        assertEquals(7, juego.getAltura());
    }

    @Test public void iniciarJuegoYQueJuegeRojas(){
        Game juego = new Game(6, 7);
        assertEquals(6, juego.getBase());
        assertEquals(7, juego.getAltura());
        juego.playRedAt(1);
        assertEquals(6, juego.getBase());
        assertEquals(7, juego.getAltura());
    }

}
