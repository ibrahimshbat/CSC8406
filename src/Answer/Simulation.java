
package Answer;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class to run simulation of the game.
 * @author Nursultan Kenenbayev
 * @version 22/10/2016
 */
public class Simulation{
	// The current match.
	private Match match;
	
	/**
	 * Construct a simulation setting its match
	 * @param match The match object that will be simulated
	 */
	public Simulation(Match match){
		this.match = match;
	}
	
	/**
	 * A method to simulate a football game with timer given 
	 */
	public void game(){
		// The counter for timer of the game
		int timer = 0;
		// The number of situation that might happen to player who has the ball
		String[] situations = {"shoot", "miss", "ball is taken", "pass"};
		// Get two clubs playing against each other
		Club club = match.getFirstClub();
		Club other = match.getSecondClub();
		// Find goalkeepers of two clubs from current team. 
		GoalKeeper goalkeeper = club.getGoalKeeper(match.getFirstTeam());
		GoalKeeper otherGoalkeeper = other.getGoalKeeper(match.getSecondTeam());
		// Hold club's current team
		ArrayList<Player> players = new ArrayList<Player>();
		// random
		Random rnd = new Random();
		System.out.println("Match started");
		System.out.println();
		
		// Until the timer reaches 30, the game will be played
		while (timer != 30){
			// Get random integer  
			int random = rnd.nextInt(4);
			// Chance for the first club
			if(random == 1){
				// Get all players for current team
				players = match.getFirstTeam();
				// Choose randomly a player but not goal keeper
				Player player = players.get(rnd.nextInt(players.size()));
				// If player is goal keeper choose again
				if(player instanceof GoalKeeper)
					player = players.get(rnd.nextInt(players.size()));
				// If ball is taken or player missed to score goal
				if(situations[rnd.nextInt(situations.length)] == "miss" 
						|| situations[rnd.nextInt(situations.length)] == "ball is taken"){
					//System.out.println(player.getName() + " from " + club.getName() + " missed chance to score");
					// Increment timer 
					timer++;
				}
				// Player gave a pass to player
				else if(situations[rnd.nextInt(situations.length)] == "pass"){
					System.out.println(player.getName() + " gave pass to " + players.get(rnd.nextInt(players.size())).getName());
					timer++;
				}
				// Ball is headed to the goal(goal keeper) 
				else{
					// call shoot method and randomise the result 
					// Pass information first club, the player who shoot the ball, and the opponent's goal keeper
					try {
						shoot(club, player, otherGoalkeeper);
					} catch (PlayerNotInClub e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					timer++;
				}
			}
			// Chance for the second club the opponent
			else if(random == 2){
				// Get all players for the current team
				players = match.getSecondTeam();
				//Randomly choose a player but not goalkeeper
				Player player = players.get(rnd.nextInt(players.size()));
				if(player instanceof GoalKeeper)
					player = players.get(rnd.nextInt(players.size()));
				// If the ball is taken or player have missed to score goal
				if(situations[rnd.nextInt(situations.length)] == "miss" 
						|| situations[rnd.nextInt(situations.length)] == "ball is taken"){
					System.out.println(player.getName() + " from " + other.getName() + " missed chance to score");
					timer++;
				}
				// Player gave a pass to player
				else if(situations[rnd.nextInt(situations.length)] == "pass"){
					System.out.println(player.getName() + " gave pass to " + players.get(rnd.nextInt(players.size())).getName());
					timer++;
				}
				// Ball is headed to the goal(goal keeper) 
				else{
					// call shoot method and randomise the result 
					// Pass information the opponent club, the player who shoot ball and the first club's goal keeper 
					try {
						shoot(other, player, goalkeeper);
					} catch (PlayerNotInClub e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					timer++;
				}
			}
			// No chance for two clubs to score
			else if(random == 0 || random == 3){
				System.out.println("There is a very tention between two clubs");
				timer++;
			}
		}
		// Once timer reached limit print out the result and record.
		System.out.println("The final score is " + match.getFinalScore());
		System.out.println(match.getFinalResult());
		System.out.println();
	}
	
	/**
	 * A method to randomise whether the ball headed to the goal is 
	 * passed through the goal keeper or not. In other words to randomise
	 * whether the goal keeper will save the ball or not.
	 * @param club The club object who is trying to score
	 * @param player The player object who shoot the ball
	 * @param goalKeeper The goal keeper who will try to catch the ball
	 * @throws PlayerNotInClub The exception that will be thrown if player is not in any of two clubs.
	 */
	private void shoot(Club club, Player player, GoalKeeper goalKeeper) throws PlayerNotInClub {
		//System.out.println(goalKeeper);
		Random rnd = new Random();
		// Situation whether goal keeper is saved ball or not.
		String[] situations = {"Goal", "Save"};
		// If goal keeper could not save the ball
		if(situations[rnd.nextInt(situations.length)] == "Goal"){
			// Record who scored the goal
			match.scoreGoal(player);
			// Print out who scored the goal 
			System.out.println("The player: " + player.getName() + " from " + club.getName() + " has scored the ball");
			// Print out the current score
			System.out.println("The score is " + match.getFirstClubScore() + " : " + match.getSecondClubScore());
		}
		// If goal keeper was able to save the ball.
		else{
			System.out.println("The goal keeper " + goalKeeper.getName()+ " from " + club.getName() + " saved the ball");
		}	
	}
	
	/**
	 * Return match to be recorded to played matches
	 * @return match in order record to played matches
	 */
	public Match getMatch(){
		return match;
	}
}
