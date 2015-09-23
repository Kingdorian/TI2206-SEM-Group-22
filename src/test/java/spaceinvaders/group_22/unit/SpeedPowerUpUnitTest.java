package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.Player;

/**
 * Test for Speed Power Up, extends PowerUpTest Test.
 * @author Bryan
 */
public class SpeedPowerUpUnitTest extends PowerUpUnitTest {
	
	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		return new SpeedPowerUpUnit(x, y, spriteFile, SpeedPowerUpUnit.DURATION);
	}
	/**
	 * Test the activation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activatePowerUpTest() {
		SpeedPowerUpUnit powerUp = new SpeedPowerUpUnit(500, 200, "testimage.png", SpeedPowerUpUnit.DURATION);
		powerUp.activate(new Player(new Game(1000, 720)));
		assertEquals(SpaceShip.MAXVELX, 750);
	}
	/**
	 * Test the deactivation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void deactivatePowerUpTest() {
		SpeedPowerUpUnit powerUp = new SpeedPowerUpUnit(500, 200, "testimage.png", SpeedPowerUpUnit.DURATION);
		powerUp.activate(new Player(new Game(1000, 720)));
		powerUp.deactivate();
		assertEquals(SpaceShip.MAXVELX, 250);
	}

}
