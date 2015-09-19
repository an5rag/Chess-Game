package test.pieceTests;

import boardSetUp.SetBoard;
import components.ChessBoard;
import components.ChessBox;
import components.piece.Bishop;
import components.piece.King;
import components.piece.Piece;
import components.piece.Unicorn;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by an5ra on 9/18/2015.
 */
public class UnicornTest {
    @Test
    public void testBishopMoveValidity() throws Exception {
        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c);
        Piece unicorn;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[3][4];
        unicorn = new Unicorn("white", boxToPutIn);
        System.out.println(unicorn.getCurrentPosition());
        c.allPieces.add(unicorn);
        System.out.println("----------------------------------");

        ChessBox boxToMoveTo = c.boxes[6][7];
        boolean check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);


        //Trying out invalid moves

        boxToMoveTo = c.boxes[6][6];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[6][4];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);


        boxToMoveTo = c.boxes[1][7];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);
    }

    @Test
    public void testKingMoveValidity() throws Exception {


        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c);
        Piece unicorn;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[4][5];
        unicorn = new Unicorn("white", boxToPutIn);
        c.allPieces.add(unicorn);
        System.out.println("----------------------------------");

        ChessBox boxToMoveTo = c.boxes[3][5];
        boolean check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[3][6];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[4][6];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[5][6];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[5][5];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[5][4];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[4][4];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[3][4];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        //Trying out invalid moves

        boxToMoveTo = c.boxes[6][6];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[6][4];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[0][6];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[1][0];
        check = unicorn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);


    }

}