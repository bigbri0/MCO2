package Models;
import java.util.ArrayList;

public class Compendium {

    /*|*********************************
                 Attributes
    ***********************************/   
    private ArrayList<Creature> arrCreatureList;   // stores all creatures available in the game
    private int[] starterIndices;               // stores the indices of the starter creatures

    /*|*********************************
                Constructor
    ***********************************/
    public Compendium() {
        this.arrCreatureList = new ArrayList<Creature>();
        this.initEL1Creatures();
        this.initEL2Creatures();
        this.initEL3Creatures();
        this.initStarters();
    }
    
    /**
     *   ` Initializes the 'arrCreatureList' with Evolution Level 1 (EL1) creatures.
     *   
     *   EL1 Creatures:
     *   [0] Strawander (Fire, Family A, Level 1)
     *   [1] Chocowool (Fire, Family B, Level 1)
     *   [2] Parfwit (Fire, Family C, Level 1)
     *   [3] Brownisaur (Grass, Family D, Level 1)
     *   [4] Frubat (Grass, Family E, Level 1)
     *   [5] Malts (Grass, Family F, Level 1)
     *   [6] Squirpie (Water, Family G, Level 1)
     *   [7] Chocolite (Water, Family H, Level 1)
     *   [8] Oshacone (Water, Family I, Level 1)
     */
    private void initEL1Creatures() {
        arrCreatureList.add( new Creature( "Strawander", "Fire", "A", 1) );
        arrCreatureList.add( new Creature( "Chocowool", "Fire", "B", 1) );
        arrCreatureList.add( new Creature( "Parfwit", "Fire", "C", 1) );
        arrCreatureList.add( new Creature( "Brownisaur", "Grass", "D", 1) );
        arrCreatureList.add( new Creature( "Frubat", "Grass", "E", 1) );
        arrCreatureList.add( new Creature( "Malts", "Grass", "F", 1) );
        arrCreatureList.add( new Creature( "Squirpie", "Water", "G", 1) );
        arrCreatureList.add( new Creature( "Chocolite", "Water", "H", 1) );
        arrCreatureList.add( new Creature( "Oshacone", "Water", "I", 1) );
    }

    /**
     *   ` Initializes the 'arrCreatureList' with Evolution Level 1 (EL1) creatures.
     *   
     *   EL1 Creatures:
     *   [9] Strawleon (Fire, Family A, Level 1)
     *   [10] Chocofluff (Fire, Family B, Level 1)
     *   [11] Parfure (Fire, Family C, Level 1)
     *   [12] Chocosaur (Grass, Family D, Level 1)
     *   [13] Golberry (Grass, Family E, Level 1)
     *   [14] Kirlicake (Grass, Family F, Level 1)
     *   [15] Tartortle (Water, Family G, Level 1)
     *   [16] Chocolish (Water, Family H, Level 1)
     *   [17] Dewice (Water, Family I, Level 1)
     */
    private void initEL2Creatures() {
        arrCreatureList.add( new Creature( "Strawleon", "Fire", "A", 2) );
        arrCreatureList.add( new Creature( "Chocofluff", "Fire", "B", 2) );
        arrCreatureList.add( new Creature( "Parfure", "Fire", "C", 2) );
        arrCreatureList.add( new Creature( "Chocosaur", "Grass", "D", 2) );
        arrCreatureList.add( new Creature( "Golberry", "Grass", "E", 2) );
        arrCreatureList.add( new Creature( "Kirlicake", "Grass", "F", 2) );
        arrCreatureList.add( new Creature( "Tartortle", "Water", "G", 2) );
        arrCreatureList.add( new Creature( "Chocolish", "Water", "H", 2) );
        arrCreatureList.add( new Creature( "Dewice", "Water", "I", 2) );
    }

    /**
     *   ` Initializes the 'arrCreatureList' with Evolution Level 1 (EL1) creatures.
     *   
     *   EL1 Creatures:
     *   [18] Strawizard (Fire, Family A, Level 1)
     *   [19] Candaros (Fire, Family B, Level 1)
     *   [20] Parfelure (Fire, Family C, Level 1)
     *   [21] Fudgasaur (Grass, Family D, Level 1)
     *   [22] Croberry (Grass, Family E, Level 1)
     *   [23] Velvevior (Grass, Family F, Level 1)
     *   [24] Piestoise (Water, Family G, Level 1)
     *   [25] Icesundae (Water, Family H, Level 1)
     *   [26] Samurcone (Water, Family I, Level 1)
     */
    private void initEL3Creatures() {
        arrCreatureList.add( new Creature( "Strawizard", "Fire", "A", 3) );
        arrCreatureList.add( new Creature( "Candaros", "Fire", "B", 3) );
        arrCreatureList.add( new Creature( "Parfelure", "Fire", "C", 3) );
        arrCreatureList.add( new Creature( "Fudgasaur", "Grass", "D", 3) );
        arrCreatureList.add( new Creature( "Croberry", "Grass", "E", 3) );
        arrCreatureList.add( new Creature( "Velvevior", "Grass", "F", 3) );
        arrCreatureList.add( new Creature( "Piestoise", "Water", "G", 3) );
        arrCreatureList.add( new Creature( "Icesundae", "Water", "H", 3) );
        arrCreatureList.add( new Creature( "Samurcone", "Water", "I", 3) );
    }

    /**
     *   ` Initializes the 'starterIndices' with indices of starter creatures.
     *   These indices corresponds to the order of creatures in 'arrCreatureList'.
     * 
     *   Starter Creatures: [0] Strawander, [1] Brownisaur, [2] Squirpie
     */
    private void initStarters() {
        starterIndices = new int[3];
        starterIndices[0] = 0;  // Strawander
        starterIndices[1] = 3;  // Brownisaur
        starterIndices[2] = 6;  // Squirpie
    }

    /*|*********************************
                Class Methods
    ***********************************/
    /**
     *  ` Creates a new instance of a Creature by copying an existing creatures from 
     *    the ArrayList. This method allows for the easy creation of a copy of a 
     *    creature that has already been added to the arrCreatureList.
     * 
     *   @param index       0-based indexing, the index of the creature in the array list
     *   @return            a new creature object 
     *   @preconditions     'index' must be a valid index within the arrCreatureList
     * 
     *   NOTE: We create a copy of a creature instead of returning the object in the array
     *   list to prevent the unintended side effects of changing the attributes of the 
     *   creatures stored in the array list.
     */
    public Creature generateCreature( int index ) { 
        Creature selected = arrCreatureList.get(index);
        return new Creature( 
            selected.getName(), 
            selected.getType(), 
            selected.getFamily(), 
            selected.getCurrentLevel() );
    }

    /**
     *  ` Allows the player to choose a starter creature based on their choice
     * 
     *   @param choice      the player's choice for the starter pokemon  
     *   @return            a new creature object representing the chosen starter
     *   @preconditions     'choice' must be 0, 1, or 2 to select a valid starter
     */
    public Creature chooseStarter( int choice ) {
        return generateCreature( this.starterIndices[choice] );
    }

    public int findCreatureIndex( Creature creature ) {
        int index = 0;
        
        for ( int i = 0; i < arrCreatureList.size(); i++ ) {

            if ( creature.getName() != arrCreatureList.get(i).getName() ) {
                index ++;
            }
            else {
                return index; // - return creature index
            }
        }
        return -1; // - creature index not found
    }


    /*|*********************************
              Setters & Getters
    ***********************************/
    public int[] getStarterIndices() {
        return starterIndices;
    }
}