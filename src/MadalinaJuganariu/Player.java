package MadalinaJuganariu;
/**
 * Store the details of a football player,
 * such as the name, height, age and goal tally.
 * 
 * @author Madalina Juganariu
 * @version 21/10/2015
 */
public class Player {
	// Variable to store the player's name.
	private String pName;
	// Variable to store the player's height.
	private int height;
	// Variable to store the goal tally of a player.
	private int goalTally;
	// Variable to store the age of the player.
	private int age;
	/**
	 * Constructor for objects of class Player.
	 * @param pname The player's name. 
	 * @param height The player's height.
	 * @param goalTally The player's goal tally.
	 */
	public Player(String pName, int height, int goalTally, int age) {
		this.pName = pName;
		this.height = height;
		this.goalTally = goalTally;
		this.age = age;
	}

	/**
	 * Set the height of the player.
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * Set the age of the player.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * Set the name of the player.
	 */
	public void setName(String pName) {
		this.pName = pName;
	}

	/**
	 * Set the goal tally of the player.
	 */
	public void setGoalTally(int goalTally) {
		this.goalTally = goalTally;
	}
	/**
	 * Return the goal tally of the player.
	 * @return The goalTally.
	 */
	public int getGoalTally() {
		return goalTally;
	}
	/**
	 * Return the player's name.
	 * @return The pname.
	 */
	public String getName() {
		return pName;
	}
	/**
	 * Return the player's age.
	 * @return The age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Return the height.
	 * @return The height.
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Increase the goal tally of the player by 1 everytime this method is called
	 */
	public void increaseGoalTally() {
		goalTally++;

	}
}