package Models;

import java.util.ArrayList;

public class Inventory {

    /*|*********************************
                Attributes
    ***********************************/
    private ArrayList<Creature> arrCreatureList;
    private int nSelected;
    
    /*|*********************************
                Constructor
    ***********************************/
    public Inventory() {
        this.arrCreatureList = new ArrayList<Creature>();
    }

    /*|*********************************
                Class Methods
    ***********************************/
    /**
     *  ` Adds a captured creature to the inventory.
     *
     *   @param captured the captured creature to add
     */
    public void addCreature( Creature captured ) {
        arrCreatureList.add( captured );
        if( arrCreatureList.size() == 1 ) {
            nSelected = 0;
        }
    }

    /*|*********************************
                Setters & Getters
    ***********************************/
    public ArrayList<Creature> getCreatureList() {
        return arrCreatureList;
    }

    public Creature getActiveCreature() {
        if (nSelected >= 0 && nSelected < arrCreatureList.size()) {
            return arrCreatureList.get(nSelected);
        } else {
            // Handle the case where the index is out of bounds
            return null;
        }
    }

    public int getSelected() {
        return nSelected;
    }

    public void setSelected( int nSelected ) {
        this.nSelected = nSelected;
    }

    public int getCreatureListSize() {
        return arrCreatureList.size();
    }
}