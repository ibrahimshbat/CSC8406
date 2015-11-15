package MadalinaJuganariu;
import java.util.ArrayList;
/**
 * Store the details of a match such as place,current teams that are playing
 * the result and display the winner
 * @author (Madalina Juganariu) 
 * @version (26/10/2015)
 */
public class Match {
	// Variable to store the place of the match
	private String mPlace;
	//Arraylist to store the clubs playing in a match
	private ArrayList < Club > clubs = new ArrayList < Club > ();
	private int i;

	/**
	 * Constructor for objects of class Match
	 */
	public Match(String mPlace) {
		this.mPlace = mPlace;
	}
	/**
	 * Add an instance of the club class
	 * To the Match class
	 */
	public void addClub(Club club) {
		clubs.add(club);
	}
	/**
	 * List all players from a club
	 */
	public void recordPlayers() {

		for (Club club: clubs) {
			System.out.println("For" + " " +club.getClubName());
			club.listAllPlayers();
		}

	}
	/**
	 * Method to create a match between clubs
	 */
	public void playMatches() {
		i = 0;
		//loop through the array of clubs
		for (Club club: clubs) {
		    //increase the index so that a club doesnt play against itself
			i++;
			//loop through the clubs indexes
			for (int j = i; j < clubs.size(); j++) {
			    //print out the results of the game
				System.out.println("Result:" + " " + club.getClubName() + " " + club.getGoalsScored() + " " + clubs.get(j).getClubName() + " " + clubs.get(j).getGoalsScored());
				//call the method that lists all the players that have played in the match
				recordPlayers();
				//if one team has scored more goals than the other
				if (club.getGoalsScored() > clubs.get(j).getGoalsScored()) {
				    //increase its games won
					club.increaseWon();
					//increase the other team's games lost
					clubs.get(j).increaseLost();
					System.out.println("The winner is:" + " " + club.getClubName());
				} else if (club.getGoalsScored() < clubs.get(j).getGoalsScored()) {
				    //increase the other's team won
					clubs.get(j).increaseWon();
					//increase the other team's games lost
					club.increaseLost();
					System.out.println("The winner is:" + " " + clubs.get(j).getClubName());
				} else {
				    //if drawn increase both teams' games drawn 
					clubs.get(j).increaseDrawn();
					club.increaseDrawn();
					System.out.println("This game was a draw");
				}
				club.setGoalsConceded(clubs.get(j).getGoalsScored());
				clubs.get(j).setGoalsConceded(club.getGoalsScored());
				System.out.println();
			}

		}

	}
	/**
	 * Return the place of the match.
	 * @return The mPlace.
	 */
	public String matchPlace() {
		return mPlace;
	}
}