package core;

/**
 * Created by an5ra on 9/7/2015.
 */
public class ChessBox {

    char file;
    int rank;
    char color;
    Piece occupyingPiece;
    boolean occupied;

    public ChessBox (char file, int rank, char color)
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
        return String.format(color + " box: " + file + rank);
    }

    public static int getFileNumber(char f)
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
}
