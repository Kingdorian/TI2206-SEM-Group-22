package spaceinvaders.group_22;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.ui.JavaFXThreadingRule;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.Explosion;
import spaceinvaders.group_22.unit.NormalAlien;
import spaceinvaders.group_22.unit.ShipBullet;
import spaceinvaders.group_22.unit.SpaceShip;
import spaceinvaders.group_22.unit.Unit;

/**
 * Test for the game class.
 * @author Dorian
 *
 */
@SuppressWarnings("checkstyle:magicnumber")   
public abstract class GameTest {
	
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	private static Game game;
	/**
	 * Method to create a subclass of the game class.
	 * @param width of the canvas.
	 * @param height of the canvas.
	 * @return game object to test.
	 */
	public abstract Game createInstance(double width, double height);


	/**
	 * Class to set up a game before each test is executed.
	 */
	@Before
	public final void setUpGame() {
		game = createInstance(200, 200);
		game.setTickrate(1.0);
		ArrayList<Alien> row = new ArrayList<Alien>();
		row.add(new NormalAlien(10, 10));
		game.getAlienController().getAlienWave().addAlienRow(row);
	}
	
	/**
	 * Tests if the testInProgress method returns false if the game is not in progress.
	 */
	@Test
	public final void testIsNotInProgress() {
		Assert.assertFalse(game.isInProgress());
	}
	/**
	 * Tests if the testInProgress method returns t if the game is in progress.
	 */
	@Test
	public final void testIsInProgress() {
		// Start game
		game.start();
		Assert.assertTrue(game.isInProgress());
	}
	/**
	 * Tests if the gethighscore method works correctly.
	 */
	@Test
	public final void testGetHighscore() {
		Assert.assertEquals(0, game.getHighScore());
	}
	/**
	 * Tests if the getHighScore sets the new highscore correctly.
	 */
	@Test
	public final void testSetHighScore() {
		game.setHighScore(100);
		Assert.assertEquals(100, game.getHighScore());
	}
	/**
	 * Test if proper exception is thrown when inputting a lower highscore.
	*/
	@Test(expected = AssertionError.class)
	public final void testIllegalNewHighScore() {
		//Setting a correct highscore
		game.setHighScore(100);
		// Setting highscore lower then current highscore
		game.setHighScore(50);
	}
	/**
	 * Test if proper exception is thrown when inputting a negative highscore.
	 */
	@Test(expected = AssertionError.class)
	public final void testNegativeNewHighScore() {
		game.setHighScore(-10);
	}
	
	/**
	 * Tests if getAliens gets the ArrayList of aliens correctly.
	 */
	@Test
	public final void testGetAliens() {
		Game game = new SinglePlayerGame(100, 100);
		ArrayList<ArrayList<Alien>> aliens = new ArrayList<ArrayList<Alien>>();
		game.getAlienController().getAlienWave().setAliens(aliens);
		Assert.assertEquals(new ArrayList<ArrayList<Alien>>(), game.getAlienController().getAliens());
	}
	/**
	 * Tests if the reset method works correctly for resetting barricades.
	 */
	@Test
	public final void testResetBarricades() {
		ShipBullet bullet = new ShipBullet(10.0, 10.0);
		bullet.setVelY(-10);
		game.getBarricadeController().getBarricades().get(0).hit(bullet);
		game.resetGame();
		Assert.assertEquals(50, game.getBarricadeController().getBarricades().get(0).getHealth());
	}
	
	/**
	 * Tests if the reset method works correctly for resetting the bullet list.
	 */
	@Test
	public final void testResetBullets() {
		game.getBullets().add(new ShipBullet(1.0, 1.0));
		game.resetGame();
		// Bullet list should be emptied when the game resets
		Assert.assertEquals(0, game.getBullets().size());
	}
	/**
	 * Tests if the reset method works correctly for resetting the explosion list.
	 */
	@Test
	public final void testResetExplosions() {
		game.getExplosions().add(new Explosion(1.0, 1.0));
		game.resetGame();
		// Bullet list should be emptied when the game resets
		Assert.assertEquals(0, game.getExplosions().size());
	}
	
	/**
	 * Test gameOver method stops the game.
	 */
	@Test
	public final void testGameOver() {
		game.gameOver();
		Assert.assertFalse(game.isInProgress());
	}

	/**
	 * Tests the getTickRate method in game.
	 */
	@Test
	public final void testGetTickRate() {
		game.setTickrate(10.0);
		Assert.assertEquals(10, game.getTickrate(), 0.05);
		
	}
	/**
	 * Tests the getShipBullets Method for non ship bullets.
	 */
	@Test
	public final void testGetNoShipBullets() {
		// Remove all existing bullets from the game.
		game.resetGame();
		ArrayList<Bullet> bulletlist = new ArrayList<Bullet>();
		bulletlist.add(game.getAlienController().getAliens().get(0).shootBullet(1));
		game.setBullets(bulletlist);
		Assert.assertEquals(new ArrayList<Bullet>(), game.getShipBullets());
	}
	/**
	 * Tests the getShipBullets Method for ship bullets.
	 */
	@Test
	public final void testGetShipBullets() {
		// Remove all existing bullets from the game.
		game.resetGame();
		ArrayList<Bullet> bulletlist = new ArrayList<Bullet>();
		bulletlist.add(new ShipBullet(50, 10));
		game.setBullets(bulletlist);
		Assert.assertEquals(bulletlist, game.getShipBullets());
	}
}
