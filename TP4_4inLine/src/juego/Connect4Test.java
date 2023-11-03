package juego;

import org.junit.Test;

import static org.junit.Assert.*;

public class Connect4Test {

    @Test
    public void test00() {
        Linea game = new Linea(1, 1, 'A');

        assertEquals("| |", game.show());
    }
    @Test
    public void test01() {
        Linea game = new Linea(2, 1, 'A');

        assertEquals("| | |", game.show());
    }
    @Test
    public void test02() {
        Linea game = new Linea(1, 2, 'A');

        assertEquals("| |\n" +
                "| |", game.show());
    }
    @Test
    public void test03() {
        Linea game = new Linea(6, 7, 'A');
        assertEquals("| | | | | | |\n" +
                "| | | | | | |\n" +
                "| | | | | | |\n" +
                "| | | | | | |\n" +
                "| | | | | | |\n" +
                "| | | | | | |\n" +
                "| | | | | | |", game.show());
    }
    @Test
    public void test04() {
        Linea game = new Linea(1, 1, 'A');
        game.playRedAt(0);

        assertEquals(game.buscarCoordenada(0, 0), 'X');
    }
    @Test
    public void test05() {
        Linea game = new Linea(2, 2, 'A');
        assertEquals(Linea.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playBlueAt(0)).getMessage());
        assertNotEquals("Blue", game.getTurno());
        assertEquals("Red", game.getTurno());
    }
    @Test
    public void test06() {
        Linea game = new Linea(2, 2, 'A');

        game.playRedAt(0);
        assertEquals(Linea.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playRedAt(0)).getMessage());
        assertNotEquals("Red", game.getTurno());
        assertEquals("Blue", game.getTurno());
    }
    @Test
    public void test07() {
        Linea game = new Linea(2, 2, 'A');

        game.playRedAt(0);
        game.playBlueAt(0);
        assertEquals(Linea.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playBlueAt(0)).getMessage());
        assertNotEquals("Blue", game.getTurno());
        assertEquals("Red", game.getTurno());
    }
    @Test
    public void test08() {
        Linea game = new Linea(1, 1, 'A');
        game.playRedAt(0);

        assertEquals("|X|", game.show());
    }
    @Test
    public void test09() {
        Linea game = new Linea(2, 2, 'A');
        game.playRedAt(0);
        game.playBlueAt(0);

        assertEquals(Linea.JUGADA_NO_VALIDA, assertThrows(RuntimeException.class, () -> game.playRedAt(0)).getMessage());
    }
    @Test
    public void test10() {
        Linea game = new Linea(1, 1, 'A');
        game.playRedAt(0);

        assertTrue(game.finished());
    }

    @Test
    public void test11() {
        Linea game = new Linea(2, 2, 'A');
        game.playRedAt(0);
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(1);

        assertEquals("|0|0|\n" +
                              "|X|X|", game.show());

        assertTrue(game.finished());
    }

    @Test public void testTablero4x4(){
        Linea game = new Linea(4,4, 'A');

        assertEquals(  "| | | | |\n" +
                                "| | | | |\n" +
                                "| | | | |\n" +
                                "| | | | |", game.show());

    }

    @Test public void test15() {
        Linea game = new Linea(4, 4, 'B');
        game.playRedAt(0);
        game.playBlueAt(1);

        assertEquals("| | | | |\n" +
                "| | | | |\n" +
                "| | | | |\n" +
                "|X|0| | |", game.show());

    }

    @Test public void testRojoGanaHorizontal(){
        Linea game = new Linea(4, 4, 'A');
        game.playRedAt(0);
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);

        assertEquals(  "| | | | |\n" +
                                "| | | | |\n" +
                                "|0|0|0| |\n" +
                                "|X|X|X|X|", game.show());

        assertEquals("Red", game.getGanador());
        assertTrue(game.finished());
    }

    @Test public void testRojoGanaVertical() {
        Linea game = new Linea(4, 4, 'A');
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);


        assertEquals(  "|X| | | |\n" +
                                "|X|0| | |\n" +
                                "|X|0| | |\n" +
                                "|X|0| | |", game.show());

        assertEquals("Red", game.getGanador());

    }






















//
//    @Test public void test12() {
//        Linea game = new Linea(4,4, 'A');
//        game.playRedAt(2);
//        game.playBlueAt(1);
//        game.playRedAt(0);
//        game.playBlueAt(1);
//        game.playRedAt(0);
//        game.playBlueAt(1);
//        game.playRedAt(0);
//        game.playBlueAt(1);
//
//
//
////        assertTrue(game.finished());
//    }
//
//    @Test public void test13(){
//        Linea game = new Linea(4,4,'A');
//        game.playRedAt(0);
//        game.playBlueAt(0);
//        game.playRedAt(1);
//        game.playBlueAt(1);
//        game.playRedAt(2);
//        game.playBlueAt(2);
//        game.playRedAt(3);
//
////        assertTrue(game.finished());
//    }
//
//    @Test public void test14(){
//        Linea game = new Linea(4,4,'B');
//
//
//        game.playRedAt(0);
//        game.playBlueAt(1);
//        game.playRedAt(1);
//        game.playBlueAt(3);
//        game.playRedAt(2);
//        game.playBlueAt(2);
//        game.playRedAt(2);
//        game.playBlueAt(2);
//        game.playRedAt(3);
//        game.playBlueAt(3);
//        game.playRedAt(3);
//
////        assertTrue(game.finished());
//        assertEquals("Red", game.getGanador());
//    }



    @Test public void test16(){
        Linea game = new Linea(6, 7, 'B');
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(5);
        game.playRedAt(4);

        assertEquals( "| | | | | | |\n" +
                              "| | | | | | |\n" +
                              "| | | | | | |\n" +
                              "| | | | | | |\n" +
                              "| | | | | | |\n" +
                              "|X| | | | | |\n" +
                              "|X|0| | |X|0|", game.show());
    }

//    @Test public void test17(){
//        Linea game = new Linea(6, 7, 'A');
//        game.playRedAt(0);
//        game.playBlueAt(1);
//        game.playRedAt(0);
//        game.playBlueAt(5);
//        game.playRedAt(4);
//        game.playBlueAt(4);
//        game.playRedAt(0);
//        game.playBlueAt(4);
//        game.playRedAt(0);
//
//        assertEquals(  "| | | | | | |\n" +
//                                "| | | | | | |\n" +
//                                "| | | | | | |\n" +
//                                "|R| | | | | |\n" +
//                                "|R| | | |B| |\n" +
//                                "|R| | | |B| |\n" +
//                                "|R|B| | |R|B|", game.show());
//
//        assertEquals("Red", game.getGanador());
//        assertTrue(game.finished());
//
//
//    }



}
