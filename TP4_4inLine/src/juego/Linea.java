package juego;

import java.util.ArrayList;
import java.util.List;

public class Linea {

    public static String NO_ES_TU_TURNO = "No es tu turno";
    public static String JUGADA_NO_VALIDA = "Jugada no valida";
    private ArrayList<ArrayList< Character >> tablero;
    private int base;
    private int altura;
    private char jugabilidad;

    private boolean finished = false;

    private String turno = "Red";

    public Linea(int base, int altura, char jugabilidad) {
        this.base = base;
        this.altura = altura;
        this.jugabilidad = jugabilidad;

        tablero = new ArrayList<ArrayList<Character>>();
            for (int j = 0; j < base; j++) {
                tablero.add(new ArrayList<Character>());
            }

    }

    public String show() {
        StringBuilder mostrar = new StringBuilder();
        for (int i = 0; i < altura; i++) {
            mostrar.append("|");
            mostrar.append(" |".repeat(Math.max(0, base)));
            mostrar.append("\n");
        }
        mostrar.delete( mostrar.length() - 1, mostrar.length());

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                reemplazarCoordenada(mostrar, i, j, buscarCoordenada(i, j));
            }
        }

        return mostrar.toString();
    }

    public boolean finished() {
        return finished;
    }

    public void playRedAt(int jugada) {
        if (jugada > base) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        if (turno.equals("Blue")) {
            throw new RuntimeException(NO_ES_TU_TURNO);
        }

        tablero.get( jugada ).add('R');
        turno = "Blue";

    }

    public void playBlueAt(int jugada) {
        if (jugada > base) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        if (turno.equals("Red")) {
            throw new RuntimeException(NO_ES_TU_TURNO);
        }

        tablero.get( jugada ).add('B');
        turno = "Red";
    }

    public char buscarCoordenada(int x, int y){
        return tablero.get(x).get(y);
    }

    public String getTurno() {
        return turno;
    }

    private StringBuilder reemplazarCoordenada(StringBuilder tablero, int x, int y, char ficha) {
        int coordenada = (2 * altura) * (base - y) + (2 * x);
        tablero.replace(coordenada - 1, coordenada, String.valueOf(ficha));
        return tablero;
    }
}