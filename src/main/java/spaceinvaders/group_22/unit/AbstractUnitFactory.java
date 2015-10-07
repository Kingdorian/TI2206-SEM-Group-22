package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

/**
 * Class defining an Abstract Unit Factory.
 * @author Jochem
 *
 */
public abstract class AbstractUnitFactory {
	
	/**
	 * Abstract Constructor for a Unit Factory.
	 */
	public AbstractUnitFactory() {
		Game.getLogger().log(getClass().getName() + "  created succesfully", LogEvent.Type.INFO);
	}
	
	/**
	 * Abstract method. A subclass implementing this, 
	 * should return a SpaceShip, or an Alien depending on the factory type.
	 * @param x X Coordinate.
	 * @param y Y Coordinate.
	 * @return A Spaceship or an Alien.
	 */
	abstract Unit createUnit(final double x, final double y);
	
	/**
	 * Abstract method. A subclass implementing this, 
	 * should return the bullet corresponding to the factory type.
	 * @param x X Coordinate.
	 * @param y Y Coordinate.
	 * @return A ShipBullet or an AlienBullet.
	 */
	abstract Unit createBullet(final double x, final double y);
	
	/**
	 * A method responsible for creating a barricade object.
	 * @param x X Coordinate.
	 * @param y Y Coordinate.
	 * @return A Barricade object.
	 */
	public final Barricade createBarricade(final double x, final double y) {
		return new Barricade(x, y, "barrier.png");
	}
	
	/**
	 * A method responsible for creating an explosion object.
	 * @param x X Coordinate.
	 * @param y Y Coordinate.
	 * @return An explosion object.
	 */
	public final Explosion createExplosion(final double x, final double y) {
		return new Explosion(x, y, "explosion.png");
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
