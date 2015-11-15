package WeiRwn;

import java.util.ArrayList;
import java.util.Date;
/**
 * Write a description of class Clubs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clubs
{
    // instance variables - replace the example below with your own
    private String name;
    private int scoredgoal;
    private int concededgoal;
    private int difference;
    private ArrayList<Players> squadplayer;
    private int score;
    private int points;
    private int win;
    private int tie;
   
    /**
     * Constructor for objects of class Clubs
     */
    public Clubs(String name)
    {
        // initialise instance variables
        points = 0;
        this.name = name;
        squadplayer = new ArrayList<Players> ();
        win = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    // get club's score
    public int getScore(int Score)
    {       
        score = Score;
        return score;
    }
    // win tally
    public int addWin()
    {
        win = win + 1;
        return win;
    }
    //tie tally
    public int addTie()
    {
        tie = tie + 1;
        return tie;
    }
    // get club's points
    public int getPoints()
    {
        int points = 0;
        points = win*3 + tie*1;
        return points;
    
    }
    // add a new player to club's squad;
    public void addPlayer(String name,Date time,int number,int height)
    {
        squadplayer.add(new Players(name,time,number,height));
    }
    // find out whether a player is in the club's squad;
    public void findPlayer(String name)
    {
        for(Players p:squadplayer)
        {
            if(!(p.getName().equals(name)))
            {
                System.out.println("This player is not in the club's squad.");
            }
            else
            {
                System.out.println("This player is in the club's squad.");
            }
        }
    }
    // average age of team
    public int averageAge()
    {
        int sum = 0;
        int average;
        int j;
        for(j = 0;j <= squadplayer.size();j++)
        {
            sum = sum + squadplayer.get(j).getAge();
        }
        average = sum/squadplayer.size();
        return average;
    }
    // average height of team
    public int averageHeight()
    {
        int sum = 0;
        int average;
        int k;
        for(k = 0;k <= squadplayer.size();k++)
        {
            sum = sum + squadplayer.get(k).getHeight();
        }
        average = sum/squadplayer.size();
        return average;
    }
    // get name of club
    public String getName()
    {
        return name;
    }
    // get every team member's name
    public ArrayList<String> Squadplayer1()
    {
        ArrayList<String> temparray = new ArrayList<String>();
        for(Players p:squadplayer)
        {
             temparray.add(p.getName());            
        }
        return temparray;
    }
    // get every team member's score
    public ArrayList<Integer> Squadplayer2()
    {
        ArrayList<Integer> temparray = new ArrayList<Integer>();
        for(Players p:squadplayer)
        {
            temparray.add(p.getScore());
        }
        return temparray;
    }
    // get the goal difference of the club
    public int getDiffer(String name)
    {
        int difference;
        Clubs club = new Clubs(name);
        difference = club.addScoredGoal(0) - club.addConcededGoal(0);
        return difference;
    }
    public int addScoredGoal(int sg)
    {
        scoredgoal = scoredgoal + sg;
        return scoredgoal;
    }
    public int addConcededGoal(int gg)
    {
        concededgoal = concededgoal + gg;
        return concededgoal;
    }
}
