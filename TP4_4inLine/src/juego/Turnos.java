package juego;
public abstract class Turnos {
    public static String NO_ES_TU_TURNO = "No es tu turno";
    public abstract Turnos cambiarTurno();

    public abstract void chequeoTurno( Turnos turno);

    protected abstract void TurnoEsRojo();

    protected abstract void TurnoEsAzul();

    public abstract String getPlayer();
}
