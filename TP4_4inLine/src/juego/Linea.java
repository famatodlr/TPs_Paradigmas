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
    private String turno = "Red";
    private boolean Rojoganador;
    private boolean Azulganador;
    private String ganador = "Nadie";

    public Linea(int base, int altura, char jugabilidad) {
        this.base = base;
        this.altura = altura;
        this.jugabilidad = jugabilidad;
//        this.ganador = "Nadie";

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

    public boolean chequeoTableroCompleto() {
        return tablero.stream().allMatch(columna -> columna.size() == altura);
    }

    public char buscarCoordenada(int x, int y) {
        return tablero.get(x).get(y);
    }

    public String getTurno() {
        return turno;
    }

    public String getGanador() {
        return ganador;
    }


    public void playRedAt(int posicion) {
        if (posicion > base) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }
        if (turno.equals("Blue")) {
            throw new RuntimeException(NO_ES_TU_TURNO);
        }
        if (tablero.get(posicion).size() == altura) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        //chequear que la jugada del rojo sea ganadora

        tablero.get(posicion).add('X');
        turno = "Blue";
        finished = chequeoTableroCompleto();
//        if (isWinner('X', tablero, jugabilidad)) {
//            ganador = "Red";
//            finished = true;
//        }
//        Rojoganador = horizontalWin(posicion) || verticalWin(posicion) || diagonalWin(posicion) || inversedDiagonalWin(posicion);
        Rojoganador = isWinner('X', jugabilidad);

        if (Rojoganador) {
            finished = true;
            ganador = "Red";
        }
    }

    public void playBlueAt(int posicion) {
        if (posicion > base) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }
        if (turno.equals("Red")) {
            throw new RuntimeException(NO_ES_TU_TURNO);
        }
        if (tablero.get(posicion).size() == altura) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        tablero.get(posicion).add('0');
        turno = "Red";
        finished = chequeoTableroCompleto();

//        Azulganador = horizontalWin(posicion) || verticalWin('0', ) || diagonalWin(posicion) || inversedDiagonalWin(posicion);
        Azulganador = isWinner('0', jugabilidad);
        if (Azulganador) {
            finished = true;
            ganador = "Blue";
        }



    }







    public boolean isWinner(char player, char jugabilidad) {
        if (jugabilidad == 'A') {
            return horizontalWin(player) || verticalWin(player);
        }
//        if (jugabilidad == 'B') {
//            return diagonalWin(player, tablero, posicion) || chequeooGanadorDiagonalInversa(player, tablero, posicion);
//        }
//        if (jugabilidad == 'C'){
//            return chequeoGanadorHorizontal(player, tablero, posicion ) || chequeoGanadorVertical(player, tablero, posicion) || chequeoGanadorDiagonal(player, tablero, posicion) || chequeooGanadorDiagonalInversa(player, tablero, posicion);
//        }
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
        int contador;
        for (int fila = 0; fila < altura; fila++) {
            contador = 0; // Reiniciar el contador para cada fila

            for (int columna = 0; columna < base; columna++) {
                if (buscarCoordenada(columna, fila) == player) {
                    contador++;
                    if (contador == 4) {
                        return true; // Encontró 4 en línea horizontal
                    }
                } else {
                    contador = 0; // Reiniciar el contador si no hay una ficha del jugador
                }
            }
        }
        return false; // No se encontraron 4 en línea horizontal
    }







//            //check upward diagonal
//            for (int row = 3; row < tablero.size(); row++) {
//                for (int col = 0; col < tablero.get(0).size() - 3; col++) {
//                    if (tablero.get(row).get(col) == player &&
//                            tablero.get(row - 1).get(col + 1) == player &&
//                            tablero.get(row - 2).get(col + 2) == player &&
//                            tablero.get(row - 3).get(col + 3) == player) {
//                        return true;
//                    }
//                }
//            }
//            //check downward diagonal
//            for (int row = 0; row < tablero.size() - 3; row++) {
//                for (int col = 0; col < tablero.get(0).size() - 3; col++) {
//                    if (tablero.get(row).get(0) == player &&
//                            tablero.get(row + 1).get(1) == player &&
//                            tablero.get(row + 2).get(2) == player &&
//                            tablero.get(row + 3).get(3) == player) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }


}
