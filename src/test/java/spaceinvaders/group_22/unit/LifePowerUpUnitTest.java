package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.Player;

/**
 * Test for Speed Power Up, extends PowerUpTest Test.
 * @author Bryan
 */
public class LifePowerUpUnitTest extends PowerUpUnitTest {
	
	@Override
	public final Unit createInstance(final double x, final double y) {
		return new LifePowerUpUnit(x, y);
	}
	
	/**
	 * Test the activation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activatePowerUpTest() {
		LifePowerUpUnit powerUp = new LifePowerUpUnit(500, 200);
		Player player = new Player(new Game(1000, 720));
		powerUp.activate(player);
		assertEquals(player.getLives(), 4);
	}
	/**
	 * Test two times activation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activateTwoTimesPowerUpTest() {
		LifePowerUpUnit powerUp = new LifePowerUpUnit(500, 200);
		Player player = new Player(new Game(1000, 720));
		powerUp.activate(player);
		powerUp.activate(player);
		assertEquals(player.getLives(), 5);
	}
	/**
	 * Test three times activation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activateThreeTimesPowerUpTest() {
		LifePowerUpUnit powerUp = new LifePowerUpUnit(500, 200);
		Player player = new Player(new Game(1000, 720));
		powerUp.activate(player);
		powerUp.activate(player);
		powerUp.activate(player);
		assertEquals(player.getLives(), 5);
	}

}