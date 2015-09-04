package group22.space_invaders.unit;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for Alien, extends UnitTest.
 * @author Ege de Bruin
 */
public class AlienTest extends UnitTest{

	@Override
	public Unit createInstance(double X, double Y) {
		return new Alien(X,Y);
	}
	
	/**
	 * Test if the Alien creates a new Bullet which goes downwards.
	 */
	@Test
	public void shootBulletTest(){
		float x = 1;
		float y = 1;
		Alien alien = new Alien(x,y);
		Bullet bullet = alien.shootBullet(1);
		assertTrue(bullet.getXCoor() == alien.getXCoor());
		assertTrue(bullet.getYCoor() == alien.getYCoor());
		bullet.moveUnit();
		assertTrue(bullet.getXCoor() == alien.getXCoor());
		assertTrue(bullet.getYCoor() == alien.getYCoor() - 1);
	}

}
