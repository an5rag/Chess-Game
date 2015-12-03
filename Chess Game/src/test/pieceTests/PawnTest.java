package test.pieceTests;

import boardSetUp.SetBoard;
import components.ChessBoard;
import components.ChessBox;
import components.piece.*;
import model.Move;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by an5ra on 9/18/2015.
 */
public class PawnTest {

    @Test
    public void testMoveValidityStepUpWhite() throws Exception {
        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        Piece pieceToPut;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[1][7];
        pieceToPut = new Pawn("white", boxToPutIn);
        c.allPieces.add(pieceToPut);
        System.out.println("----------------------------------");

        //valid makeMove
        ChessBox boxToMoveTo = c.boxes[2][7];
        boolean check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        Move moveObject = new Move(c);
        moveObject.makeMove(pieceToPut.getCurrentPosition(), c.boxes[2][7]);
        assertEquals(c.boxes[2][7],pieceToPut.getCurrentPosition());

        //Invalid makeMove
        boxToMoveTo = c.boxes[4][7];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

        //valid makeMove
        boxToMoveTo = c.boxes[3][7];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        //Placing pieces in path

    }

    @Test
    public void testMoveValidityStepUpBlack() throws Exception {
        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        Piece pieceToPut;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[6][7];
        pieceToPut = new Pawn("black", boxToPutIn);
        c.allPieces.add(pieceToPut);
        System.out.println("----------------------------------");

        //valid makeMove
        ChessBox boxToMoveTo = c.boxes[5][7];
        boolean check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        Move moveObject = new Move(c);
        moveObject.makeMove(pieceToPut.getCurrentPosition(), boxToMoveTo);
        assertEquals(boxToMoveTo,pieceToPut.getCurrentPosition());

        //valid makeMove
        boxToMoveTo = c.boxes[4][7];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        //invalid makeMove
        boxToMoveTo = c.boxes[3][7];
        check = pieceToPut.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

    }

    @Test
    public void testMoveValidityPiecesInBetween() throws Exception {


        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        Piece pawn;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[1][0];
        pawn = new Pawn("white", boxToPutIn);

        c.allPieces.add(pawn);
        System.out.println("----------------------------------");

        //adding friendly piece in path
        boxToPutIn = c.boxes[2][0];
        Piece friend = new Knight("white", boxToPutIn);
        c.allPieces.add(friend);

        ChessBox boxToMoveTo = c.boxes[2][0];
        boolean check = pawn.checkMoveValidity(c, boxToMoveTo);
        assertEquals(false, check);


        //adding enemy in path
        boxToPutIn = c.boxes[3][0];
        Piece enemy = new Queen("black", boxToPutIn);
        c.allPieces.add(enemy);

        boxToMoveTo = c.boxes[3][0];
        check = pawn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);

    }

    @Test
    public void testMoveValidityDiagonalMove() throws Exception {


        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c, false);
        Piece pawn;
        ChessBox boxToPutIn;
        boxToPutIn = c.boxes[1][4];
        pawn = new Pawn("white", boxToPutIn);

        c.allPieces.add(pawn);
        System.out.println("----------------------------------");


        //adding enemy in path RIGHT
        boxToPutIn = c.boxes[2][5];
        Piece enemy = new Queen("black", boxToPutIn);
        c.allPieces.add(enemy);

        ChessBox boxToMoveTo = c.boxes[2][5];
        boolean check = pawn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        //adding another enemy in path LEFT
        boxToPutIn = c.boxes[2][3];
        enemy = new Queen("black", boxToPutIn);
        c.allPieces.add(enemy);

        boxToMoveTo = c.boxes[2][3];
        check = pawn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(true, check);

        //removing enemy piece
        enemy.die(pawn);
        assertEquals(false, enemy.isAlive());
        boxToMoveTo.removeCurrentPiece();

        //adding friendly piece
        boxToPutIn = c.boxes[2][3];
        Piece friend = new Queen("white", boxToPutIn);
        c.allPieces.add(friend);

        boxToMoveTo = c.boxes[2][3];
        check = pawn.checkMoveValidity(c,boxToMoveTo);
        assertEquals(false, check);




    }
}