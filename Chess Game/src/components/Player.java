package components;

import components.piece.Piece;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by an5ra on 9/8/2015.
 */
public class Player {
    String color;
    String name;
    boolean inCheck;
    //Image profilePicture;
    double totalTimeSpent;
    ArrayList<Piece> deadPieces = new ArrayList<Piece>();

    /**
     * Constructor to initiate a Player
     * @param color
     * @param name
     */
    public Player(String color, String name) {
        this.color = color;
        this.name = name;
        inCheck = false;
        totalTimeSpent = 0.0;
    }

    /**
     * Constructor which only takes in color as argument
     * and requests name from CONSOLE
     * @param color
     */
    public Player(String color) {
        this.color = color;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ("+color+") Player's name: ");
        name = scanner.nextLine();
        inCheck = false;
        totalTimeSpent = 0.0;
    }

    /**
     * Used to print Player Statistics for debug purposes
     */
    public void printStats()
    {
        System.out.println("Player Name: "+ name);
        System.out.println("Color: "+color);
//      System.out.println("No of allPieces alive ");
        System.out.println("Total Time Spent " + totalTimeSpent);
    }

    ///--------------------GETTERS AND SETTERS-------------------------///

    public boolean isInCheck() {
        return inCheck;
    }

    public void setInCheck(boolean inCheck) {
        this.inCheck = inCheck;
    }

    public double getTotalTimeSpent() {
        return totalTimeSpent;
    }

    public void setTotalTimeSpent(double totalTimeSpent) {
        this.totalTimeSpent = totalTimeSpent;
    }
}
