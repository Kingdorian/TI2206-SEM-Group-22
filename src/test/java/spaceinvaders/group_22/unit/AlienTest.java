package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Test for Alien, extends UnitTest.
 * @author Ege de Bruin
 */
@SuppressWarnings("checkstyle:magicnumber") 
public class AlienTest extends UnitTest {

	@Override
	public final Unit createInstance(final double x, final double y) {
		return new NormalAlien(x, y);
	}
	
	/**
	 * Test if the Alien creates a new Bullet which goes downwards.
	 */
	@Test
	public final void shootBulletTest() {
		float x = 1;
		float y = 1;
		Alien alien = new NormalAlien(x, y);
		ArrayList<Bullet> list = alien.shootBullet(1);
		Bullet bullet = list.get(0);
		assertEquals(alien.getXCoor(), bullet.getXCoor(), 0.05);
		assertEquals(alien.getYCoor(), bullet.getYCoor(), 0.05);
		bullet.move(1.0);
		assertEquals(alien.getXCoor(), bullet.getXCoor(), 0.05);
		assertEquals(alien.getYCoor() + 1, bullet.getYCoor(), 0.05);
	}
	/**
	 * Test the set and get method of the bullet chance variable.
	 */
	@Test
	public final void bulletChanceTest() {
		float x = 1;
		float y = 1;
		Alien alien = new NormalAlien(x, y);
		alien.increaseShooting();
		assertEquals(alien.getBulletChance(), 0.25, 0.25);
	}
	/**
	 * Test the health of an alien.
	 */
	@Test
	public final void healthTest() {
		float x = 1;
		float y = 1;
		Alien alien = new HealthAlien(x, y);
		alien.hit();
		assertEquals(alien.getHealth(), 4);
	}
	/**
	 * Test the health of a BossAlien.
	 */
	@Test
	public final void bossHealthTest() {
		float x = 1;
		float y = 1;
		Alien alien = new BossAlien(x, y);
		alien.hit();
		assertEquals(alien.getHealth(), 19);
	}
	/**
	 * Test the shoot method for a BossAlien.
	 */
	@Test
	public final void bossShootTest() {
		float x = 1;
		float y = 1;
		Alien alien = new BossAlien(x, y);
		ArrayList<Bullet> list = alien.shootBullet(1);
		assertEquals(list.size(), 6);
	}
	/**
	 * Test moving for a BossAlien.
	 */
	@Test
	public final void bossMoveTest() {
		float x = 1;
		float y = 1;
		Alien alien = new BossAlien(x, y);
		alien.setVelX(1);
		alien.setVelY(1);
		alien.move(1);
		assertEquals(alien.getYCoor(), 1, 0);
	}

}
