import Controllers.Game;
import Views.Resources;

public class Driver {

    public static void main( String[] args ) {
        Resources.load();
        Game.init();
        Game.start();
    }
}