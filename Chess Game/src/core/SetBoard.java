package core;

import boardSetUp.GameState;
import core.*;

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
                        color = "white";
                    else
                        color = "black";
                }
                else
                    if(j%2==0)
                        color= "black";
                    else
                        color="white";

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
        for(int i = 1,j=0; j<chessBoard.getNumberOfRanks();j++)
        {
            Piece p = new Pawn("black", chessBoard.boxes[i][j]);
            chessBoard.boxes[i][j].add_piece(p);
        }
    }
}
