package juego;

import java.util.ArrayList;

public class Linea {

    public static String NO_ES_TU_TURNO = "No es tu turno";
    public static String JUGADA_NO_VALIDA = "Jugada no valida";
    private ArrayList<ArrayList< Character >> tablero;
    private int base;
    private int altura;
    private char jugabilidad;
    private boolean finished;
    private String turno = "Red";
    private String ganador;

    public Linea(int base, int altura, char jugabilidad) {
        this.base = base;
        this.altura = altura;
        this.jugabilidad = jugabilidad;

        tablero = new ArrayList<>();
        for (int j = 0; j < base; j++) {
            tablero.add(new ArrayList<>());
        }
    }

    public String show() {
        StringBuilder mostrar = new StringBuilder();
        for (int i = altura -1; i >= 0; i--) {
            mostrar.append("|");
            for (int j = 0; j < base; j++) {
                if (tablero.get(j).size() > i) {
                    mostrar.append(tablero.get(j).get(i));
                } else {
                    mostrar.append(" ");
                }
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

    public void playRedAt(int posicion) {
        if (posicion > base) {throw new RuntimeException(JUGADA_NO_VALIDA);}
        if (turno.equals("Blue")) {throw new RuntimeException(NO_ES_TU_TURNO);}
        if (tablero.get( posicion ).size() == altura) {throw new RuntimeException(JUGADA_NO_VALIDA);}

        //chequear que la jugada del rojo sea ganadora
        if (isWinner('R', tablero, jugabilidad)){
            ganador = "Red";
            finished = true;
        }

        tablero.get( posicion ).add('R');
        turno = "Blue";
        finished = chequeoTableroCompleto();

    }

    public void playBlueAt(int posicion) {
        if (posicion > base) {throw new RuntimeException(JUGADA_NO_VALIDA);}
        if (turno.equals("Red")) {throw new RuntimeException(NO_ES_TU_TURNO);}
        if (tablero.get( posicion ).size() == altura) {throw new RuntimeException(JUGADA_NO_VALIDA);}

        //chequear que la jugada del azul sea ganadora
        if (isWinner('B', tablero, jugabilidad)){
            ganador = "Blue";
            finished = true;
        }

        tablero.get( posicion ).add('B');
        turno = "Red";
        finished = chequeoTableroCompleto();
    }


    public boolean chequeoTableroCompleto(){
        return tablero.stream().allMatch( columna -> columna.size() == altura);
    }
    public char buscarCoordenada(int x, int y){
        return tablero.get(x).get(y);
    }

    public String getTurno() {
        return turno;
    }

    public String getGanador() {
        return ganador;
    }


    public boolean isWinner(char player, ArrayList<ArrayList<Character>> tablero, char jugabilidad){
//        check for 4 across
        if (jugabilidad == 'A' || jugabilidad == 'C') {
            for (ArrayList<Character> characters : tablero) {
                for (int columna = 0; columna < tablero.get(0).size() - 3; columna++) {
                    if (characters.get(columna) == player &&
                            characters.get(columna + 1) == player &&
                            characters.get(columna + 2) == player &&
                            characters.get(columna + 3) == player) {
                        return true;
                    }
                }
            }
            //check for 4 up and down

            for (ArrayList<Character> chars : tablero) {
                for (int col = 0; col < tablero.get(0).size() - 3; col++) {
                    if (chars.get(col) == player &&
                            chars.get(col + 1) == player &&
                            chars.get(col + 2) == player &&
                            chars.get(col + 3) == player) {
                        return true;
                    }
                }
            }
            //HACELO SIN FOR
            //check for 4 up and down
            for (int row = 0; row < tablero.size() - 3; row++) {
                for (int col = 0; col < tablero.get(0).size(); col++) {
                    if (tablero.get(row).get(col) == player &&
                            tablero.get(row + 1).get(col) == player &&
                            tablero.get(row + 2).get(col) == player &&
                            tablero.get(row + 3).get(col) == player) {
                        return true;
                    }
                }
            }
        }
        if (jugabilidad == 'B' || jugabilidad == 'C') {
            //check upward diagonal
            for (int row = 3; row < tablero.size(); row++) {
                for (int col = 0; col < tablero.get(0).size() - 3; col++) {
                    if (tablero.get(row).get(col) == player &&
                            tablero.get(row - 1).get(col + 1) == player &&
                            tablero.get(row - 2).get(col + 2) == player &&
                            tablero.get(row - 3).get(col + 3) == player) {
                        return true;
                    }
                }
            }
            //check downward diagonal
            for (int row = 0; row < tablero.size() - 3; row++) {
                for (int col = 0; col < tablero.get(0).size() - 3; col++) {
                    if (tablero.get(row).get(0) == player &&
                            tablero.get(row + 1).get(1) == player &&
                            tablero.get(row + 2).get(2) == player &&
                            tablero.get(row + 3).get(3) == player) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}