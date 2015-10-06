package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.Player;
import spaceinvaders.group_22.ShootPowerUp;

/**
 * Test for Speed Power Up, extends PowerUpTest Test.
 * @author Bryan
 */
public class SpeedPowerUpUnitTest extends PowerUpUnitTest {
	
	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		return new SpeedPowerUpUnit(x, y, spriteFile);
	}
	/**
	 * Test the activation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activatePowerUpTest() {
		SpeedPowerUpUnit powerUp = new SpeedPowerUpUnit(500, 200, "testimage.png");
		Player player = new Player(new Game(1000, 720));
		powerUp.activate(player);
		
		assertEquals(player.getSpaceShip().getVelMultiplier(), 2.5, 0.f);
	}

}