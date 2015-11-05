package Answer; 
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
/**
 * A club which holds the list of players in the squad and goals scored as well as goals conceded.
 * Points awarded for match is recorded also.
 * Additional task is to find average height and age of the players.
 * @author Nursultan Kenenbayev
 * @version 23/10/2015
 */
public class Club {
	// A name of the club.
	private String name;
	// The goals scored by a club.
	private int goalsScored = 0;
	// The goals conceded by a club.
	private int goalsConceded = 0;
	// The points received for match.
	private int points = 0;
	// The list of the players who play for a club
	private ArrayList<Player> squad;
	// The list of the players who play for current team.
	private ArrayList<Player> team;
	// The number of players should be in a current team.
	private int LIMIT = 11;
	// Club's stadium name
	private String stadiumName;
	
	/**
	 * Construct a Club, setting its name and stadium name,
	 * and initialising the array lists of objects
	 * @param name The name of the club
	 * @param stadiumName The name of the stadium of the club
	 */
	public Club(String name, String stadiumName){
		this.name = name;
		this.stadiumName = stadiumName;
		squad = new ArrayList<Player>();
		team = new ArrayList<Player>();
	}
	
	/**
	 * Set the name of the club
	 * @param name The name of the club.
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Return name of the club
	 * @return String name, the name of the club
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Add number of goals scored by a club
	 * @param tally The number of goals scored
	 */
	public void addGoalsScored(int tally){
		goalsScored = goalsScored + tally;
	}
	
	/**
	 * Add number of goals that club conceded as well as
	 * increment where appropriate goals let in or the number of clean sheets.
	 * @param tally The number of goals conceded
	 */
	public void addGoalsConceded(int tally){
		goalsConceded = goalsConceded + tally;
		// If match won without goals conceding
		if(tally == 0){
			// Increment the number of times goal keeper conceded no goal
			// Find goalkeeper from current team
			getGoalKeeper(team).addCleanSheets(1);;
		}
		else
			// Otherwise, increment by how many goals conceded.
			// Find goalkeeper from current team
			getGoalKeeper(team).addGoalsLetIn(tally);
	}
	
	/**
	 * Choose random players for the team to play with other clubs
	 * and return. 
	 * @return team, the array list of the player for the team
	 */
	public ArrayList<Player> getRandomPlayersForTeam(){
		// The counter of players for the positions.
		int forward = 0, midFielder = 0, defender = 0, goalkeeper=0;
		// Clear array list of previous players
		team.clear();
		// To randomly choose players, swap index of each element(player)
		Collections.swap(squad, 0, squad.size() - 1);
		// Choose player from squad
		for(Player player : squad){
			// We need 1 goal keeper
			if(player instanceof GoalKeeper && goalkeeper < 1){
				// Record that the this goal keeper will play in the next match
				team.add((GoalKeeper) player);
				goalkeeper++;
			}
			// Player will be added unless the number of players for this position is exceeded already
			// Increment the appropriate position by 1 when player is added
			else if(player.getPosition() == "Forward" && forward < 2){
				team.add(player);
				forward++;
				
			}
			else if(player.getPosition() == "Mid Fielder" && midFielder < 4){
				team.add(player);
				midFielder++;
			}
			else if(player.getPosition() == "Defender" && defender < 4){
				team.add(player);
				defender++;
			}
		}
		return team;
	}
	
	/**
	 * Choose players manually for the team to play with other clubs 
	 * @param player The player object
	 */
	public void addPlayerToCurrentTeam(Player player){
		// The counter of players for the positions.
		int forward = 0,midFielder = 0,defender = 0, goalKeeper=0;
		// We need goal keeper
		if(player instanceof GoalKeeper && goalKeeper < 1){
			team.add((GoalKeeper) player);
			goalKeeper++;
		}
		// Player will be added unless the number of players for this position is exceeded already
		// Increment the appropriate position by 1 when player is added
		else if(player.getPosition() == "Forward" && forward < 2){
			team.add(player);
			forward++;
		}
		else if(player.getPosition() == "Mid Fielder" && midFielder <4){
			team.add(player);
			midFielder++;
		}
		else if(player.getPosition() == "Defender" && defender < 4){
			team.add(player);
			defender++;
		}
		// if number of players reached 11
		else if(team.size() == LIMIT){
			System.out.println("The team constructed");
		}
		else
			System.out.println("The player for this position is already taken");
	}
	
	/**
	 * Return array list of players who are in current team
	 * @return team, the array list of the player who play for the team
	 */
	public ArrayList<Player> getManuallySelectedTeam(){
		return team;
	}
	
	/**
	 * Find goal keeper from given team array list.
	 * @param _team The team in which goalkeeper should be found 
	 * @return GoalKeeper goalKeeper, the goal keeper of the club.
	 */
	public GoalKeeper getGoalKeeper(ArrayList<Player> _team){
		GoalKeeper goalkeeper = null;
		for(Player player : _team){
			// If player is the goal keeper
			if( player instanceof GoalKeeper)
				goalkeeper = (GoalKeeper) player;
		}
		return goalkeeper;
	}
	
	/**
	 * Return goal difference 
	 * @return int goal difference
	 */
	public int getGoalDifference(){
		return goalsScored - goalsConceded;
	}
	
	/**
	 * Return number of points earned
	 * @return int points, the points that awarded for the club.
	 */
	public int getPoints(){
		return points;
	}
	
	/**
	 * Add points awarded to the club
	 * @param score The number of points
	 */
	public void addPoints(int score){
		points = points + score;
	}
	
	/**
	 * Add a new player to the club's squad
	 * @param player The player object
	 */
	public void addPlayer(Player player){
		squad.add(player);	
	}
	
	/**
	 * Find a player whether he is in a squad or not
	 * @param player The player object
	 * @return true if he is, false otherwise.
	 */
	public boolean findPlayer(Player player){
		boolean playerFound = false;
		for(int i = 0; i < squad.size();i++){
			if(squad.get(i) == player){
				playerFound = true;
				// if found player, exit the loop
				break;
			}
		}
		if(playerFound){
			return true;
		}
		else{
			return false;
		}
	}
	
	/** 
	 * Return array list of players who are in the squad
	 * @return squad, the array list of players who are in the squad
	 */
	public ArrayList<Player> getSquad(){
		return squad;
	}
	
	/**
	 * Return average of all player
	 * @return double average age of all players.
	 */
	public double getAverageAge(){
		int age = 0;
		int sum = 0;
		// Set calendar for default time zone and locale
		Calendar calendar = Calendar.getInstance();
		// Set calendar's time with the current date
		calendar.setTime(new Date());
		// Extract year from current date
		int currentYear = calendar.get(Calendar.YEAR);
		for(int i = 0; i < squad.size(); i++){
			// Set calendar time with date of birth of the player
			calendar.setTime(squad.get(i).getDateOfBirth());
			// Extract year birth of the player
			int yearBirth = calendar.get(Calendar.YEAR);
			age = currentYear - yearBirth;
			sum = sum + age;
		}
		// Limit number of decimals to 3 digits
		DecimalFormat numberFormat = new DecimalFormat("#.000");
		String result = numberFormat.format(sum / squad.size());
		return Double.parseDouble(result);
	}
	
	/**
	 * Return average height of the players
	 * @return double average height of players in club
	 */
	public double getAverageHeight(){
		double sum = 0.0;
		for(int i = 0; i < squad.size(); i++){
			sum = sum + squad.get(i).getHeight();
		}
		// Limit number of decimals to 3 digits
		DecimalFormat numberFormat = new DecimalFormat("#.000");
		String result = numberFormat.format(sum / squad.size());
		return Double.parseDouble(result);
	}
	
	/**
	 * Return the goals scored
	 * @return int goal scored so far
	 */
	public int getGoalsScored(){
		return goalsScored;
	}
	
	/**
	 * Return goals conceded
	 * @return int goals conceded so far.
	 */
	public int getGoalsConceded(){
		return goalsConceded;
	}
	
	/**
	 * Return stadium name of the club
	 * @return String name of the stadium
	 */
	public String getStadiumName(){
		return stadiumName;
	}
}
