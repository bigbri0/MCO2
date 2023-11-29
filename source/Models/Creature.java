package Models;
import java.util.Random;  

public class Creature {
    
    /*|*********************************
                Attributes
    ***********************************/
    // - Creature details
    private String strName;
    private String strType;
    private String strFamily;
    private int nCurrentLevel;

    // - Enemy details 
    private float fHealth = 50.0f;

    // - Helper class
    Random rand = new Random();

    /*|*********************************
                Constructors
    ***********************************/
    public Creature( String strName, String strType, String strFamily, int nCurrentLevel ) {
        this.strName = strName;
        this.strType = strType;
        this.strFamily = strFamily;
        this.nCurrentLevel = nCurrentLevel;
    }

    public Creature() {}

    /*|*********************************
                Class Methods
    ***********************************/
    /**
     *  ` Attacks an enemy creature and calculates the damage dealt.
     *
     *   @param enemy the enemy creature being attacked
     *   @return the amount of damage dealt
     */
    public float attackCreature( Creature enemy ) {

        // - Get current enemy health
        float Health = enemy.getHealth();

        // - Calculate damage
        float multiplier = this.strTypeAdvantage( this.strType, enemy.getType() );
        float damage = rand.nextInt(1,11) * multiplier;

        // - Attack the enemy creature
        enemy.setHealth( Health - damage );

        return damage;
    }

    /**
     *  ` Calculates the strType advantage multiplier based on the attacking and defending strTypes.
     *
     *   @param strTypeUser  the strType of the attacking creature
     *   @param strTypeEnemy the strType of the defending creature
     *   @return the strType advantage multiplier
     */
    private float strTypeAdvantage( String strTypeUser, String strTypeEnemy ) {
        float multiplier = 1.0f;
        strTypeUser = strTypeUser.toLowerCase();
        strTypeEnemy = strTypeEnemy.toLowerCase();

        // Determine the strType advantage based on the attacker's strType
        switch( strTypeUser ) {
            case "fire": {
                if( strTypeEnemy.equals("grass") ) {
                    multiplier = 1.5f;
                } else if( strTypeEnemy.equals("water") ) {
                    multiplier = 0.75f;
                }
            } break;
            case "grass" : {
                if( strTypeEnemy.equals("water") ) {
                    multiplier = 1.5f;
                } else if( strTypeEnemy.equals("fire") ) {
                    multiplier = 0.75f;
                }
            } break;
            case "water" : {
                if( strTypeEnemy.equals("fire") ) {
                    multiplier = 1.5f;
                } else if( strTypeEnemy.equals("grass") ) {
                    multiplier = 0.75f;
                }
            } break;
        } 

        return multiplier;
    }

    /**
     *  ` Restores the fHealth of the creature to the default value.
     */
    public void restoreHealth() {
        this.fHealth = 50.0f;
    }

    /*|*********************************
            Setters & Getters
    ***********************************/
    public void setName( String strName )  {
        this.strName = strName;
    }

    public String getName() {
        return strName;
    }

    public void setType( String strType ) {
        this.strType = strType;
    }

    public String getType() {
        return strType;
    }

    public void setFamily( String strFamily ) {
        this.strFamily = strFamily;
    }

    public String getFamily() {
        return strFamily;
    }

    public void setCurrentLevel( int nCurrentLevel ) {
        this.nCurrentLevel = nCurrentLevel;
    }

    public int getCurrentLevel() {
        return nCurrentLevel;
    }

    public float getHealth() {
        return fHealth;
    }

    public void setHealth( float fHealth ) {
        this.fHealth = fHealth;
    }
}