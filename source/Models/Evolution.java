package Models;

import java.util.ArrayList;

public class Evolution {

    /*|*********************************
                 Attributes
    ***********************************/  
    // - Game data 
    private Compendium compendium;

    /*|*********************************
                Constructor
    ***********************************/
    public Evolution () {
        this.compendium = new Compendium();
    }

    /**
     *  ` Checks if a given creature is evolvable.
     *
     * @param creature The creature to check for evolvability.
     * @return True if the creature is evolvable (current level is less than 3), false otherwise.
     */

    public boolean isEvolvable ( Creature creature ) {
        if ( creature.getCurrentLevel() < 3) {

                return true; // return true if creature not max level
            } 
            
        else return false; // return flase if creature is max level

    }

    /**
     *  ` Performs evolution in the evolution chamber.
     * Removes the selected creatures from the list, generates an evolved creature,
     * and adds the evolved creature to the list.
     *
     * @param primary The index of the primary creature in the evolution chamber.
     * @param secondary The index of the secondary creature in the evolution chamber.
     * @param creatureList The list of creatures in the evolution chamber.
     * @return The updated list of creatures after evolution.
     */
    public ArrayList<Creature> EvolutionChamber( int primary, int secondary, ArrayList<Creature> creatureList ) {
        
        Creature creature1 = creatureList.get(primary);

        // get evolved creature index
        int evolvedCreatureIndex = compendium.findCreatureIndex(creature1) + 9; 

        // remove creatures from array in order to prevent error
        int firstToRemove = Math.min(primary, secondary);
        int secondToRemove = Math.max(primary, secondary);

        creatureList.remove(secondToRemove);
        creatureList.remove(firstToRemove);

        // generate evolved creature
        Creature evolvedCreature = compendium.generateCreature(evolvedCreatureIndex);
        creatureList.add(evolvedCreature);
        System.out.println("Evolution Successful: " + evolvedCreature.getName() + " added to your inventory.");
        
    
    return creatureList; // return updated creature list

    }

}


