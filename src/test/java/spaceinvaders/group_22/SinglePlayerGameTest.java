package spaceinvaders.group_22;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.NormalAlien;
import spaceinvaders.group_22.unit.SpaceShip;
/**
 * Single player game test extends the game Test.
 * @author Bryan
 *
 */
public class SinglePlayerGameTest extends GameTest {
	/**
	 * Single game object to test.
	 */
	private SinglePlayerGame singleGame;

	@Override
	public final Game createInstance(final double width, final double height) {
		return new SinglePlayerGame(width, height);
	}
	
	/**
	 * Class to set up a game before each test is executed.
	 */
	@Before
	public final void setUp() {
		singleGame = new SinglePlayerGame(200, 200);
		singleGame.setTickrate(1.0);
		ArrayList<Alien> row = new ArrayList<Alien>();
		row.add(new NormalAlien(10, 10));
		singleGame.getAlienController().getAlienWave().addAlienRow(row);
	}
	
	/**
	 * Tests if the reset method works correctly for resetting the player.
	 */
	@Test
	public final void testResetPlayer() {
		singleGame.getPlayer().addScore(111);
		singleGame.resetGame();
		// Player should be resetted so his score should be 0
		Assert.assertEquals(0, singleGame.getPlayer().getScore());
	}
	
	/**
	 * Tests the moveSpaceShip method for bouncing spaceship to the right border.
	 */
	@Test
	public final void testShipBounceRight() {
		singleGame.getPlayer().setSpaceShip(new SpaceShip(singleGame.getCanvasWidth() + 5, 10));
		singleGame.getPlayer().getSpaceShip().setVelX(10.0);
		singleGame.getSpaceShipController().moveSpaceShip(new ArrayList<KeyCode>(), singleGame.getPlayer());
		Assert.assertTrue(singleGame.getPlayer().getSpaceShip().getVelX() <= 0);
	}
	/**
	 * Tests if the reset method works correctly for resetting .
	 */
	@Test
	public final void testShootingAllowed() {
		singleGame.getPlayer().getSpaceShip().shootBullet(0.1);
		singleGame.resetGame();
		// Bullet list should be emptied when the game resets
		Assert.assertTrue(singleGame.getShootingAllowed());
	}
	
	/**
	 * Test gameOver method when the player has a new highscore.
	 */
	@Test
	public final void testGameOverNewHighScore() {
		// Making sure the player has at least 1 point more then the current highscore
		singleGame.getPlayer().addScore(singleGame.getHighScore() + 1);
		singleGame.gameOver();
		Assert.assertEquals(1, singleGame.getHighScore());
	}
	/**
	 * Test gameover method when the player has no new highscore.
	 */
	@Test
	public final void testGameOverNoNewHighscore() {
		singleGame.setHighScore(1);
		//Make sure score is 0
		singleGame.getPlayer().resetScore();
		singleGame.gameOver();
		Assert.assertEquals(1, singleGame.getHighScore());
	}

}
