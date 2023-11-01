public class Game {

//    public static void main( String[] args) throws Exception {
//
//        System.out.println( "Dimensiones?");
//
//        Linea game = new Linea( prompt( "Base? " ), prompt( "Altura? " ), 'C' );
//
//
//
//        System.out.println( game.show() );
//
//
//
//        while ( !game.finished() ) {
//
//            game.playRedAt( prompt( "Negras? " ) );
//
//            System.out.println( game.show() );
//
//
//
//            if ( !game.finished() ) {
//
//                game.playBlueAt( prompt( "Blancas? " ) );
//
//                System.out.println( game.show() );
//
//            }
//
//        }
//
//
//
//    }
//
//
//
//    private static int prompt( String message ) {
//
//        System.out.print( message );
//
//        return Integer.parseInt( System.console().readLine() );
//
//    }

    private int base;
    private int altura;

    public Game(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }
}