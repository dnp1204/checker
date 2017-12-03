package GameTypeState;

import GUIElements.FirstScreen;
import GUIElements.SecondScreen;

public class LocalGameState implements GameState {
    private FirstScreen firstScreen;

    public LocalGameState(FirstScreen firstScreen) {
        this.firstScreen = firstScreen;
    }

    @Override
    public void doAction() {
        try {
            //set up a local game
            firstScreen.getTheFacade().setGameMode(firstScreen.getTheFacade().getLOCALGAME());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        firstScreen.getTheFacade().createPlayer(1, firstScreen.getTheFacade().getLOCALGAME());
        firstScreen.getTheFacade().createPlayer(2, firstScreen.getTheFacade().getLOCALGAME());

        //hide the FirstScreen, make a SecondScreen and show it
        firstScreen.hide();
        SecondScreen next = new SecondScreen(firstScreen.getTheFacade(), firstScreen, firstScreen.getTheFacade()
                .getLOCALGAME());
        next.show();
    }

    @Override
    public void setIPField() {
        firstScreen.getIPField().setEnabled(false);
    }
}
