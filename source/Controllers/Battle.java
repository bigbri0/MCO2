package Controllers;
import Models.*;

public class Battle {

    /*|*********************************
                 Attributes
    ***********************************/  
    // - Game data 
    private User user;
    private Creature enemy;

    /*|*********************************
                Constructor
    ***********************************/
    public Battle( User user, Creature enemy ) {
        this.user = user;
        this.enemy = enemy;

    }

    /*|*********************************
            Battle Phase Actions 
    ***********************************/
    /**
     *  ` Performs an attack by the active creature on the enemy creature.
     *
     * This method calculates the damage dealt by the active creature to the enemy
     * creature and displays the attack result using the specified battle display.
     * It also decrements the move counter to keep track of remaining moves.
     *
     *   @param active The creature performing the attack.
     *   @param enemy The target creature being attacked.
     */
    public void performAttack( Creature active, Creature enemy ) {
        // Calculate the damage dealt by the active creature
        Float damage = active.attackCreature(enemy);

    }

    /*|*********************************
              Setters & Getters
    ***********************************/
    public Creature getEnemy() {
        return this.enemy;
    }
}