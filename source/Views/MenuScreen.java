package Views;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Controllers.StackManager;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Represents the menu screen of the game, allowing the user to access different functionalities.
 * Inherits from the GameState class.
 */
public class MenuScreen extends GameState {

    /*|*********************************
                 Attributes
    ***********************************/
    // Buttons for menuScreen and exiting the program
    private JButton viewInventory, exploreArea, evolution, exitProgram;

    // Background label for visual aesthetics
    private JLabel background;

    /*|*********************************
                Constructor
    ***********************************/
    public MenuScreen(StackManager manager) {
        super(manager);
        super.setLayout(null);

        // Initialize Buttons
        viewInventory = new JButton("View inventory" );
        exploreArea = new JButton( "Explore Area" );
        evolution = new JButton( " Evolution" );
        exitProgram = new JButton( "Exit Program" );

        // Initialize button appearance and positions
        initButtons();

        // Background initialization
        background = new JLabel();
        initBackground();
    }

    /**
     *  ` Initializes the background of the menu screen.
     */
    private void initBackground() {

        // Background Initialization
        background.setBackground(Color.white);
        background.setOpaque(true); // Make the label opaque
        background.setLayout(null);
        background.setBounds(0, 0, 1280, 720);
        background.setVisible(true);
        background.setIcon( new ImageIcon("image\\battleBackground.jpg"));
        super.add(background);
    }

    /**
     *  ` Initializes the buttons on the menu screen and sets their action listeners.
     */
    private void initButtons() {
        // Button Initialization
        ActionListener viewInventoryAction = e -> {
            manager.stackState( new InventoryScreen(manager) );
            manager.getWindow().changePanel( manager.peekStack() );
            manager.getWindow().createWindow();

        };
        viewInventory.addActionListener(viewInventoryAction);

        ActionListener exploreAreaAction = e -> {
            manager.stackState( new AreaChoice(manager) );
            manager.getWindow().changePanel( manager.peekStack() );
            manager.getWindow().createWindow();
        };
        exploreArea.addActionListener(exploreAreaAction);

        ActionListener evolutionAction = e -> {
            manager.stackState( new EvolutionScreen(manager) );
            manager.getWindow().changePanel( manager.peekStack() );
            manager.getWindow().createWindow();
        };
        evolution.addActionListener(evolutionAction);

        ActionListener exitProgramAction = e -> System.exit(0);
        exitProgram.addActionListener(exitProgramAction);


        // View Inventory Button Initialization

        customizeButton(viewInventory);
        viewInventory.setBounds(325, 150, 200, 50);
        super.add(viewInventory);

        // Explore Area Button Initialization
        customizeButton(exploreArea);
        exploreArea.setBounds(325, 220, 200, 50);
        super.add(exploreArea);


        // Evolution Button Initialization
        customizeButton(evolution);
        evolution.setBounds(325, 290, 200, 50);
        super.add(evolution);
        

        // Exit Program Button Initialization
        customizeButton(exitProgram);
        exitProgram.setBounds(325, 360, 200, 50);
        super.add(exitProgram);
        
    }

    /*|*********************************
                Class Methods
    ***********************************/
    /**
     *  ` Customizes the appearance of the specified button.
     *
     * @param button The button to customize.
     */
    private void customizeButton( JButton button ) {
        button.setOpaque(true);
        button.setContentAreaFilled(true);  // Set to true to make the button visible
        button.setBorderPainted(true);      // Set to true to show the button border
        button.setFocusPainted(true);       // Set to true to show focus indicator
        button.setForeground(Color.white);
        button.setBackground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        
    }
}