package group22.space_invaders.unit;

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
