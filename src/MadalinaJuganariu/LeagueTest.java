package MadalinaJuganariu;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LeagueTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LeagueTest
{
    /**
     * Default constructor for test class LeagueTest
     */
    public LeagueTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {


    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    @Test
    public void testFindTopScorer()
    {
        Player player = new Player("Vlad Chiriches", 190, 13, 21);
        Player player15 = new Player("James Dalton", 182, 20, 29);
        Player player16 = new Player("Rob Earnshaw", 165, 3, 27);
        Club club = new Club("Tottenham");
        Club club1 = new Club("Arsenal");
        Club club2 = new Club("Newcastle");
        League league = new League("Premier League");
        club.addPlayer(player);
        club.addPlayer(player15);
        club.addPlayer(player16);
        league.addClub(club);
        league.addClub(club1);
        league.addClub(club2);
        assertEquals(player15, league.findTopScorer());
    }
}
