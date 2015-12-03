package components;

import components.piece.King;
import components.piece.Piece;

import java.util.ArrayList;

/**
 * This class represents the entire Chess Board and it's methods
 * It can be modified to represent different board sizes
 * and to accomodate different pieces
 * Created by an5ra on 9/8/2015.
 */
public class ChessBoard {


    int numberOfPieces = 32;
    int numberOfFiles = 8;
    int numberOfRanks = 8;
    public ArrayList<Piece> allPieces;

    public King blackKing;
    public King whiteKing;

    public ChessBox boxes[][];

    //For Undo
    public Piece lastDestinationPiece;
    public Piece lastSourcePiece;
    public ChessBox lastSourceBox;
    public ChessBox lastDestinationBox;

    public ChessBoard()
    {
        allPieces = new ArrayList<Piece>();
        boxes = new ChessBox[numberOfRanks][numberOfFiles];

    }

    public void undo()
    {
        if(lastDestinationPiece!=null)
        {
            lastDestinationPiece.revive();
        }

        lastSourcePiece.setCurrentPosition(lastSourceBox);
        lastDestinationBox.removeCurrentPiece();
        lastSourceBox.addPiece(lastSourcePiece);
    }

    /**
     * Used to display the board on the CONSOLE
     */
    public void displayBoard()
    {
        for(int i = numberOfRanks-1; i>=0; i--)
        {
            for(int j =0; j<numberOfFiles; j++)
            {
                System.out.print("| ");
                if(!boxes[i][j].occupied)
                    System.out.print(boxes[i][j] + boxes[i][j].getColor());
                else
                    System.out.print(boxes[i][j].getOccupyingPiece());
                System.out.print(" |\t");
            }
            System.out.println();
        }


    }

    ///--------Getter methods--------///

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public int getNumberOfFiles() {
        return numberOfFiles;
    }

    public int getNumberOfRanks() {
        return numberOfRanks;
    }

    public ChessBox[][] getBoxes() {
        return boxes;
    }

    public void setBoxes(ChessBox[][] boxes) {
        this.boxes = boxes;
    }

    public ArrayList<Piece> getAllPieces() {
        return allPieces;
    }

    public void setAllPieces(ArrayList<Piece> allPieces) {
        this.allPieces = allPieces;
    }

    public King getBlackKing() {
        return blackKing;
    }

    public void setBlackKing(King blackKing) {
        this.blackKing = blackKing;
    }

    public King getWhiteKing() {
        return whiteKing;
    }

    public void setWhiteKing(King whiteKing) {
        this.whiteKing = whiteKing;
    }
}
