package spaceinvaders.group_22;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.ui.JavaFXThreadingRule;
import spaceinvaders.group_22.unit.SpaceShip;
/**
 * Test for the single spaceship controller.
 * @author Bryan
 *
 */
public final class SingleSpaceShipControllerTest {

	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	/**
	 * Static game used for testing.
	 */
	private static SinglePlayerGame game;
	/**
	 * Static Controller used for testing.
	 */
	private static SingleSpaceShipController controller;
	
	/**
	 * Set up every test with an SpaceShipController.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber") 
	public void setUpController() {
		game = new SinglePlayerGame(1000, 720);
		controller = (SingleSpaceShipController) game.getSpaceShipController();
		game.setTickrate(1.0);
	}
	/**
	 * Tests the moveSpaceShip method for bouncing spaceship to the left border.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testShipBounceLeft() {
		game.setTickrate(10.0);
		game.getPlayer().setSpaceShip(new SpaceShip(-5, 0));
		game.getPlayer().getSpaceShip().setVelX(-10.0);
		controller.moveSpaceShip(new ArrayList<KeyCode>(), game.getPlayer());
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() >= 0);
	}
	/**
	 * Tests the ship moving normally to the right when D is pressed. 
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testShipMovingRight() {
		game.getPlayer().setSpaceShip(new SpaceShip(100, 100));
		ArrayList<KeyCode> keyList = new ArrayList<KeyCode>();

		keyList.add(KeyCode.D);
		controller.moveSpaceShip(keyList, game.getPlayer());
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() > 0);
	}
	/**
	 * Tests the ship moving normally to the left when A is pressed. 
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testShipMovingLeft() {
		game.getPlayer().setSpaceShip(new SpaceShip(100, 100));
		ArrayList<KeyCode> keyList = new ArrayList<KeyCode>();

		keyList.add(KeyCode.A);
		controller.moveSpaceShip(keyList, game.getPlayer());
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() < 0);
	}
	/**
	 * Test when the ship goes faster then the max speed.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testShipFasterThenMaxSpeedRight() {
		game.getPlayer().setSpaceShip(new SpaceShip(100, 100));
		game.getPlayer().getSpaceShip().setVelX(500);
		controller.moveSpaceShip(new ArrayList<KeyCode>(), game.getPlayer());
		Assert.assertEquals(250, game.getPlayer().getSpaceShip().getVelX(), 0.05);
	}
	/**
	 * Tests the ship moving normally to the left when A is pressed. 
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testShipFasterThenMaxSpeedLeft() {
		SpaceShip spaceship = new SpaceShip(100, 100);
		spaceship.setPlayer(game.getPlayer());
		game.getPlayer().setSpaceShip(spaceship);
		game.getPlayer().getSpaceShip().setVelX(-500);
		controller.moveSpaceShip(new ArrayList<KeyCode>(), game.getPlayer());
		Assert.assertEquals(-250, game.getPlayer().getSpaceShip().getVelX(), 0.05);
	}
	
	/**
	 * Tests the ship moving normally to the left when A is pressed and tick is called. 
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testTick() {
		SpaceShip spaceship = new SpaceShip(100, 100);
		spaceship.setPlayer(game.getPlayer());
		game.getPlayer().setSpaceShip(spaceship);
		ArrayList<KeyCode> keyList = new ArrayList<KeyCode>();
		keyList.add(KeyCode.D);
		controller.tick(keyList);
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() > 0);
	}
}
