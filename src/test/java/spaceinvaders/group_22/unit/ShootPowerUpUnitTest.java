package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.game.SinglePlayerGame;
import spaceinvaders.group_22.unit.ShootPowerUpUnit;
import spaceinvaders.group_22.unit.Unit;

/**
 * Test for Shoot Power Up, extends PowerUpTest Test.
 * @author Bryan
 */
public class ShootPowerUpUnitTest extends PowerUpUnitTest {
	
	@Override
	public final Unit createInstance(final double x, final double y) {
		return new ShootPowerUpUnit(x, y);
	}
	/**
	 * Test the activation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activatePowerUpTest() {
		ShootPowerUpUnit powerUp = new ShootPowerUpUnit(500, 200);

		SinglePlayerGame game = new SinglePlayerGame(1000, 720);
		Player player = new Player(game, game.getCanvasWidth() / 2);

		powerUp.activate(player);
		
		assertEquals(player.getSpaceShip().getShootingMultiplier(), 2.0, 0.f);
	}
}
