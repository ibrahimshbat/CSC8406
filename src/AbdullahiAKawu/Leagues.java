package AbdullahiAKawu;

import java.util.ArrayList;

/**
 * Models the operation of a League - managing Clubs and Players.
 * 
 * @author Abdullahi Abubakar Kawu
 * @version 30/10/2015
 */

public class Leagues
{
    //Fields of the League Class
    public ArrayList<Clubs> LeagueClubs;
    public ArrayList<Matches> LeagueMatches;
    private String leaguename;
    private int clublimit;
    
    

    /**
     * Constructor for objects of Class Leagues
     * New Leagues to be created (Spanish La Liga, Bundes Liga, English Premiership,  etc).
     * @param name, clubsize; name of league, number of clubs to play
     */
    
    public Leagues(String name, int limit)
    {
        LeagueClubs = new ArrayList<Clubs>();
        LeagueMatches = new ArrayList<Matches>();
        leaguename = name;
        clublimit = limit;
        
    }

    public void setNameofLeague(String name)
    {
        leaguename = name;
    }
    
    public String getNameofLeague()
    {
        return leaguename;
    }
    
    public void setClubLimit(int limit)
    {
        clublimit = limit;
        
    }
    
    public int getClubLimit()
    {
        return clublimit;
        
    }
    
    public void addClubToLeague(Clubs club)
    {
        if(LeagueClubs.size()<clublimit){
             LeagueClubs.add(club);
        }
    }
    
    
    public void addMatchToLeague(Matches match)
    {
     if (this.LeagueMatches.contains(match)==false)
     {
        LeagueMatches.add(match);
     }  
    }
    
    
    public void addFixture(Matches match)
    {
        if (match.getMatchStatus()!=true && LeagueMatches.contains(match)==false )
        {
        LeagueMatches.add(match);
        }
    
    }
    
    
    public void viewFixtures()
    {
        for (int i=0; i<LeagueMatches.size(); i++)
        {
            boolean currentstatus = LeagueMatches.get(i).getMatchStatus();
            if (currentstatus!=true)
            {
                
                System.out.println(LeagueMatches.get(i).getPlayingClubs() + "   -  \t" + LeagueMatches.get(i).getMatchVenue() + " (Venue)\t " + LeagueMatches.get(i).getMatchTime() + " (Time)");
               
            }
        }
        
        //fixtures: match yet to be played
    }
    
    public void leagueResults()
    {
        //addMatchdetails once played
        System.out.println("\t** Match Results **");
        
        
        for (int i=0; i<LeagueMatches.size(); i++)
        {
            boolean match = this.LeagueMatches.get(i).getMatchStatus();
            if (match==true)
            {
                this.LeagueMatches.get(i).MatchFinalScores();
                               
                
            }
            
            
            
        }
        
    }

    
    public int indexOfMatch(Matches match){
        //    if (LeagueMatches.contains(match)==true)
    
            for (int i=0; i<LeagueMatches.size(); i++)
        {
            if(LeagueMatches.get(i).equals(match)) 
            {
               return LeagueMatches.indexOf(match);   
            }
            
        }
        
        return -1;
     }

    
    public void endAMatch(Matches match)
     {
        //End a match in a league once played
        if (LeagueMatches.contains(match) && indexOfMatch(match)!=-1)
      {
        this.LeagueMatches.get(indexOfMatch(match)).setMatchAsEndedOrPlayed();
     }
     else      System.out.println("Match not setup for the league or does not exist in league"); 
    }
    
    
        
    
    public void topClubInLeague()
    {
        int max = LeagueClubs.get(0).getPointTally();
        int tracker = 0;
        for (int i = 0; i < LeagueClubs.size(); i++)
        {
            if (LeagueClubs.get(i).getPointTally() > max)
            {
                max =LeagueClubs.get(i).getPointTally();
                tracker = i;
            }
        }
        
        
       
    System.out.println("The Top Club in League is: " + LeagueClubs.get(tracker).getNameOfClub()+ " with " + max + " points");

        
        // Top team in the league 
    }
    
    
    
    public void printLeagueTable()
    {
        //print league table - consisting all clubs in the league
        
        System.out.println("\t\t***" + this.leaguename + " League Table ***");
        System.out.println("************************************************************");
        System.out.println("\t" + "GS\t" + "GC\t" + "GD\t" + "PT\t");
        for (int i=0; i<LeagueClubs.size(); i++)
        {
            //boolean match = this.LeagueClubs.get(i).getMatchStatus();
                     
            System.out.println(LeagueClubs.get(i).getNameOfClub() + "\t" + LeagueClubs.get(i).getGoalScoredTally() + "\t" + LeagueClubs.get(i).getGoalConcededTally()
            + "\t" + LeagueClubs.get(i).getGoalDifference() + "\t" +LeagueClubs.get(i).getPointTally());
           
        }
        System.out.println("*************************************************************");
                       System.out.println("Table Keys:");
                       System.out.println("GS: Goals Score");
                       System.out.println("GC:  Goal Conceived");
                       System.out.println("GD: Goal Difference");
                       System.out.println("PT: Points Accumulated");
    }
    
    public void topScorer()
    {
        int max = LeagueClubs.get(0).topStrikerGoals();
        int tracker = 0;
        for (int i = 0; i < LeagueClubs.size(); i++)
        {
            if (LeagueClubs.get(i).topStrikerGoals() > max)
            {
                max = LeagueClubs.get(i).topStrikerGoals();
                tracker = i;
            }
        }
        
        System.out.println("The Top Scorer in League is: " + LeagueClubs.get(tracker).revealTopStriker()+ " with " + max + " goals");
  
        // Golden Boot in League - Scores highest
    }
    
    public void bestGoalKeeper(){
        int max = LeagueClubs.get(0).cleansheet();
        int tracker = 0;
        for (int i = 0; i < LeagueClubs.size(); i++)
        {
            if (LeagueClubs.get(i).cleansheet() > max)
            {
                max = LeagueClubs.get(i).cleansheet();
                tracker = i;
            }
        }
        System.out.println("The Best Goalkeeper in the League is: " + LeagueClubs.get(tracker).getGoalkeeperName()+ " from " + LeagueClubs.get(tracker).getNameOfClub() + " who has " + max + " clean sheets");
        
    }
    
}
