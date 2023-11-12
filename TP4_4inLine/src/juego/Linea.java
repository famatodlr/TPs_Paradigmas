package juego;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {
    public static String BASE_Y_ALTURA_DEBEN_SER_POSITIVOS = "Base y altura deben ser positivos";
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
        this.ganador = "";

        if (base < 0 || altura < 0) {
            throw new RuntimeException(BASE_Y_ALTURA_DEBEN_SER_POSITIVOS);
        }

        tablero = new ArrayList<>();
        IntStream.range(0, base).forEach(j -> tablero.add(new ArrayList<>()));
    }

    public ModosDeJuego chooseMode(char jugabilidad) {
        int index = ModosDeJuego.gameModesChars.indexOf(jugabilidad);
        if (index == -1){
            throw new RuntimeException("Modo de juego no valido");
        }
        return ModosDeJuego.gameModes.get(index);

    }

    public String show() {
        StringBuilder mostrar = new StringBuilder();
        IntStream.range(0, altura).forEach(i -> {
            mostrar.append("|");
            IntStream.range(0, base).forEach(j -> {
                mostrar.append(buscarCoordenada(j, altura - i - 1));
                mostrar.append("|");
            });
            mostrar.append("\n");
        });
        mostrar.delete(mostrar.length() - 1, mostrar.length());
        if (finished) {
            mostrar.append("\nEl juego termino. El ganador es: ");
            mostrar.append(ganador);
        }
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
    public boolean checkWin(char player, int dx, int dy) {
        return IntStream.range(0, base * altura)
                .anyMatch(index -> {
                    int columna = index % base;
                    int fila = index / base;

                    return IntStream.range(0, 4)
                            .allMatch(i -> {
                                int x = columna + i * dx;
                                int y = fila + i * dy;
                                return x >= 0 && x < base && y >= 0 && y < altura && buscarCoordenada(x, y) == player;
                            });
                });
    }
}