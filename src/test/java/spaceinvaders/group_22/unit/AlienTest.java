package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test for Alien, extends UnitTest.
 * @author Ege de Bruin
 */
public class AlienTest extends UnitTest {

	@Override
	public final Unit createInstance(final double x, final double y, final String spriteFile) {
		return new Alien(x, y, spriteFile);
	}
	
	/**
	 * Test if the Alien creates a new Bullet which goes downwards.
	 */
	@Test
	public final void shootBulletTest() {
		float x = 1;
		float y = 1;
		Alien alien = new Alien(x, y, "testimage.png");
		Bullet bullet = alien.shootBullet(1);
		assertEquals(alien.getXCoor(), bullet.getXCoor(), 0.05 );
		assertEquals(alien.getYCoor(), bullet.getYCoor(), 0.05 );
		bullet.moveUnit(1.0);
		assertEquals(alien.getXCoor(), bullet.getXCoor(), 0.05);
		assertEquals(alien.getYCoor() + 1, bullet.getYCoor(), 0.05 );
	}

}
