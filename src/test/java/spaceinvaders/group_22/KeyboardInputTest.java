package spaceinvaders.group_22;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.Barricade;
import spaceinvaders.group_22.unit.NormalAlien;
import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.game.SinglePlayerGame;
import spaceinvaders.group_22.ui.JavaFXThreadingRule;

/**
 * Test key events.
 * @author Dorian
 *
 */
public class KeyboardInputTest {
	
	/**
	 * Game object used to test.
	 */
	private SinglePlayerGame game;
	/**
	 * 
	 */
	private ArrayList<KeyCode> simulEvents; 
	
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	/**
	 * Setup variables before running the tests.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void setup() {
		game = new SinglePlayerGame(1000.0 , 720.0);
		game.setPlayer(new Player(game, game.getCanvasWidth() / 2));
		game.setTickrate(60.0);
		ArrayList<Alien> row = new ArrayList<Alien>();
		row.add(new NormalAlien(10, 10));
		game.getAlienController().getAlienWave().addAlienRow(row);
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
		Assert.assertEquals(-game.getPlayer().getSpaceShip().getMAXVELX(),
				game.getPlayer().getSpaceShip().getVelX(), 0.05);
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
		Assert.assertEquals(game.getPlayer().getSpaceShip().getMAXVELX(),
				game.getPlayer().getSpaceShip().getVelX(), 0.05);
	}
	/**
	 * Test if a bullet is correctly launched when the player presses the space button. 
	 */
	@Test
	public final void testPressSpace() {
		int bulletAmount = game.getBullets().size();
		// Make sure the bullet does not accidentally collide with an barricade
		game.getBarricadeController().setBarricades(new ArrayList<Barricade>());
		simulEvents.add(KeyCode.SPACE);
		ArrayList<Alien> alienList = new ArrayList<Alien>();
		Alien alien = new NormalAlien(0, 0);
		alienList.add(alien);
		game.getAlienController().getAlienWave().setAlienRow(0, alienList);
		game.tick(simulEvents);	
		Assert.assertEquals(bulletAmount + 1, game.getShipBullets().size());
	}
}