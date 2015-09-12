package boardSetUp;
import components.Player;

/**
 * Created by an5ra on 9/8/2015.
 */
public class GameState {

    Player playerInTurn;
    Player playerNotInTurn;

    public GameState()
    {

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
