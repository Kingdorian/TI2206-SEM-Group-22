package spaceinvaders.group_22;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

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
