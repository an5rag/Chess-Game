package test.pieceTests;

import boardSetUp.SetBoard;
import components.*;
import components.piece.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by an5ra on 9/11/2015.
 */
public class KingTest {

    @Test
    public void testKingPlacement() throws Exception{

        System.out.println("----------------------------------");
        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        Piece pieceToPut;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[0][1];
        pieceToPut = new King("white", boxToPutIn);
        c.allPieces.add(pieceToPut);
        c.displayBoard();
        assertEquals(pieceToPut, c.boxes[0][1].getOccupyingPiece());
        assertEquals(boxToPutIn,pieceToPut.getCurrentPosition());
    }
    @Test
    public void testMoveValidity() throws Exception {


        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        Piece pieceToPut;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[4][5];
        pieceToPut = new King("white", boxToPutIn);
        c.allPieces.add(pieceToPut);
        System.out.println("----------------------------------");

        ChessBox boxToMoveTo = c.boxes[3][5];
        boolean check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[3][6];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[4][6];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[5][6];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[5][5];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[5][4];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[4][4];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        boxToMoveTo = c.boxes[3][4];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        //Trying out invalid moves

        boxToMoveTo = c.boxes[6][6];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[6][4];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[0][6];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        boxToMoveTo = c.boxes[1][0];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);


    }
    @Test
    public void testMoveValidityPiecesInBetween() throws Exception {


        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        Piece king;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[4][5];
        king = new King("white", boxToPutIn);

        c.allPieces.add(king);
        System.out.println("----------------------------------");

        //adding friendly piece in path
        boxToPutIn = c.boxes[3][5];
        Piece friend = new Knight("white", boxToPutIn);
        c.allPieces.add(friend);

        ChessBox boxToMoveTo = c.boxes[3][5];
        boolean check = king.checkMoveValidity(c, boxToMoveTo);
        assertEquals(false, check);


        //adding enemy in path
        boxToPutIn = c.boxes[5][4];
        Piece enemy = new Queen("black", boxToPutIn);
        c.allPieces.add(enemy);

        boxToMoveTo = c.boxes[5][4];
        check = king.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

    }

    @Test
    public void testIsCheckByPawn() throws Exception {

        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        King king;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[4][5];
        king = new King("white", boxToPutIn);

        c.allPieces.add(king);



        //adding enemy Knight
        boxToPutIn = c.boxes[5][4];
        Piece enemy = new Pawn("black", boxToPutIn);
        c.allPieces.add(enemy);

        boolean result = king.isCheck(c);
        assertEquals(true, result);
    }

    @Test
    public void testIsCheckByKnight() throws Exception {
        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        King king;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[4][5];
        king = new King("white", boxToPutIn);

        c.allPieces.add(king);



        //adding enemy Knight
        boxToPutIn = c.boxes[2][6];
        Piece enemy = new Knight("black", boxToPutIn);
        c.allPieces.add(enemy);

        boolean result = king.isCheck(c);
        assertEquals(true, result);

    }

    @Test
    public void testIsCheckByQueen() throws Exception {
        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        King king;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[4][5];
        king = new King("white", boxToPutIn);

        c.allPieces.add(king);

        //adding enemy Queen
        boxToPutIn = c.boxes[0][5];
        Piece enemy = new Queen("black", boxToPutIn);
        c.allPieces.add(enemy);

        boolean result = king.isCheck(c);
        assertEquals(true, result);

    }

    @Test
    public void testIsCheckByRook() throws Exception {
        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        King king;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[4][5];
        king = new King("white", boxToPutIn);

        c.allPieces.add(king);

        //adding enemy Queen
        boxToPutIn = c.boxes[4][7];
        Piece enemy = new Rook("black", boxToPutIn);
        c.allPieces.add(enemy);

        boolean result = king.isCheck(c);
        assertEquals(true, result);

    }

    @Test
    public void testIsCheckByBishop() throws Exception {

        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        King king;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[4][5];
        king = new King("white", boxToPutIn);

        c.allPieces.add(king);

        //adding enemy Queen
        boxToPutIn = c.boxes[1][2];
        Piece enemy = new Bishop("black", boxToPutIn);
        c.allPieces.add(enemy);

        boolean result = king.isCheck(c);
        assertEquals(true, result);

    }

    @Test
    public void testIsCheckByRhino() throws Exception {

    }

    @Test
    public void testIsCheckByUnicorn() throws Exception {

    }
}
