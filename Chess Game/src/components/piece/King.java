package components.piece;

import components.ChessBoard;
import components.ChessBox;

import java.util.ArrayList;

/**
 * Inherits from Piece and implements unique functions for the King
 * Created by an5ra on 9/10/2015.
 */
public class King extends Piece
{
    /**
     * Constructor
     * @param color
     * @param setPosition
     */
    public King(String color, ChessBox setPosition)
    {
        super("King", color, setPosition);
    }

    public ArrayList<ChessBox> getPossibleMoves(ChessBoard chessBoard)
    {
        ArrayList<ChessBox> possibleMoves = new ArrayList<ChessBox>();
        addToPossibleMoves(chessBoard,possibleMoves,1,0);//up
        addToPossibleMoves(chessBoard,possibleMoves,-1,0);//down
        addToPossibleMoves(chessBoard,possibleMoves,0,1);//right
        addToPossibleMoves(chessBoard,possibleMoves,0,-1);//left
        addToPossibleMoves(chessBoard,possibleMoves,1,1);//upright
        addToPossibleMoves(chessBoard,possibleMoves,1,-1);//upleft
        addToPossibleMoves(chessBoard,possibleMoves,-1,-1);//downleft
        addToPossibleMoves(chessBoard, possibleMoves, -1, 1);//downright
        return possibleMoves;
    }

    /**
     * if any of the opponent can kill the king, the king is in CHECK!
     *
     * @param chessBoard
     * @return
     */
    public boolean isCheck(ChessBoard chessBoard)
    {

        ArrayList<Piece> opponents = getAliveOpponentPieces(chessBoard);
        for(Piece opponent: opponents)
        {
            //System.out.println("Checking opponent: " + opponent);
            ArrayList<ChessBox> boxes = opponent.getPossibleMoves(chessBoard);
            for(ChessBox dangerBox: boxes)
            {
                if(currentPosition.equals(dangerBox))
                {
                    return true;
                }

            }
        }
        return false;

    }
}
