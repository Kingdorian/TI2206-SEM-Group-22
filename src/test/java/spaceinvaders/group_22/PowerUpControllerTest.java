package spaceinvaders.group_22;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
/**
 * Test for the Power Up controller.
 * @author Bryan
 *
 */
public class PowerUpControllerTest {
	
	/**
	 * Static game used for testing.
	 */
	private static SinglePlayerGame game;
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
		game = new SinglePlayerGame(1000, 720);
		controller = game.getPowerUpController();
		game.setTickrate(1.0);
	}
	/**
	 * Test the creaton of a powerUp by looking at the size of the powerUp list.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testCreatePowerUp() {
		controller.createPowerUpUnit(500.0, 100.0);
		assertEquals(game.getPowerUpController().getPowerUps().size(), 1);
	}
	
	/**
	 * Test the method for the checks of a moving power up.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testcheckMovePowerUps() {
		controller.createPowerUpUnit(500.0, 100.0);
		controller.checkMovingPowerUps();
		assertEquals(Double.compare(game.getPowerUpController().getPowerUps().get(0).getYCoor(), 150.00), 0);
	}
	
	/**
	 * Test the check power up method when the power up is outside the screen.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testMovePowerUpsOutsideScreen() {
		controller.createPowerUpUnit(1200.0, 800.0);
		controller.checkPowerUps();
		assertEquals(game.getPowerUpController().getPowerUps().size(), 0);
	}
	
	/**
	 * Test the check power up method when the power up is colliding with the spaceship.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testPowerUpCollided() {
		controller.createPowerUpUnit(500.0, 680.0);
		controller.checkPowerUps();
		assertEquals(game.getPowerUpController().getPowerUps().size(), 0);
	}
	/**
	 * Test the check power up method when the power up is colliding with the spaceship.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testActivePowerUp() {
		new SpeedPowerUp(game.getPlayer());
		controller.checkPowerUps();
		assertEquals(game.getPlayer().getActivePowerUps().get(0).getTimeLeft(), 4.0, 0.02);
	}
	

}
