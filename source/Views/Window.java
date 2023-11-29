package Views;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The Window class represents the main window of the graphical user interface (GUI).
 * It manages the JFrame and JPanel components used for displaying the GUI elements.
 */
public class Window {

    /*|*********************************
                 Attributes
    ***********************************/ 
    private JFrame frame; // The main JFrame component for the window
    private JPanel panel; // The main JPanel component for the content of the window

    private static final int WIDTH = 800; // Default width of the window
    private static final int HEIGHT = 600; // Default height of the window

    /*|*********************************
                Constructor
    ***********************************/
    public Window() {
        frame = new JFrame();
        frame.setBounds( 125, 60, 0, 0 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setResizable( false );
        frame.setSize( WIDTH, HEIGHT );
    }

    /*|*********************************
                Class Methods
    ***********************************/
    /**
     *  ` Changes the current JPanel component in the window.
     *
     * @param panel The new JPanel to be displayed in the window.
     */
    public void changePanel( JPanel panel ) {
        this.panel = panel;
        this.panel.setPreferredSize( new Dimension(WIDTH,HEIGHT) );
        this.panel.setFocusable( true );
        this.panel.requestFocusInWindow();
    }

    /**
     * Changes the current GameState (JPanel) in the window.
       @param gameState The new GameState to be displayed in the window.*/

    public void changePanel( GameState gameState ) {
        this.panel = gameState;
        this.panel.setPreferredSize( new Dimension(WIDTH,HEIGHT) );
        this.panel.setFocusable( true );
        this.panel.requestFocusInWindow();
    }

    /**
       Creates the window with the current JPanel content.
       Updates the JFrame content, revalidates, and makes the window visible. */

    public void createWindow() {
        frame.setContentPane( panel );
        frame.revalidate();
        frame.pack();
        frame.setVisible( true );
    }

    /**
     * Retrieves the JFrame associated with this window.
     *
     * @return The JFrame component of the window.
     */
    public JFrame getJFrame() {
        return frame;
    }
}

