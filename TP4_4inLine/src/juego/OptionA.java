package juego;

import java.util.ArrayList;

public class OptionA extends ModosDeJuego {

    private ArrayList<ArrayList<Character>> tablero;

    public OptionA(ArrayList<ArrayList<Character>> tablero) {
        this.tablero = tablero;
    }

    public boolean isWinner() {
        return false;
    }
}