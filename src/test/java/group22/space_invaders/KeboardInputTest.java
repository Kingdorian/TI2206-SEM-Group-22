package group22.space_invaders;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KeboardInputTest {
	
	private Game game;
	private ArrayList<KeyCode> simulEvents; 
	/**
	 * Setup variables before running the tests.
	 */
	@Before
	public void setup() {
		game = new Game();
		game.setPlayer(new Player(game));
		// Create simulated events
		simulEvents = new ArrayList<KeyCode>();
	}
	/**
	 * Test if the speed of the spaceship correctly gets updated when the A key gets pressed.
	 * When the A key is pressed the spaceship should start moving to the left.
	 */
	@Test
	public void testPressA() {
		simulEvents.add(KeyCode.A);
		game.tick(simulEvents);
		Assert.assertEquals(game.getPlayer().getSpaceShip().getVelX(), -10);
	}
	/**
	 * Test if the speed of the spaceship correctly gets updated when the D key gets pressed.
	 * When the D key is pressed the spaceship should start moving to the right.
	 */
	@Test
	public void testPressD() {
		simulEvents.add(KeyCode.D);
		game.tick(simulEvents);
		Assert.assertEquals(game.getPlayer().getSpaceShip().getVelX(), 10);
	}
	/**
	 * Test if a bullet is correctly launched when the player presses the space button. 
	 */
	@Test
	public void testPressSpace() {
		simulEvents.add(KeyCode.SPACE);
		game.tick(simulEvents);
		//TODO Assertion to check if a bullet is launched.
	}
}