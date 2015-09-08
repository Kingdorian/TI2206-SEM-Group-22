package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Test for the SpaceShip class which extends UnitTest.
 * @author Bryan van Wijk
 *
 */
public class SpaceShipTest extends UnitTest {

	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		return new SpaceShip(x, y, spriteFile);
	}
	
	/**
	 * Test if the SpaceShip creates a bullet which goes upwards.
	 */
	@Test
	public final void shootBulletTest() {
		float x = 1;
		float y = 1;
		SpaceShip spaceship = new SpaceShip(x, y, "testimage.png");
		Bullet bullet = spaceship.shootBullet(1);
		assertTrue(bullet.getXCoor() == spaceship.getXCoor());
		assertTrue(bullet.getYCoor() == spaceship.getYCoor());
		bullet.moveUnit();
		assertTrue(bullet.getXCoor() == spaceship.getXCoor());
		assertTrue(bullet.getYCoor() == spaceship.getYCoor() + 1);
	}
	
	/**
	 * Test the Equals method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsSpaceShip() {
		SpaceShip ship2 = new SpaceShip(1.2, 3, "testimage.png");
		SpaceShip ship1 = new SpaceShip(1.2, 3, "testimage.png");
		assertEquals(ship1, ship2);
	}
	
	/**
	 * Test the Equals method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEquals2() {
		SpaceShip ship2 = new SpaceShip(1, 3, "testimage.png");
		SpaceShip ship1 = new SpaceShip(1.2, 3, "testimage.png");
		assertNotEquals(ship1, ship2);
	}
	/**
	 * Test the Equals method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsNull() {
		SpaceShip ship1 = new SpaceShip(1.2, 3, "testimage.png");
		assertNotEquals(ship1, null);
	}
}
