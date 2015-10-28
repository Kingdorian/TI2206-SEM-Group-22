package spaceinvaders.group_22.game.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import spaceinvaders.group_22.game.MultiPlayerGame;
import spaceinvaders.group_22.game.powerup.SpeedPowerUp;
import spaceinvaders.group_22.ui.JavaFXThreadingRule;
/**
 * Test the multiplayer powerupcontroller.
 * @author Bryan
 *
 */
public class MultiPlayerPowerUpControllerTest {
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	/**
	 * Static game used for testing.
	 */
	private static MultiPlayerGame game;
	/**
	 * Static Controller used for testing.
	 */
	private static MultiPlayerPowerUpController controller;
	
	/**
	 * Set up every test with an AlienController.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void setUpController() {
		game = new MultiPlayerGame(1000, 720);
		controller = (MultiPlayerPowerUpController) game.getPowerUpController();
		game.setTickrate(1.0);
	}
	
	
	/**
	 * Test the check power up method when the power up is colliding with a spaceship.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testPowerUpCollided() {
		controller.createPowerUpUnit(333.33, 630.0);
		controller.checkPowerUps();
		assertEquals(game.getPowerUpController().getPowerUps().size(), 0);
	}
	
	/**
	 * Test the check power up method when the power up is colliding with the second spaceship.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testPowerUpCollidedsecond() {
		controller.createPowerUpUnit(666.66, 630.0);
		controller.checkPowerUps();
		assertEquals(game.getPowerUpController().getPowerUps().size(), 0);
	}
	
	
	/**
	 * Test the check power up method when the power up is activated.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testActivePowerUp() {
		new SpeedPowerUp(game.getPlayers().get(0));
		controller.checkPowerUps();
		assertEquals(game.getPlayers().get(0).getActivePowerUps().get(0).getTimeLeft(), 4.0, 0.02);
	}
	


}
