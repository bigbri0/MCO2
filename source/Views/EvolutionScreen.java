package Views;

import javax.swing.*;

import Controllers.StackManager;
import Models.Creature;
import Models.Evolution;
import Models.GameData;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * The EvolutionScreen class represents the screen where players can perform creature evolution.
 * It allows players to choose two compatible creatures for evolution and trigger the evolution process.
 */
public class EvolutionScreen extends GameState implements ActionListener{
    
    /*|*********************************
                 Attributes
    ***********************************/
    private Evolution evolution;
    private Creature chamber1, chamber2;
    private JButton choose1, choose2, evolve, back;
    private int chooseButtonPressed;

    private JLabel creature1, creature2;
    private JLabel c1Name, c1EvolutionLevel, c2Name, c2EvolutionLevel;
    private JLabel background, note;
    private int nIndex1, nIndex2;

    /*|*********************************
                 Constructor
    ***********************************/
    public EvolutionScreen( StackManager manager ) {

        super(manager);
        super.setLayout(null);
        this.evolution = new Evolution();

        choose1 = new JButton("Choose");
        choose2 = new JButton("Choose");
        evolve = new JButton("Evolve");
        back = new JButton("back");
        creature1 = new JLabel();
        creature2 = new JLabel();
        c1Name = new JLabel("Name");
        c1EvolutionLevel = new JLabel("EL");
        c2Name = new JLabel("Name");
        c2EvolutionLevel = new JLabel("EL");
        note = new JLabel();


        initButton();
        initLayout();

        // Background
        background = new JLabel();
        initBackground();
    }

    /**
     *  ` Initializes the buttons for choosing creatures, triggering evolution, and going back.
     */
    private void initButton() {

        // Customize the buttons
        choose1.setBounds(100, 200, 75, 50);
        choose1.addActionListener(this);
        customizeButton(choose1);

        choose2.setBounds(600, 200, 75, 50);
        choose2.addActionListener(this);
        customizeButton(choose2);

        evolve.setBounds(350, 200, 75, 50);
        evolve.addActionListener(this);
        customizeButton(evolve);

        back.setBounds(350, 500, 75, 50);
        back.addActionListener(this);

        // Add buttons to the super
        super.add(choose1);
        super.add(choose2);
        super.add(evolve);
        super.add(back);
    }

    /**
     *  ` Initializes the layout of panels and labels for creature display.
     */
    private void initLayout() {

        // Customize the panels
        creature1.setBackground(Color.white);
        creature1.setBounds(75, 125, 125, 200);

        creature2.setBackground(Color.white);
        creature2.setBounds(575, 125, 125, 200);

        // Customize the labels
        c1Name.setBounds(80, 325, 125, 25);
        c1Name.setOpaque(false);
        c1EvolutionLevel.setBounds(80, 350, 125, 25);
        c2Name.setBounds(580, 325, 125, 25);
        c2EvolutionLevel.setBounds(580, 350, 125, 25);
        note.setBounds(250, 250, 400, 50);

        // Add panels to the super
        super.add(creature1);
        super.add(creature2);

        // Add labels to the super
        super.add(c1Name);
        super.add(c1EvolutionLevel);
        super.add(c2Name);
        super.add(c2EvolutionLevel);
        super.add(note);

    }

    /**
     *  ` Initializes the background for the EvolutionScreen.
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
     *  ` Handles button actions and performs corresponding actions for choosing creatures,
     * triggering evolution, and going back.
     *
     * @param e The ActionEvent representing the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Object buttonPressed = e.getSource();

            // - 1st creature
        if( buttonPressed == choose1 ) {
            InventoryScreen inventoryScreen = new InventoryScreen(manager);
            manager.stackState(inventoryScreen);
            manager.getWindow().changePanel(manager.peekStack());
            manager.getWindow().createWindow();

            chooseButtonPressed = 1;
        }

        // - 2nd creature
        if (buttonPressed == choose2) {
            InventoryScreen inventoryScreen = new InventoryScreen(manager);
            manager.stackState(inventoryScreen);
            manager.getWindow().changePanel(manager.peekStack());
            manager.getWindow().createWindow();

            chooseButtonPressed = 2;
        }

        // - Evolution
        if(buttonPressed == evolve){

            if (isChamberFull(chamber1) && isChamberFull(chamber2)) {

                if (chamber1.getName() == chamber2.getName() && chamber1.getCurrentLevel() < 3) {
                    ArrayList<Creature> creatureList = manager.getData().getUser().getInventory().getCreatureList();
                    System.out.printf( "[1] " + nIndex1);
                    System.out.printf( "[2] " + nIndex2);


                creatureList = evolution.EvolutionChamber(nIndex1, nIndex2, creatureList);
                System.out.println("After evolution: " + creatureList.size());
                
                GameData data = new GameData();
        
                for (int i = 0; i < creatureList.size(); i++) {
                    data.getUser().getInventory().addCreature(creatureList.get(i));
                }
                data.getUser().getInventory().setSelected(creatureList.size() - 1);
                manager.setData(data);
                
                note.setText( manager.getData().getUser().getInventory().getActiveCreature().getName() + " added to your inventory.");

            } else note.setText("Evolution failed: Creatures are not compatible.");
        

        } else note.setText("Evolution failed: Evolution chamber not full");
    
        

        }

        // - Exit window
        if(buttonPressed == back){
            manager.popStack();
            manager.getWindow().changePanel( manager.peekStack() );
            manager.getWindow().createWindow();
        }
    }

    /**
     *  ` Updates the chosen evolution chamber with the selected creature details.
     *
     * @param selectedCreature The creature selected for the evolution chamber.
     */
    public void updateChamber( Creature selectedCreature ) {
        Boolean isNotNull = selectedCreature != null;
        Boolean isNotMaxed = selectedCreature.getCurrentLevel() < 3;

        if( chooseButtonPressed == 1 && isNotNull && isNotMaxed && selectedCreature != chamber2 ) {
            chamber1 = selectedCreature;
            nIndex1 = manager.getData().getUser().getInventory().getSelected();
            c1Name.setText("Name: " + chamber1.getName());
            c1EvolutionLevel.setText("EL: " + chamber1.getCurrentLevel());
            creature1.setIcon(Resources.CREATURE_LIST.get(manager.getData().getCompendium().findCreatureIndex(chamber1)));
        }

        if( chooseButtonPressed == 2 && isNotNull && isNotMaxed && selectedCreature != chamber1 ) {
            chamber2 = selectedCreature;
            nIndex2 = manager.getData().getUser().getInventory().getSelected();
            c2Name.setText("Name: " + chamber2.getName());
            c2EvolutionLevel.setText("EL: " + chamber2.getCurrentLevel());
            creature2.setIcon(Resources.CREATURE_LIST.get(manager.getData().getCompendium().findCreatureIndex(chamber2)));
        }
    }

    /**
     *  ` Customizes the appearance of buttons.
     *
     * @param button The JButton to be customized.
     */
    private void customizeButton( JButton button ) {
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.black);
        button.setFont(new Font("Calibri", Font.BOLD, 10));
    }

    /**
     *  ` Checks if the evolution chamber is full with a creature.
     *
     * @param chamber The creature in the evolution chamber.
     * @return True if the chamber is full, false otherwise.
     */
    private boolean isChamberFull( Creature chamber ) {

        if (chamber == null ) {
            return false;
        }else return true;
    }
}
