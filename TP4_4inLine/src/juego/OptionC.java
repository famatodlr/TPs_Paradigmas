package juego;
public class OptionC extends ModosDeJuego {
    public boolean isWinner(Linea juego, char player) {
        return juego.checkWin(player, 1, 0) || juego.checkWin(player, 0, 1) || juego.checkWin(player, 1, 1) || juego.checkWin(player, 1, -1);
    }
}
