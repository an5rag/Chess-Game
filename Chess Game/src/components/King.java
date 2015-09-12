package components;

/**
 * Created by an5ra on 9/10/2015.
 */
public class King extends Piece
{
    public King(String color, ChessBox setPosition)
    {
        super("King", color, setPosition);
    }
    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        int fileDifference = destinationChessBox.getFile() - currentPosition.getFile();
        int rankDifference = destinationChessBox.getRank() - currentPosition.getRank();

        //checks if one of the rank or file difference is maximum one (either both or exactly one)
        if(Math.abs(fileDifference)==1 && destinationChessBox.getRank()==currentPosition.getRank())
            return true;
        else if(Math.abs(rankDifference)==1 && destinationChessBox.getFile()==currentPosition.getFile())
            return true;
        else if(Math.abs(fileDifference)==1 && Math.abs(rankDifference)==1)
            return true;

        //comes here if none of the above conditions are true
        return false;
    }
    //not-implemented
    public ChessBox[] getPossibleMoves(Piece selectedPiece)
    {
        return null;
    }
}
