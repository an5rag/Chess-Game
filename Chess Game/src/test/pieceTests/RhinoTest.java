package test.pieceTests;

import boardSetUp.SetBoard;
import components.ChessBoard;
import components.ChessBox;
import components.piece.King;
import components.piece.Piece;
import components.piece.Rhino;
import components.piece.Rook;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by an5ra on 9/18/2015.
 */
public class RhinoTest {
    @Test
    public void testRookMoveValidity() throws Exception {


        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c);
        Piece rhino;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[0][0];
        rhino = new Rhino("white", boxToPutIn);
        System.out.println(rhino.getCurrentPosition());
        c.allPieces.add(rhino);
        System.out.println("----------------------------------");

        ChessBox boxToMoveTo = c.boxes[3][0];
        boolean check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[7][0];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[0][3];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[0][7];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        //Trying out invalid moves

        boxToMoveTo = c.boxes[6][6];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[6][4];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);


        boxToMoveTo = c.boxes[1][7];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);


    }

    @Test
    public void testKingMoveValidity() throws Exception {


        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c);
        Piece rhino;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[4][5];
        rhino = new Rhino("white", boxToPutIn);
        c.allPieces.add(rhino);
        System.out.println("----------------------------------");

        ChessBox boxToMoveTo = c.boxes[3][5];
        boolean check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[3][6];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[4][6];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[5][6];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[5][5];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[5][4];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[4][4];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[3][4];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        //Trying out invalid moves

        boxToMoveTo = c.boxes[6][6];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[6][4];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[0][6];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[1][0];
        check = rhino.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);


    }


}