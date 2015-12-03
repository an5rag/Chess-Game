package boardSetUp;
import components.*;
import components.piece.*;
import model.GameState;

/**
 * Sets the board and its Pieces (in hard-coded locations)
 * Created by an5ra on 9/8/2015.
 */
public class SetBoard {

    ChessBoard chessBoard;

    public SetBoard(ChessBoard chessBoard, boolean isSpecial)
    {
        this.chessBoard = chessBoard;
        setBoxes();
        //setPieces(isSpecial);


    }

    public void setBoxes()
    {
        for(int i = 0; i<chessBoard.getNumberOfRanks();i++)
            for(int j = 0; j<chessBoard.getNumberOfFiles();j++)
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
    }


    /**
     * Sets the Pieces in known locations
     * @param isSpecial
     */
    public void setPieces(boolean isSpecial)
    {
        Piece pieceToPut;
        ChessBox boxToPutIn;

        //Setting black pawns
        for(int i = 6,j=0; j<chessBoard.getNumberOfRanks();j++)
        {
            boxToPutIn = chessBoard.boxes[i][j];
            pieceToPut = new Pawn("black", chessBoard.boxes[i][j]);
            chessBoard.allPieces.add(pieceToPut);


        }

        //Setting white pawns
        for(int i = 1,j=0; j<chessBoard.getNumberOfRanks();j++)
        {
            boxToPutIn = chessBoard.boxes[i][j];
            pieceToPut = new Pawn("white", boxToPutIn);
            chessBoard.allPieces.add(pieceToPut);

        }

        //Setting black rooks
        boxToPutIn = chessBoard.boxes[7][0];
        pieceToPut = new Rook("black", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);


        boxToPutIn = chessBoard.boxes[7][7];
        pieceToPut = new Rook("black", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);


        //Setting white rooks
        boxToPutIn = chessBoard.boxes[0][0];
        pieceToPut = new Rhino("white", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);

        boxToPutIn = chessBoard.boxes[0][7];
        pieceToPut = new Rook("white", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);

        //Setting black bishops
        boxToPutIn = chessBoard.boxes[7][2];
        pieceToPut = new Bishop("black", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);

        boxToPutIn = chessBoard.boxes[7][5];
        pieceToPut = new Bishop("black", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);

        //Setting white bishops
        boxToPutIn = chessBoard.boxes[0][2];
        pieceToPut = new Bishop("white", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);

        boxToPutIn = chessBoard.boxes[0][5];
        pieceToPut = new Bishop("white", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);

        //Setting black knights
        boxToPutIn = chessBoard.boxes[7][1];
        pieceToPut = new Knight("black", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);

        boxToPutIn = chessBoard.boxes[7][6];
        pieceToPut = new Knight("black", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);

        //Setting white knights
        boxToPutIn = chessBoard.boxes[0][1];
        pieceToPut = new Knight("white", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);

        boxToPutIn = chessBoard.boxes[0][6];
        pieceToPut = new Knight("white", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);

        //Setting black queen
        boxToPutIn = chessBoard.boxes[7][4];
        pieceToPut = new Queen("black", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);


        //Setting white queen
        boxToPutIn = chessBoard.boxes[0][4];
        pieceToPut = new Queen("white", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);

        //Setting black king
        boxToPutIn = chessBoard.boxes[7][3];
        pieceToPut = new King("black", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);
        chessBoard.setBlackKing((King)pieceToPut);


        //Setting white king
        boxToPutIn = chessBoard.boxes[0][3];
        pieceToPut = new King("white", boxToPutIn);
        chessBoard.allPieces.add(pieceToPut);
        chessBoard.setWhiteKing((King)pieceToPut);

    }
}
