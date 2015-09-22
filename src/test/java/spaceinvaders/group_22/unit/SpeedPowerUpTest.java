package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.Player;

/**
 * Test for Speed Power Up, extends PowerUpTest Test.
 * @author Bryan
 */
public class SpeedPowerUpTest extends PowerUpTest {
	
	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		return new SpeedPowerUp(x, y, spriteFile, SpeedPowerUp.DURATION);
	}
	/**
	 * Test the activation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activatePowerUpTest() {
		SpeedPowerUp powerUp = new SpeedPowerUp(500, 200, "testimage.png", SpeedPowerUp.DURATION);
		powerUp.activate(new Player(new Game(1000, 720)));
		assertEquals(SpaceShip.MAXVELX, 750);
	}
	/**
	 * Test the deactivation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void deactivatePowerUpTest() {
		SpeedPowerUp powerUp = new SpeedPowerUp(500, 200, "testimage.png", SpeedPowerUp.DURATION);
		powerUp.activate(new Player(new Game(1000, 720)));
		powerUp.deactivate();
		assertEquals(SpaceShip.MAXVELX, 250);
	}

}
