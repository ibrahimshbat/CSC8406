package WeiRwn;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Matches here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Matches
{
    // instance variables - replace the example below with your own
    private int time;
    private String place;
    private Clubs club1;
    private Clubs club2;
    private ArrayList<String> players;
    private int score1;
    private int score2;
    /**
     * Constructor for objects of class Matches
     */
    public Matches(String name1,String name2,String clubs)
    {
        // initialise instance variables
       club1 = new Clubs(name1);
       club2 = new Clubs(name2);
    }

    /**
     * get final score and final result of matches
   
     */
    
    public String getFinalScore()
    {
        System.out.println("Final score is:" + club1.getName() + score1 + " - " + score2 + club2.getName());
        return (score1+"-"+score2);
    }
    public String getFinalResult()
    {
        
        if(score1 > score2)
        {
            
            System.out.println("Winner:" + club1.getName() + "\n" + "Score:" + score1);
            club1.addWin();
            club1.addScoredGoal(score1);
            club1.addConcededGoal(score2);
            club2.addScoredGoal(score2);
            club2.addConcededGoal(score1);
            return club1.getName();
        }
        else if(score1 == score2)
        {
            System.out.println("Equal." + "\n" + club1.getName() + score1 + " " + score2 + club2.getName());
            club1.addTie();
            club2.addTie();
            club1.addScoredGoal(score1);
            club1.addConcededGoal(score2);
            club2.addScoredGoal(score2);
            club2.addConcededGoal(score1);
            return "Tie";
        }
             else
             {
                 
                 System.out.println("Winner:" + club2.getName() + "\n" + "Score:" + score2);
                 club2.addWin();
                 club2.addScoredGoal(score2);
                 club2.addConcededGoal(score1);
                 club1.addScoredGoal(score1);
                 club1.addConcededGoal(score2);
                 return club2.getName();
             }
        
    }
    // match place
    public String getPlace()
    {
        return place;
    }
    // match time
    public int getTime()
    {
        return time;
    }
    // clubs' name in match
    public String getClubName()
    {
        return club1.getName()+","+club2.getName();
    }
    // record squad players
    public void recordPlayers(String name)
    {
        Clubs club = new Clubs(name);
        for(String p:club.Squadplayer1())
        {
            System.out.println(p);
        }
    }
    // record every squad player's score
    public void recordScorer(String name)
    {
        Clubs club = new Clubs(name);
        for(Integer s:club.Squadplayer2())
        {
            System.out.println(s);
        }
    }
    public void inputscore()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("please input score1:");
        score1 = s.nextInt();
        Scanner p = new Scanner(System.in);
        System.out.println("please input score2");
        score2 = p.nextInt();
    }
}
