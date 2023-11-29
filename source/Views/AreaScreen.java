package Views;
import javax.swing.*;

import Controllers.Battle;
import Controllers.StackManager;
import Models.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Represents the screen where the player can navigate and encounter events in a specific game area.
 * Inherits from the GameState class and implements the ActionListener interface for button actions.
 */
public class AreaScreen extends GameState implements ActionListener {

    /*|*********************************
                 Attributes
    ***********************************/ 
    private JButton up, down, left, right, exit;
    private JPanel map;
    private JPanel[][] mapPanels;
    private int nCharacterRow;
    private int nCharacterCol;
    private int nIndex;
    private int nRows;
    private int nCols;


    /*|*********************************
                Constructor
    ***********************************/
    public AreaScreen(StackManager manager, int nIndex) {
        super(manager);
        super.setLayout(null);
        this.nIndex = nIndex;

        // Initialize buttons
        up = new JButton("^");
        down = new JButton("v");
        left = new JButton("<");
        right = new JButton(">");
        exit = new JButton("Exit");

        // Initialize Map
        nRows = manager.getData().getArea(nIndex).getWidth();
        nCols = manager.getData().getArea(nIndex).getLength();

        map = new JPanel(new GridLayout(nRows, nCols));
        mapPanels = new JPanel[nRows][nCols];
        nCharacterRow = 0;
        nCharacterCol = 0;

        // Initialize button appearance and positions
        initButton();
        // Initialize layout appearance and positions
        initLayout();
    }

    /**
     *  ` Initializes the directional buttons and exit button on the area screen.
     */
    private void initButton() {

        // Customize the buttons
        up.setBounds(75, 200, 50, 50);
        up.addActionListener(this);
        customizeButton(up);

        down.setBounds(75, 300, 50, 50);
        down.addActionListener(this);
        customizeButton(down);

        left.setBounds(25, 250, 50, 50);
        left.addActionListener(this);
        customizeButton(left);

        right.setBounds(125, 250, 50, 50);
        right.addActionListener(this);
        customizeButton(right);

        exit.setBounds(50, 500, 100, 25);
        exit.addActionListener(this);
        customizeButton(exit);

        // Add buttons to the frame
        super.add(up);
        super.add(down);
        super.add(left);
        super.add(right);
    }

    /**
     *  ` Initializes the layout of the area screen, including the map grid and buttons.
     */
    private void initLayout() {
        // setup area panel
        map.setBounds(200, 0, 600, 600);

        // Create the area grid
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                mapPanels[row][col] = createMapPanel(row, col);
                map.add(mapPanels[row][col]);
            }
        }

        super.add(map);
        super.add(exit);

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
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();

        // Move character based on button clicked
        if (buttonPressed == up && nCharacterRow > 0) {
            moveCharacter(nCharacterRow - 1, nCharacterCol);
            encounter();
        } else if (buttonPressed == down && nCharacterRow < nRows - 1) {
            moveCharacter(nCharacterRow + 1, nCharacterCol);
            encounter();
        } else if (buttonPressed == left && nCharacterCol > 0) {
            moveCharacter(nCharacterRow, nCharacterCol - 1);
            encounter();
        } else if (buttonPressed == right && nCharacterCol < nCols - 1) {
            moveCharacter(nCharacterRow, nCharacterCol + 1);
            encounter();
        } else if (buttonPressed == exit) {
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
        button.setOpaque(false);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }
    
    /**
     *  ` Creates a JPanel representing a cell in the area map grid.
     *
     * @param row The row nIndex of the cell.
     * @param col The column nIndex of the cell.
     * @return A JPanel representing the cell with appropriate content.
     */
    private JPanel createMapPanel(int row, int col) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Optional border
        panel.setLayout(new BorderLayout());

        JLabel label;
        if (row == nCharacterRow && col == nCharacterCol) {
            label = new JLabel("Player", SwingConstants.CENTER);
        } else {
            label = new JLabel("A" + (row * nCols + col + 1), SwingConstants.CENTER);
        }
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }

    /**
     *  ` Moves the character to a new position on the map.
     *
     * @param newRow The new row nIndex of the character.
     * @param newCol The new column nIndex of the character.
     */
    private void moveCharacter(int newRow, int newCol) {
        mapPanels[nCharacterRow][nCharacterCol].removeAll();
        mapPanels[nCharacterRow][nCharacterCol].add(new JLabel("A" + (nCharacterRow * nCols + nCharacterCol + 1), SwingConstants.CENTER));

        mapPanels[newRow][newCol].removeAll();
        mapPanels[newRow][newCol].add(new JLabel("Player", SwingConstants.CENTER));

        nCharacterRow = newRow;
        nCharacterCol = newCol;

        manager.getWindow().getJFrame().revalidate();
        manager.getWindow().getJFrame().repaint();
    }

    /**
     *  ` Initiates an encounter based on a random event.
     * If an encounter occurs, it transitions to the BattleScreen.
     * The probability of encounter is 40%.
     */
    private void encounter(){ 
        Random rand = new Random();
        int random = rand.nextInt(100);

        if( random <= 40 ) {
            
            int enemynIndex = manager.getData().getArea(nIndex).generateEnemyIndex(manager.getData().getArea(nIndex));
            Creature enemy = manager.getData().getCompendium().generateCreature(enemynIndex);
            Battle battle = new Battle(manager.getData().getUser(), enemy);  // Assuming 'user' and 'enemy' are already defined
            manager.stackState( new BattleScreen(manager,battle) );
            manager.getWindow().changePanel( manager.peekStack() );
            manager.getWindow().createWindow();

            
        }
    }
}