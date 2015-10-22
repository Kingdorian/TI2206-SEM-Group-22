package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.Player;
import spaceinvaders.group_22.ShootPowerUp;
import spaceinvaders.group_22.SinglePlayerGame;
import spaceinvaders.group_22.SpeedPowerUp;

/**
 * Test for the SpaceShip class which extends UnitTest.
 * @author Bryan van Wijk
 *
 */
@SuppressWarnings("checkstyle:magicnumber")   
public class SpaceShipTest extends UnitTest {

	@Override
	public final Unit createInstance(final double x, final double y) {
		return new SpaceShip(x, y);
	}
	
	/**
	 * Test if the SpaceShip creates a bullet which goes upwards.
	 */
	@Test
	public final void shootBulletTest() {
		float x = 1;
		float y = 1;
		SpaceShip spaceship = new SpaceShip(x, y);

		Bullet bullet = spaceship.shootBullet(1);
		assertEquals(spaceship.getXCoor(), bullet.getXCoor(), 0.05);
		assertEquals(spaceship.getYCoor(), bullet.getYCoor(), 0.05);
		bullet.move(1.0);
		assertEquals(spaceship.getXCoor(), bullet.getXCoor(), 0.05);
		assertEquals(spaceship.getYCoor() + 1.0, bullet.getYCoor(),  0.05);
	}
	
	/**
	 * Test the Equals method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsSpaceShip() {
		SpaceShip ship2 = new SpaceShip(1.2, 3);
		SpaceShip ship1 = new SpaceShip(1.2, 3);
		assertEquals(ship1, ship2);
	}
	
	/**
	 * Test the Equals method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEquals2() {
		SpaceShip ship2 = new SpaceShip(1, 3);
		SpaceShip ship1 = new SpaceShip(1.2, 3);
		assertNotEquals(ship1, ship2);
	}

	/**
	 * Test the Equals method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsNull() {
		SpaceShip ship1 = new SpaceShip(1.2, 3);
		assertNotEquals(ship1, null);
	}
	
	/**
	 * Test the multiplier update method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testUpdateMultiplierSpeed() {
		Game game = new SinglePlayerGame(1000, 750);
		Player player = new Player(game, game.getCanvasWidth() / 2);
		player.getActivePowerUps().add(new SpeedPowerUp(player));
		player.getSpaceShip().updateMultiplier();
		assertEquals(625, player.getSpaceShip().getMAXVELX(), 0.f);
	}
	
	/**
	 * Test the multiplier update method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testUpdateMultiplierShoot() {
		Game game = new SinglePlayerGame(1000, 750);
		Player player = new Player(game, game.getCanvasWidth() / 2);
		player.getActivePowerUps().add(new ShootPowerUp(player));
		player.getSpaceShip().updateMultiplier();
		assertEquals(2, player.getSpaceShip().getShootTimes(), 0.f);

	}
}
