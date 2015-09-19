package core;

import components.ChessBoard;
import components.ChessBox;
import components.piece.Piece;

/**
 * The class is used to facilitate movement of allPieces across the chess board
 * Created by an5ra on 9/8/2015.
 */
public class Move {

    ChessBoard chessBoard;
    public Move(ChessBoard chessBoard)
    {
        this.chessBoard = chessBoard;
    }

    /**
     * Used to parse the inputted string from the CONSOLE
     * @param move
     * @return
     */
    public int[] parseMoveString(String move)
    {

        int toReturn[] = new int[4];
        int startFile = ChessBox.convertFileCharacter(move.charAt(0));
        int startRank = ChessBox.convertRankCharacter(move.charAt(1));
        int endFile = ChessBox.convertFileCharacter(move.charAt(3));
        int endRank = ChessBox.convertRankCharacter(move.charAt(4));
        toReturn[0]=startFile;
        toReturn[1] = startRank;
        toReturn[2] = endFile;
        toReturn[3] = endRank;
        return toReturn;
    }

    /**
     * Carries out the movement according to the inputted string from CONSOLE
     * @param moveString
     */
    public void move(String moveString)
    {
        int parsedMove[] = parseMoveString(moveString);

        ChessBox sourceBox = chessBoard.boxes[parsedMove[1]][parsedMove[0]];
        ChessBox destinationBox = chessBoard.boxes[parsedMove[3]][parsedMove[2]];

        //Piece lifted from box
        Piece p =sourceBox.removeCurrentPiece();
//        assert p!=null;

        //only moves the allPieces once its deemed valid
        if(p.checkMoveValidity(chessBoard,destinationBox))
        {
            p.movePiece(destinationBox);
        }
        else {
            //Piece added back to box
            sourceBox.addPiece(p);
            System.out.println("Invalid move!");
        }
    }

    /**
     * Establishes a move of the piece in sourceBox to the destinationBox
     * Only moves if allowed
     * @param sourceBox
     * @param destinationBox
     */
    public void move(ChessBox sourceBox, ChessBox destinationBox)
    {
        //Piece lifted from box
        Piece p =sourceBox.removeCurrentPiece();
//        assert p!=null;

        //only moves the allPieces once its deemed valid
        if(p.checkMoveValidity(chessBoard,destinationBox))
        {
            p.movePiece(destinationBox);
        }
        else {
            //Piece added back to box
            sourceBox.addPiece(p);
            System.out.println("Invalid move!");
        }
    }


}
