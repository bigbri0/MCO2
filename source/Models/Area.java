package Models;
import java.util.ArrayList;
import java.util.Random;

public class Area {

    /*|*********************************
                 Attributes
    ***********************************/    
    // - Area attributes
    private String strName;
    private int nWidth;
    private int nLength;

    /*
     *  ` 'enemyIndices' represents an array of creature indices that determine which creatures 
     *  can appear as enemies in this area. The array stores indices corresponding to the creatures 
     *  available in the 'Compendium' class. 
     * 
     *  The selected indices control which creatures are eligible to appear as enemies within
     *  a specific area. For example, if an area's 'enemyIndices' contains [0, 2], only creatures 
     *  with the creature index of 0 (Strawander) and 2 (Parfwit) from the 'Compendium' may appear
     *  as enemies in this area.
     */
    private ArrayList<Integer> enemyIndices;
        
    /*|*********************************
                 Constructor
    ***********************************/
    public Area( String strName, int nLength, int nwidth ) {   
        this.strName = strName;       
        this.nWidth = nwidth;
        this.nLength = nLength;
        this.enemyIndices = new ArrayList<Integer>();
        initEnemyIndices();
    }

    public Area( String strName, int nLength, int nwidth, ArrayList<Integer> enemyIndices ) {   
        this.strName = strName;       
        this.nWidth = nwidth;
        this.nLength = nLength;
        this.enemyIndices = enemyIndices;
    }

    /**
     *  ` Initializes the 'enemyIndices' array list with integers from 0 to 26, which corresponds to
     *  Evolution Level 1 - 3 creatures. 
     */
    private void initEnemyIndices() {
        for( int i = 0; i < 27; i++) {
            enemyIndices.add(i);
        }
    }

    /*|*********************************
                Class Methods
    ***********************************/
    /**
     *  ` Generates a random index to select an enemy from a predefined list of indices.
     *
     *   @return a random enemy index
     */
    public int generateEnemyIndex( Area area ) {
        Random rand = new Random();
        int index = 0;
        if (area.getWidth() == 1) {
            // - Generate enemy from lvl 1
            index = rand.nextInt(0,9);
        }
        if (area.getWidth() == 3) {
            // - Generate enemy from lvl 1 - 2
            index = rand.nextInt(0,18);
        }
        if (area.getWidth() == 4) {
            // - Generate enemy from lvl 1 - 3
            index = rand.nextInt(0,27);
      }
        return enemyIndices.get(index);
    }

    /*|*********************************
              Setters & Getters
    ***********************************/
    public String getName() {
        return strName;
    }

    public void setName( String strName ) {
        this.strName = strName;
    }

    public int getWidth() {
        return nWidth;
    }
    
    public void setwidth( int nwidth ) {
        this.nWidth = nwidth;
    }

    public int getLength() {
        return nLength;
    }

    public void setLength( int nLength ) {
        this.nLength = nLength;
    }
}