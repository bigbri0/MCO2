package Views;

import javax.swing.*;

import Controllers.StackManager;

import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the screen where the player can choose an area.
 * It provides buttons for three different areas and an option to go back.
 * Each button triggers the transition to the corresponding area screen.
 */
public class AreaChoice extends GameState implements ActionListener {

    /*|*********************************
                 Attributes
    ***********************************/ 
    // Buttons for different areas and to go back
    private JButton area1, area2, area3, back;

    // Background label for visual aesthetics
    private JLabel background;

    /*|*********************************
                Constructor
    ***********************************/
    public AreaChoice(StackManager manager) {
        super(manager);
        super.setLayout(null);

        // Initialize buttons
        area1 = new JButton("area 1");
        area2 = new JButton("area 2");
        area3 = new JButton("area 3");
        back = new JButton("Back");

        // Initialize button appearance and positions
        initButton();

        // Background initialization
        background = new JLabel();
        initBackground();

    }

    /**
     *  ` Initializes the appearance and positions of buttons.
     */
    private void initButton() { 

         // Customize the buttons
         area1.setBounds(325, 150, 200, 50);
         area1.addActionListener(this);
         customizeButton(area1);
 
         area2.setBounds(325, 220, 200, 50);
         area2.addActionListener(this);
         customizeButton(area2);
 
         area3.setBounds(325, 290, 200, 50);
         area3.addActionListener(this);
         customizeButton(area3);
 
         back.setBounds(325, 360, 200, 50);
         back.addActionListener(this);
         customizeButton(back);
 
         // Add buttons to the frame
         super.add(area1);
         super.add(area2);
         super.add(area3);
         super.add(back);
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
        background.setIcon( new ImageIcon("image\\battleBackground.jpg"));
        background.setVisible(true);
        super.add(background);
    }

    /*|*********************************
                Class Methods
    ***********************************/
    /**
     *  ` Handles button actions and triggers transitions based on the button pressed.
     *
     * @param e The ActionEvent representing the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Object buttonPressed = e.getSource();

        // - View Inventory
        if(buttonPressed == area1){
            
            manager.stackState( new AreaScreen(manager,0) );
            manager.getWindow().changePanel( manager.peekStack() );
            manager.getWindow().createWindow();
        }

        // - Explore Area
        if(buttonPressed == area2){
            manager.stackState( new AreaScreen(manager,1) );
            manager.getWindow().changePanel( manager.peekStack() );
            manager.getWindow().createWindow();
        }

        // - Evolution
        if(buttonPressed == area3){
            manager.stackState( new AreaScreen(manager,2) );
            manager.getWindow().changePanel( manager.peekStack() );
            manager.getWindow().createWindow();
        }
        // - Exit window
        if(buttonPressed == back){
            manager.popStack();
            manager.getWindow().changePanel( manager.peekStack() );
            manager.getWindow().createWindow();
        }
    }

    /**
     *  ` Customizes the appearance of the specified button.
     *
     * @param button The button to customize.
     */
    private void customizeButton(JButton button) {
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.white);
        button.setBackground(Color.black);
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }
}

