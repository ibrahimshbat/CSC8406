package Answer;
/**
 * The JUnit class to test all fields and methods of the Club class.
 * Whether the result as exoected or not
 * @author Nursultan Kenenbayev
 * @version 22/10/2015
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Answer.Club;
import Answer.Player.Position;

public class ClubTest {

	/**
	 * Test the method whether it constructs the object correctly
	 */
	@Test
	public void testClub() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		assertEquals("Arsenal", club.getName());
	}
	
	/**
	 * Test setName method and see if the method sets a new name 
	 * correctly.
	 */
	@Test
	public void testSetName() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		club.setName("arsenal");
		assertEquals("arsenal", club.getName());
	}
	
	/**
	 * Test getName method and see whether the method outputs 
	 * it right 
	 */
	@Test
	public void testGetName() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		assertEquals("Arsenal", club.getName());
	}
	
	/**
	 * Check whether the method records number of goals
	 * scored correctly. 
	 */
	@Test
	public void testAddGoalsScored() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		club.addGoalsScored(2);
		club.addGoalsScored(5);
		club.addGoalsScored(3);
		club.addGoalsScored(5);
		// Arsenal should have scored 15 goals
		assertEquals(15, club.getGoalsScored());
	}
	
	/**
	 * Test the method and see if it outputs the result
	 * as expected. 
	 */
	@Test
	public void testAddGoalsConceded() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		Player asmirBegovic = new GoalKeeper("Asmir Begovic", 1.75, "20/6/1987", Position.GOAL_KEEPER);
		club.addPlayer(asmirBegovic);
		club.getRandomPlayersForTeam();
		club.addGoalsConceded(1);
		club.addGoalsConceded(1);
		club.addGoalsConceded(1);
		club.addGoalsConceded(1);
		club.addGoalsConceded(1);
		assertEquals(5, club.getGoalsConceded());
	}
	
	/**
	 * Add players to current team and test whether it outputs 
	 * the correct result.
	 */
	@Test
	public void testAddPlayerToCurrentTeam(){
		Club chelsea = new Club("Arsenal", "Emirates Stadium");
		Player asmirBegovic = new GoalKeeper("Asmir Begovic", 1.75, "20/6/1987", Position.GOAL_KEEPER);
		Player cesarAzpilicueta = new Player("Cesar Azpilicueta", 1.78, "28/8/1989", Position.DEFENDER);
		Player garyCahill = new Player("Gary Cahill", 1.93, "19/12/1985", Position.DEFENDER);
		Player branislavIvanovic = new Player("Branislav Ivanovic", 1.85, "22/2/1984", Position.DEFENDER);
		Player johnTerry = new Player("John Terry", 1.87, "07/12/1980", Position.DEFENDER);
		Player oscar = new Player("Oscar", 1.79, "09/9/1991", Position.MIDFIELDER);
		Player pedro = new Player("Pedro", 1.85, "28/7/1987", Position.MIDFIELDER);
		Player ramires = new Player("Ramires", 1.80, "24/3/1987", Position.MIDFIELDER);
		Player willian = new Player("Willian", 1.75,  "09/8/1988", Position.MIDFIELDER);
		Player diegoCosta = new Player("Diego Costa", 1.80, "07/10/1988", Position.FORWARD);
		Player falcao = new Player("Falcao", 1.77, "10/2/1986", Position.FORWARD);
		// Add player to the squad
		chelsea.addPlayer(asmirBegovic);
		chelsea.addPlayer(willian);
		chelsea.addPlayer(cesarAzpilicueta);
		chelsea.addPlayer(garyCahill);
		chelsea.addPlayer(branislavIvanovic);
		chelsea.addPlayer(johnTerry);
		chelsea.addPlayer(oscar);
		chelsea.addPlayer(pedro);
		chelsea.addPlayer(ramires);
		chelsea.addPlayer(diegoCosta);
		chelsea.addPlayer(falcao);
		
		// Choose and add players to the current team
		chelsea.addPlayerToCurrentTeam(asmirBegovic);
		chelsea.addPlayerToCurrentTeam(willian);
		chelsea.addPlayerToCurrentTeam(cesarAzpilicueta);
		chelsea.addPlayerToCurrentTeam(garyCahill);
		chelsea.addPlayerToCurrentTeam(branislavIvanovic);
		chelsea.addPlayerToCurrentTeam(johnTerry);
		chelsea.addPlayerToCurrentTeam(oscar);
		chelsea.addPlayerToCurrentTeam(pedro);
		chelsea.addPlayerToCurrentTeam(ramires);
		chelsea.addPlayerToCurrentTeam(diegoCosta);
		chelsea.addPlayerToCurrentTeam(falcao);
		
		ArrayList<Player> club = new ArrayList<Player>();
		club.add(asmirBegovic);
		club.add(willian);
		club.add(cesarAzpilicueta);
		club.add(garyCahill);
		club.add(branislavIvanovic);
		club.add(johnTerry);
		club.add(oscar);
		club.add(pedro);
		club.add(ramires);
		club.add(diegoCosta);
		club.add(falcao);
		assertEquals(club, chelsea.getManuallySelectedTeam());
	}
	
	/**
	 * Test whether the method outputs the current team of the club
	 */
	@Test
	public void testGetManuallySelectedTeam() {
		Club chelsea = new Club("Arsenal", "Emirates Stadium");
		Player asmirBegovic = new GoalKeeper("Asmir Begovic", 1.75, "20/6/1987", Position.GOAL_KEEPER);
		Player cesarAzpilicueta = new Player("Cesar Azpilicueta", 1.78, "28/8/1989", Position.DEFENDER);
		Player garyCahill = new Player("Gary Cahill", 1.93, "19/12/1985", Position.DEFENDER);
		Player branislavIvanovic = new Player("Branislav Ivanovic", 1.85, "22/2/1984", Position.DEFENDER);
		Player johnTerry = new Player("John Terry", 1.87, "07/12/1980", Position.DEFENDER);
		Player oscar = new Player("Oscar", 1.79, "09/9/1991", Position.MIDFIELDER);
		Player pedro = new Player("Pedro", 1.85, "28/7/1987", Position.MIDFIELDER);
		Player ramires = new Player("Ramires", 1.80, "24/3/1987", Position.MIDFIELDER);
		Player willian = new Player("Willian", 1.75,  "09/8/1988", Position.MIDFIELDER);
		Player diegoCosta = new Player("Diego Costa", 1.80, "07/10/1988", Position.FORWARD);
		Player falcao = new Player("Falcao", 1.77, "10/2/1986", Position.FORWARD);
		// Add player to the squad
		chelsea.addPlayer(asmirBegovic);
		chelsea.addPlayer(willian);
		chelsea.addPlayer(cesarAzpilicueta);
		chelsea.addPlayer(garyCahill);
		chelsea.addPlayer(branislavIvanovic);
		chelsea.addPlayer(johnTerry);
		chelsea.addPlayer(oscar);
		chelsea.addPlayer(pedro);
		chelsea.addPlayer(ramires);
		chelsea.addPlayer(diegoCosta);
		chelsea.addPlayer(falcao);
		
		// Choose and add players to the current team
		chelsea.addPlayerToCurrentTeam(asmirBegovic);
		chelsea.addPlayerToCurrentTeam(willian);
		chelsea.addPlayerToCurrentTeam(cesarAzpilicueta);
		chelsea.addPlayerToCurrentTeam(garyCahill);
		chelsea.addPlayerToCurrentTeam(branislavIvanovic);
		chelsea.addPlayerToCurrentTeam(johnTerry);
		chelsea.addPlayerToCurrentTeam(oscar);
		chelsea.addPlayerToCurrentTeam(pedro);
		chelsea.addPlayerToCurrentTeam(ramires);
		chelsea.addPlayerToCurrentTeam(diegoCosta);
		chelsea.addPlayerToCurrentTeam(falcao);
		
		ArrayList<Player> club = new ArrayList<Player>();
		club.add(asmirBegovic);
		club.add(willian);
		club.add(cesarAzpilicueta);
		club.add(garyCahill);
		club.add(branislavIvanovic);
		club.add(johnTerry);
		club.add(oscar);
		club.add(pedro);
		club.add(ramires);
		club.add(diegoCosta);
		club.add(falcao);
		assertEquals(club, chelsea.getManuallySelectedTeam());
	}

	/**
	 * Check whether the method can find goal keeper and 
	 * output the result
	 */
	@Test
	public void testGetGoalKeeper() {
		Club club = new Club("arsenal", "Emirates Stadium");
		Player asmirBegovic = new GoalKeeper("Asmir Begovic", 1.75, "20/6/1987", Position.GOAL_KEEPER);
		club.addPlayer(asmirBegovic);
		assertEquals(asmirBegovic, club.getGoalKeeper(club.getSquad()));
	}

	/**
	 * Test whether the goal difference calculated in a right way.
	 */
	@Test
	public void testGetGoalDifference() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		club.addGoalsScored(2);
		club.addGoalsScored(5);
		club.addGoalsScored(3);
		club.addGoalsScored(5);
		Player asmirBegovic = new GoalKeeper("Asmir Begovic", 1.75, "20/6/1987", Position.GOAL_KEEPER);
		club.addPlayer(asmirBegovic);
		club.getRandomPlayersForTeam();
		club.addGoalsConceded(1);
		club.addGoalsConceded(1);
		
		assertEquals(13, club.getGoalDifference());
	}
	
	/**
	 * Check if points awarded is recorded 
	 * output it correctly
	 */
	@Test
	public void testGetPoints() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		club.addPoints(3);
		club.addPoints(3);
		club.addPoints(1);
		
		assertEquals(7, club.getPoints());
	}

	/**
	 * Check if points awarded is recorded correctly
	 */
	@Test
	public void testAddPoints() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		club.addPoints(3);
		club.addPoints(3);
		club.addPoints(2);
		
		assertEquals(8, club.getPoints());
	}
	
	/**
	 * Check if the method adds player or not
	 */
	@Test
	public void testAddPlayer() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		Player falcao = new Player("Falcao", 1.77, "10/2/1986", Position.FORWARD);
		club.addPlayer(falcao);
		
		assertEquals(true, club.findPlayer(falcao));
	}

	/**
	 * Test whether the method can find player within squad
	 */
	@Test
	public void testFindPlayer() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		Player willian = new Player("Willian", 1.75,  "09/8/1988", Position.MIDFIELDER);
		Player diegoCosta = new Player("Diego Costa", 1.80, "07/10/1988", Position.FORWARD);
		Player falcao = new Player("Falcao", 1.77, "10/2/1986", Position.FORWARD);
		club.addPlayer(falcao);
		club.addPlayer(diegoCosta);
		club.addPlayer(willian);
		
		assertEquals(true, club.findPlayer(willian));
		
	}
	
	/**
	 * Check whether squad of the club is output correctly
	 */
	@Test
	public void testGetSquad() {
		Club chelsea = new Club("Arsenal", "Emirates Stadium");
		Player asmirBegovic = new GoalKeeper("Asmir Begovic", 1.75, "20/6/1987", Position.GOAL_KEEPER);
		Player cesarAzpilicueta = new Player("Cesar Azpilicueta", 1.78, "28/8/1989", Position.DEFENDER);
		Player garyCahill = new Player("Gary Cahill", 1.93, "19/12/1985", Position.DEFENDER);
		Player branislavIvanovic = new Player("Branislav Ivanovic", 1.85, "22/2/1984", Position.DEFENDER);
		Player johnTerry = new Player("John Terry", 1.87, "07/12/1980", Position.DEFENDER);
		Player oscar = new Player("Oscar", 1.79, "09/9/1991", Position.MIDFIELDER);
		Player pedro = new Player("Pedro", 1.85, "28/7/1987", Position.MIDFIELDER);
		Player ramires = new Player("Ramires", 1.80, "24/3/1987", Position.MIDFIELDER);
		Player willian = new Player("Willian", 1.75,  "09/8/1988", Position.MIDFIELDER);
		Player diegoCosta = new Player("Diego Costa", 1.80, "07/10/1988", Position.FORWARD);
		Player falcao = new Player("Falcao", 1.77, "10/2/1986", Position.FORWARD);
		// Add player to the squad
		chelsea.addPlayer(asmirBegovic);
		chelsea.addPlayer(willian);
		chelsea.addPlayer(cesarAzpilicueta);
		chelsea.addPlayer(garyCahill);
		chelsea.addPlayer(branislavIvanovic);
		chelsea.addPlayer(johnTerry);
		chelsea.addPlayer(oscar);
		chelsea.addPlayer(pedro);
		chelsea.addPlayer(ramires);
		chelsea.addPlayer(diegoCosta);
		chelsea.addPlayer(falcao);
		
		ArrayList<Player> club = new ArrayList<Player>();
		club.add(asmirBegovic);
		club.add(willian);
		club.add(cesarAzpilicueta);
		club.add(garyCahill);
		club.add(branislavIvanovic);
		club.add(johnTerry);
		club.add(oscar);
		club.add(pedro);
		club.add(ramires);
		club.add(diegoCosta);
		club.add(falcao);
		
		assertEquals(club, chelsea.getSquad());
	}
	/**
	 * Test whether the calculation of average age is right or not
	 */
	@Test
	public void testGetAverageAge() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		Player oscar = new Player("Oscar", 1.79, "09/9/1991", Position.MIDFIELDER);
		Player diegoCosta = new Player("Diego Costa", 1.80, "07/10/1988", Position.FORWARD);
		Player falcao = new Player("Falcao", 1.77, "10/2/1986", Position.FORWARD);
		club.addPlayer(oscar);
		club.addPlayer(diegoCosta);
		club.addPlayer(falcao);
		
		//0.01 is the range where the result should be
		assertEquals(26.0, club.getAverageAge(), 0.01);
	}
	
	/**
	 * Test method whether it outputs the correct average 
	 * height of the given players. 
	 */
	@Test
	public void testGetAverageHeight() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		Player oscar = new Player("Oscar", 1.79, "09/9/1991", Position.MIDFIELDER);
		Player diegoCosta = new Player("Diego Costa", 1.80, "07/10/1988", Position.FORWARD);
		Player falcao = new Player("Falcao", 1.77, "10/2/1986", Position.FORWARD);
		club.addPlayer(oscar);
		club.addPlayer(diegoCosta);
		club.addPlayer(falcao);
		
		//0.01 is the range where the result should be
		assertEquals(1.786, club.getAverageHeight(), 0.01);
	}
	/**
	 * Test number of goals scored whether it returns the 
	 * same amount as expected.
	 */
	@Test
	public void testGetGoalsScored() {
		Club club = new Club("Arsenal","Emirates Stadium");
		club.addGoalsScored(2);
		club.addGoalsScored(5);
		club.addGoalsScored(3);
		club.addGoalsScored(5);
		
		assertEquals(15, club.getGoalsScored());
		
	}
	/**
	 * Test number of goals conceded whether the method 
	 * gets it right.
	 */
	@Test
	public void testGetGoalsConceded() {
		Club club = new Club("Arsenal", "Emirates Stadium");
		Player asmirBegovic = new GoalKeeper("Asmir Begovic", 1.75, "20/6/1987", Position.GOAL_KEEPER);
		club.addPlayer(asmirBegovic);
		club.getRandomPlayersForTeam();
		club.addGoalsConceded(1);
		club.addGoalsConceded(1);
		
		assertEquals(2, club.getGoalsConceded());
	}
	
	/**
	 * Test whether a club return its stadium name
	 */
	@Test
	public void testGetStadiumName(){
		Club club = new Club("Arsenal", "Emirates Stadium");
		assertEquals("Emirates Stadium", club.getStadiumName());
	}

}
