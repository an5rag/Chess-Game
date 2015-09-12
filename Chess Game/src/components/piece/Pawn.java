package components.piece;

import components.ChessBoard;
import components.ChessBox;

import java.util.ArrayList;

/**
 * Inherits from Piece and implements unique functions for the Pawns
 * Created by an5ra on 9/10/2015.
 */
public class Pawn extends Piece
{
    //boolean hasEverMoved;
    public Pawn(String color, ChessBox setPosition)
    {

        super("Pawn", color, setPosition);
    }

    public ArrayList<ChessBox> getPossibleMoves(ChessBoard chessBoard)
    {
        ArrayList<ChessBox> possibleMoves = new ArrayList<ChessBox>();
        //------------------IF THE PAWN IS BLACK------------------
        if(color.equals("black"))
        {
            if(!chessBoard.boxes[currentPosition.getFile()][currentPosition.getRank()-1].isOccupied())
            addToPossibleMoves(chessBoard,possibleMoves,0,-1);//down
            if(currentPosition.getFile()==6)
                addToPossibleMoves(chessBoard,possibleMoves,0,-2);//two-steps down
            try
            {
                if(chessBoard.boxes[currentPosition.getRank()-1][currentPosition.getFile()-1].isOccupiedByOpponentPiece(this))
                {
                    addToPossibleMoves(chessBoard,possibleMoves,-1,-1);
                }
            }
            catch(ArrayIndexOutOfBoundsException e){}
            try
            {
                if(chessBoard.boxes[currentPosition.getRank()+1][currentPosition.getFile()-1].isOccupiedByOpponentPiece(this))
                {
                    addToPossibleMoves(chessBoard,possibleMoves,+1,-1);
                }
            }
            catch(ArrayIndexOutOfBoundsException e){}
        }
        //-----------------IF THE PAWN IS WHITE---------------
        else {
            if(!chessBoard.boxes[currentPosition.getFile()][currentPosition.getRank()+1].isOccupied())
            addToPossibleMoves(chessBoard,possibleMoves,0,1);//up
            if(currentPosition.getFile()==1)
                addToPossibleMoves(chessBoard,possibleMoves,0,2);//two-steps up
            try{
                if(chessBoard.boxes[currentPosition.getRank()-1][currentPosition.getFile()+1].isOccupiedByOpponentPiece(this))
                {
                    addToPossibleMoves(chessBoard,possibleMoves,-1,+1);
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {}
            try{
                if(chessBoard.boxes[currentPosition.getRank()+1][currentPosition.getFile()+1].isOccupiedByOpponentPiece(this))
                {
                    addToPossibleMoves(chessBoard,possibleMoves,+1,+1);
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {}
        }


        return possibleMoves;
    }
}
