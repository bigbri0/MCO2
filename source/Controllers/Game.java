package Controllers;

import Views.StarterScreen;

/**
 * The Game class represents the main entry point for the game. It initializes the game manager
 * and starts the game by pushing the initial game state onto the state stack.
 */
public class Game {

	/*|*********************************
                 Attributes
    ***********************************/ 
	/**
     * The StackManager responsible for managing the game's state stack and window.
     */
	private static StackManager gameManager;
	
	/**
     *  ` Initializes the game by creating a new StackManager.
     */
	public static void init() {
		gameManager = new StackManager();
	}
	
	/*|*********************************
                Class Methods
    ***********************************/
	/**
     *  ` Starts the game by pushing the initial game state (StarterScreen) onto the state stack,
     * changing the panel in the window, and creating the game window.
     */
	public static void start() {
		// Push the initial game state onto the state stack
		gameManager.stackState( new StarterScreen(gameManager) );

		// Change the panel in the window to the top of the state stack
		gameManager.getWindow().changePanel( gameManager.peekStack() );

		// Create the game window
		gameManager.getWindow().createWindow();
	}
}
