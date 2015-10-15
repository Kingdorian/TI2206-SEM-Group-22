package spaceinvaders.group_22;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.unit.SpaceShip;

public class SpaceShipControllerTest {

	/**
	 * Static game used for testing.
	 */
	private static SinglePlayerGame game;
	/**
	 * Static Controller used for testing.
	 */
	private static SpaceShipController controller;
	
	/**
	 * Set up every test with an SpaceShipController.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void setUpController() {
		game = new SinglePlayerGame(1000, 720);
		controller = game.getSpaceShipController();
		game.setTickrate(1.0);
	}
	/**
	 * Tests the moveSpaceShip method for bouncing spaceship to the left border.
	 */
	@Test
	public final void testShipBounceLeft() {
		game.setTickrate(10.0);
		game.getPlayer().setSpaceShip(new SpaceShip(-5, 0, "spaceship.png"));
		game.getPlayer().getSpaceShip().setVelX(-10.0);
		((SingleSpaceShipController) game.getSpaceShipController()).moveSpaceShip(new ArrayList<KeyCode>(), game.getPlayer());
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() >= 0);
	}
	/**
	 * Tests the ship moving normally to the right when D is pressed. 
	 */
	@Test
	public final void testShipMovingRight() {
		game.getPlayer().setSpaceShip(new SpaceShip(100, 100, "spaceship.png"));
		ArrayList<KeyCode> keyList = new ArrayList<KeyCode>();
		keyList.add(KeyCode.D);
		((SingleSpaceShipController) game.getSpaceShipController()).moveSpaceShip(keyList, game.getPlayer());
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() > 0);
	}
	/**
	 * Tests the ship moving normally to the left when A is pressed. 
	 */
	@Test
	public final void testShipMovingLeft() {
		game.getPlayer().setSpaceShip(new SpaceShip(100, 100, "spaceship.png"));
		ArrayList<KeyCode> keyList = new ArrayList<KeyCode>();
		keyList.add(KeyCode.A);
		((SingleSpaceShipController) controller).moveSpaceShip(keyList, game.getPlayer());
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() < 0);
	}
	/**
	 * Test
	 */
	@Test
	public final void testShipFasterThenMaxSpeedRight() {
		game.getPlayer().setSpaceShip(new SpaceShip(100, 100, "spaceship.png"));
		game.getPlayer().getSpaceShip().setVelX(500);
		((SingleSpaceShipController) controller).moveSpaceShip(new ArrayList<KeyCode>(), game.getPlayer());
		Assert.assertEquals(250, game.getPlayer().getSpaceShip().getVelX(), 0.05);
	}
	/**
	 * Tests the ship moving normally to the left when A is pressed. 
	 */
	@Test
	public final void testShipFasterThenMaxSpeedLeft() {
		game.getPlayer().setSpaceShip(new SpaceShip(100, 100, "spaceship.png"));
		game.getPlayer().getSpaceShip().setVelX(-500);
		((SingleSpaceShipController) controller).moveSpaceShip(new ArrayList<KeyCode>(), game.getPlayer());
		Assert.assertEquals(-250, game.getPlayer().getSpaceShip().getVelX(), 0.05);
	}
	
	
}
