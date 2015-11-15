package MadalinaJuganariu;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClubTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClubTest
{
    /**
     * Default constructor for test class ClubTest
     */
    public ClubTest()
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
    public void testAddPlayer()
    {
        Club club = new Club("Tottenham");
        Player player = new Player("Vlad Chiriches", 190, 0, 21);
        club.addPlayer(player);
        assertEquals(1, club.getNumberOfPlayers());
    }
    @Test
    public void testGetTopPlayer()
    {
        Player player = new Player("Vlad Chiriches", 190, 9, 21);
        Player player15 = new Player("James Dalton", 182, 8, 29);
        Player player16 = new Player("Rob Earnshaw", 165, 3, 27);
        Club club = new Club("Tottenham");
        club.addPlayer(player);
        club.addPlayer(player15);
        club.addPlayer(player16);
        assertEquals(player, club.getTopPlayer());
    }
}
