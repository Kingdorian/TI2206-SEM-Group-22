package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.game.Game;
import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.game.SinglePlayerGame;
import spaceinvaders.group_22.unit.LifePowerUpUnit;
import spaceinvaders.group_22.unit.Unit;

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
		Game game = new SinglePlayerGame(1000, 720);
		Player player = new Player(game, game.getCanvasWidth() / 2);
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
		Game game = new SinglePlayerGame(1000, 720);
		Player player = new Player(game, game.getCanvasWidth() / 2);

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

		Game game = new SinglePlayerGame(1000, 720);
		Player player = new Player(game, game.getCanvasWidth() / 2);

		powerUp.activate(player);
		powerUp.activate(player);
		powerUp.activate(player);
		assertEquals(player.getLives(), 5);
	}

}