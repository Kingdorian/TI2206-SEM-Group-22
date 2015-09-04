package group22.space_invaders.unit;

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
