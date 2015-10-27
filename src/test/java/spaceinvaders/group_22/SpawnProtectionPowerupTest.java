package spaceinvaders.group_22;

import org.junit.Rule;

import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.game.powerup.PowerUp;
import spaceinvaders.group_22.game.powerup.SpawnProtectionPowerup;
import spaceinvaders.group_22.ui.JavaFXThreadingRule;

/**
 * Test for the spawn protection power Up.
 * @author Bryan
 *
 */
public class SpawnProtectionPowerupTest extends PowerUpTest {

	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	@Override
	public final PowerUp createInstance(final Player setplayer) {
		return new SpawnProtectionPowerup(setplayer);
	}
	

}
