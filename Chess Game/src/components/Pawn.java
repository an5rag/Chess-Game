package components;

/**
 * Created by an5ra on 9/10/2015.
 */
public class Pawn extends Piece
{
    //boolean hasEverMoved;
    public Pawn(String color, ChessBox setPosition)
    {

        super("Pawn", color, setPosition);
    }

    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        int fileDifference = destinationChessBox.getFile() - currentPosition.getFile();
        int rankDifference = destinationChessBox.getRank() - currentPosition.getRank();

        //hard-coding initial moves
        if (color.equals("black"))
        {
//            if(currentPosition.getFile())
        }
        else //white pawn
        {

        }

        return false;


    }
    //not-implemented
    public ChessBox[] getPossibleMoves(Piece selectedPiece)
    {
        return null;
    }
}
