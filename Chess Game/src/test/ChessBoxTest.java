package test;

import components.ChessBox;
import components.piece.King;
import components.piece.Piece;
import components.piece.Queen;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by an5ra on 9/18/2015.
 */
public class ChessBoxTest {

    @Test
    public void testAddPiece() throws Exception {

        ChessBox box = new ChessBox(1,1,"black");
        ChessBox otherBox = new ChessBox(3,1,"white");
        Piece p = new King("black", otherBox);
        box.addPiece(p);
        assertEquals(p, box.getOccupyingPiece());

    }

    @Test
    public void testRemoveCurrentPiece() throws Exception {
        ChessBox box = new ChessBox(1,1,"black");
        Piece p = new King("black", box);
        box.removeCurrentPiece();
        assertEquals(false,box.isOccupied());

    }

    @Test
    public void testIsOccupiedByFriendlyPiece() throws Exception {
        ChessBox box = new ChessBox(1,1,"black");
        Piece p = new King("black", box);
        //making friendly piece
        ChessBox otherBox = new ChessBox(3,1,"white");
        Piece friend = new Queen("black", otherBox);
        boolean result = box.isOccupiedByFriendlyPiece(friend);
        assertEquals(true, result);

    }

    @Test
    public void testIsOccupiedByOpponentPiece() throws Exception {
        ChessBox box = new ChessBox(1,1,"black");
        Piece p = new King("black", box);
        //making friendly piece
        ChessBox otherBox = new ChessBox(3,1,"white");
        Piece enemy = new Queen("white", otherBox);
        boolean result = box.isOccupiedByOpponentPiece(enemy);
        assertEquals(true, result);

    }

}