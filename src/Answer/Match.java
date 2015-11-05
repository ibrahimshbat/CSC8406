package Answer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


/**
 * A class which sets the time and place of the current match
 * to be played. Also the clubs that will play against each other.
 * It records who played in the game and which player scored how many goals.
 * Finally the class gets final score and result of the current match.
 * @author Nursultan Kenenbayev
 * @version 21/10/2015
 */
public class Match {
	// A place where match will be played
	private String place;
	// The time when the match will start
	private Date startTime;
	// Club which should play
	private Club firstClub;
	// The against club which should play
	private Club secondClub;
	// Hash map to record number of players who played and how many goals each player scored.
	private HashMap<Player, Integer> playersPlayed;
	// Current score for two clubs
	private int score, scoreOpponent = 0;
	//Array list to store team of players of the clubs
	private ArrayList<Player> firstTeam;
	private ArrayList<Player> secondTeam;
	
	/**
	 * Construct a match, setting its time and place
	 * and also the clubs playing against each other.
	 * Initialise the array needed for this class.
	 * @param place The place of the match
	 * @param startTime The start time of the match
	 * @param club The first club who will play against other club
	 * @param opponent The opponent club who will play with first club
	 */
	public Match(String place, String startTime, Club club, Club opponent){
		this.place = place;
		this.firstClub = club;
		this.secondClub = opponent;
		playersPlayed = new HashMap<Player,Integer>();
		// First club's team
		firstTeam = club.getRandomPlayersForTeam();
		// The opponent club's team
		secondTeam = opponent.getRandomPlayersForTeam();
		// Format of the start time
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm");
		try {
			// Try to parse the string to an actual start time
			this.startTime = sdf.parse(startTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Return place of the match
	 * @return String place, place where match will be played
	 */
	public String getPlace() {
		return place;
	}
    
	/**
	 * Set place where match will be played
	 * @param place The place of the match
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * Return start time of the match
	 * @return Date start time of the match
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * Set start time of the match
	 * @param startTime The start time of the match
	 */
	public void setStartTime(String startTime) {
		// Format of the start time
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm");
		try {
			// Try to parse the string to an actual start time
			this.startTime = sdf.parse(startTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Record the list of players who will play in a match
	 */
	public void setGame(){
		// Add each player from the current team of each club
		// Set initially the number of goals for each player to 0
		for(Player player : firstTeam){
			playersPlayed.put(player, 0);
		}
		
		for(Player player : secondTeam){
			playersPlayed.put(player, 0);
		}
	}
	
	/**
	 * Return first club object
	 * @return Club club, the first club who is in the match
	 */
	public Club getFirstClub(){
		return firstClub;
	}
	
	/**
	 * Return opponent club object
	 * @return Club opponent, the opponent of first club in the match
	 */
	public Club getSecondClub(){
		return secondClub;
	} 
	
	/**
	 * Return the first club's team
	 * @return arraylist of players
	 */
	public ArrayList<Player> getFirstTeam(){
		return firstTeam;
	}
	
	/**
	 * Return the team of the opponent club
	 * @return array list of players
	 */
	public ArrayList<Player> getSecondTeam(){
		return secondTeam;
	}
	
	/**
	 * Return two clubs playing against each other
	 * @return string two clubs playing against each other
	 */
	public String getPlayingClubs(){
		return firstClub.getName() + " VS " + secondClub.getName();
	}
	
	/**
	 * Update hash map with the number of goals a player scored.
	 * @param player The player object
	 * @throws PlayerNotInClub The exception will be thrown if player is not in any of two clubs 
	 */
	public void scoreGoal(Player player) throws PlayerNotInClub{
		// Find player
		if(firstClub.findPlayer(player)){
			// Update current score for the club
			score++;
			// Update hash map with number of goals the player has scored
			playersPlayed.put(player, playersPlayed.get(player) + 1);
			// Record score to player goal tally
			player.addGoalTally(1);
		}
		else if(secondClub.findPlayer(player)){
			// Update current score for the club
			scoreOpponent++;
			// Update hash map with number of goals the player has scored
			playersPlayed.put(player, playersPlayed.get(player) + 1);
			// Record score to player goal tally
			player.addGoalTally(1);
		}
		// Not found player in clubs
		else
			throw new PlayerNotInClub("The player is not present in any of the clubs");
	}
	
	/**
	 * Return first club's score 
	 * @return int score, the first club's score so far
	 */
	public int getFirstClubScore(){
		return score;
	}
	
	/**
	 * Return opponent club score
	 * @return int scoreOpponent, the opponent club's score so far
	 */
	public int getSecondClubScore(){
		return scoreOpponent;
	}
	
	/**
	 * Return final score of the match
	 * @return String final score of the current match
	 */
	public String getFinalScore(){
		return firstClub.getName() + " " + score + "-" + scoreOpponent + " " + secondClub.getName();
	}
	
	/**
	 * Return final result of the match
	 * @return string final result of the current match
	 */
	public String getFinalResult(){
		System.out.println("Final Score: " + score +":"+scoreOpponent);
		// First club won
		if(score > scoreOpponent){
			// Record the number of goals scored and conceded.
		    // And the number of points gained
			firstClub.addPoints(3);
			firstClub.addGoalsScored(score);
			firstClub.addGoalsConceded(scoreOpponent);
			secondClub.addGoalsScored(scoreOpponent);
			secondClub.addGoalsConceded(score);
			return firstClub.getName() + " Won";
		}
		// The opponent club won
		else if (score < scoreOpponent){
			// Record the number of goals scored and conceded.
		    // And the number of points gained
			secondClub.addPoints(3);
			firstClub.addGoalsScored(score);
			firstClub.addGoalsConceded(scoreOpponent);
			secondClub.addGoalsScored(scoreOpponent);
			secondClub.addGoalsConceded(score);
			return secondClub.getName() + " Won";
		}
		// Draw
		else{
			// Record the number of goals scored and conceded.
		    // And the number of points gained
			firstClub.addPoints(1);
			secondClub.addPoints(1);
			secondClub.addGoalsScored(scoreOpponent);
			secondClub.addGoalsConceded(score);
			firstClub.addGoalsScored(score);
			firstClub.addGoalsConceded(scoreOpponent);
			return "Draw";
		}
	}
	
	/**
	 * Return players played in this match
	 * @return players played in this match
	 */
	public HashMap<Player,Integer> getPlayers(){
		return playersPlayed;
	}
}
