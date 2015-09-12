package components;

/**
 * Created by an5ra on 9/10/2015.
 */
public class Rook extends Piece
{
    public Rook(String color, ChessBox setPosition)
    {
        super("Rook", color, setPosition);
    }
    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        boolean possible = true;
        int i;

        //if same rank
        if(destinationChessBox.getRank()==currentPosition.getRank())
            //loop to see if there is any piece in the path
            for(i= currentPosition.getFile(); i<= destinationChessBox.getFile(); i++)
                if(chessBoard.boxes[i][currentPosition.rank].occupied)
                {
                    possible = false;
                    break;
                }
        //if same file
        else if(destinationChessBox.getFile()==currentPosition.getFile())
            //loop to see if there is any piece in the path
            for(i= currentPosition.getRank(); i<= destinationChessBox.getRank(); i++)
                if(chessBoard.boxes[currentPosition.getFile()][i].occupied)
                {
                    possible = false;
                    break;
                }


        return possible;
    }
    //not-implemented
    public ChessBox[] getPossibleMoves(Piece selectedPiece)
    {
        return null;
    }
}
