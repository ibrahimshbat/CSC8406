package LiguangCen;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
/**
 * A class holds all details of a league including matches and clubs.
 * It can play a specified match and update details or manage clubs in this league.
 * Initially read club data and match data from files.
 * *
 * @author Liguang Cen 
 * @version 2015.10.29
 */
public class League
{
    private String name;
    private ArrayList<Club> clubs;
    private ArrayList<Match> matches;
    private DataReader reader;
    private int clubMaxNumber;

    /**
     * Constructor for objects of class League
     * Intialized and read data from two folders of
     * clublist and matchlist.
     * 
     * @param name The name of the league
     * @param max The maximum number of clubs in the league
     */
    public League(String name, int max)
    {
        // initialise instance variables
        clubs = new ArrayList<Club>();
        matches = new ArrayList<Match>();
        reader = new DataReader();
        this.name = name;
        this.clubMaxNumber = max;
        readClubData("clublist");
        readMatchData("matchlist");
    }

    /**
     * Set the name of the league
     * 
     * @param newName The new name of this league
     */
    public void setName(String newName)
    {
        // put your code here
        name = newName;
    }
    
    /**
     * @return The name of the league.
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
    /**
     * Add a club into this league.
     * 
     * @param club The club need to be added.
     */
    public void addClub(Club club)
    {
        if(clubs.size()== clubMaxNumber)
        {
            throw new StackOverflowError(
                "Clubs overloaded, The stack of clubs is full.");
        }
        clubs.add(club);
    }
    
    /**
     * @return The list of clubs in this league.
     */
    public ArrayList<Club> getClubs()
    {
        return clubs;
    }
    
    /**
     * Add a new match in league's record.
     * @param match The match need to be added.
     */
    public void addFixture(Match match)
    {
        matches.add(match);
    }
    
    /**
     * Turn a match from unplayed into played status, and update the involing details in clubs and players
     * @param match The match need to be updated.
     * @param homescored The goals of home team.
     * @param awayscored The goals of away team.
     * @param homeresult The individual records of home team in this match.
     * @param awayscored The individual records of away team in this match.
     * @param clubs The participated clubs that need to be updated.
     */
    public void playMatch(Match match, int homescored, int awayscored, Map<Player, Integer> homeresult, Map<Player, Integer> awayresult, ArrayList<Club> clubs)
    {
        match.playMatch(homescored, awayscored, homeresult, awayresult, clubs);
    }
    
    /**
     * Display every club in this league.
     */
    public void listClubs()
    {
        for(int i=0; i<clubs.size();i++)
        {
            System.out.println(clubs.get(i).getName());
        }
    }
    
    /**
     * @return The list of matches.
     */
    public ArrayList<Match> getMatch()
    {
        return matches;
    }
    
    /**
     * Find the top team in the league, if there are clubs with same points
     * then sort by goal difference.
     * @return The club has highest points in the league.
     */
    public Club findTopTeam()
    {
        Club topteam = null;
        int temppoint = 0;
        ArrayList<Club> topclubs = new ArrayList<Club>();
        for(Club club : clubs)
        {
            if(club.getPointTally()>temppoint)
            {
                temppoint = club.getPointTally();
                topteam = club;
            }
        }
        for(Club club : clubs)
        {
            if(club.getPointTally()==temppoint)
            {
                topclubs.add(club);
            }
        }
        if(topclubs.size() > 1)
        {
            int tempdifference = topteam.getGoalDifference();
            for(Club club : clubs)
            {   
                if(club.getGoalDifference() > tempdifference)
                {
                    topteam = club;
                }
            }
        }
        return topteam;
    }
    
    /**
     * Display the match table.
     */
    public void printMatchTable()
    {
        for(Match match : matches)
        {
            String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(match.getMatchTime().getTime());
            System.out.println(str);
            System.out.println("Place: " + match.getMatchPlace());
            System.out.println(match.getMatchClubs().get(0).getName() + "vs." + match.getMatchClubs().get(1).getName());
            if(match.getIsPlayed())
            {
                System.out.println(match.getScore().get(match.getMatchClubs().get(0)) + " : " + match.getScore().get(match.getMatchClubs().get(1)));
                System.out.println("Status: Completed");
                System.out.println("Winner: " + match.getWinnerClub());
            }
            else
            {
                System.out.println("Status: To be started");
            }
            System.out.println("*************************************");
        }
    }
    
    /**
     * Find the golden boot in this league among all clubs
     * @return The player who are most scored
     */
    public Player findTopScorer()
    {
        Player topscorer = null;
        int highestscored = 0;
        for(Club club : clubs)
        {
            for(Player player : club.getSquad())
            {
                if(player.getTally() > highestscored)
                topscorer = player;
                highestscored = player.getTally();
            }
        }
        return topscorer;
    }
    
    /**
     * Club reader initializer, read files with specified suffix.
     * @param folderName The folder contains the match details. 
     */
    public void readClubData(String folderName)
    {
        ArrayList<Club> tempClubs = reader.readClubs(folderName, ".txt");

        // Put all thetracks into the organizer.
        for(Club club : tempClubs) {
            addClub(club);
        }
    }
    
    /**
     * Display the golden boot's name and number of scored.
     */
    public void displayGoldenBoot()
    {
        Player goldenBoot = null;
        int temptally = 0;
        for(Club club : clubs)
        {
            for(Player player : club.getSquad())
            {
                if(player.getTally() > temptally)
                {
                    temptally = player.getTally();
                    goldenBoot = player;
                }
            }
        }
        System.out.println(goldenBoot.getName() + " scored: " + temptally);
    }
    
    public void displayClubList()
    {
        for(Club club : clubs)
        {
            System.out.println(club.getName());
        }
    }
    
    /**
     * Display the best keeper's name and tally number in this league.
     */
    public void displayBestKeeper()
    {
        GoalKeeper bestkeeper = null;
        int temptally = 0;
        for(Club club : clubs)
        {
            for(Player player : club.getSquad())
            {
                if(player instanceof GoalKeeper)
                {
                    if(((GoalKeeper)player).getKeeperTally() > temptally)
                    {
                        temptally = ((GoalKeeper)player).getKeeperTally();
                        bestkeeper = (GoalKeeper)player;
                    }
                }
            }
        }
        System.out.println(bestkeeper.getName() + " keeper tally: " + temptally);
                    
    }
    
    /**
     * Display the descending league table.
     */
    public void displayLeagueTable()
    {
        Comparator<Club> comparator = new Comparator<Club>(){
            public int compare(Club c1, Club c2) {
                //point first
                if(c1.getPointTally()!=c2.getPointTally()){
                    return c2.getPointTally()-c1.getPointTally();
                }
                else{
                    //same point, then order by goal difference
                    return c2.getGoalDifference()-c1.getGoalDifference();
                }
            }
        };
        Collections.sort(clubs,comparator);
        for(Club club : clubs)
        {
            System.out.println(club.getName() + "; " + club.getPointTally() + "; " + club.getGoalDifference());
        }
    }
    
    /**
     * Match reader initializer, read files with specified suffix.
     * @param folderName The folder contains the match details.
     */
    public void readMatchData(String folderName)
    {
        ArrayList<Match> tempMatches = reader.readMatches(folderName, ".txt",clubs);

        // Put all thetracks into the organizer.
        for(Match match : tempMatches) {
            addFixture(match);
        }
    }
    
}
