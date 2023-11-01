package juego;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;


public class FourInLineTest {

    @Test public void test00(){
        Linea game = new Linea(1, 1, 'A');

        assertEquals("| |\n" , game.show());
    }

    @Test public void test01(){
        Linea game = new Linea(2, 1, 'A');

        assertEquals("| | |\n", game.show());
    }

    @Test public void test02(){
        Linea game = new Linea(1, 2, 'A');

        assertEquals("| |\n" +
                              "| |\n", game.show());
    }

    @Test public void test03(){
        Linea game = new Linea(6, 7, 'A');

        assertEquals( "| | | | | | |\n" +
                               "| | | | | | |\n" +
                               "| | | | | | |\n" +
                               "| | | | | | |\n" +
                               "| | | | | | |\n" +
                               "| | | | | | |\n" +
                               "| | | | | | |\n" ,game.show());
    }

    @Test public void test04(){
        Linea game = new Linea(1, 1, 'A');
        game.playRedAt(0);

        assertEquals( game.buscarCoordenada( 0, 0), 'R');
    }

    @Test public void test05(){
        Linea game = new Linea(2,2,'A');
        assertEquals( Linea.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playBlueAt(0)).getMessage());
        assertNotEquals("Blue", game.getTurno());
        assertEquals("Red", game.getTurno());
    }

    @Test public void test06(){
        Linea game = new Linea(2,2,'A');

        game.playRedAt(0);
        assertEquals( Linea.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playRedAt(0)).getMessage());
        assertNotEquals("Red", game.getTurno());
        assertEquals("Blue", game.getTurno());
    }

    @Test public void test07(){
        Linea game = new Linea(2,2,'A');

        game.playRedAt(0);
        game.playBlueAt(0);
        assertEquals( Linea.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playBlueAt(0)).getMessage());
        assertNotEquals("Blue", game.getTurno());
        assertEquals("Red", game.getTurno());
    }
}
