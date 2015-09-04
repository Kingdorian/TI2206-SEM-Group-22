package group22.space_invaders.unit;

/**
 * Test for AlienBullet, extends BulletTest
 * @author Ege
 *
 */
public class AlienBulletTest extends BulletTest{

	@Override
	public Unit createInstance(double X, double Y) {
		return new AlienBullet(X,Y);
	}

}
