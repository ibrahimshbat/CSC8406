package Answer;
/**
 * A class that represents a goal keeper
 * Inherits from Player class
 * @author Nursultan Kenenbayev
 * @version 21/10/2015
 */
public class GoalKeeper extends Player{
	// number of times match won without any goals conceded
	private int cleanSheets = 0;
	// Number of goals that goal keeper let in
	private int goalsLetIn = 0;
	
	/**
	 * Construct a goal keeper, setting its initial information
	 * @param name The name of the goal keeper
	 * @param height The height of the goal keeper
	 * @param dateOfBirth The date of birth of the goal keeper
	 * @param position The position of the goal keeper
	 */
	public GoalKeeper(String name, double height, String dateOfBirth,
			Position position) {
		super(name, height, dateOfBirth, position);
	}
	
	/**
	 * Add the number of times match won without any goals conceded
	 * @param tally The number of times the match won without any goals let in
	 */
	public void addCleanSheets(int tally){
		cleanSheets = cleanSheets + tally;
	}
	
	/**
	 * Return number of times match won with clean sheets
	 * @return int number of times clean sheets.
	 */
	public int getCleanSheets(){
		return cleanSheets;
	}
	
	/**
	 * Add number of goals that goal keeper let in
	 * @param tally The number of goals let in
	 */
	public void addGoalsLetIn(int tally){
		goalsLetIn = goalsLetIn + tally;
	}
	
	/**
	 * Return number goals let in
	 * @return int goals goal keeper let in
	 */
	public int getGoalsLetIn(){
		return goalsLetIn;
	}
}
