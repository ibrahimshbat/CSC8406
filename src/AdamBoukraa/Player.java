package AdamBoukraa;

import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author Adam Boukraa
 * @version Version 3
 */
public class Player
{
    private String name;
    private double dob;
    private double height=0;
    private int hasscored=0;
    private int goaltally=0;

    



public Player(String name, double dob, double height, int hasscored, int goaltally)
{
this.name = name;
this.dob = dob;
this.height = height;
this.hasscored = hasscored;
this.goaltally = goaltally;
}



/**
 * Method to set name
 */

public void setname(String name)
{
    this.name = name;
}


/**
 * Method to set date of birth
 */

public void setdob(double dob)
{
    this.dob = dob;
}

/**
 * Method to set height
 */

public void setheight(double height)
{
    this.height = height;
}



/**
 * Method to add goals scored
 */

public void sethasscored(int as)
{
   hasscored += as;
}

/**
 * Method to set goal tally
 */

public void setgoaltally(int gt)
{
    goaltally += gt;
}

/**
 * Method to get name
 */

public String name()
{
    return name;
}

/**
 * Method to get date of birth
 */

 public double dob()
{
    return dob;
}

/**
 * Method to get height
 */

public double height()
{
    return height;
}

/**
 * Method to get add scored
 */

public int hasscored()
{
    return hasscored;
}

/**
 * Method to get goaltally
 */

public int getgoaltally()
{
    return goaltally;
}
}