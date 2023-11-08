package juego;

public class OptionA extends ModosDeJuego {
    public boolean isWinner( Linea juego , char player){
        return (juego.horizontalWin( player) || juego.verticalWin( player ));
    }

    public void isFinished() {
        return;
    }
}