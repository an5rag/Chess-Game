package components;

/**
 * Created by an5ra on 9/10/2015.
 */
public class Bishop extends Piece
{
    public Bishop(String color, ChessBox setPosition)
    {
        super("Bishop", color, setPosition);
    }
    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        int fileDifference = destinationChessBox.getFile() - currentPosition.getFile();
        int rankDifference = destinationChessBox.getRank() - currentPosition.getRank();
        boolean possible = true;

        if(Math.abs(fileDifference) == Math.abs(rankDifference))
        {
            int direction = 0;

            if (fileDifference > 0)                  //going right
            {
                if (rankDifference > 0)
                    direction = 1;                  //going up-right
                else
                    direction = 2;                  //going down-right
            }
            else                                  //going left
            {
                if (rankDifference > 0)
                    direction = 3;                  //going up-left
                else
                    direction = 4;                  //going down-left
            }

            //initializing counter variables for loop in switch
            int i = currentPosition.getFile();
            int j = currentPosition.getRank();

            for(;i<destinationChessBox.getFile() && j<destinationChessBox.getRank();)
            {
                //moving according to direction
                switch (direction)
                {
                    case 1:
                        i++;
                        j++;
                        break;
                    case 2:
                        i++;
                        j--;
                        break;
                    case 3:
                        i--;
                        j++;
                        break;
                    case 4:
                        i--;
                        j--;
                        break;
                }
                if(chessBoard.boxes[currentPosition.getFile()][i].occupied)
                {
                    possible = false;
                    break;
                }
            }
        }
        return possible;
    }
    //not-implemented
    public ChessBox[] getPossibleMoves(Piece selectedPiece)
    {
        return null;
    }
}
