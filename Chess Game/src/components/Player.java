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
    int score;
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
        score = 0;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Piece> getDeadPieces() {
        return deadPieces;
    }

    public void setDeadPieces(ArrayList<Piece> deadPieces) {
        this.deadPieces = deadPieces;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore()
    {
        score++;
    }

    public void resetScore() {
        score=0;
    }
}
