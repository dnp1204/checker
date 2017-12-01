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
            firstScreen.getTheFacade().setGameMode(firstScreen.getTheFacade().LOCALGAME);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        firstScreen.getTheFacade().createPlayer(1, firstScreen.getTheFacade().LOCALGAME);
        firstScreen.getTheFacade().createPlayer(2, firstScreen.getTheFacade().LOCALGAME);

        //hide the FirstScreen, make a SecondScreen and show it
        firstScreen.hide();
        SecondScreen next = new SecondScreen(firstScreen.getTheFacade(), firstScreen, firstScreen.getTheFacade()
                .LOCALGAME);
        next.show();
    }

    @Override
    public void setIPField() {
        firstScreen.getIPField().setEnabled(false);
    }
}
