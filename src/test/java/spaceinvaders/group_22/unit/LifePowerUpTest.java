package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.Player;

/**
 * Test for Speed Power Up, extends PowerUpTest Test.
 * @author Bryan
 */
public class LifePowerUpTest extends PowerUpTest {
	
	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		return new LifePowerUp(x, y, spriteFile, 0.0);
	}
	
	/**
	 * Test the activation of this powerUp.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activatePowerUpTest() {
		LifePowerUp powerUp = new LifePowerUp(500, 200, "testimage.png", 0);
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
		LifePowerUp powerUp = new LifePowerUp(500, 200, "testimage.png", 0);
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
		LifePowerUp powerUp = new LifePowerUp(500, 200, "testimage.png", 0);
		Player player = new Player(new Game(1000, 720));
		powerUp.activate(player);
		powerUp.activate(player);
		powerUp.activate(player);
		assertEquals(player.getLives(), 5);
	}

}