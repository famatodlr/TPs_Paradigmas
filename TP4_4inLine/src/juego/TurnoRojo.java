package juego;

public class TurnoRojo extends Turnos {
    public Turnos cambiarTurno() {
        return new TurnoAzul();
    }

    public void chequeoTurno(Turnos turno) {
        turno.TurnoEsRojo();

    }

    protected void TurnoEsRojo() {
        return;
    }

    protected void TurnoEsAzul() {
        throw new RuntimeException(Turnos.NO_ES_TU_TURNO);
    }

    public String getPlayer() {
        return "Rojo";
    }
}
