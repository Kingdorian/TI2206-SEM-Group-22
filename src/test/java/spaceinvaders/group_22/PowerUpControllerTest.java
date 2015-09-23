package spaceinvaders.group_22;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import spaceinvaders.group_22.unit.PowerUpUnit;
import spaceinvaders.group_22.unit.SpeedPowerUpUnit;
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
		game.setTickrate(1.0);
	}
	/**
	 * Test the creaton of a powerUp by looking at the size of the powerUp list.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testCreatePowerUp() {
		controller.createPowerUp(500.0, 100.0);
		assertEquals(game.getPowerups().size(), 1);
	}
	
	/**
	 * Test the method for the checks of a moving power up.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testcheckMovePowerUps() {
		controller.createPowerUp(500.0, 100.0);
		controller.checkMovingPowerUp(game.getPowerups().get(0));
		System.out.println(game.getPowerups().get(0).getYCoor());
		assertEquals(Double.compare(game.getPowerups().get(0).getYCoor(), 150.00), 0);
	}
	
	/**
	 * Test the check power up method when the power up is outside the screen.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testMovePowerUpsOutsideScreen() {
		controller.createPowerUp(1200.0, 800.0);
		controller.checkPowerUps();
		assertEquals(game.getPowerups().size(), 0);
	}
	
	/**
	 * Test the check power up method when the power up is colliding with the spaceship.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testPowerUpCollided() {
		controller.createPowerUp(500.0, 630.0);
		controller.checkPowerUps();
		assertEquals(game.getPowerups().get(0).getPlayer(), game.getPlayer());
	}
	/**
	 * Test a active speed power Up.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testActiveSpeedPowerUp() {
		PowerUpUnit powerUp = new SpeedPowerUpUnit(500.0, 600.0, "testimage.png", 5.0);
		powerUp.setPlayer(game.getPlayer());
		game.getPowerups().add(powerUp);
		controller.checkActivePowerUp(powerUp);		
		assertEquals(Double.compare(powerUp.getTimeLeft(), 4.0), 0);
	}
	/**
	 * Test a active speed power Up that is expired.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testActiveSpeedPowerUpExpired() {
		PowerUpUnit powerUp = new SpeedPowerUpUnit(500.0, 600.0, "testimage.png", -1.0);
		powerUp.setPlayer(game.getPlayer());
		game.getPowerups().add(powerUp);
		controller.checkPowerUps();	
		assertEquals(game.getPowerups().size(), 0);
	}
	

}
