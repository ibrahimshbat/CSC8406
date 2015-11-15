package KennethAzodeh;

import java.text.ParseException;

/**
 * The demo class which contains the main method to run the program.
 * 
 * @author Kenneth Azodeh.
 *
 */
public class DemoProgram {

	public static void main(String[] args) throws ParseException {

		// Create a new player
		Players newPlayer= new Players("Ken", "22/05/1994", 175, "outfield");
		// Expected output: Player Name: Ken
		System.out.println("Player name: " + newPlayer.getName());
		// Expected output: Age: 21 years old.
		System.out.println("Age: " + newPlayer.getAgeAsString());
		// Expected output: DOB: Sun May 22 1994
		System.out.println("DOB: " + newPlayer.getDobAsString());
		// Expected output: Height: 175.0cm
		System.out.println("Height: " + newPlayer.getHeightInCm());
		// Expected output: Type: outfield
		System.out.println("Type: " + newPlayer.getType());

		System.out.println();
		// New lines to separate output
		System.out.println("-------------------------------------------------------------");
		System.out.println();

		// Add 5 to the goal tally of the player
		newPlayer.addToGoalTally(5);
		// Expected output: Goal Tally: 5 goals
		System.out.println("Goal Tally: " + newPlayer.getGoalTally() + " goals");
		newPlayer.addToGoalTally(5);
		// Expected output: Goal Tally: 10 goals
		System.out.println("Goal Tally: " + newPlayer.getGoalTally() + " goals");

		// Change the player name
		newPlayer.setName("Ken Azodeh");
		try {
			// Change the player's date of birth
			newPlayer.setDob("30/01/2000");
		} catch (Exception e) {
			// TODO: handle exception
		}
		// Change the player's height
		newPlayer.setHeight(180.5);
		// Change the player type to 'goalkeeper'
		newPlayer.setType("goalkeeper");

		// Print new player attributes
		// Expected output: Player Name: Ken Azodeh
		System.out.println("Player Name: " + newPlayer.getName());
		// Expected output: Age: 15 years old.
		System.out.println("Age: " + newPlayer.getAgeAsString());
		// Expected output: DOB: Sun Jan 30 2000
		System.out.println("DOB: " + newPlayer.getDobAsString());
		// Expected output: 180.5cm
		System.out.println("Height: " + newPlayer.getHeightInCm());
		// Expected output: Type: goalkeeper
		System.out.println("Type: " + newPlayer.getType());
		
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		System.out.println();
		
		Clubs newClub = new Clubs("Arsenal");
		// Expected output: Club Name: Arsenal
		System.out.println("Club Name: " + newClub.getName());
		
		// Add an existing player to the club
		newClub.addPlayer(newPlayer);
		// Create and add new players to the club
		newClub.addPlayer(new Players("Mike", "15/06/1990", 150, "outfield"));
		newClub.addPlayer(new Players("Dave", "16/12/1988", 182.4, "outfield"));
		newClub.addPlayer(new Players("Liam", "29/01/1980", 162.3, "outfield"));
		newClub.addPlayer(new Players("George", "03/05/1990", 140.3, "outfield"));
		newClub.addPlayer(new Players("Stefan", "28/07/1995", 175.5, "outfield"));
		
		// Prints a list of all the players in the club
		System.out.println("Players in the club:");
		newClub.printPlayers();
		
		// Checks if the player ken is in the squad. Expected output: true
		System.out.println("Contains player called ken: " + newClub.findPlayer(newPlayer));

		// Add to goals scored by the club
		newClub.addGoalsScored(15);
		// Add to goals conceded by the club
		newClub.addGoalsConceded(10);
		// Expected output: 15 goals scored by the club
		System.out.println(newClub.getGoalsScored() + " goals scored by the club");
		// Expected output: 10 goals conceded by the club
		System.out.println(newClub.getGoalsConceded() + " goals conceded by the club");
		// Expected output: Goal Difference: 5
		System.out.println("Goal Difference: " + newClub.getGoalDifference());
		
		// Add to the points tally of the club
		newClub.addPoints(10);
		// Expected output: Points: 10
		System.out.println("Points: " + newClub.getPoints());
		
		// Find the average age of players in the club. Expected output: 24 years old
		System.out.println("Average age of squad: " + newClub.getAverageAge() + " years old");
		
		// Find the average height of players in the club. Expected output; 165.17cm
		System.out.println("Average height of squad: " + newClub.getAverageHeight() + "cm");
		
		Clubs newClub2 = new Clubs("Chelsea");
		
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
	
		// Creates a new match
		Matches newMatch = new Matches();
		
		newMatch.setClubsPlaying(newClub, newClub2);
		newMatch.setPlace("Wembley");
		// newMatch.setMatchTime(15, 30);
		
		System.out.println(newMatch.getFirstClub().toString() + " vs " + newMatch.getSecondClub().toString());
		System.out.println(newMatch.getPlace());
		// System.out.println(newMatch.getTime());
	}

}
