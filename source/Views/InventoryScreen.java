package Views;

import Models.Creature;
import Models.Inventory;

import javax.swing.*;

import Controllers.StackManager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/**
 * InventoryScreen class represents the user's inventory screen in the game.
 * It displays a grid of creature buttons, creature information, and action buttons.
 */
public class InventoryScreen extends GameState implements  ActionListener{

    /*|*********************************
                 Attributes
    ***********************************/    
    private JButton active, back;
    private JPanel inventory;
    private JLabel creatureImage;
    private JLabel name, evolutionLevel, type, family;
    private JButton[][] inventoryButtons;
    private int nChoice;

    /*|*********************************
                Constructor
    ***********************************/
    public InventoryScreen(StackManager manager) {
        super(manager);
        super.setLayout(null);
    
        // Initialization of panels and labels
        inventory = new JPanel(new GridLayout(10, 10));
        creatureImage = new JLabel();
        name = new JLabel("Name");
        evolutionLevel = new JLabel("EL");
        type = new JLabel("Type");
        family = new JLabel("Family");

        // Initialize Buttons
        active = new JButton("Active");
        back = new JButton("Exit");
        inventoryButtons = new JButton[10][10];
        
        // Creation of inventory buttons and adding them to the grid
        for (int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {

                inventoryButtons[row][col] = createInventoryButton(row, col);
                inventory.add(inventoryButtons[row][col]);
            }
        }

        // Initialize button appearance and positions
        initButtons();

        // Initialize layout appearance and positions
        initLayout();

        // Display current active creature
        displayCreatureInfo(manager.getData().getUser().getInventory().getSelected());
    }
    
    /**
     *  ` Initializes the layout for panels and labels.
     */
    private void initLayout() {
        // Initialize layout for panels and labels
        inventory.setBounds(0, 0, 600, 600);
        creatureImage.setBounds(635, 40, 125, 200);
        name.setBounds(640, 250, 150, 25);
        evolutionLevel.setBounds(640, 275, 100, 25);
        type.setBounds(640, 300, 100, 25);
        family.setBounds(640, 325, 100, 25);

        // Set background color for panels
        inventory.setBackground(Color.white);
        Creature creature = manager.getData().getUser().getActiveCreature();
        creatureImage.setIcon(Resources.CREATURE_LIST.get(manager.getData().getCompendium().findCreatureIndex(creature)));

        // Set visibility for labels
        name.setVisible(true);
        evolutionLevel.setVisible(true);
        type.setVisible(true);
        family.setVisible(true);

        // Add buttons to the frame
        super.add(inventory);
        super.add(creatureImage);
        super.add(name);
        super.add(evolutionLevel);
        super.add(type);
        super.add(family);
        
    }

    /**
     *  ` Initializes the action buttons.
     */
    private void initButtons() {
        // Button Initialization

        // Set the layout and appearance for buttons
        customizeButton(active);
        active.setBounds(650, 450, 100, 25);
        active.addActionListener(this);
        super.add(active);

        customizeButton(back);
        back.setBounds(650, 500, 100, 25);
        back.addActionListener(this);
        super.add(back);

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
    public void actionPerformed( ActionEvent e ){
        Object buttonPressed = e.getSource();
        

         // Check if the button pressed is one of the inventory buttons
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    if (buttonPressed == inventoryButtons[row][col]) {
                        // Handle the specific inventory button at row, col
                        // You can use row and col to identify which button was pressed
                        // For example, display information based on the button position
                        nChoice = row * 10 + col;
                        displayCreatureInfo(nChoice);
                        break;
                    }
                }
            }

        // - Active creature
        if(buttonPressed == active){
            if( nChoice >= 0 && nChoice < manager.getData().getUser().getInventory().getCreatureListSize() ) {
                Inventory inventory = manager.getData().getUser().getInventory();
                inventory.setSelected(nChoice);
                
                manager.popStack(); // - Removes InventoryScreen
                if( manager.peekStack() instanceof BattleScreen ) {
                    BattleScreen battleScreen = (BattleScreen)manager.peekStack();
                    battleScreen.updateCreatureDetails();
                    battleScreen.useMoves();
                }

                if( manager.peekStack() instanceof EvolutionScreen ) {
                    EvolutionScreen evolutionScreen = (EvolutionScreen)manager.peekStack();
                    evolutionScreen.updateChamber( inventory.getActiveCreature() );
                }
                
                manager.getWindow().changePanel( manager.peekStack() );
                manager.getWindow().createWindow();
            }
        } 

        // - Exit windows
        else if(buttonPressed == back) {
            // - Removes InventoryScreen
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
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }
    
    private void customizeInventoryButton( JButton button ) {
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setForeground(Color.BLACK);
        button.setBackground(button.isFocusPainted() ? Color.red : Color.lightGray);
        button.setFont(new Font("Arial", Font.BOLD, 10));
    }

     /**
     *  ` Displays information about the selected creature.
     *
     * @param index The index of the selected creature in the inventory.
     */
    private void displayCreatureInfo( int index ) {
        // Assuming that gameData.getInventory() returns an ArrayList<Creature>
        Inventory inventory = manager.getData().getUser().getInventory();
        ArrayList<Creature> creatureList = inventory.getCreatureList();

        // Check if the index is within the bounds of the inventory
        if (index < inventory.getCreatureListSize()) {
            Creature creature = creatureList.get(index);

            if (creature != null) {
                // Update the labels or perform any other action based on the creature
                //ImageIcon Image = CreatureImages.getCreatureImage(0); // Change the index as needed
                //ImageUtils.displayImageOnPanel(Image, creatureImage);

                name.setText("Name: " + creature.getName());
                evolutionLevel.setText("EL: " + creature.getCurrentLevel());
                type.setText("Type: " + creature.getType());
                family.setText("Family: " + creature.getFamily());
                creatureImage.setIcon(Resources.CREATURE_LIST.get(manager.getData().getCompendium().findCreatureIndex(creature)));
            }
        } else {
            // If inventory slot is empty
            name.setText("Name: N/A");
            evolutionLevel.setText("EL: N/A");
            type.setText("Type: N/A");
            family.setText("Family: N/A");
        }
    }

    /**
     *  ` Creates an inventory button with specific row and column indices.
     *
     * @param row The row index of the button.
     * @param col The column index of the button.
     * @return The created inventory button.
     */
    private JButton createInventoryButton( int row, int col ) {
        JButton button = new JButton("C " + (row * 10 + col + 1));
        button.addActionListener(this);
        customizeInventoryButton(button);
        return button;
    }

    /**
     *  ` Retrieves the currently selected creature from the inventory.
     *
     * @return The selected creature.
     */
    public Creature getSelectedCreature() {
        // Assuming gameData.getInventory() returns an ArrayList<Creature>
        int selected = manager.getData().getUser().getInventory().getSelected();
        ArrayList<Creature> creatureList = manager.getData().getUser().getInventory().getCreatureList();
    
        return creatureList.get(selected);

    }



}
