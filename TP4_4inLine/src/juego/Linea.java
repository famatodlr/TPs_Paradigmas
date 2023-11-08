package juego;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Linea {
    public static String NO_ES_TU_TURNO = "No es tu turno";
    public static String JUGADA_NO_VALIDA = "Jugada no valida";
    private ArrayList<ArrayList<Character>> tablero;
    private int base;
    private int altura;
    private ModosDeJuego jugabilidad;
    private boolean finished;
    private Turnos turno;
    private String ganador;

    private static ArrayList<Character> gameModesChars = new ArrayList<>(Arrays.asList('A', 'B', 'C'));

    private static ArrayList<ModosDeJuego> gameModes = new ArrayList<>(Arrays.asList(new OptionA(), new OptionB(), new OptionC()));


    public Linea(int base, int altura, char jugabilidad) {
        this.base = base;
        this.altura = altura;
        this.jugabilidad =  chooseMode( jugabilidad );
        this.turno = new TurnoRojo();
        this.ganador = "Nadie";

        tablero = new ArrayList<>();
        for (int j = 0; j < base; j++) {
            tablero.add(new ArrayList<>());
        }
    }

    public ModosDeJuego chooseMode(char jugabilidad) {
        int index = gameModesChars.indexOf(jugabilidad);
        return gameModes.get(index);

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

    public Turnos getTurno() {
        return turno;
    }

    public String getGanador() {
        return ganador;
    }

    public void isValid(int posicion) {
//        if (turno.equals("Blue")) {
//            throw new RuntimeException(NO_ES_TU_TURNO);
//        }

        if (posicion >= base) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        if (posicion < 0) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        if (tablero.get(posicion).size() == altura) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }
    }




    public void playRedAt(int posicion) {
        posicion = posicion - 1;
        this.isValid(posicion);


        tablero.get(posicion).add('X');
        turno.cambiarTurno();
        finished = chequeoTableroCompleto() || isWinner('X');
    }

    public void playBlueAt(int posicion) {
        posicion = posicion - 1;
        this.isValid(posicion);


        tablero.get(posicion).add('0');
        turno.cambiarTurno();
        finished = chequeoTableroCompleto() || isWinner('0');

    }

    public boolean isWinner(char player) {
        return jugabilidad.isWinner( this , player);
    }
    public boolean verticalWin(char player) {
        return IntStream.range(0, base)
                .anyMatch(columna -> IntStream.range(0, tablero.get(columna).size() - 3)
                .anyMatch(fila -> IntStream.range(0, 4)
                .allMatch(offset -> buscarCoordenada(columna, fila + offset) == player)
                )
                );
    }



    public boolean horizontalWin(char player) {
//        for (int fila = 0; fila < altura; fila++) {
//            int contador = 0;
//
//            for (int columna = 0; columna < base; columna++) {
//                if (buscarCoordenada(columna, fila) == player) {
//                    contador++;
//                    if (contador == 4) {
//                        return true;
//                    }
//                } else {
//                    contador = 0;
//                }
//            }
//        }
//        return false;
         return IntStream.range(0, altura)
                    .anyMatch(fila -> IntStream.range(0, base - 3)
                    .mapToObj(start -> IntStream.range(start, start + 4)
                    .mapToObj(columna -> buscarCoordenada(columna, fila) == player)
                    .reduce(Boolean::logicalAnd)
                    .orElse(false)
                    )
                    .reduce(Boolean::logicalOr)
                    .orElse(false)
                    );
    }

    public boolean diagonalWin(char player){
//        int contador = 0;
//        for (int columna = - altura ; columna < base; columna++) {
//            for (int fila = 0; fila < altura + 1; fila++) {
//                if (buscarCoordenada(columna + fila, fila) == player) {
//                    contador++;
//                    if (contador == 4) {
//                        return true;
//                    }
//                } else {
//                    contador = 0;
//                }
//            }
//        }
//
//        return false;

            return IntStream.rangeClosed(-altura, base)
                    .anyMatch(columna -> IntStream.range(0, altura + 1)
                            .filter(fila -> columna + fila >= 0 && columna + fila < base)
                            .allMatch(fila -> buscarCoordenada(columna + fila, fila) == player)
                    );

    }

    public boolean reverseDiagonalWin(char player) {
//        int contador = 0;
//        for (int columna = base ; columna > - altura; columna--) {
//            for (int fila = altura; fila >= 0; fila--) {
//                if (buscarCoordenada(columna + (altura - fila), fila) == player) {
//                    contador++;
//                    if (contador == 4) {
//                        return true;
//                    }
//                } else {
//                    contador = 0;
//                }
//            }
//        }
//        return false;

            return IntStream.rangeClosed(base, -altura)
                    .anyMatch(columna -> IntStream.rangeClosed(0, altura)
                            .filter(fila -> columna + (altura - fila) >= 0 && columna + (altura - fila) < base)
                            .allMatch(fila -> buscarCoordenada(columna + (altura - fila), fila) == player)
                    );


    }
}
