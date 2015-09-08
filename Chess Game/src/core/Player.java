package core;

/**
 * Created by an5ra on 9/8/2015.
 */
public class Player {
    String color;
    String name;
    boolean inCheck;
    //Image profilePicture;
    double totalTimeSpent;


    public Player(String color, String name) {
        this.color = color;
        this.name = name;
        inCheck = false;
        totalTimeSpent = 0.0;
    }
}
