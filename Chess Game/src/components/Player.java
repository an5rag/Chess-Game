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
    ArrayList<Piece> Alive = new ArrayList<Piece>();

    public Player(String color, String name) {
        this.color = color;
        this.name = name;
        inCheck = false;
        totalTimeSpent = 0.0;
    }

    public Player(String color) {
        this.color = color;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ("+color+") Player's name: ");
        name = scanner.nextLine();
        inCheck = false;
        totalTimeSpent = 0.0;
    }

    public void printStats()
    {
        System.out.println("Player Name: "+ name);
        System.out.println("Color: "+color);
//        System.out.println("No of pieces alive ");
        System.out.println("Total Time Spent " + totalTimeSpent);
    }
}
