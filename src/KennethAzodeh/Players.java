package KennethAzodeh;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Class to represent players in a club
 * 
 * @author Kenneth Azodeh.
 *
 */
public class Players {

	// The name of the player.
	private String name;
	// What type of player is being represented e.g. goalkeeper or outfield
	// player.
	private String type;
	// The height of the player in cm, initialised to 0.
	private double height = 0;
	// The date of birth of the player.
	private Date dob;
	// Sets the date format.
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	// How many goals the player has scored.
	private int goalTally = 0;

	/**
	 * Constructor for objects of the player class
	 * 
	 * @param name
	 *            The name of the player
	 * @param dob
	 *            The date of birth of the player
	 * @param height
	 *            The height of the player
	 * @param type
	 *            What type of player is being represented, e.g goalkeeper or
	 *            outfield player
	 * @throws ParseException
	 */
	public Players(String name, String dob, double height, String type) throws ParseException {
		this.name = name;
		this.dob = dateFormat.parse(dob);
		this.height = height;
		dateFormat.toString();
		this.setType(type);
	}

	/**
	 * 
	 * @param name
	 *            Sets the name of the player.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the player's date of birth.
	 * 
	 * @param dob
	 *            The date of birth of the player.
	 * @throws ParseException
	 */
	public void setDob(String dob) throws ParseException {
		this.dob = dateFormat.parse(dob);
	}

	/**
	 * @return The player's date of birth as a String.
	 */
	public String getDobAsString() {
		return dob.toString();
	}

	/**
	 * 
	 * @return The player's date of birth in the Date format.
	 */
	public Date getDobAsDate() {
		return dob;
	}

	/**
	 * Sets the height of the player.
	 * 
	 * @param height
	 *            The height of the player in centimetres.
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return The player's height as a double. To be used in the Clubs class to
	 *         calculate the average height a squad.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * 
	 * @return The height of the player in centimetres.
	 */
	public String getHeightInCm() {
		return height + "cm";
	}

	/**
	 * Method to add to that player's goal tally
	 * 
	 * @param goalTally
	 *            How many goals the player has scored
	 */
	public void addToGoalTally(int addGoalTally) {
		goalTally = goalTally + addGoalTally;
	}

	/**
	 * 
	 * @return The player's goal tally
	 */
	public int getGoalTally() {
		return goalTally;
	}

	/**
	 * 
	 * @return What kind of player is being represented
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            Set type of player being represented, e.g goalkeeper or
	 *            outfield player
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Method to calculate the age of the player by subtracting their birthday
	 * from today's date.
	 * 
	 * @return The age of the player.
	 */
	public int getAge() {
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.setTime(dob);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) <= dateOfBirth.get(Calendar.DAY_OF_YEAR))
			age--;
		return age;

	}
	
	/**
	 * Method to calculate the age of the player by subtracting their birthday
	 * from today's date.
	 * 
	 * @return The age of the player as a String with "years old" appended to it.
	 */
	public String getAgeAsString() {
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.setTime(dob);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) <= dateOfBirth.get(Calendar.DAY_OF_YEAR))
			age--;
		return age +" years old";

	}

}
