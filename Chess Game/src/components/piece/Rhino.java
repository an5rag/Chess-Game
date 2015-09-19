package components.piece;

import components.ChessBoard;
import components.ChessBox;

import java.util.ArrayList;

/**
 * Created by an5ra on 9/18/2015.
 */
public class Rhino extends Piece {
    public Rhino(String color, ChessBox setPosition)
    {
        super("Rhino", color, setPosition);
    }

    public ArrayList<ChessBox> getPossibleMoves(ChessBoard chessBoard)
    {
        ArrayList<ChessBox> possibleMoves = new ArrayList<ChessBox>();
        int currentRank = getCurrentPosition().getRank();
        int currentFile = getCurrentPosition().getFile();

        ///-----------------ROOK MOVES--------------------///

        //-----------------trying along the same rank - thus rankDifference is 0------------------

        //trying RIGHT
        for(int i = 1; (currentFile+i)<chessBoard.getNumberOfFiles();i++) {
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
        for(int i = 1; (currentRank+i)<chessBoard.getNumberOfRanks();i++) {
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

        ///-----------------KING MOVES--------------------///

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
}
