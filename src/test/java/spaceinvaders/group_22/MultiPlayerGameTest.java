package spaceinvaders.group_22;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.Bullet;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import spaceinvaders.group_22.unit.SpaceShip;
import static org.mockito.Mockito.times;

/**
 * Multi Player game test.
 * @author Bryan
 *
 */
public class MultiPlayerGameTest extends GameTest {
	
	/**
	 * Multi player game object.
	 */
	private MultiPlayerGame multiGame;

	@Override
	public final Game createInstance(final double width, final double height) {
		return new MultiPlayerGame(width, height);
	}
	
	/**
	 * Class to set up a game before each test is executed.
	 */
	@Before
	public final void setUp() {
		multiGame = new MultiPlayerGame(1280, 720);
		multiGame.setTickrate(1.0);
		ArrayList<Alien> row = new ArrayList<Alien>();
		row.add(new Alien(10, 10, "invader.png"));
		multiGame.getAlienController().getAlienWave().addAlienRow(row);
	}
	
	/**
	 * Tests if the reset method works correctly for resetting the player.
	 */
	@Test
	public final void testResetPlayer() {
		multiGame.getPlayers().get(0).addScore(111);
		multiGame.resetGame();
		// Player should be resetted so his score should be 0
		Assert.assertEquals(0, multiGame.getPlayers().get(0).getScore());
	}
	
	/**
	 * Tests the moveSpaceShip method for bouncing spaceship to the right border.
	 */
	@Test
	public final void testShipBounceRight() {
		multiGame.getPlayers().get(1).setSpaceShip(new SpaceShip(multiGame.getCanvasWidth() + 5, 10, "spaceship.png"));
		multiGame.getPlayers().get(1).getSpaceShip().setVelX(10.0);
		multiGame.getSpaceShipController().moveSpaceShip(new ArrayList<KeyCode>(), multiGame.getPlayers().get(1));
		Assert.assertTrue(multiGame.getPlayers().get(1).getSpaceShip().getVelX() <= 0);
	}
	/**
	 * Tests if the shooting allowd method works correctly.
	 */
	@Test
	public final void testShootingAllowed() {
		multiGame.getPlayers().get(1).getSpaceShip().shootBullet(0.1);
		multiGame.resetGame();
		Assert.assertTrue(multiGame.getShootingAllowed().get(1));
	}
	/**
	 * Test the tick method for the multiplayer.
	 */
	@Test
	public final void testTick() {
		ArrayList<KeyCode> pressedKeys = new ArrayList<KeyCode>();
		pressedKeys.add(KeyCode.SHIFT);
		multiGame.getBullets().clear();	
		multiGame.getShootingAllowed().set(1, true);
		ArrayList<ArrayList<Alien>> aliens = new ArrayList<ArrayList<Alien>>();
		multiGame.getAlienController().getAlienWave().setAliens(aliens);
		ArrayList<Alien> row = new ArrayList<Alien>();
		Alien alien = new Alien(20, 20, "testimage.png");
		row.add(alien);
		multiGame.getAlienController().getAlienWave().addAlienRow(row);
		multiGame.tick(pressedKeys);
		Assert.assertEquals(multiGame.getBullets().size(), 1);
	}

}
