package test.pieceTests;

import boardSetUp.SetBoard;
import components.ChessBoard;
import components.ChessBox;
import components.piece.Bishop;
import components.piece.Piece;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by an5ra on 9/18/2015.
 */
public class BishopTest {

    @Test
    public void testCheckMoveValidity() throws Exception {
        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c);
        Piece bishop;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[3][4];
        bishop = new Bishop("white", boxToPutIn);
        System.out.println(bishop.getCurrentPosition());
        c.allPieces.add(bishop);
        System.out.println("----------------------------------");

        ChessBox boxToMoveTo = c.boxes[6][7];
        boolean check = bishop.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);


        //Trying out invalid moves

        boxToMoveTo = c.boxes[6][6];
        check = bishop.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[6][4];
        check = bishop.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);


        boxToMoveTo = c.boxes[1][7];
        check = bishop.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);
    }
}