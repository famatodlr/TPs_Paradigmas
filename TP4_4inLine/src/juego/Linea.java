package juego;

import java.util.ArrayList;

public class Linea {
    public static String NO_ES_TU_TURNO = "No es tu turno";
    public static String JUGADA_NO_VALIDA = "Jugada no valida";
    private ArrayList<ArrayList<Character>> tablero;
    private int base;
    private int altura;
    private char jugabilidad;
    private boolean finished;
    private String turno;
    private String ganador;

    public Linea(int base, int altura, char jugabilidad) {
        this.base = base;
        this.altura = altura;
        this.jugabilidad = jugabilidad;
        this.turno = "Red";
        this.ganador = "Nadie";

        tablero = new ArrayList<>();
        for (int j = 0; j < base; j++) {
            tablero.add(new ArrayList<>());
        }
    }

    public String show() {
        StringBuilder mostrar = new StringBuilder();
        for (int i = altura - 1; i >= 0; i--) {
            mostrar.append("|");
            for (int j = 0; j < base; j++) {
                mostrar.append(buscarCoordenada(j, i));
                mostrar.append("|");
            }
            mostrar.append("\n");
        }

        mostrar.delete(mostrar.length() - 1, mostrar.length());

        return mostrar.toString();
    }

    public boolean finished() {
        return finished;
    }

    public boolean chequeoTableroCompleto() {
        return tablero.stream().allMatch(columna -> columna.size() == altura);
    }

    public char buscarCoordenada(int x, int y) {
        if (y < 0 || x < 0 || x >= base || y >= tablero.get(x).size()) {
            return ' ';
        }
        return tablero.get(x).get(y);
    }

    public String getTurno() {
        return turno;
    }

    public String getGanador() {
        return ganador;
    }


    public void playRedAt(int posicion) {
        posicion = posicion - 1;
        if (turno.equals("Blue")) {
            throw new RuntimeException(NO_ES_TU_TURNO);
        }

        if (posicion >= base) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        if (posicion < 0) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        if (tablero.get(posicion).size() == altura) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        tablero.get(posicion).add('X');
        turno = "Blue";
        finished = chequeoTableroCompleto();

        if ( isWinner('X', jugabilidad)) {
            finished = true;
            ganador = "Red";
        }
    }

    public void playBlueAt(int posicion) {
        posicion = posicion - 1;
        if (turno.equals("Red")) {
            throw new RuntimeException(NO_ES_TU_TURNO);
        }

        if (posicion >= base) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }
        if (posicion < 0) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        if (tablero.get(posicion).size() == altura) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        tablero.get(posicion).add('0');
        turno = "Red";
        finished = chequeoTableroCompleto();

        if (isWinner('0', jugabilidad)) {
            finished = true;
            ganador = "Blue";
        }

    }

    public boolean isWinner(char player, char jugabilidad) {
        if (jugabilidad == 'A') {
            return horizontalWin(player) || verticalWin(player);
        }
        if (jugabilidad == 'B') {
            return diagonalWin(player) || reverseDiagonalWin(player);
        }

        if (jugabilidad == 'C'){
            return horizontalWin(player) || verticalWin(player) || diagonalWin(player) || reverseDiagonalWin(player);
        }
        return false;
    }
    private boolean verticalWin(char player) {
        int contador = 0;
        for (int columna = 0; columna < base; columna++) {
            for (int fila = tablero.get(columna).size() - 1; fila > -1; fila--) {
                if (buscarCoordenada(columna, fila) == player) {
                    contador++;
                    if (contador == 4) {
                        return true;
                    }
                } else {
                    contador = 0;
                }
            }

        }
        return false;
     }


    public boolean horizontalWin(char player) {
        for (int fila = 0; fila < altura; fila++) {
            int contador = 0;

            for (int columna = 0; columna < base; columna++) {
                if (buscarCoordenada(columna, fila) == player) {
                    contador++;
                    if (contador == 4) {
                        return true;
                    }
                } else {
                    contador = 0;
                }
            }
        }
        return false;
    }

    public boolean diagonalWin(char player){
        int contador = 0;
        for (int columna = - altura ; columna < base; columna++) {
            for (int fila = 0; fila < altura + 1; fila++) {
                if (buscarCoordenada(columna + fila, fila) == player) {
                    contador++;
                    if (contador == 4) {
                        return true;
                    }
                } else {
                    contador = 0;
                }
            }
        }

        return false;
    }

    public boolean reverseDiagonalWin(char player) {
        int contador = 0;
        for (int columna = base ; columna > - altura; columna--) {
            for (int fila = altura; fila >= 0; fila--) {
                if (buscarCoordenada(columna + (altura - fila), fila) == player) {
                    contador++;
                    if (contador == 4) {
                        return true;
                    }
                } else {
                    contador = 0;
                }
            }
        }
        return false;
    }
}
