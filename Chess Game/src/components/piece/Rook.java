package components.piece;

import components.ChessBoard;
import components.ChessBox;

import java.util.ArrayList;

/**
 * Inherits from Piece and implements unique functions for the Rooks
 * Created by an5ra on 9/10/2015.
 */
public class Rook extends Piece
{
    public Rook(String color, ChessBox setPosition)
    {
        super("Rook", color, setPosition);
    }

    public ArrayList<ChessBox> getPossibleMoves(ChessBoard chessBoard)
    {
        ArrayList<ChessBox> possibleMoves = new ArrayList<ChessBox>();

        //trying along the same rank
        for(int i = 0; i<8;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, 0, i);//right
            addToPossibleMoves(chessBoard, possibleMoves, 0, -i);//left
        }
        //trying along the same file
        for(int i = 0; i<8;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, i, 0);//right
            addToPossibleMoves(chessBoard, possibleMoves, -i, 0);//left
        }

        return possibleMoves;
    }
}
