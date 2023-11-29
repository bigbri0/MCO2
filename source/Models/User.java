package Models;
import java.util.Random;

public class User {
    
    /*|*********************************
                Attributes
    ***********************************/
    private Inventory inventory; 
    Random rand = new Random();

    /*|*********************************
                Constructor
    ***********************************/
    public User() {
        this.inventory = new Inventory();
    }

    /*|*********************************
                Class Methods
    ***********************************/
    /**
     *  ` Attempts to catch a creature during an encounter.
     *
     *   @param enemy the creature being encountered
     *   @return true if the creature is successfully caught, false otherwise
     */
    public Boolean catchCreature( Creature enemy ) {
        int random = rand.nextInt(100);
        float catchChance = 40 + 50 - enemy.getHealth();

        if( random <= catchChance ) {
            enemy.restoreHealth();
            inventory.addCreature(enemy);
            return true;
        }

        return false;
    }
    
    /**
     *  ` Selects a starter creature and adds it to the user's inventory.
     *
     *   @param creature the chosen starter creature
     */
    public void selectStarter( Creature creature ) {
        inventory.addCreature(creature);
    }

    /**
     *  ` Gets the currently active creature from the inventory.
     *
     *   @return the active creature
     */
    public Creature getActiveCreature() {
        return inventory.getActiveCreature();
    }

    /**
     *  ` Sets the selected creature in the inventory.
     *
     *   @param selected the index of the selected creature
     */
    public void setSelectedCreature( int selected ) {
        inventory.setSelected(selected);
    }

    /*|*********************************
              Setters & Getters
    ***********************************/
    public Inventory getInventory() {
        return inventory;
    }
}