package MadalinaJuganariu;

/**
 * This class inherits all the methods and variables
 * from the Player class
 * 
 * @author (Madalina Juganariu) 
 * @version (28/10/2015)
 */
public class Goalkeeper extends Player 
{
    //Variable to hold the games played
    private int gamesPlayed;

    /**
     * Constructor for objects of class Goalkeeper
     */
    public Goalkeeper(int gamesP, String pName, int height, int goalTally, int age)
    {
        super(pName, height,goalTally, age);
        this.gamesPlayed = gamesPlayed;
    }
}
