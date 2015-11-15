package KennethAzodeh;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Class to represent clubs in the league.
 * 
 * @author Kenneth Azodeh.
 *
 */

public class Clubs {
	// The name of the club
	private String clubName;
	// The number of goals the club has scored, initialised to 0.
	private int goalsScored = 0;
	// The number of goals the club has conceded, initialised to 0.
	private int goalsConceded = 0;;
	// The number of goals scored minus the number of goals conceded.
	private int goalDifference;
	// The number of points the club has, initialised to 0.
	private int points = 0;
	// A list of players in the team.
	ArrayList<Players> squad = new ArrayList<Players>();

	/**
	 * 
	 * @param clubName
	 *            Creates and names a new club.
	 */
	public Clubs(String clubName) {
		this.clubName = clubName;

	}

	/**
	 * 
	 * @return The name of the club.
	 */
	public String getName() {
		return clubName;
	}

	/**
	 * 
	 * @return The number of goals scored by the club.
	 */
	public int getGoalsScored() {
		return goalsScored;
	}

	/**
	 * 
	 * @param goalsScored
	 *            Sets the number of goals scored by the club.
	 */
	public void addGoalsScored(int addGoals) {
		goalsScored = goalsScored + addGoals;
	}

	/**
	 * 
	 * @return The number of goals conceded by the club.
	 */
	public int getGoalsConceded() {
		return goalsConceded;
	}

	/**
	 * 
	 * @param goalsConceded
	 *            Sets the number of goals conceded by the club.
	 */
	public void addGoalsConceded(int addConcededGoals) {
		goalsConceded = goalsConceded + addConcededGoals;
	}

	/**
	 * 
	 * @return The goal difference of the club, calculated by deducting the
	 *         number of goals the club has conceded from the number of goals
	 *         the club has scored.
	 */
	public int getGoalDifference() {
		goalDifference = goalsScored - goalsConceded;
		return goalDifference;
	}

	/**
	 * 
	 * @param addPoints
	 *            Adds to the points tally of the club.
	 */
	public void addPoints(int addPoints) {
		points = points + addPoints;
	}

	/**
	 * 
	 * @return The points tally of the club.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Adds a player to the squad of the club.
	 * 
	 * @param p
	 */
	public void addPlayer(Players p) {
		squad.add(p);

	}

	/**
	 * Prints a list of all the players in the club.
	 */
	public void printPlayers() {
		for (Players m : squad) {
			System.out.println(m.getName());
		}
	}

	/**
	 * 
	 * @param string
	 *            The player object
	 * @return true if the player being searched for is in the club, else return
	 *         false if the player is not.
	 */
	public Boolean findPlayer(Players player) {
		{
			if (squad.contains(player))
				return true;
		}
		return false;

	}

	/**
	 * Calculates the average age of the squad by summing up all ages and then
	 * dividing by the total number of players in the squad.
	 * 
	 * @return The average age of the team.
	 */
	public int getAverageAge() {
		int totalAge = 0;
		for (Players m : squad) {
			totalAge = totalAge + m.getAge();
		}
		int averageAge = (totalAge / squad.size());
		return averageAge;
	}

	/**
	 * Calculates the average height of the team by summing up the total of all
	 * heights and then dividing by the total number of players in the team.
	 * 
	 * @return The average height of the team.
	 */
	public double getAverageHeight() {
		double totalHeight = 0;
		for (Players m : squad) {
			totalHeight = totalHeight + m.getHeight();
		}
		double averageHeight = (totalHeight / squad.size());
		DecimalFormat df = new DecimalFormat("#.##");
		averageHeight = Double.valueOf(df.format(averageHeight));
		return averageHeight;
	}

}
