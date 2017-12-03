package GUIElements;/*
 * FirstScreen.java
 *
 *  * Version:
 *   $Id: FirstScreen.java,v 1.1 2002/10/22 21:12:52 se362 Exp $
 *
 * Revisions:
 *   $Log: FirstScreen.java,v $
 *   Revision 1.1  2002/10/22 21:12:52  se362
 *   Initial creation of case study
 *
 */

import Game.Facade;
import GameTypeState.GameState;
import GameTypeState.HostGameState;
import GameTypeState.JoinGameState;
import GameTypeState.LocalGameState;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * @author
 */

public class FirstScreen extends JFrame implements ActionListener {

    private Facade theFacade;

    // Variables declaration - do not modify
    private JRadioButton LocalGameButton = new JRadioButton("Local game");
    private JRadioButton HostGameButton = new JRadioButton("Host game");
    private JRadioButton JoinGameButton = new JRadioButton("Join game");
    private JTextField IPField = new JTextField("IP address goes here");
    private JLabel IPLabel = new JLabel("IP address:");
    private JButton OKButton = new JButton("OK");
    private JButton CancelButton = new JButton("Cancel");
    private JLabel IPExampleLabel = new JLabel("Ex: 123.456.789.123");
    private ButtonGroup gameModes = new ButtonGroup();

    // GameState variables
    private GameState gameState;
    private GameState localGameState;
    private GameState joinGameState;
    private GameState hostGameState;
    // End of variables declaration

    /**
     * Creates new form FirstScreen
     *
     * @param facade a facade object for the GUI to interact with
     */

    public FirstScreen(Facade facade) {

        super("First screen");
        theFacade = facade;

        localGameState = new LocalGameState(this);
        joinGameState = new JoinGameState(this);
        hostGameState = new HostGameState(this);
        gameState = localGameState;

        initComponents();
        pack();
    }

    private GridBagConstraints setGridBagConstraint(int x, int y){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        return gbc;
    }

//    private void addActionListener(){
//        JComponent[] components = {LocalGameButton,HostGameButton,JoinGameButton,
//        IPField,IPLabel,OKButton,CancelButton};
//        for(int i=0;i<components.length;i++){
//            components[i].addActionListener(this);
//        } //todo
//    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */

    private void initComponents() {
        getContentPane().setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gridBagConstraints1;
        addWindowListener(new java.awt.event.WindowAdapter() {
                              public void windowClosing(java.awt.event.WindowEvent evt) {
                                  System.exit(0);
                              }
                          }
        );

        gameModes.add(LocalGameButton);
        gameModes.add(HostGameButton);
        gameModes.add(JoinGameButton);

        LocalGameButton.setActionCommand("local");
        LocalGameButton.addActionListener(this);
        LocalGameButton.setSelected(true);

        getContentPane().add(LocalGameButton, setGridBagConstraint(1,0));

        HostGameButton.setActionCommand("host");
        HostGameButton.addActionListener(this);

        getContentPane().add(HostGameButton, setGridBagConstraint(1,1));

        JoinGameButton.setActionCommand("join");
        JoinGameButton.addActionListener(this);

        getContentPane().add(JoinGameButton, setGridBagConstraint(1,2));

        IPField.setBackground(Color.white);
        IPField.setName("textfield5");
        IPField.setForeground(Color.black);
        IPField.setEnabled(false);
        IPField.addActionListener(this);

        getContentPane().add(IPField, setGridBagConstraint(2,3));

        IPLabel.setName("label10");
        IPLabel.setBackground(new Color(204, 204, 204));
        IPLabel.setForeground(Color.black);

        getContentPane().add(IPLabel, setGridBagConstraint(1,3));

        OKButton.setActionCommand("ok");
        OKButton.setName("button6");
        OKButton.setBackground(new Color(212, 208, 200));
        OKButton.setForeground(Color.black);
        OKButton.addActionListener(this);

        gridBagConstraints1 = setGridBagConstraint(2,5);
        gridBagConstraints1.insets = new Insets(30, 0, 0, 0);
        getContentPane().add(OKButton, gridBagConstraints1);

        CancelButton.setActionCommand("cancel");
        CancelButton.setName("button7");
        CancelButton.setBackground(new Color(212, 208, 200));
        CancelButton.setForeground(Color.black);
        CancelButton.addActionListener(this);

        gridBagConstraints1 = setGridBagConstraint(3,5);
        gridBagConstraints1.insets = new Insets(30, 0, 0, 0);
        getContentPane().add(CancelButton, gridBagConstraints1);

        IPExampleLabel.setName("label11");
        IPExampleLabel.setBackground(new Color(204, 204, 204));
        IPExampleLabel.setForeground(Color.black);

        getContentPane().add(IPExampleLabel, setGridBagConstraint(2,4));
    }

    /**
     * This takes care of when an action takes place. It will check the
     * action command of all components and then deicde what needs to be done.
     *
     * @param e the event that has been fired
     */

    public void actionPerformed(ActionEvent e) {
        //this code handles disabling the IP field unless
        //the join game radio button is selected
        if ((e.getActionCommand()).equals("join")) {
            gameState = joinGameState;
            gameState.setIPField();
        } else if ((e.getActionCommand()).equals("local")) {
            gameState = localGameState;
            gameState.setIPField();
        } else if ((e.getActionCommand()).equals("host")) {
            gameState = hostGameState;
            gameState.setIPField();

        } else if ((e.getActionCommand()).equals("ok")) {
            //this next if statement takes care of when the
            //OK button is selected and goes to the second
            //screen settings the desired options
            gameState.doAction();

            //if they hit cancel exit the game
        } else if (e.getActionCommand().equals("cancel")) {
            System.exit(0);
        }
    }//end of actionPerformed

    public Facade getTheFacade() {
        return theFacade;
    }

    public JTextField getIPField() {
        return IPField;
    }
} //FirstScreen.java
