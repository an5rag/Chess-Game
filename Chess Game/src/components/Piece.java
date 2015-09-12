package components;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by an5ra on 9/7/2015.
 */
abstract public class Piece {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    String name;
    String color;
    boolean alive;
    ChessBox currentPosition;
    //Image piecePicture;
    Piece wasKilledBy;
    ArrayList<Piece> piecesKilled = new ArrayList<Piece>();

    public Piece(String name, String color, ChessBox setPosition)
    {
        this.name = name;
        this.color = color;
        currentPosition = setPosition;
        setPosition.add_piece(this);
        //piece_picture = Image.getDefaultPicture();
        alive = true;
    }

    @Override
    public String toString()
    {
        if(color.equals("black"))
          return String.format(ANSI_RED + name.charAt(0) +""+ name.charAt(name.length()-1) + ANSI_RESET);
          return String.format(ANSI_YELLOW+ name.charAt(0) +""+ name.charAt(name.length()-1)+ ANSI_RESET);
//        return String.format(color + " " + name + " at " + currentPosition.toString());
    }

    public void movePiece(ChessBox destinationChessBox)
    {
        currentPosition = destinationChessBox;
        destinationChessBox.add_piece(this);
    }

    abstract public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox);

    abstract public ChessBox[] getPossibleMoves(Piece selectedPiece);

    public String getName() {
        return name;
    }

    //--------Getter methods--------

    public String getColor() {
        return color;
    }

    public boolean isAlive() {
        return alive;
    }

    public ChessBox getCurrentPosition() {
        return currentPosition;
    }

    public Piece getWasKilledBy() {
        return wasKilledBy;
    }

    public List<Piece> getPiecesKilled() {
        return piecesKilled;
    }
}

