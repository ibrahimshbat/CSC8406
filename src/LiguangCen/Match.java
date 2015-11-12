package LiguangCen;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * Store the detail of matches,
 * such as date, place, participators, result if it is played
 * 
 * unplayed match can be turned into played by adding details and result
 * 
 * @author Liguang Cen
 * @version 2015.10.29
 */
public class Match
{
    // instance variables - replace the example below with your own
    private Calendar matchDate;
    private String place;
    private ArrayList<Club> clubsInMatch;//index of 0 is home club, 1 is away club
    private Map<Club, Integer> records;
    private Map<Player, Integer> homeresult;
    private Map<Player, Integer> awayresult;
    private boolean isplayed;
    private String winnerclub;
    
    /**
     * Constructor for objects of class Match.
     * 
     * @param year Year of match date
     * @param month Month of match date
     * @param day Day of match date
     * @param hour Hour of match time
     * @param minute Minute of match time
     * @param place The place of where the match holds/held
     * @param homeclub The home team of participators
     * @param awayclub The away team of participators
     */
    public Match(int year, int month, int day, int hour, int minute, String place, Club homeclub, Club awayclub)
    {
        //initialie instance variables
        matchDate = Calendar.getInstance(); 
        matchDate.set(year, month, day, hour, minute);
        this.place = place;
        clubsInMatch = new ArrayList<Club>();
        records = new HashMap<Club, Integer>();
        homeresult = new HashMap<Player, Integer>();
        awayresult = new HashMap<Player, Integer>();
        clubsInMatch.add(homeclub);
        clubsInMatch.add(awayclub);
        isplayed = false;
    }

    /**
     * Set the date and time of a match
     * 
     * @param year Year of match date
     * @param month Month of match date
     * @param day Day of match date
     * @param hour Hour of match time
     * @param minute Minute of match time
     */
    public void setMatchTime(int year, int month, int day, int hour, int minute)
    {
        // put your code here
        matchDate.set(year, month, day, hour, minute);
    }
    
    /**
     * Return the match's date and time.
     * @return The match's date and time.
     */
    public Calendar getMatchTime()
    {
        return matchDate;
    }
    
    /**
     * Set the place of a match
     * 
     * @param newPlace New place of match holds
     */
    public void setMatchPlace(String newPlace)
    {
        place = newPlace;
    }
    
    /**
     * Return the match's place.
     * @return The match's place.
     */
    public String getMatchPlace()
    {
        return place;
    }
    
    /**
     * Return the match's status of played or unplayed.
     * @return The match's status of played or unplayed.
     */
    public boolean getIsPlayed()
    {
        return isplayed;
    }
    
    /**
     * The participators of the match.
     * @return The participators of the match.
     */
    public ArrayList<Club> getMatchClubs()
    {
        return clubsInMatch;
    }
    
    /**
     * Return the home team result including the players played in this game and how many goals individually.
     * @return The home team result including the players played in this game and how many goals individually.
     */
    public Map<Player, Integer> getHomeTeamResult()
    {
        return homeresult;
    }
    
    /**
     * Return the away team result including the players played in this game and how many goals individually.
     * @return The away team result including the players played in this game and how many goals individually.
     */
    public Map<Player, Integer> getAwayTeamResult()
    {
        return awayresult;
    }
    
    /**
     * Return the name of the winner club
     * @return The name of the winner club
     */
    public String getWinnerClub()
    {
        if(winnerclub != null)
        {
            return winnerclub;
        }
        return "To be started";
    }
    
    /**
     * Turn the unplayed match into played status.
     * Update the club point tally and players' goal records including keeper's tally.
     * @param homescored The goals of home team.
     * @param awayscored The goals of away team.
     * @param homeresult The individual records of home team in this match.
     * @param awayscored The individual records of away team in this match.
     * @param clubs The participated clubs that need to be updated.
     */
    public void playMatch(int homescored, int awayscored, Map<Player, Integer> homeresult, Map<Player, Integer> awayresult, ArrayList<Club> clubs) //reads from file!
    {
        isplayed = true;
        for(Club club : clubs)
        {
            if(club.getName().toLowerCase().equals(clubsInMatch.get(0).getName().toLowerCase()))//find home club in league clublist
            {
                club.addGoalScored(homescored);
                club.addGoalConceded(awayscored);
                records.put(club, homescored);
                if(homescored == awayscored)
                {
                    winnerclub = "even scored";
                    club.addPointTally(1);
                }
                else
                {
                    if(homescored > awayscored)
                    {
                        winnerclub = clubsInMatch.get(0).getName();
                        club.addPointTally(3);
                        if(awayscored == 0)
                        {
                            for(Player keeper : homeresult.keySet())
                            {
                                if(keeper.getIsKeeper())
                                {
                                    int keeperindex = 0;
                                    int tempint = 0;
                                    for(Player p : club.getSquad())//find the in-game keeper's index number in club squad
                                    {
                                        if(p.getName().toLowerCase().equals(keeper.getName().toLowerCase()))
                                        {
                                            keeperindex = tempint;
                                        }
                                        else
                                        {
                                            tempint++;
                                        }
                                    }
                                    //System.out.println(club.getSquad().size() + " " + keeperindex);
                                    GoalKeeper tempKeeper = (GoalKeeper)keeper;
                                    tempKeeper.addKeeperTally();
                                    
                                    club.getSquad().set(keeperindex, tempKeeper);
                                }
                            }
                        }
                            
                    }
                }
            }
            if(club.getName().toLowerCase().equals(clubsInMatch.get(1).getName().toLowerCase()))
            {
                club.addGoalScored(awayscored);
                club.addGoalConceded(homescored);
                records.put(club, awayscored);
                if(homescored == awayscored)
                {
                    club.addPointTally(1);
                }
                else
                {
                    if(awayscored > homescored)
                        {   
                            winnerclub = clubsInMatch.get(1).getName();
                            club.addPointTally(3);
                            if(homescored == 0)
                            {
                                for(Player keeper : awayresult.keySet())
                                {
                                    if(keeper.getIsKeeper())
                                    {
                                        
                                        keeper.addKeeperTally();
                                    }
                                }
                            }
                        }
                }
            }
        }

        this.homeresult = homeresult; //fields update
        this.awayresult = awayresult;
        for (Map.Entry<Player, Integer> entry : homeresult.entrySet()) //traverse map
        {
            for(Player player: clubsInMatch.get(0).getSquad()) //match home team
            {
                if(player.getName().toLowerCase().equals(entry.getKey().getName().toLowerCase())) //lookup player and update their goal tally
                {
                    player.addTally(entry.getValue());
                }
            }
                    
        }
        
        for (Map.Entry<Player, Integer> entry : awayresult.entrySet()) 
        {
            for(Player player: clubsInMatch.get(1).getSquad()) //match away team
            {
                if(entry.getKey().getName().toLowerCase().equals(player.getName().toLowerCase()))
                {
                    player.addTally(entry.getValue());
                }
            }
                    
        }
    }

    /**
     * @return The match result with goals on each team.
     */
    public Map<Club, Integer> getScore()
    {
        return records;
    }
    
    /**
     * Show the result of club and goals in this match.
     */
    public void displayResult()
    {
        for(Map.Entry<Club, Integer> entry : records.entrySet())
        {    
            
            System.out.println(entry.getKey().getName()+" ： "+entry.getValue());
        }
    }    
    
    /**
     * Show the records of players in each team and individual goals in this match.
     */
    public void displayGoal()
    {
        for(Map.Entry<Player, Integer> entry : homeresult.entrySet())
        {    
            System.out.println(entry.getKey().getName()+" ： "+entry.getValue());
        }
        System.out.println("---------------");
        for(Map.Entry<Player, Integer> entry : awayresult.entrySet())
        {    
            System.out.println(entry.getKey().getName()+" ： "+entry.getValue());
        }
    }
}
