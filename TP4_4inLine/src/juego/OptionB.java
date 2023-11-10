package juego;

public class OptionB extends ModosDeJuego {
    public boolean isWinner(Linea juego, char player) {
        return juego.checkWin(player, 1, 1) || juego.checkWin(player, 1, -1);
    }
}
