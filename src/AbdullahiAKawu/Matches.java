package AbdullahiAKawu;

import java.util.*;
import java.time.LocalTime;
/**
 * This class represent the Matches played in the league. 
 * The class manages matches between clubs.
 * 
 * @Abdullahi Abubakar Kawu 
 * @30.10.2015
 */
public class Matches
{
   
    //Fields for Matches class
    private String matchvenue;
    private LocalTime matchtime;
    private ArrayList<Players> PlayersScoring;
    private String result;
    //private int matchnumber;
    private Clubs PlayingClub1;
    private Clubs PlayingClub2;
    private boolean status;
    private int clubonescore;
    private int clubtwoscore;
    private Leagues league;
    private int hrs;
    private int min;

    /**
     * Constructor for objects of class Matches
     */
    
    public Matches(String matchvenuex, int hours,int mins, Clubs club1, Clubs club2)
    {
        PlayersScoring = new ArrayList<Players>();
        matchvenue = matchvenuex;;
        PlayingClub1 = club1;
        PlayingClub2 = club2;
        status = false;
        clubonescore = 0;
        clubtwoscore = 0;
        hrs = hours;
        min = mins;
        matchtime = LocalTime.of(hours, mins);

       
    }

    /**
     * Sets the Time of Match;
     * @param hours, mins
     */
    
    public void setMatchTime(int hours, int mins)
    {
        matchtime = LocalTime.of(hours, mins);
    }

    /**
     * Sets the Venue or Place of Match;
     * @param matchvenuex - Match Venue
     */
    
    public void setMatchVenue(String matchvenuex)
    {
        matchvenue = matchvenuex;
    }
    
    /**
     * Gets the Venue of the Match;
     * @return Match Venue
     */
    
    public String getMatchVenue()
    {
        return matchvenue;
    }
    
    /**
     * Gets the Time of the Match;
     * @return getMatchTime
     */
    
    public LocalTime getMatchTime()
    {
        return matchtime;
    }
   
    /**
     * Setup the 1st Playing Club for matching;
     * @param PlayingClub1
     */
      
    public void set1stPlayingClub(Clubs club1)
    {
        PlayingClub1 = club1;
    }
    
    /**
     * Setup the 2nd Playing Club for matching;
     * @param PlayingClub2
     */
    public void set2ndPlayingClub(Clubs club2)
    {
        PlayingClub2 = club2;
    }
    
    /**
     * The 1st Playing Club for matching;
     * @return PlayingClub1
     */
    
    public Clubs get1stPlayingClub()
    {
        return PlayingClub1;
    }
    
    /**
     * The 2nd Playing Club for matching;
     * @return PlayingClub2
     */
    
    public Clubs get2ndPlayingClub()
    {
        return PlayingClub2;
    }
    
    /**
     * Setup Both Playing Clubs for the match;
     * @param club1, club2 - Playing Clubs to play the match
     */
    public void setPlayingClubs(Clubs club1, Clubs club2)
    {
        PlayingClub1 = club1;
        PlayingClub2 = club2;
    }
    
    
    /**
     * Displays on Console Both Playing Clubs for the match;
     * @return PlayingClubs - A String that displays both Playing Clubs for the match
     */
    
    public String getPlayingClubs()
    {
        String playingClubs = PlayingClub1.getNameOfClub() + " vs " + PlayingClub2.getNameOfClub();
        return playingClubs;
    }
    
    /**
     * Method to set Match as played
     * 
     */
    // Another method to indicate match has started
    public void setMatchAsEndedOrPlayed()
    {
        status = true;
         if (clubonescore > clubtwoscore)
         {
            PlayingClub1.addPointTally(3);
            
         }
         
          else if (clubonescore < clubtwoscore)
        {
            PlayingClub2.addPointTally(3);
            
        
        }
        
              
        else
        
        {
            
            PlayingClub1.addPointTally(1);
            PlayingClub2.addPointTally(1);
            
        }
      /*      
        if(clubonescore==0)
        {
            PlayingClub1.updateGoalKeeperCleanSheet();
        }
        
        else if (clubonescore==0)
        {
            PlayingClub2.updateGoalKeeperCleanSheet();
        }
    */
    }
   
    /**
     * Method to indicate status of match, whether ended or not ended.
     * @return status: match status, returns true if ended, false if otherwise.
     */
    
    public boolean getMatchStatus()
    {
        return status;
    }
    
    
    
   
   /**
    * This method is use to record that a player scored. It ensures that a player belongs to a Club Squad or a Team and that Club is in a League
    * It also updates other relevant variable like player's goal tally, clubs goals tally and conceded
    * @param p; p is an object of Players Class
    */
      
    public void playerScored(Players p)
    {
      if (status == true)
       {
        if ((PlayingClub1.checkPlayerInTeam(p) || PlayingClub1.checkPlayerInSquad(p)))
        {
             Players S = p;
            if (!PlayersScoring.contains(S))
                 {
                    S.resetGoalTally();
                    PlayersScoring.add(S);
                    
                }
            
            //p.addGoalTally();
            S.addGoalTally();
            PlayingClub1.addGoalScoredTally();
            PlayingClub2.addGoalConcededTally();
            //PlayingClub1.updatePlayerSquadGoal(p);
            //PlayingClub1.updatePlayerTeamGoal(p);
            clubonescore += 1;

            
        }
        
        else if ((PlayingClub2.checkPlayerInTeam(p) || PlayingClub2.checkPlayerInSquad(p)))
            {
                Players S = p;
                if (!PlayersScoring.contains(S))
                {
                   PlayersScoring.add(S);
                    S.resetGoalTally();
                 }
            
            //p.addGoalTally();
            S.addGoalTally();
            PlayingClub2.addGoalScoredTally();
            PlayingClub1.addGoalConcededTally();
            //PlayingClub2.updatePlayerSquadGoal(p);
            //PlayingClub2.updatePlayerTeamGoal(p);
            clubtwoscore += 1;
                
            }
        
        
        else
        {
        
        System.out.println("Player not in any of the playing clubs or not in this league");
       }
      }
       else {       System.out.println("Sorry, this match has ended");}
   }
     
    
   /**
     * Method to get the players who have played in a Match and those who scored;
     * Console to display all players in a club's team and those who scored in the match
     */
    
    //Players Scoring may not be record if team is not in the league. Match maybe assume to be casual   
   
    
    public void getPlayersPlayedAndGoals()
    {
        
        PlayingClub1.getPlayerInTeamOfAMatch();
        
        PlayingClub2.getPlayerInTeamOfAMatch();
        
        System.out.println("------------------------------------------------------------------");
        
        for (int i=0; i<PlayersScoring.size(); i++)
        {
            
            String playername = PlayersScoring.get(i).getPlayerName();
            int playergoals = PlayersScoring.get(i).getGoalTally();
            System.out.println(playername + " played in this match and scored " + playergoals + " goals");
            
        }
        
        
    }
    
    /**
     * Reveals match final score in the form of, or for example: "Newcastle Wins"
     * It also check the status of the match before providing this information.
     */
    
    public void MatchFinalScores()
        {
        String message;
        if (status == true)
        { 
          System.out.println(PlayingClub1.getNameOfClub() + " " + clubonescore+ " - " + clubtwoscore + " " + PlayingClub2.getNameOfClub());
         
        }
      
        else
       
          System.out.println("Match has not ended, please end match first");
         
    }

    
    /**
     * Method to reveal match result in the form or for example: "Newcastle Wins"
     * It also check the status of the match before providing this information. 
     */
    
    
    
       public void MatchResult() //Match may not have been played
    {
        if (status == true)
     {
        String message;
        if (clubonescore > clubtwoscore)
        {
            System.out.print(PlayingClub1.getNameOfClub() + " wins" + ") \n" );
                   
        }
         else if (clubonescore < clubtwoscore)
        {
            System.out.print(PlayingClub2.getNameOfClub() + " wins" +")\n" );
            
        }
        
               
        else if (clubonescore == clubtwoscore) 
        {
            
            System.out.print(" Its a draw" + PlayingClub1.getNameOfClub() + " " + clubonescore+ " - " + clubtwoscore + " " + PlayingClub2.getNameOfClub()+"\n"); 
            
        }
        
     }       
        else 
        {
            System.out.print(" Matched not yet played or still in progress, end it if you want to know the result " + PlayingClub1.getNameOfClub() + " " + clubonescore+ " - " + clubtwoscore+ " " + PlayingClub2.getNameOfClub()+"\n"); 
            
        }
    }
   
    /** Overidden method hashCode - Works with the overriden equals method to compare contents of two objects;
     * @return result:
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hrs;
        result = prime * result + min;
        result = prime * result + ((matchvenue == null) ? 0 : matchvenue.hashCode());
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
        
        if (!(obj instanceof Matches)) {
            return false;
        }
        
        Matches other = (Matches) obj;
        if (hrs != other.hrs) {
            return false;
        }

        if (min != other.min) {
            return false;
        }
        
        if (matchvenue == null) {
            if (other.matchvenue != null) {
                return false;
            }
        
        } else if (!matchvenue.equals(other.matchvenue)) {
            return false;
        }
        
       
        return true;
        
    }

}
