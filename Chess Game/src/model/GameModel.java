package model;

import boardSetUp.SetBoard;
import components.ChessBoard;
import components.ChessBox;
import components.piece.King;
import components.piece.Piece;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the main Model Class. It calls all the helper functions and initializes components
 * Created by an5ra on 9/8/2015.
 */
public class GameModel {

    ChessBoard chessBoard;
    GameState gameState;
    SetBoard setBoard;
    Move move;
    boolean isSpecial;


    //These numbers are used to communicate back and forth with the Controller
    public static final int QUEEN = 0;
    public static final int KING = 1;
    public static final int BISHOP = 2;
    public static final int KNIGHT = 3;
    public static final int ROOK = 4;
    public static final int PAWN = 5;
    public static final int BLACK = 0;
    public static final int WHITE = 1;

    /**
     * Constructor
     * @param whitePlayerName
     * @param blackPlayerName
     * @param isSpecial
     */
    public GameModel(String whitePlayerName, String blackPlayerName, boolean isSpecial)
    {
        chessBoard = new ChessBoard();
        setBoard = new SetBoard(chessBoard, isSpecial);
        setBoard.setPieces(isSpecial);
        gameState = new GameState( whitePlayerName, blackPlayerName, isSpecial);
        move = new Move(chessBoard);
        this.isSpecial = isSpecial;
    }

    /**
     * It takes in the coordinates
     * and makes the move happen in the model
     * @param startRow
     * @param startCol
     * @param endRow
     * @param endCol
     * @return
     */
    public boolean makeMove(int startRow, int startCol, int endRow, int endCol)
    {
        ChessBox source = chessBoard.getBoxes()[startRow][startCol];
        ChessBox destination = chessBoard.getBoxes()[endRow][endCol];
        boolean successful =  move.makeMove(source, destination);
        return successful;
    }

    /**
     * Calls game state's toggle turn to switch turn
     */
    public void toggleTurn()
    {
        gameState.switchTurn();
    }

    /**
     * returns an array of size-two arrays
     * list of possible moves
     * @param row
     * @param col
     * @return
     */
    public ArrayList<int[]> getPossibleMoves(int row, int col)
    {
        ChessBox chessBox = chessBoard.getBoxes()[row][col];
        ArrayList<int[]> listOfPossibleMoves= new ArrayList<int[]>();
        for(ChessBox possibleBox: chessBox.getOccupyingPiece().getPossibleMoves(chessBoard))
        {
            int arr[] = new int[2];
            arr[0]= possibleBox.getRank();
            arr[1] = possibleBox.getFile();
            listOfPossibleMoves.add(arr);
        }
        return listOfPossibleMoves;
    }

    /**
     * Returns occupied status of the box
     * @param row
     * @param col
     * @return
     */
    public boolean isOccupied(int row, int col)
    {
        return chessBoard.getBoxes()[row][col].isOccupied();
    }

    /**
     * Main class for DEBUG PURPOSES
     * @param args
     */
    public static void main(String args[])
    {
        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        s.setPieces(false);
        Move m = new Move(c);

        //Infinite Game-Loop
        while(true)
        {
            c.displayBoard();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter makeMove:");
            String move = scanner.nextLine();
            m.makeMove(move);
        }
    }

    /**
     * Checks if both the Kings if they are in Check
     * @return
     */
    public int[] kingInCheck()
    {
        King whiteKing = chessBoard.getWhiteKing();
        King blackKing = chessBoard.getBlackKing();
        ChessBox whiteKingBox = whiteKing.getCurrentPosition();
        ChessBox blackKingBox = blackKing.getCurrentPosition();
        if(whiteKing.isCheck(chessBoard))
        {
            int position[] = new int[2];
            position[0] = whiteKingBox.getRank();
            position[1] = whiteKingBox.getFile();
            return position;
        }
        else if(blackKing.isCheck(chessBoard))
        {
            int position[] = new int[2];
            position[0] = blackKingBox.getRank();
            position[1] = blackKingBox.getFile();
            return position;
        }

        return null;
    }

    /**
     * Checks if the box chosen is of the player in turn
     * returns TRUE if it ISN'T
     * @param row
     * @param col
     * @return
     */
    public boolean notInTurnBox(int row, int col) {

        ChessBox boxInQuestion = chessBoard.getBoxes()[row][col];
        String pieceColor = boxInQuestion.getOccupyingPiece().getColor();
        String playerColor = gameState.getPlayerInTurn().getColor();
        if(pieceColor.equalsIgnoreCase(playerColor))
            return false;
        return true;
    }

    /**
     * return in turn player's color
     * @return
     */
    public String getPlayerInTurnColor() {
        return gameState.getPlayerInTurn().getColor();
    }

    /**
     * Returns player's score by colo
     * @param playerColor
     * @return
     */
    public int getPlayerScore(String playerColor)
    {
        if(playerColor.equalsIgnoreCase("black"))
            return gameState.getBlackPlayer().getScore();
        else
            return gameState.getWhitePlayer().getScore();
    }

    /**
     * Increments score of a player by 1
     * @param playerColor
     */
    public void incrementPlayerScore(String playerColor)
    {
        if(playerColor.equalsIgnoreCase("black"))
            gameState.getBlackPlayer().incrementScore();
        else
            gameState.getWhitePlayer().incrementScore();
    }

    /**
     * Resets all players' scores
     */
    public void resetScores()
    {
        gameState.getBlackPlayer().resetScore();
        gameState.getBlackPlayer().resetScore();
    }

    /**
     * Reinitializes the board and sets its boxes, pieces and player's turn
     */
    public void resetBoard()
    {
        setBoard.setBoxes();
        setBoard.setPieces(isSpecial);
        gameState.resetPlayerInTurn();
    }

    /**
     * To start a new game from scratch
     */
    public void newGame() {
        resetScores();
        resetBoard();
    }

    /**
     * calls the board's undogame
     */
    public void undoGame() {

        chessBoard.undo();

    }
}
