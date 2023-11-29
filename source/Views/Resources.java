package Views;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * The Resources class provides static resources for the game, such as creature images and backgrounds.
 * It includes a list of creature images and a background image, along with constants representing creature indices.
 */
public class Resources {
    
    /**
     * ArrayList to store creature images.
     */
    public static final ArrayList<ImageIcon> CREATURE_LIST = new ArrayList<>();
    public static final ImageIcon BACKGROUND = new ImageIcon("image/battleBackground.jpg");

    // EL1
    public static final byte STRAWANDER = 0;
    public static final byte CHOCOWOOL = 1;
    public static final byte PARFWIT = 2;
    public static final byte BROWNISAUR = 3;
    public static final byte FRUBAT = 4;
    public static final byte MALTS = 5;
    public static final byte SQUIRPIE = 6;
    public static final byte CHOCOLITE = 7;
    public static final byte OSHACONE = 8;

    // EL2
    public static final byte STRAWLEON = 9;
    public static final byte CHOCOFLUFF = 10;
    public static final byte PARFURE = 11;
    public static final byte CHOCOSAUR = 12;
    public static final byte GOLBERRY = 13;
    public static final byte KIRLICAKE = 14;
    public static final byte TARTORTLE = 15;
    public static final byte CHOCOLISH = 16;
    public static final byte DEWICE = 17;

    // EL3
    public static final byte STRAWIZARD = 18;
    public static final byte CANDAROS = 19;
    public static final byte PARFELURE = 20;
    public static final byte FUDGASAUR = 21;
    public static final byte CROBERRY = 22;
    public static final byte VELVEVIOR = 23;
    public static final byte PIETOISE = 24;
    public static final byte ICESUNDAE = 25;
    public static final byte SAMURCONE = 26;

    /**
     *  ` Loads the game resources, including creature images and background.
     * Each creature image is added to the CREATURE_LIST.
     */
    public static void load() {
        // CREATURE_LIST.add( INDEX, new ImageIcon(url) );
        CREATURE_LIST.add( STRAWANDER, new ImageIcon("image/strawander.PNG") );
        CREATURE_LIST.add( CHOCOWOOL, new ImageIcon("image/chocowool.PNG") );
        CREATURE_LIST.add( PARFWIT, new ImageIcon("image/parfwit.PNG") );
        CREATURE_LIST.add( BROWNISAUR, new ImageIcon("image/brownisaur.PNG") );
        CREATURE_LIST.add( FRUBAT, new ImageIcon("image/frubat.PNG") );
        CREATURE_LIST.add( MALTS, new ImageIcon("image/malts.PNG") );
        CREATURE_LIST.add( SQUIRPIE, new ImageIcon("image/squirpie.PNG") );
        CREATURE_LIST.add( CHOCOLITE, new ImageIcon("image/chocolite.PNG") );
        CREATURE_LIST.add( OSHACONE, new ImageIcon("image/oshacone.PNG") );

        CREATURE_LIST.add( STRAWLEON, new ImageIcon("image/strawleon.PNG") );
        CREATURE_LIST.add( CHOCOFLUFF, new ImageIcon("image/chocofluff.PNG") );
        CREATURE_LIST.add( PARFURE, new ImageIcon("image/parfure.PNG") );
        CREATURE_LIST.add( CHOCOSAUR, new ImageIcon("image/chocosaur.PNG") );
        CREATURE_LIST.add( GOLBERRY, new ImageIcon("image/golberry.PNG") );
        CREATURE_LIST.add( KIRLICAKE, new ImageIcon("image/kirlicake.PNG") );
        CREATURE_LIST.add( TARTORTLE, new ImageIcon("image/tartortle.PNG") );
        CREATURE_LIST.add( CHOCOLISH, new ImageIcon("image/chocolish.PNG") );
        CREATURE_LIST.add( DEWICE, new ImageIcon("image/dewice.PNG") );

        CREATURE_LIST.add( STRAWIZARD, new ImageIcon("image/strawizard.PNG") );
        CREATURE_LIST.add( CANDAROS, new ImageIcon("image/candaros.PNG") );
        CREATURE_LIST.add( PARFELURE, new ImageIcon("image/parfelure.PNG") );
        CREATURE_LIST.add( FUDGASAUR, new ImageIcon("image/fudgasaur.PNG") );
        CREATURE_LIST.add( CROBERRY, new ImageIcon("image/croberry.PNG") );
        CREATURE_LIST.add( VELVEVIOR, new ImageIcon("image/velvevior.PNG") );
        CREATURE_LIST.add( PIETOISE, new ImageIcon("image/pietoise.PNG") );
        CREATURE_LIST.add( ICESUNDAE, new ImageIcon("iicesundae.PNG") );
        CREATURE_LIST.add( SAMURCONE, new ImageIcon("image/samurcone.PNG") );
    }
}