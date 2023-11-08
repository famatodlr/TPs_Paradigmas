package juego;

public class TurnoAzul extends Turnos {
    public void cambiarTurno() {
        new TurnoRojo();
    }

    public void chequeoTurno(Turnos turno) {
        throw new RuntimeException("No es tu turno");


    }
}
