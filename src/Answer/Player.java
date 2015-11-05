package Answer;
import java.text.*;
import java.util.Date;
/**
 * A class to create a player with the position in the field for a club.
 * Setting initial information about player
 * @author Nursultan Kenenbayev
 * @version 21/10/2015
 */
public class Player 
{
	/**
	 * Enum to set pre-defined positions for players.
	 */
	public enum Position{
		GOAL_KEEPER("Goal Keeper"), DEFENDER("Defender"), 
		MIDFIELDER("Mid Fielder"), FORWARD("Forward");
		// Position
		private final String POSITION;
		
		/**
		 * Construct position for the player	
		 * @param position The position of the player
		 */
		private Position(String position){
			this.POSITION = position;
		}
		
		/**
		 * @return position The position of the player in the field.
		 */
		public String getPosition(){
			return POSITION;
		}
	}
	// A player's name
	private String name;
	// Height of the player
	private double height;
	// Date of birth of the player
	private Date dateOfBirth;
	// The goal tally
	private int goalTally = 0;
	// The position of the player.
	private Position position;
	
	/**
	 * Construct a Player, setting its name, height, date of birth and position.
	 * @param name The name of the player
	 * @param height The height of the player
	 * @param dateOfBirth The date of birth of the player
	 * @param position The Position of the player
	 */
	public Player(String name, double height, String dateOfBirth, Position position){
		this.name = name;
		this.height = height;
		this.position = position;
		// Format of the date that should be converted to
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		try {
			// Try to parse string to actual date
			this.dateOfBirth = sdf.parse(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Return name of the player.
	 * @return String name, the name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of the player.
	 * @param name The name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Return height of the player
	 * @return double height, the height of the player.
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Set the height of the player.
	 * @param height The height of the player.
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Return date of birth of the player
	 * @return Date date, the date of birth of the player.
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Set the date of birth of the player
	 * @param dateOfBirth The date of birth of the player
	 */
	public void setDateOfBirth(String dateOfBirth) {
		// Format of the date that string should be converted to
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		try {
			// Try to parse string to an actual date
			this.dateOfBirth = sdf.parse(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Add the goal tally of a player
	 * @param tally The number of goals scored.
	 */
	public void addGoalTally(int tally){
		goalTally = goalTally + tally;
	}
	
	/**
	 * Return number of goals the player has scored so far.
	 * @return int goal, the number of goals scored the player
	 */
	public int getGoalTally(){
		return goalTally;
	}
	
	/**
	 * Change position of the player
	 * @param position The position of the player
	 */
	public void changePosition(Position position){
		this.position = position;
	}
	
	/**
	 * Return position of the player
	 * @return String position, the position of the player
	 */
	public String getPosition(){
		return position.getPosition();
	}
}
