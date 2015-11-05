package Answer;
/**
 * The JUnit class to test all fields and methods of the Player class.
 * Whether the result as exoected or not
 * @author Nursultan Kenenbayev
 * @version 22/10/2015
 */
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import Answer.Player.Position;

public class TestPlayer {
	/**
	 * Try to get name of the player using appropriate method
	 * and test whether the name is as expected or not. 
	 */
	@Test
	public void testGetName() {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		assertEquals("Nursultan", nursultan.getName());
	}
	
	/**
	 * Try to set a new name of the player using appropriate method,
	 * and see if it is set correctly or not.
	 */
	@Test
	public void testSetName() {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		nursultan.setName("nursultan");
		assertEquals("nursultan", nursultan.getName());
	}
	
	/**
	 * Try to get height of the player using method
	 * and compare whether the result is equal as you expected 
	 */
	@Test
	public void testGetHeight() {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		// 0.01 inside assertEquals is to check whether method will output result within that range
		assertEquals(1.75, nursultan.getHeight(), 0.01);
	}
	
	/**
	 * Try to set height of the player using setHeight method
	 * and see whether it is setting it correctly or not.
	 */
	@Test
	public void testSetHeight() {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		nursultan.setHeight(1.70);
		assertEquals(1.70, nursultan.getHeight(), 0.01);
	}
	
	/**
	 * Test the method get date of birth whether it is showing correct date of birth
	 * @throws ParseException The exception that will be thrown
	 */
	@Test
	public void testGetDateOfBirth() throws ParseException {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		// Format of the date that string should be converted to
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		Date dateOfBirth = sdf.parse("25/9/1993");
		assertEquals(dateOfBirth, nursultan.getDateOfBirth());
	}
	
	/**
	 * Test the method below and see whether the date of birth is correctly set. 
	 * @throws ParseException The exception that will be thrown
	 */
	@Test
	public void testSetDateOfBirth() throws ParseException {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		nursultan.setDateOfBirth("26/9/1993");
		// Format of the date that string should be converted to
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		Date dateOfBirth = sdf.parse("26/9/1993");
		assertEquals(dateOfBirth, nursultan.getDateOfBirth());
	}
	/**
	 * Test method below to see whether number of goals are recorded correctly
	 */
	@Test
	public void testAddGoalTally() {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		// Add number of goals
		nursultan.addGoalTally(5);
		nursultan.addGoalTally(1);
		nursultan.addGoalTally(4);
		nursultan.addGoalTally(7);
		assertEquals(17, nursultan.getGoalTally());
	}
	
	/**
	 * Check whether number of goals that player scored is correct
	 */
	@Test
	public void testGetGoalTally() {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		nursultan.addGoalTally(5);
		nursultan.addGoalTally(1);
		nursultan.addGoalTally(4);
		assertEquals(10, nursultan.getGoalTally());
	}
	
	/**
	 * Check the position of the player is correct or not
	 */
	@Test
	public void testGetPosition() {
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		assertEquals("Forward", nursultan.getPosition());
	}
	
	/**
	 * Change position of the player and check whether it is set correctly.
	 */
	@Test 
	public void testChangePositiob(){
		Player nursultan = new Player("Nursultan", 1.75, "25/9/1993", Position.FORWARD);
		nursultan.changePosition(Position.DEFENDER);
		assertEquals("Defender", nursultan.getPosition());
	}

}
