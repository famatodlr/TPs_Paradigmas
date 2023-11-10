package juego;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class ModosDeJuego {

    public static ArrayList<Character> gameModesChars = new ArrayList<>(Arrays.asList('A', 'B', 'C'));

    public static ArrayList<ModosDeJuego> gameModes = new ArrayList<>(Arrays.asList(new OptionA(), new OptionB(), new OptionC()));

    public abstract boolean isWinner(Linea juego, char player);
}
