package group22.space_invaders.unit;

/**
 * Test for ShipBullet, extends BulletTest.
 * @author Ege
 *
 */
public class ShipBulletTest extends BulletTest{

	@Override
	public Unit createInstance(float X, float Y) {
		return new ShipBullet(X,Y);
	}

}
