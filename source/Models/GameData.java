package Models;
import java.util.ArrayList;

/**
 * The GameData class represents the central data structure for the game,
 * encapsulating information such as user data, the compendium of creatures, evolution logic,
 * and the list of game areas.
 */
public class GameData {
    
    /*|*********************************
                 Attributes
    ***********************************/  
    // - Game data 
    private ArrayList<Area> arrAreas = new ArrayList<Area>();
    private User user;
    private Compendium compendium;
    private Evolution evolution;

    /*|*********************************
                 Constructor
    ***********************************/
    public GameData() {
        initData();
    }

    /**
     *  ` Initializes the game data required for the program. 
     *   1. Creates a new user for the game
     *   2. Sets up the game's compendium for creatures storage
     *   3. Creates the first game area
     *   4. Creates the second game area
     *   5. Creates the third game area
     */
    private void initData() {
        this.user = new User();
        this.compendium = new Compendium();
        this.evolution = new Evolution();
        this.arrAreas.add( new Area("Area 1 / Starter Road", 5, 1));
        this.arrAreas.add( new Area("Area 2 / Wubwub Plains", 3, 3));
        this.arrAreas.add( new Area("Area 3 / Zorian Plateau", 4, 4));
    }

    /*|*********************************
              Setters & Getters
    ***********************************/
    public User getUser() {
        return this.user;
    }

    public Compendium getCompendium() {
        return this.compendium;
    }

    public Area getArea(int index) {
        return arrAreas.get(index);
    }

    public Evolution getEvolution() {
        return this.evolution;
    }

}
