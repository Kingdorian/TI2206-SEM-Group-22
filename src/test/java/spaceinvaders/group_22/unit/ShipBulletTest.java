package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Player;
import static org.mockito.Mockito.mock;

/**
 * Test for ShipBullet, extends BulletTest.
 * @author Ege
 *
 */
public class ShipBulletTest extends BulletTest {

	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		return new ShipBullet(x, y, spriteFile);
	}

}
