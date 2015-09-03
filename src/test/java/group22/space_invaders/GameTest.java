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
	 * Tests if the testInProgress method returns true if the game is in progress.
	 */
	@Test
	public void testIsNotInprogress(){
		Game game = new Game();
		// Start game
		game.Start();
		Assert.assertTrue(game.isInProgress());
	}
}
