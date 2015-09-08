package core;

/**
 * Created by an5ra on 9/8/2015.
 */
public class ChessBoard {

    int numberOfPieces = 32;
    int numberOfFiles = 8;
    int numberOfRanks = 8;
    public Piece pieces[];
    public ChessBox boxes[][];

    public ChessBoard()
    {
        pieces = new Piece[numberOfPieces];
        boxes = new ChessBox[numberOfFiles][numberOfRanks];

    }

    public void displayBoard()
    {
        for(int i = 0; i<numberOfFiles; i++)
        {
            for(int j =0; j<numberOfRanks; j++)
            {
                System.out.print("| ");
                if(!boxes[i][j].occupied)
                    System.out.print(boxes[i][j].toString());
                else
                    System.out.print(boxes[i][j].getOccupyingPiece().toString());
                System.out.print(" |\t");
            }
            System.out.println();
        }


    }

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
