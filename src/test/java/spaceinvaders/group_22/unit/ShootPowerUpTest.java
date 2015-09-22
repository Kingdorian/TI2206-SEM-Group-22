package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.Player;

/**
 * Test for Shoot Power Up, extends PowerUpTest Test.
 * @author Bryan
 */
public class ShootPowerUpTest extends PowerUpTest {
	
	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		return new ShootPowerUp(x, y, spriteFile, ShootPowerUp.DURATION);
	}
	/**
	 * Test the activation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activatePowerUpTest() {
		ShootPowerUp powerUp = new ShootPowerUp(500, 200, "testimage.png", ShootPowerUp.DURATION);
		powerUp.activate(new Player(new Game(1000, 720)));
		assertEquals(SpaceShip.shootTimes, 2);
	}
	/**
	 * Test the deactivation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void deactivatePowerUpTest() {
		ShootPowerUp powerUp = new ShootPowerUp(500, 200, "testimage.png", ShootPowerUp.DURATION);
		powerUp.activate(new Player(new Game(1000, 720)));
		powerUp.deactivate();
		assertEquals(SpaceShip.shootTimes, 1);
	}
}
