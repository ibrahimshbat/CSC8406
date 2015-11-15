package AbdullahiAKawu;

import java.util.*;
import java.time.LocalDate;

/**
 * This class represent the Players. The Players Class manages Players in the league, club or match.
 * A player plays for a club in a match that can be of a league
 * @Abdullahi Abubakar Kawu 
 * @30.10.2015
 */

public class Players
{
    //Fields for Class Players
    private double height;
    private String name;
    private int goaltally;
    private int age;
    private LocalDate dob; 
    private LocalDate currentday; //Throw exception for wrong user input
    private int year;
    private int month;
    private int day;
    
    

    /**
     * Constructor for objects of class Players
     * @param pname, pheight, year, month, day
     * 
     */
    public Players(String pname, double pheight, int yearx, int monthx, int dayx)
    {
        name = pname;
        height = pheight;
        year = yearx;
        month = monthx;
        day = dayx;
        currentday = LocalDate.now();
        dob = LocalDate.of(year, month, day);
        age = currentday.getYear() - dob.getYear(); // Can use this in the clubs class 
        goaltally = 0;
    }
    
    
    /**
     * setPlayerName method - to set the Player's Name
     * @param pname - name of the player 
     */
    
    public void setPlayerName(String pname)
    {
        name = pname;
    }
    
     /**
     * setPlayerHeight method - to set the Player's Height
     * @param pheight - height of the player 
     */
    
    public void setPlayerHeight(double pheight) 
    {
        height = pheight;
    }
    
     /**
     * setPlayerDOB method - to set the Player's Date of Birth
     * @param year, month, day - Date of Birth of the player (YYYY, DD, MM)
     */
    
    public void setPlayerDOB(int year, int month, int day) //Enter the date of birth of player in the format: year, day, month - YYYY, DD, MM, 
    {
        
        dob = LocalDate.of(year, month, day);
        
    }
    
    /**
     * getPlayerName method - Retrieves Player's Name
     * @return name - Name of Player
     */
    
        public String getPlayerName()
    {
        return name;
    }
    
     /**
     * getPlayerHeight method - Retrieves the Player's Height
     * @return name - Name of Player
     */
    
    public double getPlayerHeight() 
    {
        return height;
    }
    
     /**
     * getPlayerDOB method - Retrieves the Player's Date of Birth
     * @return dob - Date of Birth of Playert
     */
    
    public LocalDate getPlayerDOB() //Enter the date of birth of player in the format: year, day, month - YYYY, DD, MM, 
    {
        
        dob = LocalDate.of(year, month, day);
        return dob;
    }
    
        
    /**
     * Add to the goal tally of the player
     * @param  goal of int - add goal(s) to the tally.
     */
    
    public void addGoalTally()
    {
        goaltally += 1;
    }
    
    
    /**
     * Retrieves the goal tally of the player;
     * @ returns player's goal tally
     */
    
    public int getGoalTally()
    {
        return goaltally;
    }    
    
    /**
     * Retrieves the goal tally of the player;
     * @ returns player's age
     */
    
    
    public int getPlayerAge()
    {
        return age;
    }
    
    
    /**
     * Resets the goal tally of the player;
     * @return void
     */
    public void resetGoalTally()
    {
        goaltally = 0;
    }
          
        
    
    
     /** Overidden method hashCode - Works with the overriden equals method to compare contents of two objects;
     * @return result:
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + day;
        long temp;
        temp = Double.doubleToLongBits(height);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + month;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + year;
        return result;
    }


    /** 
     * Overides the equals() method to enhance it to be able to compare other non-string parameters of two objects;;
     * 
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Players)) {
            return false;
        }
        Players other = (Players) obj;
        if (day != other.day) {
            return false;
        }
        if (Double.doubleToLongBits(height) != Double
                .doubleToLongBits(other.height)) {
            return false;
        }
        if (month != other.month) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (year != other.year) {
            return false;
        }
        return true;
        
    }

}

