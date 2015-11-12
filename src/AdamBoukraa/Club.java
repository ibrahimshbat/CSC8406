package AdamBoukraa;

import java.util.*;

/** 
* Class Club implements java.io.Serailizable,
extends java.awt.Button 
*/ 



/**
 * CLub class that deals with storing and showing information about the club
 * 
 * @author Adam Boukraa
 * @version Version 3
 */
public class Club
{
    
    int division;
    String cname;
    String AB;
    int cpointtally;
    int played;
    int cgtally;
    int cgconceded;
    int cgdifference;
    private int won;
    private int lost;
    private int draw;

    
    private List<Player> team = new ArrayList<Player>();
    
public Club(int division, String AB, String name) {
this.division = division;
this.AB = AB;
this.cname = name;
}

public Boolean searchPlayer(Player p)
{
    for (Player i: team)
    {
        if (i.name().equals(p.name()))
        {
            return true;
        }
    }
        return false;
    
}

public void addPlayer(Player p)
{
    team.add(p);
}

/*
 * Adds a result when the club plays a home game
 */
public void addHomeResult(int home, int away) {
if (home==away) cpointtally= cpointtally+ 1;  
if (home > away) cpointtally = cpointtally + 3; 
cgtally = cgtally + home;
cgconceded = cgconceded + away;
cgdifference = cgtally - cgconceded;
}
 
/*
 * Adds a result when the club plays an away game
 */
public void addAwayResult(int away, int home) {
if (away==home) cpointtally = cpointtally + 1; 
if (away > home) cpointtally = cpointtally + 3; 

cgtally = cgtally + away;
cgconceded = cgconceded + home;
cgdifference = cgtally - cgconceded;
}
 
public void print() {
System.out.println("CL"+"\t"+"GLS"+"\t"+"CON"+"\t"+"GDIF"+"\t"+"POINTS");
System.out.println(cname+"\t"+cgtally+"\t"+cgconceded+"\t"+cgdifference+"\t"+cpointtally+"\t");
 
} 

/*
 * Methods below are the methods to manually set values for the teams stats rather than being based off the calculations
 */
/*
 * Method to set games Won
 */

public void setWon(int aWon)
    {
        this.won = aWon;
    }

public void setLost (int aLost)
    {
        this.lost = aLost;
    }

public void setDrew (int aDraw)
    {
        this.draw = aDraw;
    }
    
public int getWon()
    {
        return this.won;
    }
    
public int getLost()
    {
        return this.lost;
    }    

public int getDraw()
    {
        return this.draw;
    }   



/**
 * Method to set points tally
 */

public void setcpointtally(int cpointtally)
{
    this.cpointtally = cpointtally;
}

/**
 * Method to get the manually set points tally
 */

public int getcpointtally()
{
    return cpointtally;


}
}