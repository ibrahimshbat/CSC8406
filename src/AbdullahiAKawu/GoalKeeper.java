package AbdullahiAKawu;

import java.util.*;
import java.time.LocalDate;

/**
 * GoalKeeper Class manages the goalkeeper aspect of the 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoalKeeper extends Players
{
     
    private int goalconceded;
    private int cleansheet;
    
    public GoalKeeper(String pname, double pheight, int year, int month, int day)
    {
        super (pname, pheight, year, month, day);
        goalconceded = 0;
        cleansheet = 0;
          

    }
    
    public void addGoalConceded()
    {
        goalconceded += 1;
    }
        
    
    public int totalConceded()
    {
        return goalconceded;
    }
    
    public void addCleanSheet()
    {
        cleansheet++;
    }
    
    public int getcleansheet()
    {
        return cleansheet;
    }
}
