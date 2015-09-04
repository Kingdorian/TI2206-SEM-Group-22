package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.unit.AlienBullet;
import spaceinvaders.group_22.unit.Unit;

/**
 * Test for AlienBullet, extends BulletTest.
 * @author Ege
 *
 */
public class AlienBulletTest extends BulletTest {

	@Override
	public final Unit createInstance(final double x, final double y) {
		return new AlienBullet(x, y);
	}

}
