package Answer;
/**
 * The JUnit class to test all fields and methods of the League class.
 * Whether the result as exoected or not
 * @author Nursultan Kenenbayev
 * @version 22/10/2015
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import Answer.Club;
import Answer.Player.Position;

public class LeagueTest {

	/**
	 * Check whether object league is constructed correctly
	 */
	@Test
	public void testLeague() {
		League league = new League("Barclays");
		assertEquals("Barclays", league.getName());
		league.setName("barclays");
		assertEquals("barclays", league.getName());
	}

	/**
	 * Test the method which adds club to the league.
	 * And adds fixture matches yet to be played 
	 * @throws DuplicatePlayer The exception that will be thrown. 
	 */
	@Test
	public void testAddClub() throws DuplicatePlayer{
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
		
		Club arsenal = new Club("Arsenal","Emirates Stadium");
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
		
		Player jackDunn= new Player("Jack Dunn", 1.75, "25/9/1987", Position.FORWARD);
		Player ryanFulton = new GoalKeeper("Ryan Fulton", 1.80, "20/8/1990", Position.GOAL_KEEPER);
		Player connorRandall = new Player("Connor Randall", 1.75, "25/9/1991", Position.DEFENDER);
		Player ryanCleary = new Player("Ryan Cleary", 1.82, "21/5/1987", Position.DEFENDER);
		Player tomBrewit = new Player("Tom Brewit", 1.73, "21/2/1989", Position.DEFENDER);
		Player bradSmith = new Player("Brad Smith", 1.86, "20/8/1979", Position.DEFENDER);
		Player adamPhillips = new Player("Adam Phillips", 1.85, "12/9/1980", Position.MIDFIELDER);
		Player mattyVirtue = new Player("Matty Virtue", 1.70, "10/8/1985", Position.MIDFIELDER);
		Player yanDhanda = new Player("Yan Dhanda", 1.95,  "15/9/1986", Position.MIDFIELDER);
		Player alexOhanlon = new Player("Alex O'Hanlon", 1.80, "12/3/1988", Position.MIDFIELDER);
		Player ryanKent = new Player("Ryan Kent", 1.75, "29/1/1987", Position.FORWARD);
		
		Club liverpool = new Club("Liverpool", "Anfield");
		liverpool.addPlayer(ryanFulton);
		liverpool.addPlayer(yanDhanda);
		liverpool.addPlayer(jackDunn);
		liverpool.addPlayer(connorRandall);
		liverpool.addPlayer(ryanCleary);
		liverpool.addPlayer(tomBrewit);
		liverpool.addPlayer(bradSmith);
		liverpool.addPlayer(adamPhillips);
		liverpool.addPlayer(mattyVirtue);
		liverpool.addPlayer(alexOhanlon);
		liverpool.addPlayer(ryanKent);
		
		League league = new League("barclays");
		league.addClub(arsenal);
		league.addClub(chelsea);
		league.addClub(liverpool);
		
		ArrayList<Club> clubs = new ArrayList<Club>();
		clubs.add(arsenal);
		clubs.add(chelsea);
		clubs.add(liverpool);
		
		// Compare leagues they should be equal
		assertEquals(clubs, league.getClubs());
		league.addFixture(chelsea, liverpool);
		league.addFixture(liverpool, arsenal);
		league.addFixture(arsenal, chelsea);
		
		Multimap<Club, Club> matches = ArrayListMultimap.create();
		matches.put(chelsea, liverpool);
		matches.put(liverpool, arsenal);
		matches.put(arsenal, chelsea);
		// Compare matches yet to be played they should be equal
		assertEquals(matches, league.getMatchesToBePlayed());
	}
	
	/**
	 * Test if duplicate player is present then throw DuplicatePlayer exception. 
	 * @throws DuplicatePlayer The exception that will be thrown.
	 */
	@Test(expected = DuplicatePlayer.class)
	public void testAddClubThrowsException() throws DuplicatePlayer{
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
		
		
		Player jackDunn= new Player("Jack Dunn", 1.75, "25/9/1987", Position.FORWARD);
		Player ryanFulton = new GoalKeeper("Ryan Fulton", 1.80, "20/8/1990", Position.GOAL_KEEPER);
		Player connorRandall = new Player("Connor Randall", 1.75, "25/9/1991", Position.DEFENDER);
		Player ryanCleary = new Player("Ryan Cleary", 1.82, "21/5/1987", Position.DEFENDER);
		Player tomBrewit = new Player("Tom Brewit", 1.73, "21/2/1989", Position.DEFENDER);
		Player bradSmith = new Player("Brad Smith", 1.86, "20/8/1979", Position.DEFENDER);
		Player adamPhillips = new Player("Adam Phillips", 1.85, "12/9/1980", Position.MIDFIELDER);
		Player mattyVirtue = new Player("Matty Virtue", 1.70, "10/8/1985", Position.MIDFIELDER);
		Player yanDhanda = new Player("Yan Dhanda", 1.95,  "15/9/1986", Position.MIDFIELDER);
		Player alexOhanlon = new Player("Alex O'Hanlon", 1.80, "12/3/1988", Position.MIDFIELDER);
		Player ryanKent = new Player("Ryan Kent", 1.75, "29/1/1987", Position.FORWARD);
		
		Club liverpool = new Club("Liverpool", "Anfield");
		liverpool.addPlayer(ryanFulton);
		liverpool.addPlayer(yanDhanda);
		liverpool.addPlayer(jackDunn);
		liverpool.addPlayer(connorRandall);
		liverpool.addPlayer(ryanCleary);
		liverpool.addPlayer(tomBrewit);
		liverpool.addPlayer(bradSmith);
		liverpool.addPlayer(adamPhillips);
		liverpool.addPlayer(mattyVirtue);
		liverpool.addPlayer(alexOhanlon);
		liverpool.addPlayer(ryanKent);
		liverpool.addPlayer(alexis);
	
		League league = new League("barclays");
		league.addClub(arsenal);
		league.addClub(chelsea);
		league.addClub(liverpool);
		ArrayList<Club> clubs = new ArrayList<Club>();
		clubs.add(arsenal);
		clubs.add(chelsea);
		clubs.add(liverpool);
	}

	/**
	 * Check whether the League class' method can find top player
	 * and top team from the league as well as the best goal keeper.
	 */
	@Test
	public void testFindTopTeamPlayerAndGoalKeeper() {
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
		
		Player jackDunn= new Player("Jack Dunn", 1.75, "25/9/1987", Position.FORWARD);
		Player ryanFulton = new GoalKeeper("Ryan Fulton", 1.80, "20/8/1990", Position.GOAL_KEEPER);
		Player connorRandall = new Player("Connor Randall", 1.75, "25/9/1991", Position.DEFENDER);
		Player ryanCleary = new Player("Ryan Cleary", 1.82, "21/5/1987", Position.DEFENDER);
		Player tomBrewit = new Player("Tom Brewit", 1.73, "21/2/1989", Position.DEFENDER);
		Player bradSmith = new Player("Brad Smith", 1.86, "20/8/1979", Position.DEFENDER);
		Player adamPhillips = new Player("Adam Phillips", 1.85, "12/9/1980", Position.MIDFIELDER);
		Player mattyVirtue = new Player("Matty Virtue", 1.70, "10/8/1985", Position.MIDFIELDER);
		Player yanDhanda = new Player("Yan Dhanda", 1.95,  "15/9/1986", Position.MIDFIELDER);
		Player alexOhanlon = new Player("Alex O'Hanlon", 1.80, "12/3/1988", Position.MIDFIELDER);
		Player ryanKent = new Player("Ryan Kent", 1.75, "29/1/1987", Position.FORWARD);
		
		Club liverpool = new Club("Liverpool", "Anfield");
		liverpool.addPlayer(ryanFulton);
		liverpool.addPlayer(yanDhanda);
		liverpool.addPlayer(jackDunn);
		liverpool.addPlayer(connorRandall);
		liverpool.addPlayer(ryanCleary);
		liverpool.addPlayer(tomBrewit);
		liverpool.addPlayer(bradSmith);
		liverpool.addPlayer(adamPhillips);
		liverpool.addPlayer(mattyVirtue);
		liverpool.addPlayer(alexOhanlon);
		liverpool.addPlayer(ryanKent);
		
		arsenal.addPoints(20);
		chelsea.addPoints(15);
		liverpool.addPoints(21);
		arsenal.getRandomPlayersForTeam();
		liverpool.getRandomPlayersForTeam();
		chelsea.getRandomPlayersForTeam();
		arsenal.addGoalsScored(35);
		liverpool.addGoalsScored(30);
		chelsea.addGoalsScored(15);
		
		arsenal.addGoalsConceded(5);
		liverpool.addGoalsConceded(12);
		chelsea.addGoalsConceded(14);
		
		League league = new League("barclays");
		try {
			league.addClub(arsenal);
			league.addClub(chelsea);
			league.addClub(liverpool);
		} catch (DuplicatePlayer e) {
			e.printStackTrace();
		}
		assertEquals("The top team is Liverpool, they have earned 21 points.", league.findTopTeam());
		nursultan.addGoalTally(10);
		arsenal.addPoints(1);
		
		// Compare with goal difference Arsenal should have bigger number than Liverpool.
		assertEquals("The top team is Arsenal, they have earned 21 points.", league.findTopTeam());
		
		falcao.addGoalTally(10);
		nursultan.addGoalTally(10);
		mesutOzil.addGoalTally(25);
		willian.addGoalTally(12);
		pedro.addGoalTally(14);
		
		// The top scorer should be Nursultan
		assertEquals("The top player is Mesut Ozil, he scored 25 goals", league.findTopScorer());
		
		// The top goal keeper should not be found instead output the goal keeper with the least number of goals he let in
		assertEquals("The best goal keeper with clean sheets not found, the minumum goals let in is "
				     + "the goal keeper David Ospina 5 goals.", league.findTopGoalKeeper());
		
		chelsea.addGoalsConceded(0);
		// Goal Keeper should be Asmir Begovic from Chelsea
		assertEquals("The best goal keeper is Asmir Begovic, he saved match with clean sheet 1 times", league.findTopGoalKeeper());
	}
	
	/**
	 * Test the method played matches whether it holds all played matches
	 * Also test print league table and manually check whether it is ranked correctly
	 * @throws PlayerNotInClub The exception that will be thrown.
	 */
	@Test
	public void testPlayedMatchesAndPrintLeagueTable() throws PlayerNotInClub {
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
		
		Player jackDunn= new Player("Jack Dunn", 1.75, "25/9/1987", Position.FORWARD);
		Player ryanFulton = new GoalKeeper("Ryan Fulton", 1.80, "20/8/1990", Position.GOAL_KEEPER);
		Player connorRandall = new Player("Connor Randall", 1.75, "25/9/1991", Position.DEFENDER);
		Player ryanCleary = new Player("Ryan Cleary", 1.82, "21/5/1987", Position.DEFENDER);
		Player tomBrewit = new Player("Tom Brewit", 1.73, "21/2/1989", Position.DEFENDER);
		Player bradSmith = new Player("Brad Smith", 1.86, "20/8/1979", Position.DEFENDER);
		Player adamPhillips = new Player("Adam Phillips", 1.85, "12/9/1980", Position.MIDFIELDER);
		Player mattyVirtue = new Player("Matty Virtue", 1.70, "10/8/1985", Position.MIDFIELDER);
		Player yanDhanda = new Player("Yan Dhanda", 1.95,  "15/9/1986", Position.MIDFIELDER);
		Player alexOhanlon = new Player("Alex O'Hanlon", 1.80, "12/3/1988", Position.MIDFIELDER);
		Player ryanKent = new Player("Ryan Kent", 1.75, "29/1/1987", Position.FORWARD);
		
		Club liverpool = new Club("Liverpool", "Anfield");
		liverpool.addPlayer(ryanFulton);
		liverpool.addPlayer(yanDhanda);
		liverpool.addPlayer(jackDunn);
		liverpool.addPlayer(connorRandall);
		liverpool.addPlayer(ryanCleary);
		liverpool.addPlayer(tomBrewit);
		liverpool.addPlayer(bradSmith);
		liverpool.addPlayer(adamPhillips);
		liverpool.addPlayer(mattyVirtue);
		liverpool.addPlayer(alexOhanlon);
		liverpool.addPlayer(ryanKent);
		
		League league = new League("barclays");
		try {
			league.addClub(arsenal);
			league.addClub(chelsea);
			league.addClub(liverpool);
		} catch (DuplicatePlayer e) {
			e.printStackTrace();
		}
		
		league.addFixture(chelsea, liverpool);
		league.addFixture(liverpool, arsenal);
		league.addFixture(arsenal, chelsea);
		
		Match match1 = new Match("Old trafford", "12/10/2015 14:55", chelsea, liverpool);
		Match match2 = new Match("Old trafford", "12/10/2015 14:55", liverpool, arsenal);
		Match match3 = new Match("Old trafford", "12/10/2015 14:55", arsenal, chelsea);
		
		match1.setGame();
		match2.setGame();
		match3.setGame();
		
		match1.scoreGoal(tomBrewit);
		match1.scoreGoal(falcao);
		match2.scoreGoal(ryanKent);
		match3.scoreGoal(ramires);
		
		match1.getFinalResult();
		match2.getFinalResult();
		match3.getFinalResult();
		
		league.addPlayedMatches(match1);
		league.addPlayedMatches(match2);
		league.addPlayedMatches(match3);
		
		ArrayList<Match> playedMatches = new ArrayList<Match>();
		playedMatches.add(match1);
		playedMatches.add(match2);
		playedMatches.add(match3);
		
		// Check whether all matches have been recorded
		assertEquals(playedMatches, league.getPlayedMatches());
		
		// From result liverpool should take 1st place in the league
		// with 4 points 2 goals scored and 1 goal conceded also 1 goal difference
		// 2nd place chelsea 1 point, 2 goals scored and 1 goal conceded also 1 goal difference
		// 3rd place arsenal 0 point, o goals scored, 2 goals conceded, and -2 goal difference
		league.printLeagueTable();
	}
}
