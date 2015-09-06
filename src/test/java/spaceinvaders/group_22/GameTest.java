package spaceinvaders.group_22;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import spaceinvaders.group_22.unit.Alien;

/**
 * Test for the game class.
 * @author Dorian
 *
 */
public class GameTest {
	
	/**
	 * Static game used for testing;
	 */
	static Game game;

	@Before
	public final void setUpGame() {
		game = new Game(200, 200);
	}
	
	/**
	 * Tests if the testInProgress method returns false if the game is not in progress.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testIsNotInProgress() {
		Assert.assertFalse(game.isInProgress());
	}
	/**
	 * Tests if the testInProgress method returns t if the game is in progress.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testIsInProgress() {
		// Start game
		game.start();
		Assert.assertTrue(game.isInProgress());
	}
	/**
	 * Tests if the gethighscore method works correctly.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testGetHighscore() {
		Assert.assertEquals(0, game.getHighScore());
	}
	/**
	 * Tests if the getHighScore sets the new highscore correctly.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testSetHighScore() {
		game.setHighScore(100);
		Assert.assertEquals(100, game.getHighScore());
	}
	/**
	 * Test if proper exception is thrown when inputting a lower highscore.
	*/
	@Test(expected = AssertionError.class)
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testIllegalNewScore() {
		//Setting a correct highscore
		game.setHighScore(100);
		// Setting highscore lower then current highscore
		game.setHighScore(50);
	}
	/**
	 * Test if proper exception is thrown when inputting a negative highscore.
	 */
	@Test(expected = AssertionError.class)
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testNegativeNewScore() {
		game.setHighScore(-10);
	}
	
	/**
	 * Tests if setAliens sets the ArrayList of aliens correctly.
	 */
	@Test
	public final void testSetAliens() {
		ArrayList<Alien> aliens = new ArrayList<Alien>();		
		game.setAliens(aliens);
		
		Assert.assertEquals(new ArrayList<Alien>(), aliens);	
		
	}
	
	/**
	 * Tests if getAliens gets the ArrayList of aliens correctly.
	 */
	@Test
	public final void testGetAliens() {
		ArrayList<Alien> aliens = new ArrayList<Alien>();		
		game.setAliens(aliens);
		
		Assert.assertEquals(new ArrayList<Alien>(), game.getAliens());
	}
}
