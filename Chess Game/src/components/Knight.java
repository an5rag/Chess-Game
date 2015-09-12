package components;

/**
 * Created by an5ra on 9/10/2015.
 */
public class Knight extends Piece
{
    public Knight(String color, ChessBox setPosition)
    {
        super("Knight", color, setPosition);
    }
    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        int fileDifference = destinationChessBox.getFile() - currentPosition.getFile();
        int rankDifference = destinationChessBox.getRank() - currentPosition.getRank();

        //checks if one of the rank or file difference is maximum one (either both or exactly one)
        if(Math.abs(fileDifference)==1 && Math.abs(rankDifference)==2 )
            return true;
        else if(Math.abs(fileDifference)==2 && Math.abs(rankDifference)==1)
            return true;
        else
            return false;
    }
    //not-implemented
    public ChessBox[] getPossibleMoves(Piece selectedPiece)
    {
        return null;
    }
}
