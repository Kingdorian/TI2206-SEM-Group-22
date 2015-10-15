package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.Player;
import spaceinvaders.group_22.SinglePlayerGame;

/**
 * Test for Shoot Power Up, extends PowerUpTest Test.
 * @author Bryan
 */
public class ShootPowerUpUnitTest extends PowerUpUnitTest {
	
	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		return new ShootPowerUpUnit(x, y, spriteFile);
	}
	/**
	 * Test the activation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activatePowerUpTest() {
		ShootPowerUpUnit powerUp = new ShootPowerUpUnit(500, 200, "testimage.png");
		Player player = new Player(new SinglePlayerGame(1000, 720));
		powerUp.activate(player);
		
		assertEquals(player.getSpaceShip().getShootingMultiplier(), 2.0, 0.f);
	}
}
