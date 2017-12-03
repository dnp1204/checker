package GameTypeState;

import GUIElements.FirstScreen;
import GUIElements.SecondScreen;

public class HostGameState implements GameState {
    private FirstScreen firstScreen;

    public HostGameState(FirstScreen firstScreen) {
        this.firstScreen = firstScreen;
    }

    @Override
    public void doAction() {
        //set up to host a game
        try {
            firstScreen.getTheFacade().setGameMode(firstScreen.getTheFacade().getHOSTGAME());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        firstScreen.getTheFacade().createPlayer(1, firstScreen.getTheFacade().getHOSTGAME());
        firstScreen.getTheFacade().createPlayer(2, firstScreen.getTheFacade().getHOSTGAME());

        //hide the FirstScreen, make the SecondScreen and show it
        firstScreen.hide();
        SecondScreen next = new SecondScreen(firstScreen.getTheFacade(), firstScreen, firstScreen.getTheFacade()
                .getHOSTGAME());
        next.show();
    }

    @Override
    public void setIPField() {
        firstScreen.getIPField().setEnabled(false);
    }
}
