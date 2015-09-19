package test.pieceTests;

import boardSetUp.SetBoard;
import components.ChessBoard;
import components.ChessBox;
import components.piece.Piece;
import components.piece.Queen;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by an5ra on 9/18/2015.
 */
public class QueenTest {

    /**
     * Tests all Bishops moves by a Queen
     * @throws Exception
     */
    @Test
    public void testBishopMoveValidity() throws Exception {
        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c);
        Piece queen;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[0][7];
        queen = new Queen("white", boxToPutIn);
        System.out.println(queen.getCurrentPosition());
        c.allPieces.add(queen);
        System.out.println("----------------------------------");

        ChessBox boxToMoveTo = c.boxes[7][0];
        boolean check = queen.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);
    }

    /**
     * Tests all possible Rook Moves by a Queen
     * @throws Exception
     */
    @Test
    public void testRookMoveValidity() throws Exception {


        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c);
        Piece queen;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[0][7];
        queen = new Queen("white", boxToPutIn);
        System.out.println(queen.getCurrentPosition());
        c.allPieces.add(queen);
        System.out.println("----------------------------------");

        ChessBox boxToMoveTo = c.boxes[7][7];
        boolean check = queen.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[0][0];
        check = queen.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

    }

}