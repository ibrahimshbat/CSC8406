package LiguangCen;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
/**
 * A class stored the details of a player
 * such as player's name, date of birth, height and number of score.
 * 
 * @author Liguang Cen 
 * @version 2015.10.30
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String name;
    private int year;
    private int month;
    private int day;// Date of birth in form of yyyy-MM-dd
    private int height;
    private int tally;
    protected boolean iskeeper;
    private String club; //indicate in which club the player is
    private boolean isInClub;
    /**
     * Constructor for objects of class Player
     * @param name The name of the player.
     * @param year The year of birth.
     * @param month The month of birth.
     * @param day The day of birth.
     * @param height The height of the player.
     */
    public Player(String name, int year, int month, int day, int height)
    {
        // initialise instance variables
        
        this.name = name;
        Calendar currentTime = Calendar.getInstance();
        Calendar birthDay = Calendar.getInstance();
        birthDay.set(year, month-1, day);
        if (currentTime.before(birthDay)) 
        {
            System.out.println("invalid birthday, later than current time.");
            throw new IllegalArgumentException(
                "invalid birthday, later than current time.");
        }
        this.year = year;
        this.month = month;
        this.day = day;
        this.height = height;
        this.iskeeper = false;
    }

    /**
     * @return The name of the player.
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
    /**
     * @return The date of birth of the player.
     */
    public String getDob()
    {
        return (year + "-" + month + "-" + day);
    }
    
    /**
     * @return The height of the player.
     */
    public int getHeight()
    {
        return height;
    }
    
    /**
     * @return The number of score by the player.
     */
    public int getTally()
    {
        return tally;
    }
    
    /**
     * @return Is the player is a goalkeeper.
     */
    public boolean getIsKeeper()
    {
        return iskeeper;
    }
    
    /**
     * Set the name of the player.
     * @param name The new name of the player.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Set the date of birth of the player.
     * @param year The year of birth.
     * @param month The month of birth.
     * @param day The day of birth.
     */
    public void setDob(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    /**
     * Set the height of the player.
     * @param height The height of the player.
     */
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    /**
     * Add the individual goals scored by the number given from parameter.
     * @param score The goals made by the player in a game.
     */
    public void addTally(int score)
    {
        tally += score;
    }
    
    /**
     * @return Is the player is already in a club.
     */
    public boolean getIsInClub()
    {
        return isInClub;
    }
    
    /**
     * Join the player into a given club.
     * @param club The club in which the player joins
     */
    public void joinClub(String club)
    {
            this.club = club;
            isInClub = true;
    }
    
    /**
     * @return The age of the player.
     */
    public int getAge()
    {
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;//MONTH count from 0
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(yearNow +" "+ monthNow +" "+ dayOfMonthNow);
        cal.set(year, month-1, day);
        int age = yearNow - year;

        if (monthNow <= month) {
            if (monthNow == month) {
                //monthNow==month
                if (dayOfMonthNow < day) {
                    age--;
                } else {
                    //do nothing
                }
            } else {
                //monthNow>monthBirth
                age--;
            }
        } else {
            //monthNow<monthBirth
            //donothing
        }
        return age;
    }
    
    /**
     * Empty method for subclass overriding.
     */
    public void addKeeperTally()
    {}
    
    /**
     * A method for subclass overriding.
     */
    public int getKeeperTally()
    {
        return -1;
    }
}
