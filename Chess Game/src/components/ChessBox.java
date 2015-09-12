package components;

import components.piece.Piece;

/**
 * Represents a single functional ChessBox on the Board
 * Created by an5ra on 9/7/2015.
 */
public class ChessBox {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

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
    public ChessBox (int file, int rank, String color)
    {
        this.file = file;
        this.rank = rank;
        this.color = color;
        occupied = false;
        occupyingPiece = null;
    }

    @Override
    public String toString()
    {   if(color.equals("black"))
        return String.format(ANSI_GREEN+ convertFileNumber(rank) + "" + convertRankNumber(file) + ANSI_RESET);
        return String.format( convertFileNumber(rank) + "" + convertRankNumber(file));

    }

    /**
     * Returns a real-life character for index File Number
     * @param f
     * @return
     */
    public static char convertFileNumber(int f)
    {
        //add the ASCII value of 'a' to get the index character
        return (char)(f+97);
    }

    /**
     *
     * @param r
     * @return
     */
    public static int convertRankNumber(int r)
    {
        return (r+1);
    }

    /**
     *
     * @param f
     * @return
     */
    public static int convertFileCharacter(char f)
    {
        //subtract the ASCII value of 'a' to get the index number
        int x =f;
//        System.out.println("Inside converRank: " + x);
        return (f - 'a');
    }

    /**
     *
     * @param r
     * @return
     */
    public static int convertRankCharacter(char r)
    {
        int x =r;
//        System.out.println("Inside converRank: " + x);
        //subtract the ASCII value of 'a' to get the index number
        return (r - '1');
    }



    public void addPiece(Piece toAddPiece)
    {
        assert occupyingPiece == null: "This box already has a piece in it";
        occupyingPiece=toAddPiece;
        occupied = true;
    }

    public Piece removeCurrentPiece()
    {
        Piece toReturnPiece = occupyingPiece;
        occupied = false;
        occupyingPiece = null;
        return toReturnPiece;
    }

    /**
     * Does this box contain Piece p's own piece?
     * @param p
     * @return
     */
    public boolean isOccupiedByOwnPiece(Piece p)
    {
        if(occupied==false)
            return false;

        Piece occupyingPiece = getOccupyingPiece();
        if(occupyingPiece.getColor()== p.getColor())
            return true;

        return false;
    }

    /**
     *
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
