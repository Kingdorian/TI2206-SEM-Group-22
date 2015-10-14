package spaceinvaders.group_22;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import spaceinvaders.group_22.unit.Unit;

/**
 * Test the abstract powerUp class.
 * 
 * @author Bryan van Wijk
 *
 */
public abstract class PowerUpTest {
	/**
	 * The PowerUp that needs to be tested.
	 */
	private PowerUp powerup;
	/**
	 * Used to test the Power up on.
	 */
	private Player player;
	/**
	 * Game to test the power up in.
	 */
	private Game game;
	
	/**
	 * Method to create an instance of a subclass of the powerUp class.
	 * @param setplayer Player to which this powerUp belongs.
	 * @return The PowerUp to be tested.
	 */
	public abstract PowerUp createInstance(Player setplayer);
	
	/**
	 * Setup the unit.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void setup() {
		game = new Game(1000, 750);
		player = new Player(game, game.getCanvasWidth() / 2);
		powerup = createInstance(player);
	}
	
	/**
	 * Test the decrease time left method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testDecreaseTimeLeft() {
		powerup.decreaseTimeLeft(1.0);
		assertEquals(powerup.getTimeLeft(), 4.0, 0.001);
	}
	
	/**
	 * Test the decrease time left method to less as 0.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testDecreaseTimeLeftAndDeactivated() {
		powerup.decreaseTimeLeft(6.0);
		assertEquals(player.getActivePowerUps().size(), 0);
	}

}
