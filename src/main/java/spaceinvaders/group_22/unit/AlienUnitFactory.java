package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

/**
 * A Factory responsible for Alien related objects.
 * @author Jochem
 *
 */
public class AlienUnitFactory extends AbstractUnitFactory {
	
	/**
	 * Constructor for an AlienUnitFactory.
	 */
	public AlienUnitFactory() {
		Game.getLogger().log(getClass().getName() + "  created succesfully", LogEvent.Type.INFO);
	}
	
	@Override
	public final Alien createUnit(final double x, final double y) {
		return new Alien(x, y, "invader.png");
	}

	@Override
	public final AlienBullet createBullet(final double x, final double y) {
		return new AlienBullet(x, y, "alienbullet.png");
	}
	
	/**
	 * A method responsible for creating a SpeedPowerUpUnit.
	 * @param x X Coordinate.
	 * @param y Y Coordinate.
	 * @return A SpeedPowerUpUnit object.
	 */
	public final SpeedPowerUpUnit createSpeedPowerup(final double x, final double y) {
		return new SpeedPowerUpUnit(x, y, "powerup_blue.png");
	}
	
	/**
	 * A method responsible for creating a ShootPowerUpUnit.
	 * @param x X Coordinate.
	 * @param y Y Coordinate.
	 * @return A ShootPowerUpUnit object.
	 */
	public final ShootPowerUpUnit createShootPowerup(final double x, final double y) {
		return new ShootPowerUpUnit(x, y, "powerup_orange.png");
	}
	
	/**
	 * A method responsible for creating a LifePowerUpUnit.
	 * @param x X Coordinate.
	 * @param y Y Coordinate.
	 * @return A LifePowerUpUnit object.
	 */
	public final LifePowerUpUnit createLifePowerup(final double x, final double y) {
		return new LifePowerUpUnit(x, y, "powerup_red.png");
	}

}
