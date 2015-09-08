package core;

import java.util.List;

/**
 * Created by an5ra on 9/7/2015.
 */
abstract public class Piece {
    String name;
    String color;
    boolean aliveOrNot;
    ChessBox currentPosition;
    //Image piecePicture;
    Piece wasKilledBy;
    List<Piece> piecesKilled;

    public Piece(String name, String color, ChessBox setPosition)
    {
        this.name = name;
        this.color = color;
        currentPosition = setPosition;
        //piece_picture = Image.getDefaultPicture();
        aliveOrNot = true;
    }

    @Override
    public String toString()
    {
        return String.format(color + " " +name + " at " + currentPosition.toString());
    }

    abstract public boolean checkMoveValidity(ChessBox destinationChessBox);

    abstract public ChessBox[] getPossibleMoves(Piece selectedPiece);
}


