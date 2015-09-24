package spaceinvaders.group_22;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.unit.SpaceShip;

/**
 * Shoot Power Up test extends the Power Up test.
 * @author Bryan
 *
 */
public class ShootPowerUpTest extends PowerUpTest {

	@Override
	public final PowerUp createInstance(final Player setplayer) {
		return new ShootPowerUp(setplayer);
	}
	
	/**
	 * Test the deactivated method of this power up.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void deactivatedTest() {
		Game game = new Game(1000, 750);
		Player player = new Player(game);
		PowerUp powerup = new ShootPowerUp(player);
		powerup.deactivate();
		assertEquals(SpaceShip.shootTimes, 1);
	}

}