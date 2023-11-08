package juego;

public class TurnoAzul extends Turnos {
    public Turnos cambiarTurno() {
        return new TurnoRojo();
    }

    public void chequeoTurno(Turnos turno) {

    }
}
