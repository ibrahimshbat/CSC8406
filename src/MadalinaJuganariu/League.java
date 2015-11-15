package MadalinaJuganariu;
import java.util.ArrayList;
import java.util.*;

/**
 * Here a match and a club can be added. It also creates fixtures between all the clubs
 * in the league
 * Find the top team in the league and the top scorer
 * Print a league table
 * 
 * @author (Madalina Juganariu) 
 * @version (29/10/2015)
 */
public class League {
    // instance variables - replace the example below with your own
    private String leagueName;
    private ArrayList < Club > clubs = new ArrayList < Club > ();
    private ArrayList < Match > matches = new ArrayList < Match > ();
    private int i;

    /**
     * Constructor for objects of class League
     * Set the league name
     */
    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    /**
     * Return the league name
     * @return The leagueName
     */
    public String getLeagueName() {
        return leagueName;
    }
    /**
     * Set the league name
     */
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
    /**
     * Add a club to the league
     */
    public void addClub(Club club) {
        clubs.add(club);
    }
    public void addMatch(Match match) {
        matches.add(match);
    }
    /**
     * Create fixtures between all the clubs in the league
     */
    public void leagueFixtures() {
        i = 0;
        //loop through the array of clubs
        for (Club club: clubs) {
            //skip the first club so that it doesnt play with itself
            i++;
            for (int j = i; j < clubs.size(); j++) {
                System.out.println(club.getClubName() + " plays " + clubs.get(j).getClubName());

            }

        }

    }
    /**
     * Find top club in the league
     * @return max
     */
    public Club findTopTeam() {
        //create an aux club object for which it will later be assigned the top club
        Club max = new Club("top team");
        //loop through the array of clubs
        for (Club club: clubs) {
            //if one of the club from the array has a higher points tally
            if (max.getPoints() < club.getPoints()) {
                //assign the top club to the aux club
                max = club;
            }
        }
        //return the aux club which will be the top club
        return max;
    }
    /**
     * Print the league table
    */
    public void printLeagueTable(){
        //sort out the clubs
       Collections.sort(clubs);
       //loop through the new club order and dispay their data
      System.out.println("Premier League Top teams");
	   for(Club club: clubs){
	        // Display league table
            System.out.println("Club:" + " " +club.getClubName() + " " + "Points:" + " "+ club.getPoints()+ " " + "Played:" + " " + club.getPlayed()+ " " + "Conceded:"+ " " + club.getGoalsConceded()+ " " +"Scored:"+ " "+ club.getGoalsScored()+ " " +"Difference:"+ " " + club.getGoalDifference());
	   }

    }
    /**
     * Find top scorer in the league
     * @return maxScorer
     */
    public Player findTopScorer() {
        //create two aux players, one will store the top player from the club
        //the other will store the top scorer from all the club's top scorers
        Player maxScorer = new Player("top", 0, 0, 0);
        Player playerAux = new Player("top", 0, 0, 0);
        //loop through the array of clubs
        for (Club club: clubs) {
            //assign to the playerAux the top player from a club
            playerAux = club.getTopPlayer(); 
            if (maxScorer.getGoalTally() < playerAux.getGoalTally()) {
                maxScorer = playerAux;
            }

        }
        return maxScorer;
    }
}