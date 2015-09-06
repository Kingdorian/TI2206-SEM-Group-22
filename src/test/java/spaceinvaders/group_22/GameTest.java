package spaceinvaders.group_22;

import static org.junit.Assert.assertFalse;



import org.junit.Assert;
import org.junit.Test;
/**
 * Test for the game class.
 * @author Dorian
 *
 */
public class GameTest {

	/**
	 * Tests if the testInProgress method returns false if the game is not in progress.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testIsNotInProgress() {
		Game game = new Game(200, 200);
		Assert.assertFalse(game.isInProgress());
	}
	/**
	 * Tests if the testInProgress method returns t if the game is in progress.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testIsInProgress() {
		Game game = new Game(200, 200);
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
		Game game = new Game(200, 200);
		Assert.assertEquals(0, game.getHighScore());
	}
	/**
	 * Tests if the getHighScore sets the new highscore correctly.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testSetHighScore() {
		Game game = new Game(200 , 200);
		game.setHighScore(100);
		Assert.assertEquals(100, game.getHighScore());
	}
	/**
	 * Test if proper exception is thrown when inputting a lower highscore.
	*/
	@Test(expected = AssertionError.class)
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testIlligalNewScore() {
		Game game = new Game(200, 200);
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
		Game game = new Game(200, 200);
		game.setHighScore(-10);
	}
	
}
