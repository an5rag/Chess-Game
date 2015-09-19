package components.piece;

import components.ChessBoard;
import components.ChessBox;

import java.util.ArrayList;

/**
 * Created by an5ra on 9/18/2015.
 */
public class Unicorn extends Piece {

    public Unicorn(String color, ChessBox setPosition)
    {
        super("Unicorn", color, setPosition);
    }

    public ArrayList<ChessBox> getPossibleMoves(ChessBoard chessBoard)
    {
        ArrayList<ChessBox> possibleMoves = new ArrayList<ChessBox>();
        int currentRank = getCurrentPosition().getRank();
        int currentFile = getCurrentPosition().getFile();

        ///---------------------BISHOP MOVES---------------------------

        //-----------------trying along the right diagonal------------------

        //trying RIGHT UP
        for(int i = 1; (currentFile+i)< chessBoard.getNumberOfFiles() && (currentRank+i)< chessBoard.getNumberOfRanks();i++) {
            addToPossibleMoves(chessBoard, possibleMoves, i, i);//right-up
            if(chessBoard.boxes[currentRank+1][currentFile+i].isOccupied())
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

        ///--------------------KING MOVES--------------------


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
