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
    int direction;
    int startRank;
    //boolean hasEverMoved;
    public Pawn(String color, ChessBox setPosition)
    {

        super("Pawn", color, setPosition);
        if(color.equalsIgnoreCase("black"))
            direction = -1;
        else
            direction = 1;

        startRank = setPosition.getRank();
    }

    public ArrayList<ChessBox> getPossibleMoves(ChessBoard chessBoard)
    {
        ArrayList<ChessBox> possibleMoves = new ArrayList<ChessBox>();
        int currentFile = currentPosition.getFile();
        int currentRank = currentPosition.getRank();

        //checking diagonal kills
        //LEFT<<<<<<<<<<<<<
        try
            {
                if(chessBoard.boxes[currentRank+direction][currentFile-1].isOccupiedByOpponentPiece(this))
                {
                    addToPossibleMoves(chessBoard,possibleMoves,direction,-1);
                }

            }
        catch(ArrayIndexOutOfBoundsException e) {//silently ignore
        }
        //RIGHT>>>>>>>>>>>>
        try
        {
            if(chessBoard.boxes[currentRank+direction][currentFile+1].isOccupiedByOpponentPiece(this))
            {
                addToPossibleMoves(chessBoard,possibleMoves,direction,1);
            }

        }
        catch(ArrayIndexOutOfBoundsException e) {//silently ignore
        }

        //checking two-step jump in the start
        try
        {
            if(!chessBoard.boxes[currentRank+2*direction][currentFile].isOccupied())
            {
                if(currentRank == startRank)
                addToPossibleMoves(chessBoard,possibleMoves,direction*2,0);
            }

        }
        catch(ArrayIndexOutOfBoundsException e) {//silently ignore
        }

        //checking normal one-step
        try
        {
            if(!chessBoard.boxes[currentRank+direction][currentFile].isOccupied())
            {
                    addToPossibleMoves(chessBoard,possibleMoves,direction,0);
            }

        }
        catch(ArrayIndexOutOfBoundsException e) {//silently ignore
        }

        return possibleMoves;
    }
}