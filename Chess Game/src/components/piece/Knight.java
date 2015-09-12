package components.piece;

import components.ChessBoard;
import components.ChessBox;

import java.util.ArrayList;

/**
 * Inherits from Piece and implements unique functions for the Kinghts
 * Created by an5ra on 9/10/2015.
 */
public class Knight extends Piece
{
    /**
     * Constructor
     * @param color
     * @param setPosition
     */
    public Knight(String color, ChessBox setPosition)
    {
        super("Knight", color, setPosition);
    }

    public ArrayList<ChessBox> getPossibleMoves(ChessBoard chessBoard)
    {
        ArrayList<ChessBox> possibleMoves = new ArrayList<ChessBox>();
        addToPossibleMoves(chessBoard,possibleMoves,2,1);//upright
        addToPossibleMoves(chessBoard,possibleMoves,2,-1);//upleft
        addToPossibleMoves(chessBoard,possibleMoves,1,2);//uprightright
        addToPossibleMoves(chessBoard,possibleMoves,1,-2);//upleftleft
        addToPossibleMoves(chessBoard,possibleMoves,-2,1);//downright
        addToPossibleMoves(chessBoard,possibleMoves,-2,-1);//downright
        addToPossibleMoves(chessBoard,possibleMoves,-1,-2);//downleftleft
        addToPossibleMoves(chessBoard,possibleMoves,-1,2);//downrightright
        return possibleMoves;
    }
}
