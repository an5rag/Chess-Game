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

        int currentRank = getCurrentPosition().getRank();
        int currentFile = getCurrentPosition().getFile();

        //--------------------BISHOP FUNCTIONS-----------
        //-----------------trying along the right diagonal------------------

        //trying RIGHT UP
        for(int i = 1; (currentFile+i)<8 && (currentRank+i)<8;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, i, i);//right-up
            if(chessBoard.boxes[currentRank+i][currentFile+i].isOccupied()) {
                break;
            }
        }

        //trying LEFT DOWN
        for(int i = 1; (currentFile-i)>=0&& (currentRank-i)>=0;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, -i, -i);//left-down
            if(chessBoard.boxes[currentRank-i][currentFile-i].isOccupied())
                break;

        }

        //-----------------trying along the left diagonal------------------

        //trying UP LEFT
        for(int i = 1; (currentRank+i)<8 && (currentFile-i)>=0;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, i, -i);//left-up
            if(chessBoard.boxes[currentRank+i][currentFile-i].isOccupied())
                break;

        }

        //trying DOWN RIGHT
        for(int i = 1; (currentRank-i)>=0 &&(currentFile+i)<8;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, -i, i);//right-down
            if(chessBoard.boxes[currentRank-i][currentFile+i].isOccupied())
                break;

        }

        //-------------------ROOK FUNCTIONS----------------
        //-----------------trying along the same rank - thus rankDifference is 0------------------

        //trying RIGHT
        for(int i = 1; (currentFile+i)<8;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, 0, i);//right
            if(chessBoard.boxes[currentRank][currentFile+i].isOccupied())
                break;

        }

        //trying LEFT
        for(int i = 1; (currentFile-i)>=0;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, 0, -i);//left
            if(chessBoard.boxes[currentRank][currentFile-i].isOccupied())
                break;

        }

        //-----------------trying along the same file - thus fileDifference is 0------------------

        //trying UP
        for(int i = 1; (currentRank+i)<8;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, i, 0);//up
            if(chessBoard.boxes[currentRank+i][currentFile].isOccupied())
                break;

        }

        //trying DOWN
        for(int i = 1; (currentRank-i)>=0;i++) {
            addToPossibleMoves(chessBoard, possibleMoves, -i, 0);//left
            if(chessBoard.boxes[currentRank-i][currentFile].isOccupied())
                break;

        }


        return possibleMoves;
    }
}
