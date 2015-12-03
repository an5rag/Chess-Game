package test;

import components.ChessBoard;
import components.ChessBox;
import components.piece.King;
import components.piece.Piece;
import model.Move;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by an5ra on 9/15/2015.
 */
public class MoveTest {

    @Test
    public void testParseMoveString() throws Exception {
        ChessBoard chessBoard = new ChessBoard();
        Move m = new Move(chessBoard);
        int arr[] = m.parseMoveString("a1 d4");
        assertEquals(0,arr[0]);
        assertEquals(0, arr[1]);
        assertEquals(3,arr[2]);
        assertEquals(3,arr[3]);
    }

    @Test
    public void testMove() throws Exception {
        ChessBoard chessBoard = new ChessBoard();
        //trying valid makeMove
        ChessBox box = new ChessBox(1,1,"black");
        Piece p = new King("black", box);
        //making friendly piece
        ChessBox otherBox = new ChessBox(3,1,"white");
        Move m = new Move(chessBoard);


    }
}