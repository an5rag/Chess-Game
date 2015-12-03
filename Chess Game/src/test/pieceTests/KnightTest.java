package test.pieceTests;

import boardSetUp.SetBoard;
import components.ChessBoard;
import components.ChessBox;
import components.piece.Knight;
import components.piece.Piece;
import components.piece.Queen;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by an5ra on 9/18/2015.
 */
public class KnightTest {

    @Test
    public void testMoveValidity() throws Exception {


        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        Piece knight;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[4][5];
        knight = new Knight("white", boxToPutIn);
        c.allPieces.add(knight);
        System.out.println("----------------------------------");

        ChessBox boxToMoveTo = c.boxes[6][6];
        boolean check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[6][4];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[5][3];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[5][7];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[2][4];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[2][6];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[3][3];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[3][7];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        //Trying out invalid moves

        boxToMoveTo = c.boxes[6][7];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[5][6];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[3][5];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[0][0];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);


    }
    @Test
    public void testMoveValidityPiecesInBetween() throws Exception {


        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        Piece knight;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[4][5];
        knight = new Knight("white", boxToPutIn);

        c.allPieces.add(knight);
        System.out.println("----------------------------------");

        //adding friendly piece in path
        boxToPutIn = c.boxes[6][6];
        Piece friend = new Knight("white", boxToPutIn);
        c.allPieces.add(friend);

        ChessBox boxToMoveTo = c.boxes[6][6];
        boolean check = knight.checkMoveValidity(c, boxToMoveTo);
        assertEquals(false, check);


        //adding enemy in path
        boxToPutIn = c.boxes[6][4];
        Piece enemy = new Queen("black", boxToPutIn);
        c.allPieces.add(enemy);

        boxToMoveTo = c.boxes[6][4];
        check = knight.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

    }

}