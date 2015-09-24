package spaceinvaders.group_22;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.Barricade;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.Explosion;
import spaceinvaders.group_22.unit.ShipBullet;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * Test for the game class.
 * @author Dorian
 *
 */
public class GameTest {
	
	/**
	 * Static game used for testing.
	 */
	private static Game game;

	/**
	 * Class to set up a game before each test is executed.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void setUpGame() {
		game = new Game(200, 200);
		game.setTickrate(1.0);
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
	 * Tests if the getBarricades method works correctly.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testGetBarricades() {
		ArrayList<Barricade> barricades = new ArrayList<Barricade>();
		Barricade barricade = new  Barricade(10, 10, "testimage.png");
		barricades.add(barricade);
		game.getBarricadeController().setBarricades(barricades);
		Assert.assertEquals(barricade, game.getBarricadeController().getBarricades().get(0));
	}
	/**
	 * Tests if the addBarricade method adds a barricade correctly.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testAddBarricade() {
		ArrayList<Barricade> barricades = new ArrayList<Barricade>();
		Barricade barricade = new Barricade(10, 10, "testimage.png");
		barricades.add(barricade);
		game.getBarricadeController().setBarricades(new ArrayList<Barricade>());
		game.getBarricadeController().addBarricade(barricade);
		System.out.println(game.getBarricadeController().getBarricades());
		//Assert.assertEquals(barricades, game.getBarricades());
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
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testNegativeNewHighScore() {
		game.setHighScore(-10);
	}
	
	/**
	 * Tests if setAliens sets the ArrayList of aliens correctly.
	 */
	@Test
	public final void testSetAliens() {
		ArrayList<Alien> aliens = new ArrayList<Alien>();		
		game.getAlienController().setAliens(aliens);
		
		Assert.assertEquals(new ArrayList<Alien>(), aliens);	
		
	}
	
	/**
	 * Tests if getAliens gets the ArrayList of aliens correctly.
	 */
	@Test
	public final void testGetAliens() {
		ArrayList<Alien> aliens = new ArrayList<Alien>();		
		game.getAlienController().setAliens(aliens);
		
		Assert.assertEquals(new ArrayList<Alien>(), game.getAlienController().getAliens());
	}
	/**
	 * Tests if the reset method works correctly for resetting barricades.
	 */
	@Test
	public final void testResetBarricades() {
		game.getBarricadeController().getBarricades().get(0).hit();
		game.reset();
		Assert.assertEquals(10, game.getBarricadeController().getBarricades().get(0).getHealth());
	}
	/**
	 * Tests if the reset method works correctly for resetting aliens.
	 */
	@Test
	public final void testResetAliens() {
		game.getAlienController().setAliens(new ArrayList<Alien>());
		game.reset();
		Assert.assertEquals(game.ALIENS_PER_ROW*game.AMOUNT_ALIEN_ROWS,	game.getAlienController().getAliens().size());
	}
	/**
	 * Tests if the reset method works correctly for resetting the player.
	 */
	@Test
	public final void testResetPlayer() {
		game.getPlayer().addScore(111);
		game.reset();
		// Player should be resetted so his score should be 0
		Assert.assertEquals(0, game.getPlayer().getScore());
	}
	/**
	 * Tests if the reset method works correctly for resetting the bullet list.
	 */
	@Test
	public final void testResetBullets() {
		game.getBullets().add(new ShipBullet(1.0, 1.0, "invader.png"));
		game.reset();
		// Bullet list should be emptied when the game resets
		Assert.assertEquals(0, game.getBullets().size() );
	}
	/**
	 * Tests if the reset method works correctly for resetting the explosion list.
	 */
	@Test
	public final void testResetExplosions() {
		game.getExplosions().add(new Explosion(1.0, 1.0, "explosion1.png"));
		game.reset();
		// Bullet list should be emptied when the game resets
		Assert.assertEquals(0, game.getExplosions().size() );
	}
	/**
	 * Tests if the reset method works correctly for resetting .
	 */
	@Test
	public final void testShootingAllowed() {
		game.getPlayer().getSpaceShip().shootBullet(0.1);
		game.reset();
		// Bullet list should be emptied when the game resets
		Assert.assertTrue(game.getShootingAllowed());
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
	 * Test gameOver method when the player has a new highscore.
	 */
	@Test
	public final void testGameOverNewHighScore() {
		// Making sure the player has at least 1 point more then the current highscore
		game.getPlayer().addScore(game.getHighScore()+1);
		game.gameOver();
		Assert.assertEquals(1, game.getHighScore());
	}
	/**
	 * Test gameover method when the player has no new highscore.
	 */
	@Test
	public final void testGameOverNoNewHighscore() {
		game.setHighScore(1);
		//Make sure score is 0
		game.getPlayer().resetScore();
		game.gameOver();
		Assert.assertEquals(1, game.getHighScore());
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
		game.reset();
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
		game.reset();
		ArrayList<Bullet> bulletlist = new ArrayList<Bullet>();
		bulletlist.add(game.getPlayer().getSpaceShip().shootBullet(10.1));
		game.setBullets(bulletlist);
		Assert.assertEquals(bulletlist, game.getShipBullets());
	}
	/**
	 * Tests the setPlayer method in game.
	 */
	@Test
	public final void testSetPlayer() {
		Player player = new Player(game);
		game.setPlayer(player);
		Assert.assertEquals(game.getPlayer(), player);
	}
	/**
	 * Tests the moveSpaceShip method for bouncing spaceship to the left border.
	 */
	@Test
	public final void testShipBounceLeft() {
		game.setTickrate(10.0);
		game.getPlayer().setSpaceShip(new SpaceShip(-5, 0, "spaceship.png"));
		game.getPlayer().getSpaceShip().setVelX(-10.0);
		game.moveSpaceShip(new ArrayList<KeyCode>());
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() >= 0);
	}
	/**
	 * Tests the moveSpaceShip method for bouncing spaceship to the right border.
	 */
	@Test
	public final void testShipBounceRight() {
		game.getPlayer().setSpaceShip(new SpaceShip(game.getCanvasWidth() + 5, 10, "spaceship.png"));
		game.getPlayer().getSpaceShip().setVelX(10.0);
		game.moveSpaceShip(new ArrayList<KeyCode>());
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() <= 0);
	}
	/**
	 * Tests the ship moving normally to the right when D is pressed. 
	 */
	@Test
	public final void testShipMovingRight() {
		game.getPlayer().setSpaceShip(new SpaceShip(100, 100, "spaceship.png"));
		ArrayList keyList = new ArrayList<KeyCode>();
		keyList.add(KeyCode.D);
		game.moveSpaceShip(keyList);
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() > 0);
	}
	/**
	 * Tests the ship moving normally to the left when A is pressed. 
	 */
	@Test
	public final void testShipMovingLeft() {
		game.getPlayer().setSpaceShip(new SpaceShip(100, 100, "spaceship.png"));
		ArrayList keyList = new ArrayList<KeyCode>();
		keyList.add(KeyCode.A);
		game.moveSpaceShip(keyList);
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() < 0);
	}
	/**
	 * Test
	 */
	@Test
	public final void testShipFasterThenMaxSpeedRight() {
		game.getPlayer().setSpaceShip(new SpaceShip(100, 100, "spaceship.png"));
		game.getPlayer().getSpaceShip().setVelX(500);
		game.moveSpaceShip(new ArrayList<KeyCode>());
		Assert.assertEquals(250, game.getPlayer().getSpaceShip().getVelX(), 0.05);
	}
	/**
	 * Tests the ship moving normally to the left when A is pressed. 
	 */
	@Test
	public final void testShipFasterThenMaxSpeedLeft() {
		game.getPlayer().setSpaceShip(new SpaceShip(100, 100, "spaceship.png"));
		game.getPlayer().getSpaceShip().setVelX(-500);
		game.moveSpaceShip(new ArrayList<KeyCode>());
		Assert.assertEquals(-250, game.getPlayer().getSpaceShip().getVelX(), 0.05);
	}
	
}
