package group22.space_invaders;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

	/**
	 * Tests if the testInProgress method returns false if the game is not in progress.
	 */
	@Test
	public void testIsInProgress(){
		Game game = new Game();
		Assert.assertFalse(game.isInProgress());
	}
	/**
	 * Tests if the testInProgress method returns false if the game is not in progress.
	 */
	@Test
	public void testIsNotInprogress(){
		Game game = new Game();
		// Start game
		game.start();
		Assert.assertTrue(game.isInProgress());
	}
}
