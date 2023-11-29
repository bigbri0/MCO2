package Views;

import javax.swing.*;
import Controllers.Battle;
import Controllers.StackManager;
import Models.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * BattleScreen class represents the screen for creature battles in the game.
 * It includes buttons for attack, swap, capture, and run, as well as information about
 * the player's active creature and the enemy creature.
 */
public class BattleScreen extends GameState implements ActionListener {

    /*|*********************************
                 Attributes
    ***********************************/
    private Battle battle; 
    private int nMoves;
    private JButton attack, swap, capture, run;
    private JLabel enemyImage;
    private JLabel name, evolutionLevel, type, enemyName, enemyEvolutionLevel, enemyType, note;
    private JProgressBar enemyHealth;
    private JLabel background;

    /*|*********************************
                Constructor
    ***********************************/
    public BattleScreen( StackManager manager, Battle battle ){
        super(manager);
        super.setLayout(null);
        this.battle = battle;

        nMoves = 3;

        attack = new JButton("Attack");
        swap = new JButton("Swap");
        capture = new JButton("Catch");
        run = new JButton("Run");
        enemyImage = new JLabel();
        name = new JLabel("Name");
        evolutionLevel = new JLabel("EL");
        type = new JLabel("Type");
        enemyName = new JLabel("Name");
        enemyEvolutionLevel = new JLabel("EL");
        enemyType = new JLabel("Type");
        note = new JLabel();
        enemyHealth = new JProgressBar();

        // Initialize button appearance and positions
        initButton();

        // Initialize layout appearance and positions
        initLayout();

        // Background initialization
        background = new JLabel();
        initBackground();
    }

    /**
     *  ` Initializes the buttons for attack, swap, capture, and run.
     */
    private void initButton() {

        // Customize the buttons
        attack.setBounds(300, 450, 75, 50);
        attack.addActionListener(this);
        customizeButton(attack);

        swap.setBounds(400, 450, 75, 50);
        swap.addActionListener(this);
        customizeButton(swap);

        capture.setBounds(500, 450, 75, 50);
        capture.addActionListener(this);
        customizeButton(capture);

        run.setBounds(600, 450, 75, 50);
        run.addActionListener(this);
        customizeButton(run);

        // Add buttons to the frame
        super.add(attack);
        super.add(swap);
        super.add(capture);
        super.add(run);
    }

    /**
     *  ` Initializes the layout of panels, labels, and progress bars.
     */
    private void initLayout() {
        // Customize the panels
        enemyImage.setBounds(300, 125, 125, 200);
        enemyImage.setIcon(Resources.CREATURE_LIST.get(manager.getData().getCompendium().findCreatureIndex(battle.getEnemy())));

        // Customize the labels
        name.setBounds(75, 450, 125, 25);
        evolutionLevel.setBounds(75, 475, 125, 25);
        type.setBounds(75, 500, 125, 25);
        enemyName.setBounds(450, 125, 125, 25);
        enemyEvolutionLevel.setBounds(450, 150, 125, 25);
        enemyType.setBounds(450, 175, 125, 25);
        note.setBounds(75, 175, 200, 25);
        
        // Customize the progress bar
        enemyHealth.setValue((int) (battle.getEnemy().getHealth() / 50 * 100));
        enemyHealth.setBounds(75, 125, 150, 25);
        enemyHealth.setStringPainted(true);

        // Add panels to the frame
        super.add(enemyImage);

        // Add labels to the frame
        super.add(name);
        super.add(evolutionLevel);
        super.add(type);
        super.add(enemyName);
        super.add(enemyEvolutionLevel);
        super.add(enemyType);
        super.add(enemyHealth);
        super.add(note);

        // Customize the labels
        name.setText("Name: " + manager.getData().getUser().getInventory().getActiveCreature().getName());
        evolutionLevel.setText("EL: " + manager.getData().getUser().getInventory().getActiveCreature().getCurrentLevel());
        type.setText("Type: " + manager.getData().getUser().getInventory().getActiveCreature().getType());
        enemyName.setText("Name: " + battle.getEnemy().getName());
        enemyEvolutionLevel.setText("EL: " + battle.getEnemy().getCurrentLevel());
        enemyType.setText("Type: " + battle.getEnemy().getType());
    }

    /**
     *  ` Initializes the background for the battle screen.
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

    /*|*********************************
                Class Methods
    ***********************************/
    /**
     *  ` Handles button actions and performs corresponding actions in the battle.
     *
     * @param e The ActionEvent representing the button press.
     */
    @Override
    public void actionPerformed( ActionEvent e ){
        Object buttonPressed = e.getSource();

        // attack enemy
        if( buttonPressed == attack ){
            battle.performAttack(manager.getData().getUser().getActiveCreature(), battle.getEnemy());
            enemyHealth.setValue((int) (battle.getEnemy().getHealth() / 50 * 100));
            note.setText("Enemy creature took " + (50 - battle.getEnemy().getHealth()) + " damage.");
            nMoves -= 1;
            
        }

        // swap creature
        if( buttonPressed == swap && manager.getData().getUser().getInventory().getCreatureListSize() > 1 ){
            // change panel to inventoryScreen
            InventoryScreen inventoryScreen = new InventoryScreen(manager);
            manager.stackState(inventoryScreen);
            manager.getWindow().changePanel(manager.peekStack());
            manager.getWindow().createWindow();
        }

        // capture enemy
        if( buttonPressed == capture ){
            boolean isCaptured = manager.getData().getUser().catchCreature(battle.getEnemy());
            if( isCaptured ) {
                note.setText("Capture successful.");
                // exit battleScreen
                manager.popStack();
                manager.getWindow().changePanel( manager.peekStack() );
                manager.getWindow().createWindow();
            } else {
                note.setText("Capture failed.");
            }
            nMoves -= 1;
            
        }
        if( buttonPressed == run || isOutOfnMoves(nMoves) ){
            // exit battleScreen
            manager.popStack();
            manager.getWindow().changePanel( manager.peekStack() );
            manager.getWindow().createWindow();
        } 
    }

    /**
     *  ` Customizes the appearance of buttons.
     *
     * @param button The JButton to be customized.
     */
    private void customizeButton( JButton button ) {
        button.setOpaque(false);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Calibri", Font.BOLD, 10));
    }

    /**
     *  ` Checks if the player is out of nMoves.
     *
     * @param nMoves The remaining number of nMoves.
     * @return True if the player is out of nMoves, false otherwise.
     */
    private boolean isOutOfnMoves( int nMoves ) {
        if (nMoves <= 0) {
            return true;
        }
        else return false;
    }
    
    /**
     *  ` Updates the displayed details of the player's active creature on the battle screen.
     * Retrieves the active creature from the user's inventory and updates the corresponding
     * JLabels with the creature's name, evolution level, and type.
     */
    public void updateCreatureDetails() {
        Inventory inventory = manager.getData().getUser().getInventory();
        Creature activeCreature = inventory.getActiveCreature();

        // update active creature detail
        name.setText("Name: " + activeCreature.getName());
        evolutionLevel.setText("EL: " + activeCreature.getCurrentLevel());
        type.setText("Type: " + activeCreature.getType());
    }

    /**
     *  ` Decreases the remaining number of moves in the battle.
     * Called when the player performs an action such as attacking or capturing.
     */
    public void useMoves() {
        this.nMoves--;
    }
}