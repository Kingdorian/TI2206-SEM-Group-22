package spaceinvaders.group_22.unit;

/**
 * Test for Speed Power Up, extends PowerUpTest Test.
 * @author Bryan
 */
public class SpeedPowerUpTest extends PowerUpTest {
	
	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		return new SpeedPowerUp(x, y, spriteFile, 5.0);
	}

}
