package components.piece;

import components.ChessBoard;
import components.ChessBox;

import java.util.ArrayList;

/**
 * Inherits from Piece and implements unique functions for the Bishops
 * Created by an5ra on 9/10/2015.
 */
public class Bishop extends Piece
{
    public Bishop(String color, ChessBox setPosition)
    {
        super("Bishop", color, setPosition);
    }

    public ArrayList<ChessBox> getPossibleMoves(ChessBoard chessBoard)
    {
        ArrayList<ChessBox> possibleMoves = new ArrayList<ChessBox>();

        //trying along the right diagonal
        for(int i = 0; i<8;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, i, i);//upright
            addToPossibleMoves(chessBoard, possibleMoves, -i, -i);//downleft
        }
        //trying along the left diagonal
        for(int i = 0; i<8;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, i, -i);//upleft
            addToPossibleMoves(chessBoard, possibleMoves, -i, i);//downright
        }

        return possibleMoves;
    }

}
