package Game;/*
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

import GameTypeState.GameState;
import GameTypeState.LocalGameState;

import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * @author
 */

public class FirstScreen extends JFrame implements ActionListener {

    Facade theFacade;
    SecondScreen next;

    // Variables declaration - do not modify
    private JRadioButton LocalGameButton;
    private JRadioButton HostGameButton;
    private JRadioButton JoinGameButton;
    private JTextField IPField;
    private JLabel IPLabel;
    private JButton OKButton;
    private JButton CancelButton;
    private JLabel IPExampleLabel;
    private ButtonGroup gameModes;

    private GameState gameState;
    private LocalGameState localGameState;
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
        gameState = localGameState;

        initComponents();
        pack();
    }


    /**
     * This method is called from within the constructor to
     * initialize the form.
     */

    private void initComponents() {

        LocalGameButton = new JRadioButton();
        HostGameButton = new JRadioButton();
        JoinGameButton = new JRadioButton();
        gameModes = new ButtonGroup();
        IPField = new JTextField();
        IPLabel = new JLabel();
        OKButton = new JButton();
        CancelButton = new JButton();
        IPExampleLabel = new JLabel();
        getContentPane().setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gridBagConstraints1;
        addWindowListener(new java.awt.event.WindowAdapter() {
                              public void windowClosing(java.awt.event.WindowEvent evt) {
                                  exitForm(evt);
                              }
                          }
        );

        gameModes.add(LocalGameButton);
        gameModes.add(HostGameButton);
        gameModes.add(JoinGameButton);

        LocalGameButton.setActionCommand("local");
        LocalGameButton.setText("Local game");
        LocalGameButton.addActionListener(this);
        LocalGameButton.setSelected(true);

        gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 0;
        getContentPane().add(LocalGameButton, gridBagConstraints1);


        HostGameButton.setActionCommand("host");
        HostGameButton.setText("Host game");
        HostGameButton.addActionListener(this);

        gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 1;
        getContentPane().add(HostGameButton, gridBagConstraints1);


        JoinGameButton.setActionCommand("join");
        JoinGameButton.setText("Join game");
        JoinGameButton.addActionListener(this);

        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 2;
        getContentPane().add(JoinGameButton, gridBagConstraints1);


        IPField.setBackground(Color.white);
        IPField.setName("textfield5");
        IPField.setForeground(Color.black);
        IPField.setText("IP address goes here");
        IPField.setEnabled(false);
        IPField.addActionListener(this);

        gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 3;
        getContentPane().add(IPField, gridBagConstraints1);

        IPLabel.setName("label10");
        IPLabel.setBackground(new Color(204, 204, 204));
        IPLabel.setForeground(Color.black);
        IPLabel.setText("IP address:");

        gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 3;
        getContentPane().add(IPLabel, gridBagConstraints1);

        OKButton.setText("OK");
        OKButton.setActionCommand("ok");
        OKButton.setName("button6");
        OKButton.setBackground(new Color(212, 208, 200));
        OKButton.setForeground(Color.black);
        OKButton.addActionListener(this);

        gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 5;
        gridBagConstraints1.insets = new Insets(30, 0, 0, 0);
        getContentPane().add(OKButton, gridBagConstraints1);

        CancelButton.setText("Cancel");
        CancelButton.setActionCommand("cancel");
        CancelButton.setName("button7");
        CancelButton.setBackground(new Color(212, 208, 200));
        CancelButton.setForeground(Color.black);
        CancelButton.addActionListener(this);

        gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridx = 3;
        gridBagConstraints1.gridy = 5;
        gridBagConstraints1.insets = new Insets(30, 0, 0, 0);
        getContentPane().add(CancelButton, gridBagConstraints1);

        IPExampleLabel.setName("label11");
        IPExampleLabel.setBackground(new Color(204, 204, 204));
        IPExampleLabel.setForeground(Color.black);
        IPExampleLabel.setText("Ex: 123.456.789.123");

        gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 4;
        getContentPane().add(IPExampleLabel, gridBagConstraints1);


    }

    /**
     * Exit the Application
     *
     * @param the event to close the window
     */

    private void exitForm(WindowEvent evt) {
        System.exit(0);
    }

    /**
     * This takes care of when an action takes place. It will check the
     * action command of all components and then deicde what needs to be done.
     *
     * @param e the event that has been fired
     */

    public void actionPerformed(ActionEvent e) {

        try {
            //this code handles disabling the IP field unless
            //the join game radio button is selected
            if ((e.getActionCommand()).equals("join")) {
                IPField.setEnabled(true);
            } else if ((e.getActionCommand()).equals("local")) {
                gameState = localGameState;
                localGameState.setIPField();
            } else if ((e.getActionCommand()).equals("host")) {
                IPField.setEnabled(false);

                //this next if statement takes care of when the
                //OK button is selected and goes to the second
                //screen settign the desired options

            } else if ((e.getActionCommand()).equals("ok")) {

                //a temporary button to use for determining the game type
                ButtonModel tempButton = gameModes.getSelection();

                //if check to see of the local radio button is selected
                if (tempButton.getActionCommand().equals("local")) {
                    System.out.println(gameState);
                    gameState.doAction();

                    //if the host game button is selected
                } else if (tempButton.getActionCommand().equals("host")) {

                    //set up to host a game
                    theFacade.setGameMode(theFacade.HOSTGAME);

                    theFacade.createPlayer(1, theFacade.HOSTGAME);
                    theFacade.createPlayer(2, theFacade.HOSTGAME);

                    //hide the FirstScreen, make the SecondScreen and show it
                    this.hide();
                    next = new SecondScreen(theFacade, this, theFacade.HOSTGAME);
                    next.show();

                    //if the join game button is selected
                } else if (tempButton.getActionCommand().equals("join")) {

                    //set up to join a game
                    theFacade.setGameMode(theFacade.CLIENTGAME);

                    theFacade.createPlayer(1, theFacade.CLIENTGAME);
                    theFacade.createPlayer(2, theFacade.CLIENTGAME);

                    //try to connect
                    try {

                        //create a URL from the IP address in the IPfield
                        URL address = new URL("http://" + IPField.getText());
                        //set the host
                        theFacade.setHost(address);

                        //hide the FirstScreen, make and show the Second screen
                        this.hide();
                        next = new SecondScreen(theFacade, this, theFacade.CLIENTGAME);
                        next.show();

                        //catch any exceptions
                    } catch (MalformedURLException x) {
                        JOptionPane.showMessageDialog(null,
                                "Invalid host address",
                                "Error",
                                JOptionPane.INFORMATION_MESSAGE);
                    }//end of networking catch statement

                    //set up to connect to another person
                }


                //if they hit cancel exit the game
            } else if (e.getActionCommand().equals("cancel")) {
                System.exit(0);
            }

        } catch (Exception x) {
            System.err.println(x.getMessage());
        }//end of general catch statement

    }//end of actionPerformed

    public Facade getTheFacade() {
        return theFacade;
    }

    public JTextField getIPField() {
        return IPField;
    }
}//FirstScreen.java
