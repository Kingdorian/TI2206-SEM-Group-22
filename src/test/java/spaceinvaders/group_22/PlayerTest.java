package spaceinvaders.group_22;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import spaceinvaders.group_22.ui.JavaFXThreadingRule;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.ShipBullet;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * Test for the player class.
 * @author Dorian
 *
 */
public class PlayerTest {
	/**
	 * Player object to test.
	 */
	private Player player;
	/**
	 * Game object used for testing.
	 */
	private SinglePlayerGame game;
	/**
	 * Setup the player class for testing.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void setUp() {
		game = new SinglePlayerGame(200 , 200);
		 player = new Player(game, game.getCanvasWidth() / 2);
	}
	
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	/**
	 * Test behavior of the getSpaceShip method for the player.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testGetSetSpaceShip() {
		SpaceShip ship = new SpaceShip(10.0, 10.0);
		player.setSpaceShip(ship);
		Assert.assertEquals(ship, player.getSpaceShip());
	}
	/**
	 * Test behaviour of the getScore method for the player class.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testGetScore() {
		Assert.assertEquals(0, player.getScore());
	}
	/**
	 * Tests the behaviour of the addpoints method for the player class for positive amounts of points.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testAddPositiveScore() {
		player.addScore(10);
		Assert.assertEquals(10, player.getScore());
	}
	/**
	 * Tests the behaviour of the addPoints method when adding a negative amount of points to the players score.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testAddNegativeScore() { 
		player.addScore(-10);
		Assert.assertEquals(-10, player.getScore());
	}
	/**
	 * Tests the getLives method from the player class.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testGetLives() {
		Assert.assertEquals(3, player.getLives());
	}
	/**
	 * Tests the die method for the player class when the player has more then 1 live left.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testDie() {
		player.die();
		Assert.assertEquals(2, player.getLives());
	}
	/**
	 * Tests the resetScore method that the score is 0.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testresetScore() {
		player.addScore(10);
		player.resetScore();
		Assert.assertEquals(0, player.getScore());
	}
	/**
	 * Tests the respawn method to load the spaceship in the middle again.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testRespawn() {
		player.getSpaceShip().setVelX(20);
		player.getSpaceShip().move(60.0);
		player.respawnShip();
		Assert.assertEquals(game.getCanvasWidth() / 2, player.getSpaceShip().getXCoor(), 0.05);
	}
	/**
	 * Tests the die method for te player when it has only one live left.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testDieOutOfLives() {
		game.start();
		player.die();
		player.die();
		player.die();
		
		Assert.assertFalse(game.isInProgress());
	}
	/**
	 * Test if the fired bullet is from the player.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testShootBullet() {
		ArrayList<Bullet> list = player.getSpaceShip().shootBullet(5.0);
		ShipBullet bullet = (ShipBullet) list.get(0);
		System.out.println(player.getSpaceShip().getPlayer());
		assertEquals(bullet.getPlayer(), player);
	}
	/**
	 * Test the set active powerups method.
	 */
	@Test
	public final void testSetActivePowerUps() {
		ArrayList<PowerUp> powerups = new ArrayList<PowerUp>();
		PowerUp powerup = new ShootPowerUp(player);
		powerups.add(powerup);
		player.setActivePowerUps(powerups);
		assertEquals(player.getActivePowerUps(), powerups);
	}
	/**
	 * Test the add life method.
	 */
	@Test
	public final void testAddLife() {
		int lives = player.getLives();
		player.addLife();
		assertEquals(player.getLives(), lives + 1);
	}
	/**
	 * Test the add life method when the max is reached.
	 */
	@Test
	public final void testMaxAddLife() {
		player.addLife();
		player.addLife();
		player.addLife();
		assertEquals(player.getLives(), 5);
	}
	
}