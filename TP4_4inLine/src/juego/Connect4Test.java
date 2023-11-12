package juego;

import org.junit.Test;

import static org.junit.Assert.*;

public class Connect4Test {

    @Test
    public void testCreaElShow() {
        Linea game = tablero1x1();

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
        Linea game = tablero6x7();
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
        Linea game = tablero1x1();
        game.playRedAt(1);

        assertEquals(game.buscarCoordenada(0, 0), 'X');
    }

    @Test
    public void testNoPuedoPonerFichasFueraDelTablero() {
        Linea game = tablero1x1();
        assertEquals(Linea.JUGADA_NO_VALIDA, assertThrows(RuntimeException.class, () -> game.playRedAt(2)).getMessage());
    }

    @Test
    public void testPuedoPonerFichasEnCualquierColumna() {
        Linea game = tablero2x2();
        game.playRedAt(1);
        game.playBlueAt(2);

        assertEquals("| | |\n|X|0|", game.show());
    }

    @Test
    public void testNoPuedoPonerFichasEnColumnaNegativa() {
        Linea game = tablero2x2();
        assertEquals(Linea.JUGADA_NO_VALIDA, assertThrows(RuntimeException.class, () -> game.playRedAt(-1)).getMessage());
    }

    @Test
    public void testAzulNoPuedeEmpezar() {
        Linea game = tablero2x2();
        assertEquals(Turnos.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playBlueAt(1)).getMessage());
        assertNotEquals(TurnoAzul.class, game.getTurno().getClass());
        assertEquals(TurnoRojo.class, game.getTurno().getClass());
    }

    @Test
    public void testRojoNoJuegaDosVeces() {
        Linea game = tablero2x2();

        game.playRedAt(1);
        assertEquals(Turnos.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playRedAt(1)).getMessage());
        assertNotEquals(TurnoRojo.class, game.getTurno().getClass());
        assertEquals(TurnoAzul.class, game.getTurno().getClass());
    }

    @Test
    public void testAzulNoJuegaDosVeces() {
        Linea game = tablero2x2();

        game.playRedAt(1);
        game.playBlueAt(1);
        assertEquals(Turnos.NO_ES_TU_TURNO, assertThrows(RuntimeException.class, () -> game.playBlueAt(2)).getMessage());
        assertEquals(TurnoRojo.class, game.getTurno().getClass());
        assertNotEquals(TurnoAzul.class, game.getTurno().getClass());
    }

    @Test
    public void testNoPuedoPonerFichaEnColumnaLLena() {
        Linea game = tablero2x2();
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
        Linea game = tablero2x2();
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);

        assertEquals("|0|0|\n" +
                "|X|X|\nEl juego termino. El ganador es: Empate", game.show());

        assertTrue(game.finished());
    }

    @Test
    public void testRojoGanaHorizontalEnModoA() {
        Linea game = tablero4x4('A');
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(4);

        assertEquals("| | | | |\n" +
                "| | | | |\n" +
                "|0|0|0| |\n" +
                "|X|X|X|X|\nEl juego termino. El ganador es: Rojo", game.show());

        assertEquals("Rojo", game.getGanador());
        assertTrue(game.finished());
    }

    @Test
    public void testAzulGanaHorizontalEnModoA() {
        Linea game = tablero4x4('A');
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

        assertEquals("| | | | |\n" +
                "|X|X| | |\n" +
                "|0|0|0|0|\n" +
                "|X|X|X|0|\nEl juego termino. El ganador es: Azul", game.show());

        assertTrue(game.finished());
        assertEquals("Azul", game.getGanador());
    }

    @Test
    public void testRojoGanaVerticalEnModoA() {
        Linea game = tablero4x4('A');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);


        assertEquals("|X| | | |\n" +
                "|X|0| | |\n" +
                "|X|0| | |\n" +
                "|X|0| | |\nEl juego termino. El ganador es: Rojo", game.show());

        assertEquals("Rojo", game.getGanador());
        assertTrue(game.finished());
    }

    @Test
    public void testAzulGanaVerticalEnModoA() {
        Linea game = tablero4x4('A');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(4);
        game.playBlueAt(2);

        assertEquals("| |0| | |\n" +
                "|X|0| | |\n" +
                "|X|0| | |\n" +
                "|X|0| |X|\nEl juego termino. El ganador es: Azul", game.show());

        assertTrue(game.finished());
    }


    @Test
    public void testRojoGanaDiagonalEnModoB() {
        Linea game = tablero4x4('B');

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

        assertEquals("| | |0|X|\n" +
                "| | |X|0|\n" +
                "| |X|0|X|\n" +
                "|X|0|X|0|\nEl juego termino. El ganador es: Rojo", game.show());

        assertTrue(game.finished());
        assertEquals("Rojo", game.getGanador());
    }

    @Test
    public void testAzulGanaDiagonalEnModoB() {
        Linea game = tablero4x4('B');

        game.playRedAt(2);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(4);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(3);
        game.playRedAt(2);
        game.playBlueAt(4);

        assertEquals("| | | |0|\n" +
                "| |X|0|X|\n" +
                "|X|0|X|0|\n" +
                "|0|X|0|X|\nEl juego termino. El ganador es: Azul", game.show());

        assertTrue(game.finished());
        assertEquals("Azul", game.getGanador());
    }

    @Test
    public void testRojoGanaDiagonalInvertidoEnModoB() {
        Linea game = tablero4x4('B');

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
                "|0|X|0|X|\nEl juego termino. El ganador es: Rojo", game.show());

        assertTrue(game.finished());
        assertEquals("Rojo", game.getGanador());
    }

    @Test
    public void testAzulGanaDiagonalInvertidoEnModoB() {
        Linea game = tablero4x4('B');

        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(4);

        assertEquals("|0|X| | |\n" +
                "|X|0|X| |\n" +
                "|0|X|0| |\n" +
                "|X|0|X|0|\nEl juego termino. El ganador es: Azul", game.show());

        assertTrue(game.finished());
        assertEquals("Azul", game.getGanador());

    }

    @Test
    public void testModalidadCEnVertical() {
        Linea game = tablero4x4('C');
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);


        assertEquals("|X| | | |\n" +
                "|X|0| | |\n" +
                "|X|0| | |\n" +
                "|X|0| | |\nEl juego termino. El ganador es: Rojo", game.show());

        assertEquals("Rojo", game.getGanador());
        assertTrue(game.finished());
    }

    @Test
    public void testModalidadCEnHorizontal() {
        Linea game = tablero4x4('C');
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(4);

        assertEquals("| | | | |\n" +
                "| | | | |\n" +
                "|0|0|0| |\n" +
                "|X|X|X|X|\nEl juego termino. El ganador es: Rojo", game.show());

        assertEquals("Rojo", game.getGanador());
        assertTrue(game.finished());
    }

    @Test
    public void testModalidadCEnDiagonal() {
        Linea game = tablero4x4('C');


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

        assertEquals("| | |0|X|\n" +
                "| | |X|0|\n" +
                "| |X|0|X|\n" +
                "|X|0|X|0|\nEl juego termino. El ganador es: Rojo", game.show());

        assertTrue(game.finished());
        assertEquals("Rojo", game.getGanador());
    }

    @Test
    public void testModalidadCEnDiagonalInvertido() {
        Linea game = tablero4x4('C');

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
                "|0|X|0|X|\nEl juego termino. El ganador es: Rojo", game.show());

        assertTrue(game.finished());
        assertEquals("Rojo", game.getGanador());
    }

    @Test
    public void testNoAceptaJugdasCuandoElJuegoTermina() {
        Linea game = tablero1x1();
        game.playRedAt(1);
        assertTrue(game.finished());
        assertEquals(Linea.JUGADA_NO_VALIDA, assertThrows(RuntimeException.class, () -> game.playBlueAt(1)).getMessage());
        assertEquals(TurnoAzul.class, game.getTurno().getClass());
        assertTrue(game.finished());
    }

    @Test
    public void testNoSeGanaSiHay4IgualesPeroNoEnLinea() {
        Linea game = tablero6x7();
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(4);
        game.playBlueAt(4);
        game.playRedAt(5);
        game.playBlueAt(5);

        assertEquals("| | | | | | |\n" +
                "| | | | | | |\n" +
                "| | | | | | |\n" +
                "| | | | | | |\n" +
                "| | | | | | |\n" +
                "| | |0|0|0| |\n" +
                "|X|0|X|X|X| |", game.show());

        assertEquals("", game.getGanador());
        assertFalse(game.finished());
    }

    @Test public void testBaseYAlturaDebenSerPositivos(){
        assertEquals(Linea.BASE_Y_ALTURA_DEBEN_SER_POSITIVOS, assertThrows(RuntimeException.class, () -> new Linea(-1, 1, 'A')).getMessage());
    }

    private static Linea tablero1x1() {
        return new Linea(1, 1, 'A');
    }

    private static Linea tablero4x4( char jugabilidad) {
        return new Linea(4, 4, jugabilidad);
    }

    private static Linea tablero6x7() {
        return new Linea(6, 7, 'A');
    }

    private static Linea tablero2x2() {
        return new Linea(2, 2, 'A');
    }
}