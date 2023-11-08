package juego;

import java.util.ArrayList;

public class OptionA extends ModosDeJuego {
    public boolean isWinner( Linea juego , char player){
        return (juego.horizontalWin( player) || juego.verticalWin( player ));
    }
}