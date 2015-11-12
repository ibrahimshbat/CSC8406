package LiguangCen;


/**
 * A class GoalKeeper stored goalkeeper details.
 * Inherited from Class Player
 * 
 * @author Liguang Cen 
 * @version 2015.10.30
 */
public class GoalKeeper extends Player
{
    // instance variables - replace the example below with your own
    private int keepertally;

    /**
     * Constructor for objects of class GoalKeeper
     * @param name The name of the goalkeeper.
     * @param year The year of birth.
     * @param month The month of birth.
     * @param day The day of birth.
     * @param height The height of the goalkeeper.
     */
    public GoalKeeper(String name, int year, int month, int day, int height)
    {
        super(name, year, month, day, height);
        this.iskeeper = true; 
        // initialise instance variables
    }

    /**
     * @return The number of matches involved by the goalkeeper when no score conceded.
     */
    public int getKeeperTally()
    {
        // put your code here
        return keepertally;
    }
    
    /**
     * Set the keeper tally of the goalkeeper.
     * @param newTallyNumber The number set for a new keeper tally.
     */
    public void setKeeperTally(int newTallyNumber)
    {
        keepertally = newTallyNumber;
    }
    
    /**
     * Add the keeper tally by 1.
     * It means a match no goal conceded.
     */
    public void addKeeperTally()
    {
        keepertally++;
    }
    
}
