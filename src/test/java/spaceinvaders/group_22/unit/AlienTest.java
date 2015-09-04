package spaceinvaders.group_22;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.Unit;

/**
 * Test for Alien, extends UnitTest.
 * @author Ege de Bruin
 */
public class AlienTest extends UnitTest {

	@Override
	public final Unit createInstance(final double x, final double y) {
		return new Alien(x, y);
	}
	
	/**
	 * Test if the Alien creates a new Bullet which goes downwards.
	 */
	@Test
	public final void shootBulletTest() {
		float x = 1;
		float y = 1;
		Alien alien = new Alien(x, y);
		Bullet bullet = alien.shootBullet(1);
		assertTrue(bullet.getXCoor() == alien.getXCoor());
		assertTrue(bullet.getYCoor() == alien.getYCoor());
		bullet.moveUnit();
		assertTrue(bullet.getXCoor() == alien.getXCoor());
		assertTrue(bullet.getYCoor() == alien.getYCoor() - 1);
	}

}
