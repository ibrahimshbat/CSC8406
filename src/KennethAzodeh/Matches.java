package KennethAzodeh;

import java.util.ArrayList;

/**
 * Class to represent matches in the league.
 * 
 * @author Kenneth Azodeh.
 *
 */

public class Matches {
	// The time of the match.
	private String time;
	// Where the match is taking place.
	private String place;
	// The first team playing in the match.
	private String firstClub;
	// The second team playing in the match.
	private String secondClub;
	private String players;
	private String finalScore;
	private String finalResult;
	// Represents the hours in the match time.
	private NumberDisplay hours;
	// Represents the minutes in the match time.
	private NumberDisplay minutes;
	private int value;
	private int limit;
	// A list of all the clubs available.
	ArrayList<Clubs> clubsPlaying = new ArrayList<Clubs>();

	/**
	 * @return The time of the match.
	 */
	public String getTime() {
		updateDisplay();
		return time;
	}

	/**
	 * @param time
	 *            Sets the time of the match.
	 */
	public void setMatchTime(int hour, int minute) {
		hours.setValue(hour);
		minutes.setValue(minute);
		updateDisplay();
	}

	/**
	 * Set the value of the time to the new specified value. If the new value is
	 * less than zero or over the limit, do nothing.
	 */
	public void setValue(int replacementValue) {
		if ((replacementValue >= 0) && (replacementValue < limit)) {
			value = replacementValue;
		}
	}

	/**
	 * Update the internal string that represents the time.
	 */
	private void updateDisplay() {
		time = hours.getDisplayValue() + ":" + minutes.getDisplayValue();
	}

	/**
	 * Return the time value (that is, the current value as a two-digit String.
	 * If the value is less than ten, it will be padded with a leading zero).
	 */
	public String getDisplayValue() {
		if (value < 10) {
			return "0" + value;
		} else {
			return "" + value;
		}
	}

	/**
	 * @return The place where the match is being played.
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            Sets the place where the match will be played.
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return The first club playing in the match.
	 */
	public String getFirstClub() {
		return firstClub;

	}

	/**
	 * 
	 * @return The second club playing in the match.
	 */
	public String getSecondClub() {
		return secondClub;
	}

	/**
	 * @param clubsPlaying
	 *            Sets the clubs that are going to play in the match.
	 */
	public void setClubsPlaying(Clubs string, Clubs string2) {
		clubsPlaying.add(string);
		clubsPlaying.add(string2);
		firstClub = clubsPlaying.get(0).toString();
		secondClub = clubsPlaying.get(1).toString();
	}
	
	/**
	 * Print out the clubs playing in the match
	 */
	public void getClubsPlaying() {
		System.out.println(firstClub + " vs " + secondClub);
	}

//	public void recPlayer(Players a, int gScored)
//    for firstClub.
//    }
}

 
