package components;

/**
 * Created by an5ra on 9/10/2015.
 */
public class Queen extends Piece
{
    public Queen(String color, ChessBox setPosition)
    {
        super("Queen", color, setPosition);
    }
    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        Rook rook = new Rook(color, currentPosition);
        Bishop bishop = new Bishop(color,currentPosition);
        if(rook.checkMoveValidity(chessBoard, destinationChessBox) || bishop.checkMoveValidity(chessBoard, destinationChessBox))
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
