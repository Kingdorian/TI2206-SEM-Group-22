package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test for Alien, extends UnitTest.
 * @author Ege de Bruin
 */
public class AlienTest extends UnitTest {

	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		int width = 1;
		int height = 1;
		return new Alien(x, y, width, height, spriteFile);
	}
	
	/**
	 * Test if the Alien creates a new Bullet which goes downwards.
	 */
	@Test
	public final void shootBulletTest() {
		float x = 1;
		float y = 1;
		int width = 1;
		int height = 1;
		Alien alien = new Alien(x, y, width, height, "invader.png");
		Bullet bullet = alien.shootBullet(1);
		assertTrue(bullet.getXCoor() == alien.getXCoor());
		assertTrue(bullet.getYCoor() == alien.getYCoor());
		bullet.moveUnit();
		assertTrue(bullet.getXCoor() == alien.getXCoor());
		assertTrue(bullet.getYCoor() == alien.getYCoor() - 1);
	}

}
