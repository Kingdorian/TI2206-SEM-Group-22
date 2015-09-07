package spaceinvaders.group_22;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test key events.
 * @author Dorian
 *
 */
public class KeboardInputTest {
	
	/**
	 * Game object used to test.
	 */
	private Game game;
	/**
	 * 
	 */
	private ArrayList<KeyCode> simulEvents; 
	/**
	 * Setup variables before running the tests.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void setup() {
		game = new Game(200 , 200);
		game.setPlayer(new Player(game));
		
		// Create simulated events
		simulEvents = new ArrayList<KeyCode>();
	}
	/**
	 * Test if the speed of the spaceship correctly gets updated when the A key gets pressed.
	 * When the A key is pressed the spaceship should start moving to the left.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testPressA() {
		simulEvents.add(KeyCode.A);
		game.tick(simulEvents);
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() == -250);
	}
	/**
	 * Test if the speed of the spaceship correctly gets updated when the D key gets pressed.
	 * When the D key is pressed the spaceship should start moving to the right.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testPressD() {
		simulEvents.add(KeyCode.D);
		game.tick(simulEvents);
		Assert.assertTrue(game.getPlayer().getSpaceShip().getVelX() ==  250);
	}
	/**
	 * Test if a bullet is correctly launched when the player presses the space button. 
	 */
	@Test
	public final void testPressSpace() {
		simulEvents.add(KeyCode.SPACE);
		int size = game.getAliens().size();
		game.tick(simulEvents);	
		assertTrue(size - 1 == game.getAliens().size());
	}
}