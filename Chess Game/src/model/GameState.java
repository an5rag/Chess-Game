package model;
import components.Player;

/**
 * Will be used to save a Game session
 * It's player info etc
 * Created by an5ra on 9/8/2015.
 */
public class GameState {

    Player playerInTurn;
    Player playerNotInTurn;
    Player blackPlayer;
    Player whitePlayer;
    boolean specialGameOrNot;
    int gameStatus;

    //gameStatus constants
    public static final int NORMAL = 0;
    public static final int CHECK = 1;
    public static final int CHECKMATE = 2;
    public static final int STALEMATE = 3;

    public GameState(String whitePlayerName, String blackPlayerName, boolean isSpecial)
    {

        playerInTurn = new Player("White",whitePlayerName);
        whitePlayer = playerInTurn;
        playerNotInTurn = new Player("Black",blackPlayerName);
        blackPlayer = playerNotInTurn;
        this.specialGameOrNot = isSpecial;
        gameStatus = NORMAL;

    }


    public void switchTurn()
    {

        Player temp  = playerInTurn;
        playerInTurn = playerNotInTurn;
        playerNotInTurn = temp;
    }


    //--------------------GETTERS AND SETTERS------------------------

    public Player getPlayerInTurn()
    {
        return playerInTurn;
    }

    public boolean isSpecialGameOrNot() {
        return specialGameOrNot;
    }

    public void setSpecialGameOrNot(boolean specialGameOrNot) {
        this.specialGameOrNot = specialGameOrNot;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public void resetPlayerInTurn() {
        playerInTurn = whitePlayer;
        playerNotInTurn = blackPlayer;
    }
}
