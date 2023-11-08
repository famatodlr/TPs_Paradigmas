package juego;

public class TurnoRojo extends Turnos {
    public Turnos cambiarTurno() {
        return new TurnoAzul();
    }
}
