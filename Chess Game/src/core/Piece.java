package core;

import java.util.List;

/**
 * Created by an5ra on 9/7/2015.
 */
abstract public class Piece {
    String name;
    String color;
    boolean alive;
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
        alive = true;
    }

    @Override
    public String toString()
    {
          return String.format(name.charAt(0) +""+ name.charAt(name.length()-1));
//        return String.format(color + " " + name + " at " + currentPosition.toString());
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

class King extends Piece
{
    public King(String color, ChessBox setPosition)
    {
        super("King", color, setPosition);
    }
    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        int fileDifference = destinationChessBox.getFile() - currentPosition.getFile();
        int rankDifference = destinationChessBox.getRank() - currentPosition.getRank();

        //checks if one of the rank or file difference is maximum one (either both or exactly one)
        if(Math.abs(fileDifference)==1 && destinationChessBox.getRank()==currentPosition.getRank())
            return true;
        else if(Math.abs(rankDifference)==1 && destinationChessBox.getFile()==currentPosition.getFile())
            return true;
        else if(Math.abs(fileDifference)==1 && Math.abs(rankDifference)==1)
            return true;

        //comes here if none of the above conditions are true
        return false;
    }
    //not-implemented
    public ChessBox[] getPossibleMoves(Piece selectedPiece)
    {
        return null;
    }
}

class Rook extends Piece
{
    public Rook(String color, ChessBox setPosition)
    {
        super("Rook", color, setPosition);
    }
    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        boolean possible = true;
        int i;

        //if same rank
        if(destinationChessBox.getRank()==currentPosition.getRank())
            //loop to see if there is any piece in the path
            for(i= currentPosition.getFile(); i<= destinationChessBox.getFile(); i++)
                if(chessBoard.boxes[i][currentPosition.rank].occupied)
                {
                    possible = false;
                    break;
                }
        //if same file
        else if(destinationChessBox.getFile()==currentPosition.getFile())
            //loop to see if there is any piece in the path
            for(i= currentPosition.getRank(); i<= destinationChessBox.getRank(); i++)
                if(chessBoard.boxes[currentPosition.getFile()][i].occupied)
                {
                    possible = false;
                    break;
                }


        return possible;
    }
    //not-implemented
    public ChessBox[] getPossibleMoves(Piece selectedPiece)
    {
        return null;
    }
}

class Bishop extends Piece
{
    public Bishop(String color, ChessBox setPosition)
    {
        super("Bishop", color, setPosition);
    }
    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        int fileDifference = destinationChessBox.getFile() - currentPosition.getFile();
        int rankDifference = destinationChessBox.getRank() - currentPosition.getRank();
        boolean possible = true;

        if(Math.abs(fileDifference) == Math.abs(rankDifference))
        {
            int direction = 0;

            if (fileDifference > 0)                  //going right
            {
                if (rankDifference > 0)
                    direction = 1;                  //going up-right
                else
                    direction = 2;                  //going down-right
            }
            else                                  //going left
            {
                if (rankDifference > 0)
                    direction = 3;                  //going up-left
                else
                    direction = 4;                  //going down-left
            }

            //initializing counter variables for loop in switch
            int i = currentPosition.getFile();
            int j = currentPosition.getRank();

            for(;i<destinationChessBox.getFile() && j<destinationChessBox.getRank();)
            {
                //moving according to direction
                switch (direction)
                {
                    case 1:
                        i++;
                        j++;
                        break;
                    case 2:
                        i++;
                        j--;
                        break;
                    case 3:
                        i--;
                        j++;
                        break;
                    case 4:
                        i--;
                        j--;
                        break;
                }
                if(chessBoard.boxes[currentPosition.getFile()][i].occupied)
                {
                    possible = false;
                    break;
                }
            }
        }
        return possible;
    }
    //not-implemented
    public ChessBox[] getPossibleMoves(Piece selectedPiece)
    {
        return null;
    }
}

class Queen extends Piece
{
    public Queen(String color, ChessBox setPosition)
    {
        super("Queen", color, setPosition);
    }
    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        Rook rook = new Rook(color, currentPosition);
        Bishop bishop = new Bishop(color,currentPosition);
        if(rook.checkMoveValidity(chessBoard, destinationChessBox) || bishop.checkMoveValidity(chessBoard, destinationChessBox))
            return true;
        else
            return false;

    }
    //not-implemented
    public ChessBox[] getPossibleMoves(Piece selectedPiece)
    {
        return null;
    }
}

class Knight extends Piece
{
    public Knight(String color, ChessBox setPosition)
    {
        super("Knight", color, setPosition);
    }
    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        int fileDifference = destinationChessBox.getFile() - currentPosition.getFile();
        int rankDifference = destinationChessBox.getRank() - currentPosition.getRank();

        //checks if one of the rank or file difference is maximum one (either both or exactly one)
        if(Math.abs(fileDifference)==1 && Math.abs(rankDifference)==2 )
            return true;
        else if(Math.abs(fileDifference)==2 && Math.abs(rankDifference)==1)
            return true;
        else
            return false;
    }
    //not-implemented
    public ChessBox[] getPossibleMoves(Piece selectedPiece)
    {
        return null;
    }
}

class Pawn extends Piece
{
    //boolean hasEverMoved;
    public Pawn(String color, ChessBox setPosition)
    {

        super("Pawn", color, setPosition);
    }

    public boolean checkMoveValidity(ChessBoard chessBoard, ChessBox destinationChessBox)
    {
        int fileDifference = destinationChessBox.getFile() - currentPosition.getFile();
        int rankDifference = destinationChessBox.getRank() - currentPosition.getRank();

        if (color.equals("black"))
        {

        }
        else
        {

        }

        return false;


    }
    //not-implemented
    public ChessBox[] getPossibleMoves(Piece selectedPiece)
    {
        return null;
    }
}