package Answer;
/**
 * The JUnit class to test all fields and methods of the Match class.
 * Whether the result as exoected or not
 * @author Nursultan Kenenbayev
 * @version 22/10/2015
 */
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.junit.Test;

import Answer.Club;
import Answer.Player.Position;

public class MatchTest {

	/**
	 * Check if match object is constructed in a right 
	 * way. 
	 * @throws ParseException The exception that will be thrown
	 */
	@Test
	public void testMatch() throws ParseException {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		Player davidOspina = new GoalKeeper("David Ospina", 1.80, "31/8/1988", Position.GOAL_KEEPER);
		Player kieranGibbs = new Player("Kieran Gibbs", 1.75, "26/9/1986", Position.DEFENDER);
		Player nachoMonreal = new Player("Nacho Monreal", 1.82, "21/5/1993", Position.DEFENDER);
		Player gabriel = new Player("Gabriel", 1.73, "26/11/1990", Position.DEFENDER);
		Player hectorBellerin = new Player("Hector Bellerin", 1.86, "19/3/1995", Position.DEFENDER);
		Player tomasRosicky = new Player("Tomas Rosicky", 1.85, "04/10/1980", Position.MIDFIELDER);
		Player mikelArteta = new Player("Mikel Arteta", 1.70, "26/3/1982", Position.MIDFIELDER);
		Player santiCazorla  = new Player("Santi Cazorla", 1.95,  "13/12/1984", Position.MIDFIELDER);
		Player mesutOzil = new Player("Mesut Ozil", 1.80, "15/10/1988", Position.MIDFIELDER);
		Player alexis = new Player("Alexis", 1.75, "19/12/1988", Position.FORWARD);
		
		Club arsenal = new Club("Arsenal", "Emirates Stadium");
		arsenal.addPlayer(nursultan);
		arsenal.addPlayer(santiCazorla);
		arsenal.addPlayer(davidOspina);
		arsenal.addPlayer(kieranGibbs);
		arsenal.addPlayer(nachoMonreal);
		arsenal.addPlayer(gabriel);
		arsenal.addPlayer(hectorBellerin);
		arsenal.addPlayer(tomasRosicky);
		arsenal.addPlayer(mikelArteta);
		arsenal.addPlayer(mesutOzil);
		arsenal.addPlayer(alexis);
		
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
		
		Club chelsea = new Club("Chelsea", "Stamford Bridge");
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm");
		Match match = new Match("Old Trafford", "12/10/2015 14:55", arsenal, chelsea);
		
		// Check whether the object is constructed correctly
		assertEquals("Old Trafford", match.getPlace());
		assertEquals(sdf.parse("12/10/2015 14:55"), match.getStartTime());
		assertEquals(arsenal, match.getFirstClub());
		assertEquals(chelsea, match.getSecondClub());
		assertEquals("Arsenal VS Chelsea", match.getPlayingClubs());
		
	}
	
	/**
	 * Test the method whether it records it in the right way
	 * @throws PlayerNotInClub The exception that will be thrown.
	 */
	@Test
	public void testScoreGoal() throws PlayerNotInClub{
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		Player davidOspina = new GoalKeeper("David Ospina", 1.80, "31/8/1988", Position.GOAL_KEEPER);
		Player kieranGibbs = new Player("Kieran Gibbs", 1.75, "26/9/1986", Position.DEFENDER);
		Player nachoMonreal = new Player("Nacho Monreal", 1.82, "21/5/1993", Position.DEFENDER);
		Player gabriel = new Player("Gabriel", 1.73, "26/11/1990", Position.DEFENDER);
		Player hectorBellerin = new Player("Hector Bellerin", 1.86, "19/3/1995", Position.DEFENDER);
		Player tomasRosicky = new Player("Tomas Rosicky", 1.85, "04/10/1980", Position.MIDFIELDER);
		Player mikelArteta = new Player("Mikel Arteta", 1.70, "26/3/1982", Position.MIDFIELDER);
		Player santiCazorla  = new Player("Santi Cazorla", 1.95,  "13/12/1984", Position.MIDFIELDER);
		Player mesutOzil = new Player("Mesut Ozil", 1.80, "15/10/1988", Position.MIDFIELDER);
		Player alexis = new Player("Alexis", 1.75, "19/12/1988", Position.FORWARD);
		
		Club arsenal = new Club("Arsenal", "Anfield");
		arsenal.addPlayer(nursultan);
		arsenal.addPlayer(santiCazorla);
		arsenal.addPlayer(davidOspina);
		arsenal.addPlayer(kieranGibbs);
		arsenal.addPlayer(nachoMonreal);
		arsenal.addPlayer(gabriel);
		arsenal.addPlayer(hectorBellerin);
		arsenal.addPlayer(tomasRosicky);
		arsenal.addPlayer(mikelArteta);
		arsenal.addPlayer(mesutOzil);
		arsenal.addPlayer(alexis);
		
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
		
		Club chelsea = new Club("Chelsea", "Stamford Bridge");
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
		
		Match match = new Match("Old Trafford", "12/10/2015 14:55", arsenal, chelsea);
		match.setGame();
		match.scoreGoal(falcao);
		
		// Falcao should score one goal
		assertEquals(1, falcao.getGoalTally());
	}
	
	/**
	 * Check if player is not in any of two clubs playing,
	 * If not the method should throw an exception
	 * @throws PlayerNotInClub The exception that will be thrown
	 */
	
	@Test(expected = PlayerNotInClub.class)
	public void testThrowExceptionOnScoreGoal() throws PlayerNotInClub{
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		Player davidOspina = new GoalKeeper("David Ospina", 1.80, "31/8/1988", Position.GOAL_KEEPER);
		
		Club arsenal = new Club("Arsenal", "Anfield");
		arsenal.addPlayer(nursultan);
		arsenal.addPlayer(davidOspina);
		
		Player asmirBegovic = new GoalKeeper("Asmir Begovic", 1.75, "20/6/1987", Position.GOAL_KEEPER);
		Player cesarAzpilicueta = new Player("Cesar Azpilicueta", 1.78, "28/8/1989", Position.DEFENDER);
		Player falcao = new Player("Falcao", 1.77, "10/2/1986", Position.FORWARD);
		
		Club chelsea = new Club("Chelsea", "Stamford Bridge");
		chelsea.addPlayer(asmirBegovic);
		chelsea.addPlayer(cesarAzpilicueta);
		
		Match match = new Match("Old Trafford", "12/10/2015 14:55", arsenal, chelsea);
		match.setGame();
		match.scoreGoal(falcao);
	}
	
	/**
	 * Test whether the method holds correct information
	 * about clubs score. 
	 * @throws PlayerNotInClub the exception that will be thrown
	 */
	@Test
	public void testGetClubsScore() throws PlayerNotInClub{
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		Player davidOspina = new GoalKeeper("David Ospina", 1.80, "31/8/1988", Position.GOAL_KEEPER);
		Player kieranGibbs = new Player("Kieran Gibbs", 1.75, "26/9/1986", Position.DEFENDER);
		Player nachoMonreal = new Player("Nacho Monreal", 1.82, "21/5/1993", Position.DEFENDER);
		Player gabriel = new Player("Gabriel", 1.73, "26/11/1990", Position.DEFENDER);
		Player hectorBellerin = new Player("Hector Bellerin", 1.86, "19/3/1995", Position.DEFENDER);
		Player tomasRosicky = new Player("Tomas Rosicky", 1.85, "04/10/1980", Position.MIDFIELDER);
		Player mikelArteta = new Player("Mikel Arteta", 1.70, "26/3/1982", Position.MIDFIELDER);
		Player santiCazorla  = new Player("Santi Cazorla", 1.95,  "13/12/1984", Position.MIDFIELDER);
		Player mesutOzil = new Player("Mesut Ozil", 1.80, "15/10/1988", Position.MIDFIELDER);
		Player alexis = new Player("Alexis", 1.75, "19/12/1988", Position.FORWARD);
		
		Club arsenal = new Club("Arsenal", "Emirates Stadium");
		arsenal.addPlayer(nursultan);
		arsenal.addPlayer(santiCazorla);
		arsenal.addPlayer(davidOspina);
		arsenal.addPlayer(kieranGibbs);
		arsenal.addPlayer(nachoMonreal);
		arsenal.addPlayer(gabriel);
		arsenal.addPlayer(hectorBellerin);
		arsenal.addPlayer(tomasRosicky);
		arsenal.addPlayer(mikelArteta);
		arsenal.addPlayer(mesutOzil);
		arsenal.addPlayer(alexis);
		
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
		
		Club chelsea = new Club("Chelsea", "Stamford Bridge");
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
		
		Match match = new Match("Old Trafford", "12/10/2015 14:55", arsenal, chelsea);
		match.setGame();
		match.scoreGoal(alexis);
		match.scoreGoal(mesutOzil);
		match.scoreGoal(falcao);
		// Arsenal should have 2 goals scored
		assertEquals(2, match.getFirstClubScore());
		// Chelsea should have 1 goal scored
		assertEquals(1, match.getSecondClubScore());
	}

	/**
	 * Test whether the class records and outputs the final score
	 * and final result.
	 * @throws PlayerNotInClub The exception that will be thrown
	 */
	@Test
	public void testGetFinalScoreAndFinalResult() throws PlayerNotInClub {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		Player davidOspina = new GoalKeeper("David Ospina", 1.80, "31/8/1988", Position.GOAL_KEEPER);
		Player kieranGibbs = new Player("Kieran Gibbs", 1.75, "26/9/1986", Position.DEFENDER);
		Player nachoMonreal = new Player("Nacho Monreal", 1.82, "21/5/1993", Position.DEFENDER);
		Player gabriel = new Player("Gabriel", 1.73, "26/11/1990", Position.DEFENDER);
		Player hectorBellerin = new Player("Hector Bellerin", 1.86, "19/3/1995", Position.DEFENDER);
		Player tomasRosicky = new Player("Tomas Rosicky", 1.85, "04/10/1980", Position.MIDFIELDER);
		Player mikelArteta = new Player("Mikel Arteta", 1.70, "26/3/1982", Position.MIDFIELDER);
		Player santiCazorla  = new Player("Santi Cazorla", 1.95,  "13/12/1984", Position.MIDFIELDER);
		Player mesutOzil = new Player("Mesut Ozil", 1.80, "15/10/1988", Position.MIDFIELDER);
		Player alexis = new Player("Alexis", 1.75, "19/12/1988", Position.FORWARD);
		
		Club arsenal = new Club("Arsenal", "Emirates Stadium");
		arsenal.addPlayer(nursultan);
		arsenal.addPlayer(santiCazorla);
		arsenal.addPlayer(davidOspina);
		arsenal.addPlayer(kieranGibbs);
		arsenal.addPlayer(nachoMonreal);
		arsenal.addPlayer(gabriel);
		arsenal.addPlayer(hectorBellerin);
		arsenal.addPlayer(tomasRosicky);
		arsenal.addPlayer(mikelArteta);
		arsenal.addPlayer(mesutOzil);
		arsenal.addPlayer(alexis);
		
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
		
		Club chelsea = new Club("Chelsea", "Stamford Bridge");
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
		
		Match match = new Match("Old Trafford", "12/10/2015 14:55", arsenal, chelsea);
		match.setGame();
		match.scoreGoal(alexis);
		match.scoreGoal(mesutOzil);
		match.scoreGoal(falcao);
		assertEquals("Arsenal 2-1 Chelsea", match.getFinalScore());
		assertEquals("Arsenal Won", match.getFinalResult());
	}
	
	/**
	 * Check whether players played is as expected
	 * @throws PlayerNotInClub The exception that will be thrown
	 */
	@Test
	public void testPrintPlayers() throws PlayerNotInClub {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		Player davidOspina = new GoalKeeper("David Ospina", 1.80, "31/8/1988", Position.GOAL_KEEPER);
		Player kieranGibbs = new Player("Kieran Gibbs", 1.75, "26/9/1986", Position.DEFENDER);
		Player nachoMonreal = new Player("Nacho Monreal", 1.82, "21/5/1993", Position.DEFENDER);
		Player gabriel = new Player("Gabriel", 1.73, "26/11/1990", Position.DEFENDER);
		Player hectorBellerin = new Player("Hector Bellerin", 1.86, "19/3/1995", Position.DEFENDER);
		Player tomasRosicky = new Player("Tomas Rosicky", 1.85, "04/10/1980", Position.MIDFIELDER);
		Player mikelArteta = new Player("Mikel Arteta", 1.70, "26/3/1982", Position.MIDFIELDER);
		Player santiCazorla  = new Player("Santi Cazorla", 1.95,  "13/12/1984", Position.MIDFIELDER);
		Player mesutOzil = new Player("Mesut Ozil", 1.80, "15/10/1988", Position.MIDFIELDER);
		Player alexis = new Player("Alexis", 1.75, "19/12/1988", Position.FORWARD);
		
		Club arsenal = new Club("Arsenal", "Emirates Stadium");
		arsenal.addPlayer(nursultan);
		arsenal.addPlayer(santiCazorla);
		arsenal.addPlayer(davidOspina);
		arsenal.addPlayer(kieranGibbs);
		arsenal.addPlayer(nachoMonreal);
		arsenal.addPlayer(gabriel);
		arsenal.addPlayer(hectorBellerin);
		arsenal.addPlayer(tomasRosicky);
		arsenal.addPlayer(mikelArteta);
		arsenal.addPlayer(mesutOzil);
		arsenal.addPlayer(alexis);
		
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
		
		Club chelsea = new Club("Chelsea", "Stamford Bridge");
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
		
		Match match = new Match("Old Trafford", "12/10/2015 14:55", arsenal, chelsea);
		match.setGame();
		match.scoreGoal(alexis);
		match.scoreGoal(mesutOzil);
		match.scoreGoal(falcao);
		
		HashMap<Player, Integer> playersPlayed = new HashMap<Player, Integer>();
		playersPlayed.put(alexis, 1);
		playersPlayed.put(mesutOzil, 1);
		playersPlayed.put(falcao, 1);
		playersPlayed.put(nursultan, 0);
		playersPlayed.put(davidOspina, 0);
		playersPlayed.put(kieranGibbs, 0);
		playersPlayed.put(nachoMonreal, 0);
		playersPlayed.put(gabriel, 0);
		playersPlayed.put(hectorBellerin, 0);
		playersPlayed.put(tomasRosicky, 0);
		playersPlayed.put(mikelArteta, 0);
		playersPlayed.put(santiCazorla, 0);
		playersPlayed.put(asmirBegovic, 0);
		playersPlayed.put(cesarAzpilicueta, 0);
		playersPlayed.put(garyCahill, 0);
		playersPlayed.put(branislavIvanovic, 0);
		playersPlayed.put(johnTerry, 0);
		playersPlayed.put(oscar, 0);
		playersPlayed.put(pedro, 0);
		playersPlayed.put(ramires, 0);
		playersPlayed.put(willian, 0);
		playersPlayed.put(diegoCosta, 0);
		
		// Check whether all players have been recorded.
		assertEquals(playersPlayed, match.getPlayers());
	}

}
