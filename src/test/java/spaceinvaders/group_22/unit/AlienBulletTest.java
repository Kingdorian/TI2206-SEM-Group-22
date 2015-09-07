package spaceinvaders.group_22.unit;

/**
 * Test for AlienBullet, extends BulletTest.
 * @author Ege
 *
 */
public class AlienBulletTest extends BulletTest {

	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		return new AlienBullet(x, y, spriteFile);
	}

}
