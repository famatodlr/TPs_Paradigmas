package juego;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {
    public static String JUGADA_NO_VALIDA = "Jugada no valida";
    private ArrayList<ArrayList<Character>> tablero;
    private int base;
    private int altura;
    private ModosDeJuego jugabilidad;
    private boolean finished;
    private Turnos turno;
    private String ganador;

    public Linea(int base, int altura, char jugabilidad) {
        this.base = base;
        this.altura = altura;
        this.jugabilidad =  chooseMode( jugabilidad );
        this.turno = new TurnoRojo();
        this.ganador = "Nadie";

        tablero = new ArrayList<>();
        IntStream.range(0, base).forEach(j -> tablero.add(new ArrayList<>()));
    }

    public ModosDeJuego chooseMode(char jugabilidad) {
        int index = ModosDeJuego.gameModesChars.indexOf(jugabilidad);
        return ModosDeJuego.gameModes.get(index);

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

    public void isValid(int posicion, Turnos turnoEsperado) {
        turnoEsperado.chequeoTurno(turno);

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
        playAt(posicion, 'X', new TurnoRojo());
    }

    public void playBlueAt(int posicion) {
        playAt(posicion, '0', new TurnoAzul());
    }

    private void playAt(int posicion, char player, Turnos turnoEsperado) {

        posicion = posicion - 1;
        this.isValid(posicion, turnoEsperado);

        tablero.get(posicion).add(player);

        if (chequeoTableroCompleto()) {
            finished = true;
            ganador = "Empate";
        }
        if (isWinner(player)) {
            finished = true;
            ganador = turno.getPlayer();

        }
        turno = turno.cambiarTurno();
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
        return IntStream.rangeClosed(-altura, base)
                .anyMatch(columna -> IntStream.range(0, altura + 1)
                        .filter(fila -> columna + fila >= 0 && columna + fila < base)
                        .allMatch(fila -> buscarCoordenada(columna + fila, fila) == player)
                );
    }

    public boolean reverseDiagonalWin(char player) {
        return IntStream.rangeClosed(base, -altura)
                .anyMatch(columna -> IntStream.rangeClosed(0, altura)
                        .filter(fila -> columna + (altura - fila) >= 0 && columna + (altura - fila) < base)
                        .allMatch(fila -> buscarCoordenada(columna + (altura - fila), fila) == player)
                );
    }
}