package spaceinvaders.group_22.game.powerup;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import spaceinvaders.group_22.game.Game;
import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.game.SinglePlayerGame;
import spaceinvaders.group_22.game.powerup.PowerUp;
import spaceinvaders.group_22.game.powerup.SpeedPowerUp;
import spaceinvaders.group_22.ui.JavaFXThreadingRule;

/**
 * Speed Power Up test extends the Power Up test.
 * @author Bryan
 *
 */
public class SpeedPowerUpTest extends PowerUpTest {

	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	@Override
	public final PowerUp createInstance(final Player setplayer) {
		return new SpeedPowerUp(setplayer);
	}
	
	/**
	 * Test the deactivated method of this power up.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void deactivatedTest() {
		Game game = new SinglePlayerGame(1000, 750);
		Player player = new Player(game, game.getCanvasWidth() / 2);
		PowerUp powerup = new SpeedPowerUp(player);
		powerup.deactivate();
		assertEquals(player.getSpaceShip().getVelMultiplier(), 1.0, 0.f);
	}

}
