package spaceinvaders.group_22;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.unit.SpaceShip;
/**
 * Test for the Multi spaceship controller.
 * @author Bryan
 *
 */
public final class MultiSpaceShipControllerTest {

	/**
	 * Static game used for testing.
	 */
	private static MultiPlayerGame game;
	/**
	 * Static Controller used for testing.
	 */
	private static MultiSpaceShipsController controller;
	
	/**
	 * Set up every test with an SpaceShipController.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber") 
	public void setUpController() {
		game = new MultiPlayerGame(1000, 720);
		controller = (MultiSpaceShipsController) game.getSpaceShipController();
		game.setTickrate(1.0);
	}
	/**
	 * Tests the moveSpaceShip method for bouncing spaceship to the left border.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testShipBounceLeft() {
		game.setTickrate(10.0);
		game.getPlayers().get(0).setSpaceShip(new SpaceShip(-5, 0));
		game.getPlayers().get(0).getSpaceShip().setVelX(-10.0);
		controller.moveSpaceShip(new ArrayList<KeyCode>(), game.getPlayers().get(0));
		Assert.assertTrue(game.getPlayers().get(0).getSpaceShip().getVelX() >= 0);
	}
	/**
	 * Tests the ship moving normally to the right when D is pressed. 
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testShipMovingRight() {
		game.getPlayers().get(1).setSpaceShip(new SpaceShip(100, 100));
		ArrayList<KeyCode> keyList = new ArrayList<KeyCode>();
		keyList.add(KeyCode.D);
		controller.moveSpaceShip(keyList, game.getPlayers().get(1));
		Assert.assertTrue(game.getPlayers().get(1).getSpaceShip().getVelX() > 0);
	}
	/**
	 * Tests the ship moving normally to the left when A is pressed. 
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testShipMovingLeft() {
		game.getPlayers().get(1).setSpaceShip(new SpaceShip(100, 100));
		ArrayList<KeyCode> keyList = new ArrayList<KeyCode>();
		keyList.add(KeyCode.A);
		controller.moveSpaceShip(keyList, game.getPlayers().get(1));
		Assert.assertTrue(game.getPlayers().get(1).getSpaceShip().getVelX() < 0);
	}
	/**
	 * Test the increased space ship speed.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testShipFasterThenMaxSpeedRight() {
		game.getPlayers().get(1).setSpaceShip(new SpaceShip(100, 100));
		game.getPlayers().get(1).getSpaceShip().setVelX(500);
		controller.moveSpaceShip(new ArrayList<KeyCode>(), game.getPlayers().get(1));
		Assert.assertEquals(250, game.getPlayers().get(1).getSpaceShip().getVelX(), 0.05);
	}
	/**
	 * Tests the ship moving normally to the left when A is pressed. 
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testShipFasterThenMaxSpeedLeft() {
		SpaceShip spaceship = new SpaceShip(100, 100);
		spaceship.setPlayer(game.getPlayers().get(1));
		game.getPlayers().get(1).setSpaceShip(spaceship);
		game.getPlayers().get(1).getSpaceShip().setVelX(-500);
		controller.moveSpaceShip(new ArrayList<KeyCode>(), game.getPlayers().get(1));
		Assert.assertEquals(-250, game.getPlayers().get(1).getSpaceShip().getVelX(), 0.05);
	}
	
	/**
	 * Tests the ship moving normally to the left when A is pressed and tick is called. 
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testTickD() {
		SpaceShip spaceship = new SpaceShip(100, 100);
		spaceship.setPlayer(game.getPlayers().get(0));
		game.getPlayers().get(0).setSpaceShip(spaceship);
		ArrayList<KeyCode> keyList = new ArrayList<KeyCode>();
		keyList.add(KeyCode.D);
		controller.tick(keyList);
		Assert.assertTrue(game.getPlayers().get(0).getSpaceShip().getVelX() > 0);
	}
	/**
	 * Tests the ship moving normally to the left when A is pressed and tick is called. 
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testTickLeft() {
		SpaceShip spaceship = new SpaceShip(100, 100);
		spaceship.setPlayer(game.getPlayers().get(0));
		game.getPlayers().get(0).setSpaceShip(spaceship);
		ArrayList<KeyCode> keyList = new ArrayList<KeyCode>();
		keyList.add(KeyCode.LEFT);
		controller.tick(keyList);
		Assert.assertTrue(game.getPlayers().get(1).getSpaceShip().getVelX() < 0);
	}
	/**
	 * Tests the ship moving normally to the left when A is pressed and tick is called. 
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public void testTickRight() {
		SpaceShip spaceship = new SpaceShip(100, 100);
		spaceship.setPlayer(game.getPlayers().get(0));
		game.getPlayers().get(0).setSpaceShip(spaceship);
		ArrayList<KeyCode> keyList = new ArrayList<KeyCode>();
		keyList.add(KeyCode.RIGHT);
		controller.tick(keyList);
		Assert.assertTrue(game.getPlayers().get(1).getSpaceShip().getVelX() > 0);
	}
}