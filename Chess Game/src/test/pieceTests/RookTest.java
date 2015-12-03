package test.pieceTests;

import boardSetUp.SetBoard;
import components.ChessBoard;
import components.ChessBox;
import components.piece.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by an5ra on 9/18/2015.
 */
public class RookTest {

    @Test
    public void testMoveValidity() throws Exception {


        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        Piece rook;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[0][0];
        rook = new Rook("white", boxToPutIn);
        System.out.println(rook.getCurrentPosition());
        c.allPieces.add(rook);
        System.out.println("----------------------------------");

        ChessBox boxToMoveTo = c.boxes[3][0];
        boolean check = rook.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[7][0];
        check = rook.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[0][3];
        check = rook.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[0][7];
        check = rook.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        //Trying out invalid moves

        boxToMoveTo = c.boxes[6][6];
        check = rook.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[6][4];
        check = rook.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);


        boxToMoveTo = c.boxes[1][7];
        check = rook.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);


    }



}