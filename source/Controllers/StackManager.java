package Controllers;

import java.util.Stack;

import Models.GameData;
import Views.GameState;
import Views.Window;

/**
 * The StackManager class is responsible for managing the game's state stack and window.
 * It uses a stack to keep track of different game states and provides methods for stack operations.
 */
public class StackManager {

    /*|*********************************
                 Attributes
    ***********************************/
    /**
     * The GameData object representing the game's data.
     */
    private GameData data;

    /**
     * The stack to manage different game states.
     */
    private Stack<GameState> state;

    /**
     * The Window object representing the game's graphical user interface.
     */
    private Window window;

    /*|*********************************
                Constructor
    ***********************************/
    public StackManager() {
        state = new Stack<GameState>();
        window = new Window();
    }

    /*|*********************************
                Class Methods
    ***********************************/
    /**
     *  ` Pushes a new GameState onto the state stack.
     *
     * @param state The GameState to be pushed onto the stack.
     */
    public void stackState( GameState state ) {
        this.state.push( state );
    }

    /**
     *  ` Pops the top GameState from the state stack.
     */
    public void popStack() {
        this.state.pop();
    }

    /**
     *  ` Retrieves the top GameState from the state stack without removing it.
     *
     * @return The top GameState on the stack.
     */
    public GameState peekStack() {
        return state.peek();
    }

    /**
     *  ` Clears all GameStates from the state stack.
     */
    public void clearStack() {
        this.state.clear();
    }

    /**
     *  ` Checks if the state stack is empty.
     *
     * @return True if the state stack is empty, false otherwise.
     */
    public Boolean isStackEmpty() {
        if( state.empty() ) 
            return true; 
        else 
            return false; 
    }

    /*|*********************************
              Setters & Getters
    ***********************************/
    public Window getWindow() {
        return window;
    }

    public void setData( GameData data ) {
        this.data = data;
    }

    public GameData getData() {
        return data;
    }
}
