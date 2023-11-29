package Views;

import javax.swing.*;

import Controllers.StackManager;
import Models.GameData;

import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the starter screen where the player can choose a starter creature.
 * It provides buttons for three different starter creatures and an option to exit the program.
 * Each button triggers the selection of a starter creature and transitions to the menu screen.
 */
public class StarterScreen extends GameState implements ActionListener{

    /*|*********************************
                 Attributes
    ***********************************/
    // Buttons for selecting starter creatures and exiting the program
    private JButton starter1, starter2, starter3, exitProgram;

    // Background label for visual aesthetics
    private JLabel background;

    /*|*********************************
                Constructor
    ***********************************/
    public StarterScreen( StackManager manager ) {
        super(manager);
        super.setLayout(null);
        
        // Initialize buttons
        starter1 = new JButton("Strawander");
        starter2 = new JButton("Brownisaur");
        starter3 = new JButton("Squirpie");
        exitProgram = new JButton("Exit Program");

        // Initialize button appearance and positions
        initButtons();

        // Background initialization
        background = new JLabel();
        initBackground();

    }

    /**
     *  ` Initializes the appearance and positions of buttons.
     */
    private void initButtons()  {

        // Customize the buttons
        starter1.setBounds(325, 150, 200, 50);
        //starter1.setBackground(getBackground());
        starter1.addActionListener(this);
        customizeButtonColor(starter1, Color.red);
        super.add(starter1);

        starter2.setBounds(325, 220, 200, 50);
        starter2.addActionListener(this);
        customizeButtonColor(starter2, Color.darkGray);
        super.add(starter2);

        starter3.setBounds(325, 290, 200, 50);
        starter3.addActionListener(this);
        customizeButtonColor(starter3, Color.blue);
        super.add(starter3);

        exitProgram.setBounds(50, 360, 200, 50);
        exitProgram.addActionListener(e -> System.exit(0));
        customizeButton(exitProgram);
    }

    /**
     *  ` Initializes the background appearance.
     */
    private void initBackground() {

        // Background Initialization
        background.setBackground(Color.white);
        background.setOpaque(true); // Make the label opaque
        background.setLayout(null);
        background.setBounds(0, 0, 1280, 720);
        background.setIcon( Resources.BACKGROUND );
        background.setVisible(true);
        super.add(background);
    }

    /*|*********************************
                Class Methods
    ***********************************/
    /**
     *  ` Handles button actions, triggers the selection of a starter creature,
     * and transitions to the menu screen.
     *
     * @param e The ActionEvent representing the button press.
     */
    @Override
    public void actionPerformed( ActionEvent e ){
        Object buttonPressed = e.getSource();

        // - strawander
        if(buttonPressed == starter1){

            GameData data = new GameData();
            data.getUser().selectStarter(data.getCompendium().chooseStarter(0));
            manager.setData(data);
            
        }

        // - brownisaur
        if(buttonPressed == starter2){
            GameData data = new GameData();
            data.getUser().selectStarter(data.getCompendium().chooseStarter(1));
            manager.setData(data);
        
        }

        // - squirpie
        if(buttonPressed == starter3){
            GameData data = new GameData();
            data.getUser().selectStarter(data.getCompendium().chooseStarter(2));
            manager.setData(data);
        }

        // change panel to menuScreen
        manager.stackState( new MenuScreen(manager) );
        manager.getWindow().changePanel( manager.peekStack() );
        manager.getWindow().createWindow();

        
    }

    /**
     *  ` Customizes the appearance of the specified button.
     *
     * @param button The button to customize.
     */
    private void customizeButton( JButton button ) {
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.lightGray);
        button.setBackground(Color.blue);
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }

    private void customizeButtonColor( JButton button, Color color ) {
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.white);
        button.setBackground(color);
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }
}