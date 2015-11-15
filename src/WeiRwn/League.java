package WeiRwn;

import java.util.ArrayList;
import java.io.*;
/**
 * Write a description of class League here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class League
{
    // instance variables - replace the example below with your own
    private String name;
    private ArrayList<String> fixture;
    private ArrayList<String> details;
    private ArrayList<Clubs> clubs;
    private ArrayList<Matches> matches;
    private String team;
    private String scorer;
    /**
     * Constructor for objects of class League
     */
    public League(String name)
    {
        // initialise instance variables
        this.name = name;
        clubs = new ArrayList<Clubs>();
        matches = new ArrayList<Matches>();
    }
    public void addClub(String name)
    {
        clubs.add(new Clubs(name));
    }
    public String getName()
    {
        return name;
    }
    // add a match yet to be played to League
    public void addFixture()
    {
       
        for(Matches m:matches)
        {
            fixture.add(m.getTime()+m.getPlace());
        }
    }
    //add details of played match 
    public void addDetails()
    {
        for(Matches m:matches)
        {
            details.add(m.getFinalScore() + m.getFinalResult());
        }
    }
    // find top team
    public void findTop()
    {
       
 
    }
    //print out list of League
    public void listLeague()
    {
        System.out.println("League list:");
        for(Clubs b:clubs)
        {
            System.out.println(b.getName());
        }
        for(Matches m:matches)
        {
            System.out.println(m.getTime() + m.getPlace());
        }
        System.out.println("");
    }
    //find golden soccer
    public void findGolden(String name,int number)
    {
        ArrayList<Players> soccer = new ArrayList<Players>();
        String tempname = name;
        int tempnumber = number;
        for(Players p:soccer)
        {
            if(p.getName().equals(tempname) && p.getNumber() == tempnumber){
                System.out.println("Golden Soccer is:" + tempname);
            }
            else
            {
                System.out.println("Player not exists.");
            }
        }
    }
}
