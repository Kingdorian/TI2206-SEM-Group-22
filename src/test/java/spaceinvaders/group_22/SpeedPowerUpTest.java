package spaceinvaders.group_22;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.unit.SpaceShip;

/**
 * Speed Power Up test extends the Power Up test.
 * @author Bryan
 *
 */
public class SpeedPowerUpTest extends PowerUpTest {

	@Override
	public final PowerUp createInstance(final Player setplayer) {
		return new SpeedPowerUp(setplayer);
	}
	
	/**
	 * Test the deactivated method of this power up.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void deactivatedTest() {
		Game game = new Game(1000, 750);
		Player player = new Player(game, game.getCanvasWidth() / 2);
		PowerUp powerup = new SpeedPowerUp(player);
		powerup.deactivate();
		assertEquals(player.getSpaceShip().getVelMultiplier(), 1.0, 0.f);
	}

}
