package juego;

public class TurnoRojo extends Turnos {
    public void cambiarTurno() {
        new TurnoAzul();
    }

    public void chequeoTurno(Turnos turno) {
        throw new RuntimeException("No es tu turno");

    }
}
