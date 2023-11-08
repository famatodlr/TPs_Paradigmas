package juego;

public class GameFinished extends ModosDeJuego {
    public static String EL_JUEGO_YA_TERMINO = "El juego ya termino";

    public boolean isWinner(Linea juego, char player) {
        return false;
    }

    public void isFinished() {
        throw new RuntimeException(EL_JUEGO_YA_TERMINO);
    }
}
