package juego;

public class OptionB extends ModosDeJuego {
    public boolean isWinner( Linea juego , char player){
        return (juego.diagonalWin( player ) || juego.reverseDiagonalWin( player ));
    }

    public void isFinished() {
        return;
    }
}
