package Answer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Collections;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
/**
 * A class which holds the number of clubs in the league,
 * and any club can be added to the league. This class
 * stores a number of matches to be played as well as the results
 * of played matches. Class enables to find top scorer, top team 
 * and best goal keeper from the league.
 * @author Nursultan Kenenbayev
 * @version 16/10/2015
 */
public class League{
	// A name of the league
	private String name;
	// An array list of clubs
	public ArrayList<Club> clubs;
	// An multi map of matches yet to be played
	private Multimap<Club, Club> matchesTobePlayed;
	// An array list of already played matches 
	private ArrayList<Match> playedMatches;
	// An array list of players' name and their reference
	private HashMap<String, Player> allPlayersInLeague;
	
	/**
	 * Construct a League and set its name.
	 * Initialise arrays needed for this class. 
	 * @param name The name of the league
	 */
	public League(String name){
		this.name = name;
		matchesTobePlayed = ArrayListMultimap.create();	
		playedMatches = new ArrayList<Match>();
		clubs = new ArrayList<Club>();
		allPlayersInLeague = new HashMap<String, Player>();
	}

	/**
	 * Return the name of the league
	 * @return String name, the name of the league.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the league name
	 * @param name The name of the league 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Add a new Club to the league
	 * @param club The club object
	 * @throws DuplicatePlayer The exception will be thrown 
	 * if duplicate player found in two or more clubs.
	 */
	public void addClub(Club club) throws DuplicatePlayer{
		boolean duplicateFound = false;
		for(Player player : club.getSquad()){
			// Check whether player's name is already added by previous club
			if(allPlayersInLeague.get(player.getName()) == null){
				// If not, add player's name to the hash map
				allPlayersInLeague.put(player.getName(), player);
			}
			else{
				// if yes, throw an exception
				duplicateFound = true;
				throw new DuplicatePlayer("Duplicate player found " + player.getName());
			}
		}
		// If duplicate is not found, add club to the league
		if(!duplicateFound){
			clubs.add(club);
		}
	}
	
	/**
	 * Add fixture to the league, a match yet to be played
	 * @param club The first club object
	 * @param opponent The opponent club object
	 */
	public void addFixture(Club club, Club opponent){
		matchesTobePlayed.put(club, opponent);
	}
	
	/**
	 * Find and return top team in the league
	 * @return string top team in the league
	 */
	public String findTopTeam(){
		int topPoint = 0;
		String topClub = "";
		int goalDifference = 0;
		for(Club club : clubs){
			if(club.getPoints() > topPoint){
				// Update the result if point is less than current club's point 
				topPoint = club.getPoints();
				// Update the name of the club
				topClub = club.getName();
				goalDifference = club.getGoalDifference();
			}
			// If comparing points are equal
			else if(club.getPoints() == topPoint){
				if(club.getGoalDifference() > goalDifference){
					topClub = club.getName();
					topPoint = club.getPoints();
				}
			}
		}
		return "The top team is " + topClub + ", they have earned " + topPoint + " points.";	
	}
	
	/**
	 * Find and return the top scorer in the league
	 * @return string top player in the league
	 */
	public String findTopScorer(){
		int topGoals = 0;
		String topPlayer = "";
		ArrayList<Player> players = new ArrayList<Player>();
		for(Club club : clubs){
			players = club.getSquad();
			for(Player player : players){
				if(player.getGoalTally() > topGoals){
					topGoals = player.getGoalTally();
					topPlayer = player.getName();
				}
			}
		}
		return "The top player is " + topPlayer + ", he scored " + topGoals + " goals";
	}
	
	/**
	 * Record played matches in the array list
	 * @param match The played match object
	 */
	public void addPlayedMatches(Match match){
		playedMatches.add(match);
	}
	
	/** 
	 * Return played matches in array list
	 * @return array list of played matches.
	 */
	public ArrayList<Match> getPlayedMatches(){
		return playedMatches;
	}
	
	/**
	 * Return clubs in the league
	 * @return Club clubs that are in the league
	 */
	public ArrayList<Club> getClubs(){
		return clubs;
	}
	
	/** 
	 * Return matches that will be played
	 * @return HashMap matches, the matches that will be played
	 */
	public Multimap<Club, Club> getMatchesToBePlayed(){
		return matchesTobePlayed;
	}
	
	/**
	 * Print league table.
	 */
	public void printLeagueTable(){
		// Sort array list, so that club with the highest point will be first.
		Collections.sort(clubs, new Comparator<Club>() {
			@Override
			public int compare(Club club, Club other) {
				// If the first club's point is higher than other
				// then the first club's index will be before the other's
				if(club.getPoints() > other.getPoints())
					return - 1;
				// the first club's index will after other's index
				else if(club.getPoints() < other.getPoints())
					return 1;
				else if(club.getPoints() == other.getPoints()){
					// If the first club's goal difference is higher than other
					// then the first club's index will be before the other's
					if(club.getGoalDifference() > other.getGoalDifference())
						return - 1;
					// the first club's index will after other's index
					else
						return 1;
				}
				// the index will not be changed
				return 0;
			}
		});
		// Print out league table
		System.out.println();
		System.out.println("                              The league table");
		System.out.println("=============================================================================================");
		System.out.println("|   Rank   |      Club       |  Points  |  Goals Scored | Goals Conceded  | Goal Difference |");
		System.out.println("=============================================================================================");
		int count = 1;
		for(Club club : clubs){
			String clubName = club.getName();
			// In order to make a league table prettier
			switch(clubName){
			case "Manchester City":
									System.out.printf("|    %02d    | %s |    %02d    |      %02d       |      %02d         |      %02d         |", count, club.getName(), 
													  club.getPoints(),club.getGoalsScored(),club.getGoalsConceded(), club.getGoalDifference());
									System.out.println();
									count++;
									break;
			case "Liverpool":
							System.out.printf("|    %02d    |    %s    |    %02d    |      %02d       |      %02d         |      %02d         |", count, club.getName(), 
											  club.getPoints(),club.getGoalsScored(),club.getGoalsConceded(), club.getGoalDifference());
							System.out.println();
							count++;
							break;
							
			case "Manchester United":
									System.out.printf("|    %02d    |%s|    %02d    |      %02d       |      %02d         |      %02d         |", count, club.getName(), 
													  club.getPoints(),club.getGoalsScored(),club.getGoalsConceded(), club.getGoalDifference());
									System.out.println();
									count++;
									break;
									
			default:
					System.out.printf("|    %02d    |    %s      |    %02d    |      %02d       |      %02d         |      %02d         |", count, club.getName(), 
									  club.getPoints(),club.getGoalsScored(),club.getGoalsConceded(), club.getGoalDifference());
					System.out.println();
					count++;

			}
		}
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Nominations for best player, goal keeper and club");
		System.out.println(findTopTeam());
		System.out.println(findTopScorer());
		System.out.println(findTopGoalKeeper());
	}
	
	/**
	 * Find and return the best goal keeper. 0 index will contain 
	 * the best goal keeper. 
	 * @return goalKeepers, the array list of goal keepers.
	 */
	public String findTopGoalKeeper(){
		ArrayList<GoalKeeper> goalKeepers = new ArrayList<GoalKeeper>();
		// Find goal keepers of the clubs and store in array list
		for(Club club : clubs){
			goalKeepers.add(club.getGoalKeeper(club.getSquad()));
		}
		// Sort array list to find best goal keeper
		Collections.sort(goalKeepers, new Comparator<GoalKeeper>(){
			@Override
			public int compare(GoalKeeper goalKeeper, GoalKeeper other) {
				// If this goal keeper clean sheet is bigger than other club's
				// Then this goal keeper will before the other's goal keeper
				if(goalKeeper.getCleanSheets() > other.getCleanSheets())
					return -1;
				// The other way around
				else if(goalKeeper.getCleanSheets() < other.getCleanSheets())
					return 1;
				// If clean sheets are equal
				else if(goalKeeper.getCleanSheets() == other.getCleanSheets()){
					// Sort in ascending order
					if(goalKeeper.getGoalsLetIn() < other.getGoalsLetIn())
						return -1;
					else
						return 1;
				}
				return 0;
			}
		});
		// If found goal keeper with clean sheets
		if(goalKeepers.get(0).getCleanSheets() != 0)
			return "The best goal keeper is " + goalKeepers.get(0).getName() + ", he saved match with clean sheet " + goalKeepers.get(0).getCleanSheets()
				+ " times";
		else
			return "The best goal keeper with clean sheets not found, the minumum goals let in is the goal keeper " + goalKeepers.get(0).getName() 
					+ " " + goalKeepers.get(0).getGoalsLetIn() + " goals." ; 
	}
	
}
