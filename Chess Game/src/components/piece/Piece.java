package components.piece;

import components.ChessBoard;
import components.ChessBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class having common attributes across all allPieces
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

    //List of allPieces it killed
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
          return String.format( name.charAt(0) +""+ name.charAt(name.length()-1) );
          return String.format( name.charAt(0) +""+ name.charAt(name.length()-1));
    }


    /**
     * Changes current position of the piece to the new destination box
     * Calls addPiece of ChessBox
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

        System.out.println("Trying "+ newRank + "," + newFile);

        ChessBox newChessBox;
        //try-catch block to ensure that on accessing a non-existent box, the game doesn't fail
        try {
            newChessBox = chessBoard.boxes[newRank][newFile];
            if (!newChessBox.isOccupiedByFriendlyPiece(this))
                possibleMoves.add(newChessBox);
        }
        catch (Exception e)
        {
            //silently ignore
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

    /**
     * Returns list of ALIVE Opponent Pieces
     * @param chessBoard
     * @return
     */
    public ArrayList<Piece> getAliveOpponentPieces(ChessBoard chessBoard)
    {
        ArrayList<Piece> opponents = new ArrayList<Piece>();
        for(Piece p: chessBoard.allPieces)
        {
            if(p.isAlive()&&!p.color.equals(color))
            opponents.add(p);
        }
        return opponents;
    }

    /**
     * Returns list of ALIVE Fiend Pieces
     * @param chessBoard
     * @return
     */
    public ArrayList<Piece> getAliveFriendlyPieces(ChessBoard chessBoard)
    {
        ArrayList<Piece> friends = new ArrayList<Piece>();
        for(Piece p: chessBoard.allPieces)
        {
            if(p.isAlive()&&p.color.equals(color))
                friends.add(p);
        }
        return friends;
    }
    /**
     * Abstract function to be implemented by every unique piece
     * to generate list of all possible moves
     * @param chessBoard
     * @return
     */
    abstract public ArrayList<ChessBox> getPossibleMoves(ChessBoard chessBoard);

    //--------Setter methods--------
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setCurrentPosition(ChessBox currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setWasKilledBy(Piece wasKilledBy) {
        this.wasKilledBy = wasKilledBy;
    }

    public void setPiecesKilled(ArrayList<Piece> piecesKilled) {
        this.piecesKilled = piecesKilled;
    }

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

