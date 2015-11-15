package MadalinaJuganariu;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerTest
{
    /**
     * Default constructor for test class PlayerTest
     */
    public PlayerTest()
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
    public void testCreatePlayer()
    {
        Player player = new Player("Vlad Chiriches", 190, 9, 21);
        assertEquals("Vlad Chiriches", player.getName());
        assertEquals(190, player.getHeight());
        assertEquals(9, player.getGoalTally());
        assertEquals(21, player.getAge());
    }
}
