package juego;

public class OptionC extends ModosDeJuego {
    public boolean isWinner( Linea juego , char player){
        return (juego.horizontalWin( player) || juego.verticalWin( player ) || juego.diagonalWin( player ) || juego.reverseDiagonalWin( player ));
    }

    public void isFinished() {
        return;
    }
}
