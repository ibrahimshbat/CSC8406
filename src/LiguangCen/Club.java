package LiguangCen;

import java.util.ArrayList;
/**
 * A class stored the details of a club
 * such as club name, points and player squad.
 * 
 * @author Liguang Cen 
 * @version 2015.10.30
 */
public class Club
{
    // instance variables - replace the example below with your own
    private String name;
    private int scoredtally;
    private int concededtally;
    private int pointtally;
    private ArrayList<Player> squad;
    
    
    /**
     * Constructor for objects of class Club
     * @param name The name of a club
     */
    public Club(String name)
    {
        // initialise instance variables
        squad = new ArrayList<Player>();
        this.name = name;
    }

    /**
     * return The name of the club.
     * @return The name of the club.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set the name of the club.
     * @param newName the new name of the club.
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Add the goal scored of the club by the number given from parameter.
     * @param score The goals made by this club in a game.
     */
    public void addGoalScored(int score)
    {
        // put your code here
        scoredtally += score;
    }
    
    /**
     * Add the goal conceded counter by the number given from parameter.
     * @param score The goals lost in a game.
     */
    public void addGoalConceded(int score)
    {
        // put your code here
        concededtally += score;
    }
    
    /**
     * Get the difference between scored and conceded goals.
     * @return the difference number between scored and conceded goals.
     */
    public int getGoalDifference()
    {
        // put your code here
        return scoredtally - concededtally;
    }
    
    /**
     * return The point the club acquired.
     * @return The point the club acquired.
     */
    public int getPointTally()
    {
        // put your code here
        return pointtally;
    }
    
    /**
     * Add the point tally by the number given from parameter.
     * @param point The point of the club acquired.
     */
    public void addPointTally(int point)
    {
        // put your code here
        pointtally += point;
    }
    
    /**
     * Add a player into the club's squad under a condition of not in a club already.
     * @param player The player need to be added.
     */
    public void addPlayer(Player player)
    {
        if(player.getIsInClub())
        {
            throw new IllegalArgumentException(
                "already in one of clubs");
        }
        else
        {
            squad.add(player);
            player.joinClub(this.name);
        }
    }
    
    /**
     * return The list of player squad of the club.
     * @return The list of player squad of the club.
     */
    public ArrayList<Player> getSquad()
    {
        return squad;
    }
    
    public void displaySquad()
    {
        for(Player player : squad)
        {
            System.out.println(player.getName() + "; " + player.getDob() + "; " + player.getHeight());
        }
    }
    
    /**
     * Lookup a player by name.
     * @param name The name used for looking up
     * @return The player with matched name of the club.
     */
    public Player playerLookUp(String name)
    {
        for(Player player : squad)
        {
            if(player.getName().equals(name))
            {
                return player;
            }
        }
        System.out.println("player" + name + "has not been found");
        return null;
    }
    
    /**
     * Find the average age of players in a club.
     * @return The number of players' average age.
     */
    public double findAverageAge()
    {
        int sum = 0;
        double averageAge;
        for(Player player : squad)
        {
            sum = sum + player.getAge();
        }
        averageAge = sum/squad.size();
        return averageAge;
    }
    
    /**
     * Find the average height of players in a club.
     * @return The number of players' average height.
     */
    public double findAverageHeight()
    {
        int sum = 0;
        double averageHeight;
        for(Player player : squad)
        {
            sum = sum + player.getHeight();
        }
        averageHeight = sum/squad.size();
        return averageHeight;
    }
    
}
