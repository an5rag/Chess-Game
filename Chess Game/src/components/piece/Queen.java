package components.piece;

import components.ChessBoard;
import components.ChessBox;

import java.util.ArrayList;

/**
 * Created by an5ra on 9/10/2015.
 */
public class Queen extends Piece
{
    public Queen(String color, ChessBox setPosition)
    {
        super("Queen", color, setPosition);
    }

    public ArrayList<ChessBox> getPossibleMoves(ChessBoard chessBoard)
    {
        ArrayList<ChessBox> possibleMoves = new ArrayList<ChessBox>();



        //--------------------BISHOP FUNCTIONS-----------
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

        //-------------------ROOK FUNCTIONS----------------
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
