package components;

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

    public ChessBox boxes[][];

    public ChessBoard()
    {
        allPieces = new ArrayList<Piece>();
        boxes = new ChessBox[numberOfRanks][numberOfFiles];

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
                    System.out.print(boxes[i][j]);
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
}
