package core;

/**
 * Created by an5ra on 9/7/2015.
 */
public class ChessBox {

    int file;
    int rank;
    String color;
    Piece occupyingPiece;
    boolean occupied;

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
    {
        return String.format(convertFileNumber(rank) + "" + file);
    }

    public static char convertFileNumber(int f)
    {
        //add the ASCII value of 'a' to get the index character
        return (char)(f+97);
    }

    public static int convertFileCharacter(char f)
    {
        //subtract the ASCII value of 'a' to get the index number
        return ((int)f - 97);
    }

    public Piece getOccupyingPiece()
    {
        return occupyingPiece;
    }

    public void add_piece(Piece toAddPiece)
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
}
