package spaceinvaders.group_22;

import org.junit.Assert;
import org.junit.Test;

import spaceinvaders.group_22.unit.SpaceShip;

/**
 * Test for the player class.
 * @author Dorian
 *
 */
public class PlayerTest {
	
	/**
	 * Test behavior of the getSpaceShip method for the player.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testGetSetSpaceShip() {
		SpaceShip ship = new SpaceShip(10.0, 10.0, "testimage.png");
		Player player = new Player(new Game(200 , 200));
		player.setSpaceShip(ship);
		Assert.assertEquals(ship, player.getSpaceShip());
	}
	/**
	 * Test behaviour of the getScore method for the player class.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testGetScore() {
		Player player = new Player(new Game(200 , 200));
		Assert.assertEquals(0, player.getScore());
	}
	/**
	 * Tests the behaviour of the addpoints method for the player class for positive amounts of points.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testAddPositiveScore() {
		Player player = new Player(new Game(200 , 200));
		player.addScore(10);
		Assert.assertEquals(10, player.getScore());
	}
	/**
	 * Tests the behaviour of the addPoints method when adding a negative amount of points to the players score.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testAddNegativeScore() { 
		Player player = new Player(new Game(200 , 200));
		player.addScore(-10);
		Assert.assertEquals(-10, player.getScore());
	}
	/**
	 * Tests the getLives method from the player class.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testGetLives() {
		Player player = new Player(new Game(200 , 200));
		Assert.assertEquals(3, player.getLives());
	}
	/**
	 * Tests the die method for the player class when the player has more then 1 live left.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testDie() {
		Player player = new Player(new Game(200 , 200));
		player.die();
		Assert.assertEquals(2, player.getLives());
	}
	/**
	 * Tests the resetScore method that the score is 0.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testresetScore() {
		Player player = new Player(new Game(200 , 200));
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
		Game game = new Game(200 , 200);
		Player player = new Player(game);
		player.getSpaceShip().setVelX(20);
		player.getSpaceShip().moveUnit(60.0);
		player.respawnShip();
		Assert.assertTrue(player.getSpaceShip().getXCoor() == game.getCanvasWidth() / 2);
	}
	/**
	 * Tests the die method for te player when it has only one live left.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testDieOutOfLives() {
		Game game = new Game(200 , 200);
		game.start();
		Player player = new Player(game);
		player.die();
		player.die();
		player.die();
		
		Assert.assertFalse(game.isInProgress());
		
	}
}