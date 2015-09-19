package boardSetUp;
import components.Player;

/**
 * Will be used to save a Game session
 * So that it's retrievable later
 * Created by an5ra on 9/8/2015.
 */
public class GameState {

    Player playerInTurn;
    Player playerNotInTurn;
    String gameStatus;

    public GameState()    {

        playerInTurn = new Player("White");
        playerInTurn = new Player("Black");

    }

    public GameState(GameState toCopy)
    {

    }

    public void switchTurn()
    {

        Player temp  = playerInTurn;
        playerInTurn = playerNotInTurn;
        playerNotInTurn = playerInTurn;
    }

    public Player getPlayerInTurn()
    {
        return playerInTurn;
    }

}
