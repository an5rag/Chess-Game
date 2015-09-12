package boardSetUp;

import components.*;
import components.piece.*;

/**
 * Created by an5ra on 9/8/2015.
 */
public class SetBoard {

    ChessBoard chessBoard;

    public SetBoard(ChessBoard chessBoard)
    {
        this.chessBoard = chessBoard;
        for(int i = 0; i<chessBoard.getNumberOfFiles();i++)
            for(int j = 0; j<chessBoard.getNumberOfRanks();j++)
            {   String color;
                if(i%2==0) {
                    if (j % 2 == 0)
                        color = "black";
                    else
                        color = "white";
                }
                else
                    if(j%2==0)
                        color= "white";
                    else
                        color="black";

                ChessBox chessBox = new ChessBox(i,j,color);
                chessBoard.boxes[i][j] = chessBox;
            }
        setPieces();

    }

    public SetBoard(ChessBoard chessBoard, GameState toLoadGameState)
    {

    }

    public void setPieces()
    {
        Piece pieceToPut;
        ChessBox boxToPutIn;
        //Setting black pawns
        for(int i = 6,j=0; j<chessBoard.getNumberOfRanks();j++)
        {
            boxToPutIn = chessBoard.boxes[i][j];
            pieceToPut = new Pawn("black", chessBoard.boxes[i][j]);

        }

        //Setting white pawns
        for(int i = 1,j=0; j<chessBoard.getNumberOfRanks();j++)
        {
            boxToPutIn = chessBoard.boxes[i][j];
            pieceToPut = new Pawn("white", boxToPutIn);

        }

        //Setting black rooks
        boxToPutIn = chessBoard.boxes[7][0];
        pieceToPut = new Rook("black", boxToPutIn);


        boxToPutIn = chessBoard.boxes[7][7];
        pieceToPut = new Rook("black", boxToPutIn);


        //Setting white rooks
        boxToPutIn = chessBoard.boxes[0][0];
        pieceToPut = new Rook("white", boxToPutIn);


        boxToPutIn = chessBoard.boxes[0][7];
        pieceToPut = new Rook("white", boxToPutIn);


        //Setting black bishops
        boxToPutIn = chessBoard.boxes[7][2];
        pieceToPut = new Bishop("black", boxToPutIn);


        boxToPutIn = chessBoard.boxes[7][5];
        pieceToPut = new Bishop("black", boxToPutIn);


        //Setting white bishops
        boxToPutIn = chessBoard.boxes[0][2];
        pieceToPut = new Bishop("white", boxToPutIn);


        boxToPutIn = chessBoard.boxes[0][5];
        pieceToPut = new Bishop("white", boxToPutIn);

        //Setting black knights
        boxToPutIn = chessBoard.boxes[7][1];
        pieceToPut = new Knight("black", boxToPutIn);


        boxToPutIn = chessBoard.boxes[7][6];
        pieceToPut = new Knight("black", boxToPutIn);


        //Setting white knights
        boxToPutIn = chessBoard.boxes[0][1];
        pieceToPut = new Knight("white", boxToPutIn);


        boxToPutIn = chessBoard.boxes[0][6];
        pieceToPut = new Knight("white", boxToPutIn);

        //Setting black queen
        boxToPutIn = chessBoard.boxes[7][4];
        pieceToPut = new Queen("black", boxToPutIn);


        //Setting white queen
        boxToPutIn = chessBoard.boxes[0][4];
        pieceToPut = new Queen("white", boxToPutIn);

        //Setting black king
        boxToPutIn = chessBoard.boxes[7][3];
        pieceToPut = new King("black", boxToPutIn);


        //Setting white king
        boxToPutIn = chessBoard.boxes[0][3];
        pieceToPut = new King("white", boxToPutIn);




    }
}
