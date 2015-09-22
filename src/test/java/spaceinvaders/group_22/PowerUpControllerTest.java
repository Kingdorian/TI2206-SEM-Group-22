package spaceinvaders.group_22;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import spaceinvaders.group_22.unit.SpeedPowerUp;
/**
 * Test for the Power Up controller.
 * @author Bryan
 *
 */
public class PowerUpControllerTest {
	
	/**
	 * Static game used for testing.
	 */
	private static Game game;
	/**
	 * Static Controller used for testing.
	 */
	private static PowerUpController controller;
	
	/**
	 * Set up every test with an AlienController.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void setUpController() {
		game = new Game(1000, 720);
		controller = game.getPowerUpController();
		game.setTickrate(6.0);
	}
	/**
	 * Test the creaton of a powerUp by looking at the size of the powerUp list.
	 */
	@Test
	public final void testCreatePowerUp() {
		controller.createPowerUp(500.0, 100.0);
		assertEquals(game.getPowerups().size(), 1);
	}
	
	/**
	 * Test the move method of the controller.
	 */
	@Test
	public final void testMovePowerUps() {
		controller.createPowerUp(500.0, 100.0);
		controller.movePowerUps();
		assertEquals(Double.compare(game.getPowerups().get(0).getYCoor(), 400.00), 0);
	}
	
	/**
	 * Test the move method of the controller of a PowerUp outside the screen.
	 */
	@Test
	public final void testMovePowerUpsOutsideScreen() {
		controller.createPowerUp(1200.0, 800.0);
		controller.movePowerUps();
		assertEquals(game.getPowerups().size(), 0);
	}
	
	/**
	 * Test the move method of the controller of a PowerUp colliding.
	 */
	@Test
	public final void testMovePowerUpsCollided() {
		controller.createPowerUp(500.0, 380.0);
		controller.movePowerUps();
		assertEquals(game.getPowerups().size(), 0);
		
	}
	
	/**
	 * Test the check power up method.
	 */
	@Test
	public final void testCheckPowerUps() {
		game.getPowerups().add(new SpeedPowerUp(500.0 , 680.0, "testimage.png"));
		controller.checkPowerUps();
		assertEquals(game.getPowerups().size(), 0);
	}

}
