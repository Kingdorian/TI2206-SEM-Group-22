package spaceinvaders.group_22.unit;

/**
 * Test for ShipBullet, extends BulletTest.
 * @author Ege
 *
 */
public class ShipBulletTest extends BulletTest {

	@Override
	public final Unit createInstance(final double x, final double y) {
		return new ShipBullet(x, y);
	}

}