package GameTypeState;

import GUIElements.FirstScreen;
import GUIElements.SecondScreen;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class JoinGameState implements GameState {
    private FirstScreen firstScreen;

    public JoinGameState(FirstScreen firstScreen) {
        this.firstScreen = firstScreen;
    }

    @Override
    public void doAction() {
        //set up to join a game
        try {
            firstScreen.getTheFacade().setGameMode(firstScreen.getTheFacade().getCLIENTGAME());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        firstScreen.getTheFacade().createPlayer(1, firstScreen.getTheFacade().getCLIENTGAME());
        firstScreen.getTheFacade().createPlayer(2, firstScreen.getTheFacade().getCLIENTGAME());

        //try to connect
        try {

            //create a URL from the IP address in the IPfield
            URL address = new URL("http://" + firstScreen.getIPField().getText());
            //set the host
            firstScreen.getTheFacade().setHost(address);

            //hide the FirstScreen, make and show the Second screen
            firstScreen.hide();
            SecondScreen next = new SecondScreen(firstScreen.getTheFacade(), firstScreen, firstScreen.getTheFacade()
                    .getCLIENTGAME());
            next.show();

            //catch any exceptions
        } catch (MalformedURLException x) {
            JOptionPane.showMessageDialog(null,
                    "Invalid host address",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }//end of networking catch statement
    }

    @Override
    public void setIPField() {
        firstScreen.getIPField().setEnabled(true);
    }
}
