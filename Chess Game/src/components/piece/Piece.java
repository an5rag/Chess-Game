package components.piece;

import components.ChessBoard;
import components.ChessBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class having common attributes across all pieces
 * Also implements all common functions
 * Created by an5ra on 9/7/2015.
 */
abstract public class Piece {

    //--------DECLARING COLOR CONSTANTS----------
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    //-------------------------------------------

    String name;
    String color;
    boolean alive;
    ChessBox currentPosition;

    //Points to the piece which killed it
    Piece wasKilledBy;

    //List of pieces it killed
    ArrayList<Piece> piecesKilled = new ArrayList<Piece>();

    /**
     * Constructor
     * @param name
     * @param color
     * @param setPosition
     */
    public Piece(String name, String color, ChessBox setPosition)
    {
        this.name = name;
        this.color = color;
        currentPosition = setPosition;
        setPosition.addPiece(this);
        //piece_picture = Image.getDefaultPicture();
        alive = true;
    }

    /**
     * Overriding toString function to print a Piece
     * @return
     */
    @Override
    public String toString()
    {
        if(color.equals("black"))
          return String.format(ANSI_RED + name.charAt(0) +""+ name.charAt(name.length()-1) + ANSI_RESET);
          return String.format(ANSI_YELLOW+ name.charAt(0) +""+ name.charAt(name.length()-1)+ ANSI_RESET);
    }


    /**
     * Changes current position of the piece to the new destination box
     * Calls add
     * @param destinationChessBox
     */
    public void movePiece(ChessBox destinationChessBox)
    {
        currentPosition = destinationChessBox;
        destinationChessBox.addPiece(this);
    }

    /**
     * Checks if a move is possible or not and returns appropriate boolean
     * @param chessBoard
     * @param destinationChessBox
     * @return
     */
    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        ArrayList<ChessBox> possibleMoves = getPossibleMoves(chessBoard); //get List of all Possible moves

        System.out.println("Printing out possible Moves:"); //for debug purposes
        for(ChessBox c: possibleMoves)
        System.out.println(c);

        //if the destination box exists in the possible moves, it returns true
        if(insidePossibleMovesList(possibleMoves,destinationChessBox))
            return true;
        return false;
    }

    /**
     * Function adds all possible moves to an ArrayList of ChessBoxes and returns it
     * @param chessBoard
     * @param possibleMoves
     * @param RankDifference
     * @param FileDifference
     */
    public void addToPossibleMoves(ChessBoard chessBoard, ArrayList<ChessBox> possibleMoves,int RankDifference, int FileDifference)
    {
        int newRank = currentPosition.getRank() + RankDifference;
        int newFile = currentPosition.getFile()+ FileDifference;

        ChessBox newChessBox;
        //try-catch block to ensure that on accessing a non-existent box, the game doesn't fail
        try {
            newChessBox = chessBoard.boxes[newFile][newRank];
            if (!newChessBox.isOccupiedByOwnPiece(this))
                possibleMoves.add(newChessBox);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return;
        }

    }

    /**
     * Is the destination box inside the list of possible moves?
     * @param possibleMoves
     * @param boxInQuestion
     * @return
     */
    public boolean insidePossibleMovesList(ArrayList<ChessBox> possibleMoves,ChessBox boxInQuestion)
    {
        for(ChessBox iteratorBox: possibleMoves)
        {
            if(iteratorBox==boxInQuestion)
                return true;
        }
        return false;
    }

    /**
     * Piece is killed by another piece
     * @param killer
     */
    public void die(Piece killer)
    {
        alive=false;
        wasKilledBy=killer;
    }

    public ArrayList<Piece> getOpponentPieces(ChessBoard chessBoard)
    {
        ArrayList<Piece> opponents = new ArrayList<Piece>();
        for(chessBoard.pieces)
    }
    /**
     * Abstract function to be implemented by every unique piece
     * to generate list of all possible moves
     * @param chessBoard
     * @return
     */
    abstract public ArrayList<ChessBox> getPossibleMoves(ChessBoard chessBoard);


    //--------Getter methods--------
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isAlive() {
        return alive;
    }

    public ChessBox getCurrentPosition() {
        return currentPosition;
    }

    public Piece getWasKilledBy() {
        return wasKilledBy;
    }

    public List<Piece> getPiecesKilled() {
        return piecesKilled;
    }
}

