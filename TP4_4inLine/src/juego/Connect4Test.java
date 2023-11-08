package juego;

import org.junit.Test;

import static org.junit.Assert.*;

public class Connect4Test {

    @Test
    public void testCreaElShow() {
        Linea game = new Linea(1, 1, 'A');

        assertEquals("| |", game.show());
    }
    @Test
    public void testPuedeRecibirMuchasColumnas() {
        Linea game = new Linea(2, 1, 'A');

        assertEquals("| | |", game.show());
    }
    @Test
    public void testPuedeRecibirMucasFilas() {
        Linea game = new Linea(1, 2, 'A');

        assertEquals("| |\n" +
                              "| |", game.show());
    }
    @Test
    public void testPuedeRecibirShowsGrandes() {
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
    public void testPoneFichaCorrectamente() {
        Linea game = new Linea(1, 1, 'A');
        game.playRedAt(1);

        assertEquals(game.buscarCoordenada(0, 0), 'X');
    }

    @Test public void testNoPuedoPonerFichasFueraDelTablero(){
        Linea game = new Linea(1, 1, 'A');
        assertEquals(Linea.JUGADA_NO_VALIDA, assertThrows(RuntimeException.class, () -> game.playRedAt(2)).getMessage());
    }

    @Test public void testPuedoPonerFichasEnCualquierColumna(){
        Linea game = new Linea(2, 1, 'A');
        game.playRedAt(1);
        game.playBlueAt(2);

        assertEquals("|X|0|", game.show());
    }

    @Test public void testNoPuedoPonerFichasEnColumnaNegativa(){
        Linea game = new Linea(2, 1, 'A');
        assertEquals(Linea.JUGADA_NO_VALIDA, assertThrows(RuntimeException.class, () -> game.playRedAt(-1)).getMessage());
    }

    @Test public void testAzulNoPuedeEmpezar() {
        Linea game = new Linea(2, 2, 'A');
        assertEquals(Linea.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playBlueAt(1)).getMessage());
        assertNotEquals(TurnoAzul.class, game.getTurno().getClass());
        assertEquals(TurnoRojo.class, game.getTurno().getClass());
    }
    @Test
    public void testRojoNoJuegaDosVeces() {
        Linea game = new Linea(2, 2, 'A');

        game.playRedAt(1);
        assertEquals(Linea.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playRedAt(1)).getMessage());
        assertNotEquals(TurnoRojo.class, game.getTurno().getClass());
        assertEquals(TurnoAzul.class, game.getTurno().getClass());
    }

    @Test
    public void testAzulNoJuegaDosVeces() {
        Linea game = new Linea(2, 2, 'A');

        game.playRedAt(1);
        game.playBlueAt(1);
        assertEquals(Linea.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playBlueAt(2)).getMessage());
        assertEquals(TurnoRojo.class, game.getTurno().getClass());
        assertNotEquals(TurnoRojo.class, game.getTurno().getClass());
    }
    @Test
    public void testNoPuedoPonerFichaEnColumnaLLena() {
        Linea game = new Linea(2, 2, 'A');
        game.playRedAt(1);
        game.playBlueAt(1);

        assertEquals("|0| |\n" +
                              "|X| |", game.show());

        assertEquals(TurnoRojo.class, game.getTurno().getClass());
        assertNotEquals(TurnoAzul.class, game.getTurno().getClass());

        assertEquals(Linea.JUGADA_NO_VALIDA, assertThrows(RuntimeException.class, () -> game.playRedAt(1)).getMessage());

        assertEquals("|0| |\n" +
                              "|X| |", game.show());

        assertEquals(TurnoRojo.class, game.getTurno().getClass());
        assertNotEquals(TurnoAzul.class, game.getTurno().getClass());

    }

    @Test
    public void testJuegoTerminaConElTableroLLeno() {
        Linea game = new Linea(2, 2, 'A');
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);

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

    @Test public void testRojoGanaHorizontalEnModoA(){
        Linea game = new Linea(4, 4, 'A');
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(4);

        assertEquals(  "| | | | |\n" +
                                "| | | | |\n" +
                                "|0|0|0| |\n" +
                                "|X|X|X|X|", game.show());

//        assertEquals("Red", game.getGanador());
        assertTrue(game.finished());
    }

    @Test public void testAzulGanaHorizontalEnModoA(){
        Linea game = new Linea(4, 4, 'A');
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(4);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(4);


        game.playRedAt(3);
        game.playBlueAt(3);

        assertEquals(  "| | | | |\n" +
                                "|X|X| | |\n" +
                                "|0|0|0|0|\n" +
                                "|X|X|X|0|", game.show());

//        assertEquals("Blue", game.getGanador());
        assertTrue(game.finished());
    }

    @Test public void testRojoGanaVerticalEnModoA() {
        Linea game = new Linea(4, 4, 'A');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);


        assertEquals(  "|X| | | |\n" +
                                "|X|0| | |\n" +
                                "|X|0| | |\n" +
                                "|X|0| | |", game.show());

//        assertEquals("Red", game.getGanador());
        assertTrue(game.finished());
    }

    @Test public void testAzulGanaVerticalEnModoA() {
        Linea game = new Linea(4, 4, 'A');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(4);
        game.playBlueAt(2);

        assertEquals(  "| |0| | |\n" +
                                "|X|0| | |\n" +
                                "|X|0| | |\n" +
                                "|X|0| |X|", game.show());

        assertTrue(game.finished());
    }






    @Test public void testRojoGanaDiagonalEnModoB(){
        Linea game = new Linea(4,4,'B');


        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(4);
        game.playBlueAt(4);
        game.playRedAt(4);

        assertEquals(  "| | |0|X|\n" +
                                "| | |X|0|\n" +
                                "| |X|0|X|\n" +
                                "|X|0|X|0|", game.show());

        assertTrue(game.finished());
//        assertEquals("Red", game.getGanador());
    }

    @Test public void testRojoGanaDiagonalInvertidoEnModoB() {
        Linea game = new Linea(4, 4, 'B');

        game.playRedAt(4);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(1);

        assertEquals("|X|0| | |\n" +
                              "|0|X| | |\n" +
                              "|X|0|X| |\n" +
                              "|0|X|0|X|", game.show());

        assertTrue(game.finished());
//        assertEquals("Red", game.getGanador());
    }

    @Test public void testModalidadCEnVertical(){
        Linea game = new Linea(4, 4, 'C');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);


        assertEquals(  "|X| | | |\n" +
                                "|X|0| | |\n" +
                                "|X|0| | |\n" +
                                "|X|0| | |", game.show());

//        assertEquals("Red", game.getGanador());
        assertTrue(game.finished());
    }

    @Test public void testModalidadCEnHorizontal(){
        Linea game = new Linea(4, 4, 'C');
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(4);

        assertEquals(  "| | | | |\n" +
                                "| | | | |\n" +
                                "|0|0|0| |\n" +
                                "|X|X|X|X|", game.show());

//        assertEquals("Red", game.getGanador());
        assertTrue(game.finished());
    }

    @Test public void testModalidadCEnDiagonal(){
        Linea game = new Linea(4,4,'C');


        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(4);
        game.playBlueAt(4);
        game.playRedAt(4);

        assertEquals(  "| | |0|X|\n" +
                                "| | |X|0|\n" +
                                "| |X|0|X|\n" +
                                "|X|0|X|0|", game.show());

        assertTrue(game.finished());
//        assertEquals("Red", game.getGanador());
    }

    @Test public void testModalidadCEnDiagonalInvertido() {
        Linea game = new Linea(4, 4, 'C');

        game.playRedAt(4);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(1);

        assertEquals("|X|0| | |\n" +
                              "|0|X| | |\n" +
                              "|X|0|X| |\n" +
                              "|0|X|0|X|", game.show());

        assertTrue(game.finished());
//        assertEquals("Red", game.getGanador());
    }
}
