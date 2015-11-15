package WeiRwn;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * Write a description of class Players here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Players
{
    // information of a player;
    private String name;
    private int number;
    private Date birth;
    private int height;
    private int goal;
    private int age;
    /**
     * Constructor for objects of class Players
     */
    public Players(String name,Date birth,int height,int number)
    {
        // initialise instance variables
        this.name = name;
        this.birth = birth;
        this.height = height;
        this.number = number;
        this.goal = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
  
    public String getName()
    {
        return name;
    }
    public Date getBirth()
    {
        return birth;
    }
    public int getHeight()
    {
        return height;
    }
    public int getAge() 
    {

       if (birth == null)
       {
         throw new
         RuntimeException("birth date can not be empty.");
       }
       int age = 0;
       Date now = new Date();
       SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
       SimpleDateFormat format_M = new SimpleDateFormat("MM");
       String birth_year = format_y.format(birth);
       String this_year = format_y.format(now);
       String birth_month = format_M.format(birth);
       String this_month = format_M.format(now);
       age = Integer.parseInt(this_year) - Integer.parseInt(birth_year);
       if
       (this_month.compareTo(birth_month) < 0)
       {
           age -= 1;
           
       }
       if (age <
       0)
       {
       age = 0;
       }
       return age;
    }

    public int getNumber()
    {
        return number;
    }
    public int getScore()
    {
        return goal;
    }
}
