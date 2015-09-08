package core;

/**
 * Created by an5ra on 9/8/2015.
 */
public class GameController {

    public static void main(String args[])
    {
//        System.out.println("Starting");
        ChessBoard c = new ChessBoard();
        SetBoard s = new SetBoard(c);
//        System.out.println("Its fine till here");
        c.displayBoard();
    }

}
