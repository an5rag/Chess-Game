package components;

import components.piece.Piece;

/**
 * Represents a single functional ChessBox on the Board
 * Created by an5ra on 9/7/2015.
 */
public class ChessBox {

    int file;
    int rank;
    String color;
    Piece occupyingPiece;
    boolean occupied;

    /**
     * Constructor
     * @param file
     * @param rank
     * @param color
     */
    public ChessBox (int rank, int file, String color)
    {

        this.rank = rank;
        this.file = file;
        this.color = color;
        occupied = false;
        occupyingPiece = null;
    }

    @Override
    public String toString()
    {
        return String.format(rank + "," + file);
    }

    /**
     * Adds a piece to current box and turns occupied true;
     * @param toAddPiece
     */
    public void addPiece(Piece toAddPiece)
    {
//        assert occupyingPiece == null: "This box already has a piece in it";
        occupyingPiece=toAddPiece;
        occupied = true;
    }

    /**
     * Removes the piece currently in the box and returns a pointer to the piece just removed
     * @return
     */
    public Piece removeCurrentPiece()
    {
        Piece toReturnPiece = occupyingPiece;
        occupied = false;
        occupyingPiece = null;
        return toReturnPiece;
    }

    /**
     * Does this box contain a friendly piece?
     * @param p
     * @return
     */
    public boolean isOccupiedByFriendlyPiece(Piece p)
    {
        if(occupied==false)
            return false;

        Piece occupyingPiece = getOccupyingPiece();
        if(occupyingPiece.getColor().equalsIgnoreCase(p.getColor()))
            return true;

        return false;
    }

    /**
     * Does this box contain an opponent piece?
     * @param p
     * @return
     */
    public boolean isOccupiedByOpponentPiece(Piece p)
    {
        if(occupied==false)
            return false;

        Piece occupyingPiece = getOccupyingPiece();
        if(occupyingPiece.getColor()!= p.getColor())
            return true;

        return false;
    }

    /**
     * Returns a game-board character for index File Number
     * @param f
     * @return
     */
    public static char convertFileNumber(int f)
    {
        //add the ASCII value of 'a' to get the index character
        return (char)(f+97);
    }

    /**
     * Returns game-board Ranknumber for index Rank number
     * @param r
     * @return
     */
    public static int convertRankNumber(int r)
    {
        return (r+1);
    }

    /**
     * Converts File game-character to File index number
     * @param f
     * @return
     */
    public static int convertFileCharacter(char f)
    {
        //subtract the ASCII value of 'a' to get the index number
        return (f - 'a');
    }

    /**
     * Converts Rank game-board character to Rank index number
     * @param r
     * @return
     */
    public static int convertRankCharacter(char r)
    {
        return (r - '1');
    }


    //---------Getter methods----------

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public String getColor() {
        return color;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Piece getOccupyingPiece()
    {
        return occupyingPiece;
    }
}
