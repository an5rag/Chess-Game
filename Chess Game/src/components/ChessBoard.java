package components;

import components.piece.Piece;

/**
 * Created by an5ra on 9/8/2015.
 */
public class ChessBoard {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


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
//        System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
        for(int i = numberOfFiles-1; i>=0; i--)
        {
            for(int j =0; j<numberOfRanks; j++)
            {
                System.out.print("| ");
                if(!boxes[i][j].occupied)
                    System.out.print(boxes[i][j].toString());
                else
                    System.out.print(boxes[i][j].getOccupyingPiece() );
                System.out.print(" |\t");
            }
            System.out.println();
        }


    }

    //--------Getter methods--------

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
