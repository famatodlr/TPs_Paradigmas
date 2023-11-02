package juego;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Linea {

    public static String NO_ES_TU_TURNO = "No es tu turno";
    public static String JUGADA_NO_VALIDA = "Jugada no valida";
    private ArrayList<ArrayList< Character >> tablero;
    private int base;
    private int altura;
    private char jugabilidad;
    private boolean finished = false;
    private String turno = "Red";
    private String ganador;

    public Linea(int base, int altura, char jugabilidad) {
        this.base = base;
        this.altura = altura;
        this.jugabilidad = jugabilidad;

        tablero = new ArrayList<ArrayList<Character>>();
            for (int j = 0; j < base; j++) {
                tablero.add(new ArrayList<Character>());
            }

    }

    public String show() {
        StringBuilder mostrar = new StringBuilder();
        for (int i = altura -1; i >= 0; i--) {
            mostrar.append("|");
            for (int j = 0; j < base; j++) {
                if (tablero.get(j).size() > i) {
                    mostrar.append(tablero.get(j).get(i));
                } else {
                    mostrar.append(" ");
                }
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

    public void playRedAt(int jugada) {
        if (jugada > base) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        if (turno.equals("Blue")) {
            throw new RuntimeException(NO_ES_TU_TURNO);
        }

        if (tablero.get( jugada ).size() == altura) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        tablero.get( jugada ).add('R');
        turno = "Blue";

        finished = chequeoTableroCompleto();

    }

    public void playBlueAt(int jugada) {
        if (jugada > base) {
            throw new RuntimeException(JUGADA_NO_VALIDA);
        }

        if (turno.equals("Red")) {
            throw new RuntimeException(NO_ES_TU_TURNO);
        }

        tablero.get( jugada ).add('B');
        turno = "Red";

        for (int i = 0; i < tablero.size(); i++){
            for (int j = 0; j < tablero.get(i).size(); j++){
                if (isWinner('B', tablero)){
                    finished = true;
                    ganador = "Gano Blue";
                }
            }

        }
    }


    public boolean chequeoTableroCompleto(){
        for (int i = 0; i < base ; i++) {
            if (tablero.get(base).size() < altura) {
                return false;
            }
        }
        return true;
        }
    public char buscarCoordenada(int x, int y){
        return tablero.get(x).get(y);
    }

    public String getTurno() {
        return turno;
    }

    public String getGanador() {
        return ganador;
    }


    public static boolean isWinner(char player, ArrayList<ArrayList<Character>> tablero){
        //check for 4 across
        for ( ArrayList<Character> chars : tablero) {
            for (int col = 0; col < tablero.get(0).size() - 3; col++) {
                if (chars.get(col) == player &&
                        chars.get(col + 1) == player &&
                        chars.get(col + 2) == player &&
                        chars.get(col + 3) == player) {
                    return true;
                }
            }
        }
        //check for 4 up and down
        for(int row = 0; row < tablero.size() - 3; row++){
            for(int col = 0; col < tablero.get(0).size(); col++){
                if (tablero.get(row).get(col) == player   &&
                    tablero.get(row+1).get(col) == player &&
                    tablero.get(row+2).get(col) == player &&
                    tablero.get(row+3).get(col) == player){
                    return true;
                }
            }
        }
        //check upward diagonal
        for(int row = 3; row < tablero.size(); row++){
            for(int col = 0; col < tablero.get(0).size() - 3; col++){
                if (tablero.get(row).get(col) == player   &&
                    tablero.get(row-1).get(col+1) == player &&
                    tablero.get(row-2).get(col+2) == player &&
                    tablero.get(row-3).get(col+3) == player){
                    return true;
                }
            }
        }
        //check downward diagonal
        for(int row = 0; row < tablero.size() - 3; row++){
            for(int col = 0; col < tablero.get(0).size() - 3; col++){
            if (tablero.get(row).get(0) == player   &&
                tablero.get(row+1).get(1) == player &&
                tablero.get(row+2).get(2) == player &&
                tablero.get(row+3).get(3) == player){
                return true;
            }
        }
    }
        return false;
    }

//    private String contarfichas(ArrayList<Character> fichasParaContar){
//        char ficha = fichasParaContar.get(0);
//        int contador = 1;
//
//        for (int i=1 ; i < fichasParaContar.size(); i++){
//            if (ficha == fichasParaContar.get(i)){
//                contador += 1;
//            }
//            else{
//                ficha = fichasParaContar.get(i);
//            }
//            if (contador == 4){
//                return "Gano " + ficha;
//            }
//        }
//
//        return "Sigue el juego";
    }