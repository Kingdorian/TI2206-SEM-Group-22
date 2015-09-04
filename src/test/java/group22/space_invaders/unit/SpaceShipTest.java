package group22.space_invaders.unit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test for the SpaceShip class which extends UnitTest
 * @author Bryan van Wijk
 *
 */
public class SpaceShipTest extends UnitTest {

	@Override
	public Unit createInstance(double X, double Y) {
		return new SpaceShip(X, Y);
	}
	
	/**
	 * Test if the SpaceShip creates a bullet which goes upwards.
	 */
	@Test
	public void shootBulletTest(){
		float x = 1;
		float y = 1;
		SpaceShip spaceship = new SpaceShip(x,y);
		Bullet bullet = spaceship.shootBullet(1);
		assertTrue(bullet.getXCoor() == spaceship.getXCoor());
		assertTrue(bullet.getYCoor() == spaceship.getYCoor());
		bullet.moveUnit();
		assertTrue(bullet.getXCoor() == spaceship.getXCoor());
		assertTrue(bullet.getYCoor() == spaceship.getYCoor() + 1);
	}

}
