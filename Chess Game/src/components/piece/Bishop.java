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
        int currentRank = getCurrentPosition().getRank();
        int currentFile = getCurrentPosition().getFile();

        //-----------------trying along the right diagonal------------------

        //trying RIGHT UP
        for(int i = 1; (currentFile+i)< chessBoard.getNumberOfFiles() && (currentRank+i)< chessBoard.getNumberOfRanks();i++) {
            addToPossibleMoves(chessBoard, possibleMoves, i, i);//right-up
            if(chessBoard.boxes[currentRank+i][currentFile+i].isOccupied())
                break;

        }

        //trying LEFT DOWN
        for(int i = 1; (currentFile-i)>=0&& (currentRank-i)>=0;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, -i, -i);//left-down
            if(chessBoard.boxes[currentRank-i][currentFile-i].isOccupied())
                break;

        }

        //-----------------trying along the left diagonal------------------

        //trying UP LEFT
        for(int i = 1; (currentRank+i)<chessBoard.getNumberOfRanks() && (currentFile-i)>=0;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, i, -i);//left-up
            if(chessBoard.boxes[currentRank+i][currentFile-i].isOccupied())
                break;

        }

        //trying DOWN RIGHT
        for(int i = 1; (currentRank-i)>=0 &&(currentFile+i)<chessBoard.getNumberOfFiles();i++) {
            addToPossibleMoves(chessBoard, possibleMoves, -i, i);//right-down
            if(chessBoard.boxes[currentRank-i][currentFile+i].isOccupied())
                break;

        }
        return possibleMoves;
    }

}
