package Views;

import javax.swing.JPanel;

import Controllers.StackManager;

/**
 * The GameState class is an abstract class representing a state in the game's user interface.
 * It extends JPanel and provides a common structure for different states within the game.
 */
public abstract class GameState extends JPanel {

    /*|*********************************
                 Attributes
    ***********************************/
    /**
     * The GameManager object managing the game state transitions and data.
     */
    protected StackManager manager;

    /*|*********************************
                Constructor
    ***********************************/
    /**
     *  ` Constructs a GameState object with the given GameManager.
     *
     * @param manager The GameManager responsible for managing game state transitions and data.
     */
    protected GameState( StackManager manager ) {
        this.manager = manager;
    }
}
