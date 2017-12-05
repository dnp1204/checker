package GameTypeState;

import GUIElements.FirstScreen;

public class GameStateContext {
    private final String JOIN = "join";
    private final String LOCAL = "local";
    private final String HOST = "host";
    private final String OK = "ok";
    private final String CANCEL = "cancel";

    // GameState variables
    private FirstScreen firstScreen;
    private GameState gameState;
    private GameState localGameState;
    private GameState joinGameState;
    private GameState hostGameState;

    public GameStateContext(FirstScreen firstScreen) {
        this.firstScreen = firstScreen;
        localGameState = new LocalGameState(this.firstScreen);
        joinGameState = new JoinGameState(this.firstScreen);
        hostGameState = new HostGameState(this.firstScreen);
        gameState = localGameState;
    }

    public void doAction(String type) {
        switch (type) {
            case LOCAL:
                gameState = localGameState;
                break;
            case JOIN:
                gameState = joinGameState;
                break;
            case HOST:
                gameState = hostGameState;
                break;
            case OK:
                gameState.doAction();
                break;
            case CANCEL:
                System.exit(0);
        }
    }

    public void setIPField() {
        gameState.setIPField();
    }
}
