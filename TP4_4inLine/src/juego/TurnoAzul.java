package juego;

public class TurnoAzul extends Turnos {
    public Turnos cambiarTurno() {
        return new TurnoRojo();
    }

    public void chequeoTurno(Turnos turno) {
        turno.TurnoEsAzul();
    }

    protected void TurnoEsRojo() {
        throw new RuntimeException(Turnos.NO_ES_TU_TURNO);
    }

    protected void TurnoEsAzul() {}

    public String getPlayer() {
        return "Azul";
    }
}