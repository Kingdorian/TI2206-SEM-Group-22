package spaceinvaders.group_22;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

	/**
	 * Tests if the testInProgress method returns false if the game is not in progress.
	 */
	@Test
	public void testIsNotInProgress(){
		Game game = new Game();
		Assert.assertFalse(game.isInProgress());
	}
	/**
	 * Tests if the testInProgress method returns t if the game is in progress.
	 */
	@Test
	public void testIsInProgress(){
		Game game = new Game();
		// Start game
		game.start();
		Assert.assertTrue(game.isInProgress());
	}
	/**
	 * Tests if the gethighscore method works correctly.
	 */
	@Test
	public void testGetHighscore(){
		Game game = new Game();
		Assert.assertEquals(0, game.getHighScore());
	}
	/**
	 * Tests if the getHighScore sets the new highscore correctly.
	 */
	@Test
	public void testSetHighScore() {
		Game game = new Game();
		game.setHighScore(100);
		Assert.assertEquals(100, game.getHighScore());
	}
	/**
	 * Test if proper exception is thrown when inputting a lower highscore.
	*/
	@Test(expected = AssertionError.class)
	public void testIlligalNewScore() {
		Game game = new Game();
		//Setting a correct highscore
		game.setHighScore(100);
		// Setting highscore lower then current highscore
		game.setHighScore(50);
	}
	/**
	 * Test if proper exception is thrown when inputting a negative highscore.
	 */
	@Test(expected = AssertionError.class)
	public void testNegativeNewScore() {
		Game game = new Game();
		game.setHighScore(-10);
	}
	
}
